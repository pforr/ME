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
package org.opendatakit.conflict.activities;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.opendatakit.common.android.data.ColumnDefinition;
import org.opendatakit.common.android.data.UserTable;
import org.opendatakit.common.android.data.UserTable.Row;
import org.opendatakit.common.android.database.DatabaseFactory;
import org.opendatakit.common.android.provider.DataTableColumns;
import org.opendatakit.common.android.utilities.ODKDatabaseUtils;
import org.opendatakit.common.android.utilities.TableUtil;
import org.opendatakit.common.android.utilities.WebLogger;

import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * An activity for presenting a list of all the rows in conflict.
 *
 * @author sudar.sam@gmail.com
 *
 */
public class CheckpointResolutionListActivity extends ListActivity {

  private static final String TAG = CheckpointResolutionListActivity.class.getSimpleName();

  private static final int RESOLVE_ROW = 1;

  private String mAppName;
  private String mTableId;
  private ArrayAdapter<ResolveRowEntry> mAdapter;

  private static final class ResolveRowEntry {
    final String rowId;
    final String displayName;

    ResolveRowEntry(String rowId, String displayName) {
      this.rowId = rowId;
      this.displayName = displayName;
    }

    public String toString() {
      return displayName;
    }
  };

  @Override
  protected void onResume() {
    super.onResume();
    // Do this in on resume so that if we resolve a row it will be refreshed
    // when we come back.
    mAppName = getIntent().getStringExtra(Constants.APP_NAME);
    if (mAppName == null) {
      mAppName = Constants.DEFAULT_APP_NAME;
    }
    mTableId = getIntent().getStringExtra(Constants.TABLE_ID);

    SQLiteDatabase db = null;
    UserTable table = null;
    try {
      db = DatabaseFactory.get().getDatabase(this, mAppName);
      ArrayList<ColumnDefinition> orderedDefns = TableUtil.get().getColumnDefinitions(db, mAppName,
          mTableId);
      table = ODKDatabaseUtils.get().rawSqlQuery(db, mAppName, mTableId, orderedDefns,
          DataTableColumns.SAVEPOINT_TYPE + " IS NULL", null, null, null, DataTableColumns.ID,
          "ASC");
    } finally {
      db.close();
    }
    if (table != null) {
      this.mAdapter = new ArrayAdapter<ResolveRowEntry>(getActionBar().getThemedContext(),
          android.R.layout.simple_list_item_1);
      Set<String> rowIds = new TreeSet<String>();
      for (int i = 0; i < table.getNumberOfRows(); i++) {
        Row row = table.getRowAtIndex(i);
        String rowId = row.getRawDataOrMetadataByElementKey(DataTableColumns.ID);
        rowIds.add(rowId);
      }
      if (rowIds.isEmpty()) {
        this.setResult(RESULT_OK);
        finish();
        return;
      }

      ResolveRowEntry firstE = null;
      int i = 0;
      for (String rowId : rowIds) {
        ++i;
        ResolveRowEntry e = new ResolveRowEntry(rowId, "Resolve ODK Survey Checkpoint Record " + i);
        this.mAdapter.add(e);
        if (firstE == null) {
          firstE = e;
        }
      }
      this.setListAdapter(mAdapter);

      if (rowIds.size() == 1) {
        launchRowResolution(firstE);
      }
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    ResolveRowEntry e = mAdapter.getItem(position);
    WebLogger.getLogger(mAppName).e(TAG,
        "[onListItemClick] clicked position: " + position + " rowId: " + e.rowId);
    launchRowResolution(e);
  }

  private void launchRowResolution(ResolveRowEntry e) {
    Intent i = new Intent(this, CheckpointResolutionRowActivity.class);
    i.putExtra(Constants.APP_NAME, mAppName);
    i.putExtra(Constants.TABLE_ID, mTableId);
    i.putExtra(CheckpointResolutionRowActivity.INTENT_KEY_ROW_ID, e.rowId);
    this.startActivityForResult(i, RESOLVE_ROW);
  }

}
