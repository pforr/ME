/*
 * Copyright (C) 2014 University of Washington
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
package org.opendatakit.tables.preferences;

import java.util.ArrayList;
import java.util.Arrays;

import org.opendatakit.common.android.data.ColumnDefinition;
import org.opendatakit.common.android.data.PossibleTableViewTypes;
import org.opendatakit.common.android.data.TableViewType;
import org.opendatakit.common.android.database.DatabaseFactory;
import org.opendatakit.common.android.utilities.TableUtil;
import org.opendatakit.tables.R;
import org.opendatakit.tables.activities.AbsTableActivity;
import org.opendatakit.tables.views.components.TableViewTypeAdapter;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.widget.ListAdapter;

public class DefaultViewTypePreference extends ListPreference {

  /** The view types allowed for the table this preference will display. */
 //private TableProperties mTableProperties;
  private PossibleTableViewTypes mPossibleViewTypes;
  private Context mContext;
  private final String mAppName;
  private CharSequence[] mEntryValues;

  public DefaultViewTypePreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    AbsTableActivity activity = (AbsTableActivity) context; 
    this.mContext = context;
    this.mAppName = activity.getAppName();
  }

  public void setFields(String tableId, ArrayList<ColumnDefinition> orderedDefns) {
    
    TableViewType defaultViewType;
    this.mEntryValues = this.mContext.getResources().getTextArray(
      R.array.table_view_types_values);
    
    SQLiteDatabase db = null;
    try {
      db = DatabaseFactory.get().getDatabase(mContext, mAppName);
      
      this.mPossibleViewTypes = new PossibleTableViewTypes(db, 
              tableId, orderedDefns);
      // Let's set the currently selected one.
      defaultViewType = TableUtil.get().getDefaultViewType(db, tableId);
    } finally {
      if ( db != null ) {
        db.close();
      }
    }

    if (defaultViewType == null) {
      // default to spreadsheet.
      this.setValueIndex(0);
    } else {
      int index = Arrays.asList(this.mEntryValues)
          .indexOf(defaultViewType.name());
      this.setValueIndex(index);
    }
  }

  @Override
  protected void onPrepareDialogBuilder(Builder builder) {
    // We want to enable/disable the correct list.
    ListAdapter adapter = new TableViewTypeAdapter(
        this.mContext,
        this.mAppName,
        android.R.layout.select_dialog_singlechoice,
        this.getEntries(),
        this.getEntryValues(),
        this.mPossibleViewTypes);
    builder.setAdapter(adapter, this);
    super.onPrepareDialogBuilder(builder);
  }



}
