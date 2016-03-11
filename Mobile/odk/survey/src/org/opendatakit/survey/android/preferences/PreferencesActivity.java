/*
 * Copyright (C) 2014 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.opendatakit.survey.android.preferences;

import org.opendatakit.common.android.utilities.ODKDatabaseUtils;
import org.opendatakit.common.android.utilities.UrlUtils;
import org.opendatakit.survey.android.R;
import org.opendatakit.survey.android.activities.AccountList;
import org.opendatakit.survey.android.activities.MainMenuActivity;
import org.opendatakit.survey.android.logic.PropertiesSingleton;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.provider.MediaStore.Images;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;

public class PreferencesActivity extends PreferenceActivity implements OnPreferenceChangeListener {

  private static final String t = "PreferencesActivity";

  protected static final int IMAGE_CHOOSER = 0;

  // keys used in Survey to manage Google play licensing and APK
  // Expansion files
  // public static final String KEY_SALT = "licenseSalt";
  // public static final String KEY_APK_EXPANSIONS = "apkExpansions";

  // keys used in SplashScreenActivity to manage splash screen
  // presentation behavior.
  public static final String KEY_LAST_VERSION = "lastVersion";
  public static final String KEY_FIRST_RUN = "firstRun";

  public static final String KEY_PROTOCOL = "protocol";

  public static final String KEY_SERVER_URL = "server_url";
  public static final String KEY_USERNAME = "username";
  public static final String KEY_PASSWORD = "password";

  public static final String KEY_SELECTED_GOOGLE_ACCOUNT = "selected_google_account";

  public static final String KEY_FORMLIST_URL = "formlist_url";
  public static final String KEY_SUBMISSION_URL = "submission_url";

  public static final String KEY_FONT_SIZE = "font_size";
  public static final String KEY_SHOW_SPLASH = "showSplash";
  public static final String KEY_SPLASH_PATH = "splashPath";

  public static final String PROTOCOL_ODK_DEFAULT = "odk_default";
  public static final String PROTOCOL_OTHER = "";

  public static final String KEY_AUTH = "auth";
  public static final String KEY_ACCOUNT = "account";

  private ListPreference mServerProtocol;
  private EditTextPreference mServerUrlPreference;
  private EditTextPreference mUsernamePreference;
  private EditTextPreference mPasswordPreference;
  private PreferenceScreen mSelectedGoogleAccountPreference;
  private EditTextPreference mFormListUrlPreference;
  private EditTextPreference mSubmissionUrlPreference;

  private ListPreference mFontSizePreference;
  private CheckBoxPreference mShowSplashPreference;
  private PreferenceScreen mSplashPathPreference;

  private String mAppName;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mAppName = this.getIntent().getStringExtra(MainMenuActivity.APP_NAME);
    if (mAppName == null || mAppName.length() == 0) {
      mAppName = "survey";
    }
    // TODO: HACK HACK HACK HACK
    // TODO: HACK HACK HACK HACK
    // TODO: HACK HACK HACK HACK
    // TODO: HACK HACK HACK HACK
    // TODO: HACK HACK HACK HACK
    // TODO: fix this hack -- we need to get appName into the PasswordDialogPreference
    // but I don't know how to get it there, or how to access this activity from it.
    //
    PasswordDialogPreference.appName = mAppName;

    setTitle(mAppName + " > " + getString(R.string.general_preferences));

    addPreferencesFromResource(R.xml.preferences);

    // not super safe, but we're just putting in this mode to help
    // administrate
    // would require code to access it
    boolean adminMode = getIntent().getBooleanExtra("adminMode", false);

    boolean serverAvailable = (PropertiesSingleton.getProperty(mAppName,
        AdminPreferencesActivity.KEY_CHANGE_SERVER)).equalsIgnoreCase("true") ? true : false;

    PreferenceCategory serverCategory = (PreferenceCategory) findPreference(getString(R.string.server_preferences));

    // Initialize the Server Protocol List Preference
    mServerProtocol = (ListPreference) findPreference(KEY_PROTOCOL);
    if (PropertiesSingleton.containsKey(mAppName, KEY_PROTOCOL)) {
      CharSequence entryValues[] = mServerProtocol.getEntryValues();
      for (int i = 0; i < entryValues.length; i++) {
        String entry = entryValues[i].toString();
        if (entry.equals(PropertiesSingleton.getProperty(mAppName, KEY_PROTOCOL))) {
          mServerProtocol.setValue(entry);
        }
      }
    }

    mServerProtocol.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        PropertiesSingleton.setProperty(mAppName, KEY_PROTOCOL, newValue.toString());
        return true;
      }
    });

    // Initialize the Server URL Text Preference
    mServerUrlPreference = (EditTextPreference) findPreference(KEY_SERVER_URL);
    if (PropertiesSingleton.containsKey(mAppName, KEY_SERVER_URL)) {
      String url = PropertiesSingleton.getProperty(mAppName, KEY_SERVER_URL);
      mServerUrlPreference.setSummary(url);
      mServerUrlPreference.setText(url);
    }

    mServerUrlPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        String url = newValue.toString();

        // remove all trailing "/"s
        while (url.endsWith("/")) {
          url = url.substring(0, url.length() - 1);
        }

        if (UrlUtils.isValidUrl(url)) {
          preference.setSummary(newValue.toString());
          PropertiesSingleton.setProperty(mAppName, KEY_SERVER_URL, newValue.toString());
          return true;
        } else {
          Toast.makeText(getApplicationContext(), R.string.url_error, Toast.LENGTH_SHORT).show();
          return false;
        }
      }
    });

    mServerUrlPreference.getEditText().setFilters(new InputFilter[] { getReturnFilter() });

    if (!(serverAvailable || adminMode)) {
      Preference protocol = findPreference(KEY_PROTOCOL);
      serverCategory.removePreference(protocol);
      serverCategory.removePreference(mServerUrlPreference);
    }

    mUsernamePreference = (EditTextPreference) findPreference(KEY_USERNAME);
    if (PropertiesSingleton.containsKey(mAppName, KEY_USERNAME)) {
      String user = PropertiesSingleton.getProperty(mAppName, KEY_USERNAME);
      mUsernamePreference.setSummary(user);
      mUsernamePreference.setText(user);
    }

    mUsernamePreference.setOnPreferenceChangeListener(this);

    mUsernamePreference.getEditText().setFilters(new InputFilter[] { getReturnFilter() });

    boolean usernameAvailable = (PropertiesSingleton.getProperty(mAppName,
        AdminPreferencesActivity.KEY_CHANGE_USERNAME)).equalsIgnoreCase("true") ? true : false;
    if (!(usernameAvailable || adminMode)) {
      serverCategory.removePreference(mUsernamePreference);
    }

    mPasswordPreference = (EditTextPreference) findPreference(KEY_PASSWORD);
    mPasswordPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        String pw = newValue.toString();

        if (pw.length() > 0) {
          mPasswordPreference.setSummary("********");
        } else {
          mPasswordPreference.setSummary("");
        }
        PropertiesSingleton.setProperty(mAppName, KEY_PASSWORD, pw);

        return true;
      }
    });

    if (PropertiesSingleton.containsKey(mAppName, KEY_PASSWORD)) {
      String pwd = PropertiesSingleton.getProperty(mAppName, KEY_PASSWORD);
      if (pwd != null && pwd.length() > 0) {
        mPasswordPreference.setSummary("********");
      }
    }

    boolean passwordAvailable = (PropertiesSingleton.getProperty(mAppName,
        AdminPreferencesActivity.KEY_CHANGE_PASSWORD)).equalsIgnoreCase("true") ? true : false;
    if (!(passwordAvailable || adminMode)) {
      serverCategory.removePreference(mPasswordPreference);
    }

    mSelectedGoogleAccountPreference = (PreferenceScreen) findPreference(KEY_SELECTED_GOOGLE_ACCOUNT);
    mSelectedGoogleAccountPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
      @Override
      public boolean onPreferenceClick(Preference preference) {
        Intent i = new Intent(getApplicationContext(), AccountList.class);
        // TODO: convert this activity into a preferences
        // fragment
        i.putExtra(MainMenuActivity.APP_NAME, mAppName);
        startActivity(i);
        return true;
      }
    });

    if (PropertiesSingleton.containsKey(mAppName, KEY_SELECTED_GOOGLE_ACCOUNT)) {
      mSelectedGoogleAccountPreference.setSummary(PropertiesSingleton.getProperty(mAppName,
          KEY_SELECTED_GOOGLE_ACCOUNT));
    }

    boolean googleAccountAvailable = (PropertiesSingleton.getProperty(mAppName,
        AdminPreferencesActivity.KEY_CHANGE_GOOGLE_ACCOUNT)).equalsIgnoreCase("true") ? true
        : false;
    if (!(googleAccountAvailable || adminMode)) {
      serverCategory.removePreference(mSelectedGoogleAccountPreference);
    }

    mFormListUrlPreference = (EditTextPreference) findPreference(KEY_FORMLIST_URL);
    mFormListUrlPreference.setOnPreferenceChangeListener(this);

    if (PropertiesSingleton.containsKey(mAppName, KEY_FORMLIST_URL)) {
      String formListURL = PropertiesSingleton.getProperty(mAppName, KEY_FORMLIST_URL);
      mFormListUrlPreference.setSummary(formListURL);
      mFormListUrlPreference.setText(formListURL);
    }
    mServerUrlPreference.getEditText().setFilters(
        new InputFilter[] { getReturnFilter(), getWhitespaceFilter() });
    if (!(serverAvailable || adminMode)) {
      serverCategory.removePreference(mFormListUrlPreference);
    }

    mSubmissionUrlPreference = (EditTextPreference) findPreference(KEY_SUBMISSION_URL);
    mSubmissionUrlPreference.setOnPreferenceChangeListener(this);

    if (PropertiesSingleton.containsKey(mAppName, KEY_SUBMISSION_URL)) {
      String keySubmissionURL = PropertiesSingleton.getProperty(mAppName, KEY_SUBMISSION_URL);
      mSubmissionUrlPreference.setSummary(PropertiesSingleton.getProperty(mAppName,
          keySubmissionURL));
      mSubmissionUrlPreference.setText(keySubmissionURL);
    }
    mServerUrlPreference.getEditText().setFilters(
        new InputFilter[] { getReturnFilter(), getWhitespaceFilter() });
    if (!(serverAvailable || adminMode)) {
      serverCategory.removePreference(mSubmissionUrlPreference);
    }

    if (!(serverAvailable || usernameAvailable || passwordAvailable || googleAccountAvailable || adminMode)) {
      getPreferenceScreen().removePreference(serverCategory);
    }

    PreferenceCategory clientCategory = (PreferenceCategory) findPreference(getString(R.string.client));

    boolean fontAvailable = (PropertiesSingleton.getProperty(mAppName,
        AdminPreferencesActivity.KEY_CHANGE_FONT_SIZE)).equalsIgnoreCase("true") ? true : false;
    mFontSizePreference = (ListPreference) findPreference(KEY_FONT_SIZE);
    if (PropertiesSingleton.containsKey(mAppName, KEY_FONT_SIZE)) {
      CharSequence entryValues[] = mFontSizePreference.getEntryValues();
      for (int i = 0; i < entryValues.length; i++) {
        String entry = entryValues[i].toString();
        if (entry.equals(PropertiesSingleton.getProperty(mAppName, KEY_FONT_SIZE))) {
          mFontSizePreference.setValue(entry);
        }
      }
    }

    mFontSizePreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        int index = ((ListPreference) preference).findIndexOfValue(newValue.toString());
        String entry = (String) ((ListPreference) preference).getEntries()[index];
        ((ListPreference) preference).setSummary(entry);
        PropertiesSingleton.setProperty(mAppName, KEY_FONT_SIZE, newValue.toString());
        return true;
      }
    });
    if (!(fontAvailable || adminMode)) {
      clientCategory.removePreference(mFontSizePreference);
    }

    boolean splashAvailable = (PropertiesSingleton.getProperty(mAppName,
        AdminPreferencesActivity.KEY_SELECT_SPLASH_SCREEN)).equalsIgnoreCase("true") ? true : false;

    mSplashPathPreference = (PreferenceScreen) findPreference(KEY_SPLASH_PATH);
    if (PropertiesSingleton.containsKey(mAppName, KEY_SPLASH_PATH)) {
      mSplashPathPreference.setSummary(PropertiesSingleton.getProperty(mAppName, KEY_SPLASH_PATH));
    }
    mSplashPathPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {

      private void launchImageChooser() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        startActivityForResult(i, PreferencesActivity.IMAGE_CHOOSER);
      }

      @Override
      public boolean onPreferenceClick(Preference preference) {
        // if you have a value, you can clear it or select new.
        CharSequence cs = mSplashPathPreference.getSummary();
        if (cs != null && cs.toString().contains("/")) {

          final CharSequence[] items = { getString(R.string.select_another_image),
              getString(R.string.use_odk_default) };

          AlertDialog.Builder builder = new AlertDialog.Builder(PreferencesActivity.this);
          builder.setTitle(getString(R.string.change_splash_path));
          builder.setNeutralButton(getString(R.string.cancel),
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                  dialog.dismiss();
                }
              });
          builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
              if (items[item].equals(getString(R.string.select_another_image))) {
                launchImageChooser();
              } else {
                setSplashPath(getString(R.string.default_splash_path));
              }
            }
          });
          AlertDialog alert = builder.create();
          alert.show();

        } else {
          launchImageChooser();
        }

        return true;
      }
    });

    if (!(splashAvailable || adminMode)) {
      clientCategory.removePreference(mSplashPathPreference);
    }

    boolean showSplashAvailable = (PropertiesSingleton.getProperty(mAppName,
        AdminPreferencesActivity.KEY_SHOW_SPLASH_SCREEN)).equalsIgnoreCase("true") ? true : false;

    mShowSplashPreference = (CheckBoxPreference) findPreference(KEY_SHOW_SPLASH);
    if (PropertiesSingleton.containsKey(mAppName, KEY_SHOW_SPLASH)) {
      String checked = PropertiesSingleton.getProperty(mAppName, KEY_SHOW_SPLASH);
      if (checked.equals("true")) {
        mShowSplashPreference.setChecked(true);
      }
    }
    mShowSplashPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        PropertiesSingleton.setProperty(mAppName, KEY_SHOW_SPLASH, newValue.toString());
        return true;
      }
    });

    if (!(showSplashAvailable || adminMode)) {
      clientCategory.removePreference(mShowSplashPreference);
    }

    if (!(fontAvailable || splashAvailable || showSplashAvailable || adminMode)) {
      getPreferenceScreen().removePreference(clientCategory);
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    // TODO Auto-generated method stub
    super.onSaveInstanceState(outState);
    PropertiesSingleton.writeProperties(mAppName);
  }

  @Override
  public void finish() {
    PropertiesSingleton.writeProperties(mAppName);

    // TODO Auto-generated method stub
    super.finish();
  }

  private void setSplashPath(String path) {

    mSplashPathPreference = (PreferenceScreen) findPreference(KEY_SPLASH_PATH);
    mSplashPathPreference.setSummary(path);
    PropertiesSingleton.setProperty(mAppName, KEY_SPLASH_PATH, path);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    if (resultCode == RESULT_CANCELED) {
      // request was canceled, so do nothing
      return;
    }

    switch (requestCode) {
    case IMAGE_CHOOSER:
      String sourceImagePath = null;

      // get gp of chosen file
      Uri uri = intent.getData();
      if (uri.toString().startsWith("file")) {
        sourceImagePath = uri.toString().substring(6);
      } else {
        String[] projection = { Images.Media.DATA };
        Cursor c = null;
        try {
          c = getContentResolver().query(uri, projection, null, null, null);
          int i = c.getColumnIndexOrThrow(Images.Media.DATA);
          c.moveToFirst();
          sourceImagePath = ODKDatabaseUtils.get().getIndexAsString(c, i);
        } finally {
          if (c != null) {
            c.close();
          }
        }
      }

      // setting image path
      setSplashPath(sourceImagePath);
      break;
    }
  }

  /**
   * Disallows whitespace from user entry
   *
   * @return
   */
  private InputFilter getWhitespaceFilter() {
    InputFilter whitespaceFilter = new InputFilter() {
      public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart,
          int dend) {
        for (int i = start; i < end; i++) {
          if (Character.isWhitespace(source.charAt(i))) {
            return "";
          }
        }
        return null;
      }
    };
    return whitespaceFilter;
  }

  /**
   * Disallows carriage returns from user entry
   *
   * @return
   */
  private InputFilter getReturnFilter() {
    InputFilter returnFilter = new InputFilter() {
      public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart,
          int dend) {
        for (int i = start; i < end; i++) {
          if (Character.getType((source.charAt(i))) == Character.CONTROL) {
            return "";
          }
        }
        return null;
      }
    };
    return returnFilter;
  }

  /**
   * Generic listener that sets the summary to the newly selected/entered value
   */
  @Override
  public boolean onPreferenceChange(Preference preference, Object newValue) {
    preference.setSummary((CharSequence) newValue);
    PropertiesSingleton.setProperty(mAppName, preference.getKey(), newValue.toString());
    return true;
  }
}
