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
package org.opendatakit.common.android.utilities;

import java.net.URI;
import java.util.ArrayList;

import org.opendatakit.aggregate.odktables.rest.TableConstants;
import org.opendatakit.common.android.database.DatabaseConstants;
import org.opendatakit.common.android.database.DatabaseFactory;
import org.opendatakit.common.android.provider.SyncETagColumns;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SyncETagsUtils {

  /**
   * For ease of mocking...
   */
  public SyncETagsUtils() {
  }

  /**
   * Remove all ETags for the given table. Invoked when we delete a table...
   * 
   * @param db
   * @param tableId
   */
  public void deleteAllSyncETags(SQLiteDatabase db, String tableId) {

    ArrayList<String> bindArgs = new ArrayList<String>();
    StringBuilder b = new StringBuilder();
    //@formatter:off
    b.append("DELETE FROM ")
     .append("\"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" WHERE ")
     .append(SyncETagColumns.TABLE_ID);
    //@formatter:on
    if ( tableId == null ) {
      b.append(" IS NULL");
    } else {
      b.append("=?");
      bindArgs.add(tableId);
    }

    boolean inTransaction = db.inTransaction();
    
    try {
      if ( !inTransaction ) {
        db.beginTransaction();
      }
      db.execSQL(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));
      if ( !inTransaction ) {
        db.setTransactionSuccessful();
      }
    } finally {
      if ( !inTransaction ) {
        db.endTransaction();
      }
    }
    
  }

  /**
   * Remove all ETags for anything other than the given server. 
   * Invoked when we change the target sync server...
   * 
   * @param db
   * @param tableId
   */
  public void deleteAllSyncETagsExceptForServer(SQLiteDatabase db, URI serverUriPrefix) {

    ArrayList<String> bindArgs = new ArrayList<String>();
    StringBuilder b = new StringBuilder();
    //@formatter:off
    b.append("DELETE FROM ")
     .append("\"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" WHERE ")
     .append(SyncETagColumns.URL);
    //@formatter:on
    if ( serverUriPrefix == null ) {
      // i.e., delete everything
      b.append(" IS NOT NULL");
    } else {
      String urlString = serverUriPrefix.toString();
      // delete anything not beginning with this prefix
      b.append(" IS NULL")
       .append(" OR length(").append(SyncETagColumns.URL).append(") < ?");
      bindArgs.add(Integer.toString(urlString.length()));
      b.append(" OR substr(").append(SyncETagColumns.URL).append(",1,?) != ?");
      bindArgs.add(Integer.toString(urlString.length()));
      bindArgs.add(urlString);
    }

    boolean inTransaction = db.inTransaction();
    
    try {
      if ( !inTransaction ) {
        db.beginTransaction();
      }
      db.execSQL(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));
      if ( !inTransaction ) {
        db.setTransactionSuccessful();
      }
    } finally {
      if ( !inTransaction ) {
        db.endTransaction();
      }
    }
    
  }

  /**
   * Remove all ETags for anything other than the given server. 
   * Invoked when we change the target sync server...
   * 
   * @param db
   * @param tableId
   */
  public void deleteAllSyncETagsUnderServerUri(SQLiteDatabase db, URI serverUriPrefix) {

    if ( serverUriPrefix == null ) {
      throw new IllegalArgumentException("must specify a serverUriPrefix");
    }
    String urlString = serverUriPrefix.toString();
    
    ArrayList<String> bindArgs = new ArrayList<String>();
    StringBuilder b = new StringBuilder();
    //@formatter:off
    b.append("DELETE FROM ")
     .append("\"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" WHERE ")
     .append(SyncETagColumns.URL).append(" IS NOT NULL");
    // delete anything not beginning with this prefix...
    // ...long enough
    b.append(" AND length(").append(SyncETagColumns.URL).append(") >= ?");
    bindArgs.add(Integer.toString(urlString.length()));
    // ...shares prefix
    b.append(" AND substr(").append(SyncETagColumns.URL).append(",1,?) = ?");
    bindArgs.add(Integer.toString(urlString.length()));
    bindArgs.add(urlString);
    //@formatter:on

    boolean inTransaction = db.inTransaction();
    
    try {
      if ( !inTransaction ) {
        db.beginTransaction();
      }
      db.execSQL(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));
      if ( !inTransaction ) {
        db.setTransactionSuccessful();
      }
    } finally {
      if ( !inTransaction ) {
        db.endTransaction();
      }
    }
    
  }
  
  public String getManifestSyncETag(Context context, String appName, URI url, String tableId) {

    ArrayList<String> bindArgs = new ArrayList<String>();
    StringBuilder b = new StringBuilder();
    //@formatter:off
    b.append("SELECT ").append(SyncETagColumns.ETAG_MD5_HASH).append(" FROM ")
     .append("\"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" WHERE ")
     .append(SyncETagColumns.TABLE_ID);
    //@formatter:on
    if ( tableId == null ) {
      b.append(" IS NULL");
    } else {
      b.append("=?");
      bindArgs.add(tableId);
    }
    b.append(" AND ").append(SyncETagColumns.IS_MANIFEST).append("=?");
    bindArgs.add(Integer.toString(DataHelper.boolToInt(true)));
    b.append(" AND ").append(SyncETagColumns.URL).append("=?");
    bindArgs.add(url.toString());
    b.append(" ORDER BY ").append(SyncETagColumns.LAST_MODIFIED_TIMESTAMP).append(" DESC");

    SQLiteDatabase db = null;
    Cursor c = null;
    try {
      db = DatabaseFactory.get().getDatabase(context, appName);
      c = db.rawQuery(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));
      
      if ( c.getCount() == 0 ) {
        // unknown...
        return null;
      }
      
      if ( c.getCount() > 1 ) {
        // TODO: log something
      }
      
      c.moveToFirst();
      int idx = c.getColumnIndex(SyncETagColumns.ETAG_MD5_HASH);
      if ( c.isNull(idx) ) {
        // shouldn't happen...
        return null;
      }
      String value = c.getString(idx);
      return value;
    } finally {
      if ( c != null && !c.isClosed() ) {
        c.close();
      }
      if ( db != null ) {
        db.close();
      }
    }
  }

  public void updateManifestSyncETag(Context context, String appName, URI url, String tableId, String etag) {

    ArrayList<String> bindArgs = new ArrayList<String>();
    StringBuilder b = new StringBuilder();
    //@formatter:off
    b.append("DELETE FROM ")
     .append("\"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" WHERE ")
     .append(SyncETagColumns.TABLE_ID);
    //@formatter:on
    if ( tableId == null ) {
      b.append(" IS NULL");
    } else {
      b.append("=?");
      bindArgs.add(tableId);
    }
    b.append(" AND ").append(SyncETagColumns.IS_MANIFEST).append("=?");
    bindArgs.add(Integer.toString(DataHelper.boolToInt(true)));
    b.append(" AND ").append(SyncETagColumns.URL).append("=?");
    bindArgs.add(url.toString());

    SQLiteDatabase db = null;
    try {
      db = DatabaseFactory.get().getDatabase(context, appName);
      
      db.beginTransaction();
      db.execSQL(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));

      if ( etag != null ) {
        b.setLength(0);
        bindArgs.clear();
        //@formatter:off
        b.append("INSERT INTO \"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" (")
         .append(SyncETagColumns.TABLE_ID).append(",")
         .append(SyncETagColumns.IS_MANIFEST).append(",")
         .append(SyncETagColumns.URL).append(",")
         .append(SyncETagColumns.LAST_MODIFIED_TIMESTAMP).append(",")
         .append(SyncETagColumns.ETAG_MD5_HASH).append(") VALUES (");
        //@formatter:on
        if ( tableId == null ) {
          b.append("NULL,");
        } else {
          b.append("?,");
          bindArgs.add(tableId);
        }
        b.append("?,?,?,?)");
        bindArgs.add(Integer.toString(DataHelper.boolToInt(true)));
        bindArgs.add(url.toString());
        bindArgs.add(TableConstants.nanoSecondsFromMillis(System.currentTimeMillis()));
        bindArgs.add(etag);
  
        db.execSQL(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));
      }
      db.setTransactionSuccessful();
    } finally {
      if ( db != null ) {
        db.endTransaction();
        db.close();
      }
    }
  }

  
  /**
   * @param context
   * @param appName
   * @param url
   * @param tableId
   * @param modified
   * @return
   */
  public String getFileSyncETag(Context context, String appName, URI url, String tableId, long modified) {

    ArrayList<String> bindArgs = new ArrayList<String>();
    StringBuilder b = new StringBuilder();
    //@formatter:off
    b.append("SELECT ").append(SyncETagColumns.ETAG_MD5_HASH).append(",")
     .append(SyncETagColumns.LAST_MODIFIED_TIMESTAMP).append(" FROM ")
     .append("\"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" WHERE ")
     .append(SyncETagColumns.TABLE_ID);
    //@formatter:on
    if ( tableId == null ) {
      b.append(" IS NULL");
    } else {
      b.append("=?");
      bindArgs.add(tableId);
    }
    b.append(" AND ").append(SyncETagColumns.IS_MANIFEST).append("=?");
    bindArgs.add(Integer.toString(DataHelper.boolToInt(false)));
    b.append(" AND ").append(SyncETagColumns.URL).append("=?");
    bindArgs.add(url.toString());
    b.append(" ORDER BY ").append(SyncETagColumns.LAST_MODIFIED_TIMESTAMP).append(" DESC");

    SQLiteDatabase db = null;
    Cursor c = null;
    try {
      db = DatabaseFactory.get().getDatabase(context, appName);
      c = db.rawQuery(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));
      
      if ( c.getCount() == 0 ) {
        // unknown...
        return null;
      }
      
      if ( c.getCount() > 1 ) {
        // TODO: log something
      }
      
      c.moveToFirst();
      int idx = c.getColumnIndex(SyncETagColumns.ETAG_MD5_HASH);
      int idxLMT = c.getColumnIndex(SyncETagColumns.LAST_MODIFIED_TIMESTAMP);
      if ( c.isNull(idx) ) {
        // shouldn't happen...
        return null;
      }
      String value = c.getString(idx);
      String lmtValue = c.getString(idxLMT);
      Long modifiedTime = TableConstants.milliSecondsFromNanos(lmtValue);
      if ( modifiedTime.equals(modified) ) {
        return value;
      }
      return null;
    } finally {
      if ( c != null && !c.isClosed() ) {
        c.close();
      }
      if ( db != null ) {
        db.close();
      }
    }
  }

  public void updateFileSyncETag(Context context, String appName, URI url, String tableId, long modified, String etag) {

    ArrayList<String> bindArgs = new ArrayList<String>();
    StringBuilder b = new StringBuilder();
    //@formatter:off
    b.append("DELETE FROM ")
     .append("\"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" WHERE ")
     .append(SyncETagColumns.TABLE_ID);
    //@formatter:on
    if ( tableId == null ) {
      b.append(" IS NULL");
    } else {
      b.append("=?");
      bindArgs.add(tableId);
    }
    b.append(" AND ").append(SyncETagColumns.IS_MANIFEST).append("=?");
    bindArgs.add(Integer.toString(DataHelper.boolToInt(false)));
    b.append(" AND ").append(SyncETagColumns.URL).append("=?");
    bindArgs.add(url.toString());

    SQLiteDatabase db = null;
    try {
      db = DatabaseFactory.get().getDatabase(context, appName);
      
      db.beginTransaction();
      db.execSQL(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));

      if ( etag != null ) {
        b.setLength(0);
        bindArgs.clear();
        //@formatter:off
        b.append("INSERT INTO \"").append(DatabaseConstants.SYNC_ETAGS_TABLE_NAME).append("\" (")
         .append(SyncETagColumns.TABLE_ID).append(",")
         .append(SyncETagColumns.IS_MANIFEST).append(",")
         .append(SyncETagColumns.URL).append(",")
         .append(SyncETagColumns.LAST_MODIFIED_TIMESTAMP).append(",")
         .append(SyncETagColumns.ETAG_MD5_HASH).append(") VALUES (");
        //@formatter:on
        if ( tableId == null ) {
          b.append("NULL,");
        } else {
          b.append("?,");
          bindArgs.add(tableId);
        }
        b.append("?,?,?,?)");
        bindArgs.add(Integer.toString(DataHelper.boolToInt(false)));
        bindArgs.add(url.toString());
        bindArgs.add(TableConstants.nanoSecondsFromMillis(modified));
        bindArgs.add(etag);
  
        db.execSQL(b.toString(), bindArgs.toArray(new String[bindArgs.size()]));
      }
      db.setTransactionSuccessful();
    } finally {
      if ( db != null ) {
        db.endTransaction();
        db.close();
      }
    }
  }

}
