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
package org.opendatakit.sync.service;

import java.util.HashMap;
import java.util.Map;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class OdkSyncService extends Service {

  private static final String LOGTAG = OdkSyncService.class.getSimpleName();

  private Map<String, AppSynchronizer> syncs;
  private OdkSyncServiceInterfaceImpl serviceInterface;
  private GlobalSyncNotificationManager notificationManager;

  @Override
  public void onCreate() {
    serviceInterface = new OdkSyncServiceInterfaceImpl(this);
    syncs = new HashMap<String, AppSynchronizer>();
    notificationManager = new GlobalSyncNotificationManager(this);
  }

  @Override
  public IBinder onBind(Intent intent) {
    return serviceInterface;
  }

  @Override
  public void onDestroy() {
    Log.i(LOGTAG, "Service is shutting down");

  }

  private AppSynchronizer getSync(String appName) {
    AppSynchronizer sync = syncs.get(appName);
    if (sync == null) {
      sync = new AppSynchronizer(this, appName, notificationManager);
      syncs.put(appName, sync);
    }
    return sync;

  }

  public boolean push(String appName) {
    AppSynchronizer sync = getSync(appName);
    return sync.synchronize(true, false,null);
  }

  public boolean synchronize(String appName, boolean deferInstanceAttachments,String acc) {
	     AppSynchronizer sync = getSync(appName);
    return sync.synchronize(false, deferInstanceAttachments,acc);
  }

  public SyncStatus getStatus(String appName) {
    AppSynchronizer sync = getSync(appName);
    return sync.getStatus();
  }

  public SyncProgressState getSyncProgress(String appName) {
    AppSynchronizer sync = getSync(appName);
    return sync.getProgressState();
  }

  public String getSyncUpdateMessage(String appName) {
    AppSynchronizer sync = getSync(appName);
    return sync.getSyncUpdateText();
  }

}
