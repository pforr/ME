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

import org.opendatakit.aggregate.odktables.rest.ConflictType;
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
public class ConflictResolutionListActivity extends ListActivity {

  private static final String TAG = ConflictResolutionListActivity.class.getSimpleName();

  private static final int RESOLVE_ROW_RESULT = 1;

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
      table = ODKDatabaseUtils.get().rawSqlQuery(
          db,
          mAppName,
          mTableId,
          orderedDefns,
          DataTableColumns.CONFLICT_TYPE + " IN ( ?, ?)",
          new String[] { Integer.toString(ConflictType.LOCAL_DELETED_OLD_VALUES),
              Integer.toString(ConflictType.LOCAL_UPDATED_UPDATED_VALUES) }, null, null,
          DataTableColumns.ID, "ASC");
    } finally {
      db.close();
    }

    if (table != null) {
      if (table.getNumberOfRows() == 0) {
        this.setResult(RESULT_OK);
        finish();
        return;
      }

      this.mAdapter = new ArrayAdapter<ResolveRowEntry>(getActionBar().getThemedContext(),
          android.R.layout.simple_list_item_1);

      ResolveRowEntry firstE = null;
      for (int i = 0; i < table.getNumberOfRows(); i++) {
        Row localRow = table.getRowAtIndex(i);
        String localRowId = localRow.getRawDataOrMetadataByElementKey(DataTableColumns.ID);
        ResolveRowEntry e = new ResolveRowEntry(localRowId, "Resolve Conflict w.r.t. Server Row "
            + i);
        this.mAdapter.add(e);
        if (firstE == null) {
          firstE = e;
        }
      }
      this.setListAdapter(mAdapter);

      if (table.getNumberOfRows() == 1) {
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
    WebLogger.getLogger(mAppName).e(TAG, "[onListItemClick] clicked position: " + position);
    ResolveRowEntry e = this.mAdapter.getItem(position);
    launchRowResolution(e);
  }

  private void launchRowResolution(ResolveRowEntry e) {
    Intent i = new Intent(this, ConflictResolutionRowActivity.class);
    i.putExtra(Constants.APP_NAME, mAppName);
    i.putExtra(Constants.TABLE_ID, mTableId);
    i.putExtra(ConflictResolutionRowActivity.INTENT_KEY_ROW_ID, e.rowId);
    this.startActivityForResult(i, RESOLVE_ROW_RESULT);
  }

}
