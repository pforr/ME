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
package org.opendatakit.tables.activities;

import java.util.ArrayList;

import org.opendatakit.common.android.data.ColumnDefinition;
import org.opendatakit.common.android.database.DatabaseFactory;
import org.opendatakit.common.android.utilities.TableUtil;
import org.opendatakit.common.android.utilities.WebLogger;
import org.opendatakit.tables.utils.Constants;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

/**
 * This class is the base for any Activity that will display information about
 * a particular table. Callers must pass in a table id in the bundle with the
 * key {@link Constants.IntentKeys#TABLE_ID}.
 * @author sudar.sam@gmail.com
 *
 */
public abstract class AbsTableActivity extends AbsBaseActivity {
  
  private static final String TAG = 
      AbsTableActivity.class.getSimpleName();
  
  private String mTableId;
  private ArrayList<ColumnDefinition> mColumnDefinitions;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mTableId = retrieveTableIdFromIntent();
    if (mTableId == null) {
      WebLogger.getLogger(getAppName()).e(TAG, "[onCreate] table id was not present in Intent.");
      throw new IllegalStateException(
          "A table id was not passed to a table activity");
    }
    
    WebLogger.getLogger(getAppName()).e(TAG, "[onCreate] building mColumnDefinitions.");
    SQLiteDatabase db = null;
    try {
      db = DatabaseFactory.get().getDatabase(this, getAppName());
      mColumnDefinitions = TableUtil.get().getColumnDefinitions(db, getAppName(), getTableId());
    } finally {
      if ( db != null ) {
        db.close();
      }
    }
  }
  
  /**
   * Retrieve the table id from the intent. Returns null if not present.
   * @return
   */
  String retrieveTableIdFromIntent() {
    return this.getIntent().getStringExtra(Constants.IntentKeys.TABLE_ID);
  }

  public String getTableId() {
    return this.mTableId;
  }
  
  public ArrayList<ColumnDefinition> getColumnDefinitions() {
    return this.mColumnDefinitions;
  }
}
