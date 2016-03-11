/*
 * Copyright (C) 2012 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.opendatakit.tables.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.opendatakit.aggregate.odktables.rest.ElementDataType;
import org.opendatakit.aggregate.odktables.rest.ElementType;
import org.opendatakit.common.android.data.ColumnDefinition;
import org.opendatakit.common.android.data.UserTable;
import org.opendatakit.common.android.data.UserTable.Row;
import org.opendatakit.common.android.database.DatabaseFactory;
import org.opendatakit.common.android.utilities.ColumnUtil;
import org.opendatakit.common.android.utilities.DataUtil;
import org.opendatakit.common.android.utilities.ODKDatabaseUtils;
import org.opendatakit.common.android.utilities.ODKFileUtils;
import org.opendatakit.common.android.utilities.UrlUtils;
import org.opendatakit.common.android.utilities.WebLogger;
import org.opendatakit.tables.activities.AbsBaseActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

public class WebViewUtil {

  private static final String TAG = WebViewUtil.class.getSimpleName();

  /**
   * A {@link TypeReference} for a {@link HashMap} parameterized for String keys
   * and String values.
   */
  private static final TypeReference<HashMap<String, String>> MAP_REF = new TypeReference<HashMap<String, String>>() {
  };

  /**
   * The HTML to be displayed when loading a screen.
   */
  public static final String LOADING_HTML_MESSAGE = "<html><body><p>Loading, please wait...</p></body></html>";

  /**
   * Retrieve a map from a simple json map that has been stringified.
   *
   * @param appName
   * @param jsonMap
   * @return null if the mapping fails, else the map
   */
  public static Map<String, String> getMapFromJson(String appName, String jsonMap) {
    Map<String, String> map = null;
    try {
      map = ODKFileUtils.mapper.readValue(jsonMap, MAP_REF);
    } catch (JsonParseException e) {
      WebLogger.getLogger(appName).printStackTrace(e);
    } catch (JsonMappingException e) {
      WebLogger.getLogger(appName).printStackTrace(e);
    } catch (IOException e) {
      WebLogger.getLogger(appName).printStackTrace(e);
    }
    return map;
  }

  /**
   * Stringify the object. Convenience method, swallows all exceptions.
   * 
   * @param value
   * @return
   */
  public static String stringify(Object value) {
    String result = null;
    try {
      result = ODKFileUtils.mapper.writeValueAsString(value);
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Add a stringified value to the given content values. This respects the
   * column's type, as defined by {@link ColumnDefinition#getType()}.
   * 
   * @param columnProperties
   * @param rawValue
   * @param contentValues
   * @return false if the data was invalid for the given type
   */
  public static boolean addValueToContentValues(Context context, String appName, String tableId,
      DataUtil du,
      // TableProperties tp,
      ColumnDefinition colDefn, String rawValue, ContentValues contentValues) {
    // the value we're going to key things against in the database.
    String contentValuesKey = colDefn.getElementKey();
    if (rawValue == null) {
      // Then we can trust that it is ok, as we allow nulls.
      // TODO: verify that nulls are permissible for the column?
      contentValues.putNull(contentValuesKey);
      return true;
    } else {
      // we have to validate it -- get the choices list, if any
      ArrayList<Map<String, Object>> choices;
      SQLiteDatabase db = null;
      try {
        db = DatabaseFactory.get().getDatabase(context, appName);
        choices = (ArrayList<Map<String, Object>>) ColumnUtil.get().getDisplayChoicesList(db,
            tableId, colDefn.getElementKey());
      } finally {
        if (db != null) {
          db.close();
        }
      }
      // we have to validate it. this validate function just returns null if
      // valid, rather than a boolean.
      String nullMeansInvalid = ParseUtil.validifyValue(appName, du, choices, colDefn, rawValue);
      if (nullMeansInvalid == null) {
        // return false, indicating that the value was not acceptable.
        WebLogger.getLogger(appName).e(
            TAG,
            "[addRow] could not parse [" + rawValue + "] for column [" + colDefn.getElementKey()
                + "] to type: " + colDefn.getType());
        return false;
      }

      // This means all is well, and we can parse the value.
      ElementType columnType = colDefn.getType();
      ElementTypeManipulator m = ElementTypeManipulatorFactory.getInstance(appName);
      org.opendatakit.tables.utils.ElementTypeManipulator.ITypeManipulatorFragment r = m
          .getDefaultRenderer(columnType);
      ElementDataType type = columnType.getDataType();

      if (type == ElementDataType.integer) {
        contentValues.put(contentValuesKey,
            (Integer) r.parseStringValue(du, choices, rawValue, Integer.class));
      } else if (type == ElementDataType.number) {
        contentValues.put(contentValuesKey,
            (Double) r.parseStringValue(du, choices, rawValue, Double.class));
      } else if (type == ElementDataType.bool) {
        contentValues.put(contentValuesKey,
            (Boolean) r.parseStringValue(du, choices, rawValue, Boolean.class));
      } else {
        contentValues.put(contentValuesKey,
            (String) r.parseStringValue(du, choices, rawValue, String.class));
      }
      return true;
    }
  }

  /**
   * Turn the map into a {@link ContentValues} object. Returns null if any of
   * the element keys do not exist in the table, or if the value cannot be
   * parsed to the type of the column.
   * 
   * @param tableProperties
   * @param elementKeyToValue
   * @return
   */
  public static ContentValues getContentValuesFromMap(Context context, String appName,
      String tableId, ArrayList<ColumnDefinition> orderedDefns,
      Map<String, String> elementKeyToValue) {
    // Note that we're not currently
    // going to handle complex types or those that map to a json value. We
    // could, but we'd probably have to have a known entity do the conversions
    // for us somehow on the js side, rather than expect the caller to craft up
    // whatever format we've landed on for pictures.
    // This will contain the values we're going to insert into the database.
    ContentValues result = new ContentValues();
    // TODO: respect locale and timezone. Getting this structure from other
    // places it is used.

    DataUtil dataUtil = new DataUtil(Locale.ENGLISH, TimeZone.getDefault());
    for (Map.Entry<String, String> entry : elementKeyToValue.entrySet()) {
      String elementKey = entry.getKey();
      String rawValue = entry.getValue();
      // Get the column so we know what type we need to handle.
      ColumnDefinition columnDefn = ColumnDefinition.find(orderedDefns, elementKey);
      if (columnDefn == null) {
        // uh oh, no column for the given id. problem on the part of the caller
        WebLogger.getLogger(appName).e(TAG,
            "[addRow] could not find column for element key: " + elementKey);
        return null;
      }
      ElementType columnType = columnDefn.getType();
      boolean parsedSuccessfully = addValueToContentValues(context, appName, tableId, dataUtil,
          columnDefn, rawValue, result);
      if (!parsedSuccessfully) {
        WebLogger.getLogger(appName).e(TAG,
            "[addRow] could not parse value: " + rawValue + " for column type " + columnType);
        return null;
      }
    }
    return result;
  }

  /**
   * Get a {@link WebView} that is ready to be used for ODK settings. This
   * includes, e.g., having attached a logger and enabling javascript.
   * 
   * @return
   */
  @SuppressLint({ "NewApi", "SetJavaScriptEnabled" })
  public static WebView getODKCompliantWebView(AbsBaseActivity context) {
    final String appName = context.getAppName();
    WebView result = new WebView(context);
    final String webViewTag = "ODKCompliantWebView";
    if (Build.VERSION.SDK_INT >= 19) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
    result.getSettings().setJavaScriptEnabled(true);
    result.setWebViewClient(new WebViewClient() {

      @Override
      public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        WebLogger.getLogger(appName).e(
            webViewTag,
            "[onReceivedError] errorCode: " + errorCode + "; description: " + description
                + "; failingUrl: " + failingUrl);
      }
    });
    result.setWebChromeClient(new WebChromeClient() {

      @Override
      public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WebLogger.getLogger(appName).i(
            webViewTag,
            "[onConsoleMessage] level: " + consoleMessage.messageLevel().name()
                + consoleMessage.message());
        return super.onConsoleMessage(consoleMessage);
      }

    });
    return result;
  }

  /**
   * Display the file in the WebView.
   * 
   * @param context
   * @param appName
   * @param webView
   *          the WebView in which the file should be displayed
   * @param fileName
   *          the relativePath to the file. If null, a no file specified message
   *          is displayed.
   */
  public static void displayFileInWebView(Context context, String appName, WebView webView,
      String fileName) {
    if (fileName != null) {
      String webUrl = UrlUtils.getAsWebViewUri(context, appName, fileName);
      webView.loadUrl(webUrl);
    } else {
      // load the no file found html.
      webView.loadData(Constants.HTML.NO_FILE_NAME, Constants.MimeTypes.TEXT_HTML, null);
    }
  }

  /**
   * Retrieve a map of element key to value for each of the columns in the row
   * specified by rowId.
   * 
   * @param tableProperties
   * @param rowId
   * @return
   */
  public static Map<String, String> getMapOfElementKeyToValue(Context context, String appName,
      String tableId, ArrayList<ColumnDefinition> orderedDefns, String rowId) {
    SQLiteDatabase db = null;
    UserTable userTable = null;
    try {
      db = DatabaseFactory.get().getDatabase(context, appName);

      userTable = ODKDatabaseUtils.get().getDataInExistingDBTableWithId(db, appName, tableId,
          orderedDefns, rowId);
    } finally {
      if (db != null) {
        db.close();
      }
    }
    if (userTable.getNumberOfRows() > 1) {
      WebLogger.getLogger(appName).e(TAG,
          "query returned > 1 rows for tableId: " + tableId + " and " + "rowId: " + rowId);
    } else if (userTable.getNumberOfRows() == 0) {
      WebLogger.getLogger(appName).e(TAG,
          "query returned no rows for tableId: " + tableId + " and rowId: " + rowId);
    }
    Map<String, String> elementKeyToValue = new HashMap<String, String>();
    Row requestedRow = userTable.getRowAtIndex(0);
    List<String> userDefinedElementKeys = ColumnDefinition.getRetentionColumnNames(orderedDefns);
    List<String> adminElementKeys = ODKDatabaseUtils.get().getAdminColumns();
    List<String> allElementKeys = new ArrayList<String>();
    allElementKeys.addAll(userDefinedElementKeys);
    allElementKeys.addAll(adminElementKeys);
    for (String elementKey : allElementKeys) {
      elementKeyToValue.put(elementKey, requestedRow.getRawDataOrMetadataByElementKey(elementKey));
    }
    return elementKeyToValue;
  }

}
