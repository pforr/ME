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
package org.opendatakit.sync.files;

import android.util.Log;

/**
 * A utility class for common synchronization methods and definitions.
 */
public class SyncUtil {

  /** The default app name for ODK Sync */
  private static final String DEFAULT_APP_NAME = "tables";

  public static final String getDefaultAppName() {
    Log.w("SyncUtil", "appName is null on intent");
    Thread.dumpStack();
    return DEFAULT_APP_NAME;
  }
}
