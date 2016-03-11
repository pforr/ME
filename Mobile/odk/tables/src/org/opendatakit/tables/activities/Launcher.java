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
package org.opendatakit.tables.activities;

import java.io.File;
import java.util.List;

import org.opendatakit.common.android.data.Preferences;
import org.opendatakit.common.android.utilities.ODKFileUtils;
import org.opendatakit.common.android.utilities.UrlUtils;
import org.opendatakit.common.android.utilities.WebLogger;
import org.opendatakit.tables.application.Tables;
import org.opendatakit.tables.fragments.InitializeTaskDialogFragment;
import org.opendatakit.tables.provider.TablesProviderAPI;
import org.opendatakit.tables.tasks.InitializeTask;
import org.opendatakit.tables.utils.Constants;
import org.opendatakit.tables.utils.IntentUtil;
import org.opendatakit.tables.utils.TableFileUtils;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class Launcher extends AbsBaseActivity implements
InitializeTask.Callbacks {

	private static final String TAG = Launcher.class.getName();

	private String mAppName;
	/**
	 * The URI segment to a file that may be specified by callers. This is
	 * essentially a file name (e.g. assets/index.html), but it represents a URI
	 * on a scheme and host that will be opened by a server. As such it can
	 * include a hash and query parameters (e.g. assets/index.html#foo?bar=baz).
	 * In this case the full URL would be something like
	 * http://localhost:8635/assets/index.html#foo?bar=baz.
	 */
	private String mFileName;

	protected void retrieveValuesFromIntent() {
		Intent intent = this.getIntent();
		Bundle extras = intent.getExtras();
		this.mAppName = IntentUtil.retrieveAppNameFromBundle(extras);
		if (this.mAppName == null) {
			this.mAppName = TableFileUtils.getDefaultAppName();
		}
		this.mFileName = IntentUtil.retrieveFileNameFromBundle(extras);
	}

	protected Preferences createPreferences() {
		Preferences preferences = new Preferences(this, this.mAppName);
		return preferences;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.retrieveValuesFromIntent();

		Uri uri = getIntent().getData();
		if (uri != null) {
			final Uri uriTablesProvider = TablesProviderAPI.CONTENT_URI;
			if (uri.getScheme().equalsIgnoreCase(uriTablesProvider.getScheme())
					&& uri.getAuthority().equalsIgnoreCase(
							uriTablesProvider.getAuthority())) {
				List<String> segments = uri.getPathSegments();
				if (segments != null && segments.size() >= 1) {
					this.mAppName = segments.get(0);
				}
			}
		}

		// ensuring directories exist
		ODKFileUtils.verifyExternalStorageAvailability();
		ODKFileUtils.assertDirectoryStructure(this.mAppName);

		Preferences preferences = this.createPreferences();

		// First determine if we're supposed to use a custom home screen.
		// Do a check also to make sure the file actually exists.
		if (useDefaultHomeScreen() || this.customFileSpecified()) {

			String relativePathToFile = null;
			if (this.customFileSpecified()) {
				String fileNameWithoutParameters = UrlUtils
						.getFileNameFromUriSegment(this.mFileName);
				File customFile = ODKFileUtils.asAppFile(mAppName,
						fileNameWithoutParameters);
				if (!customFile.exists()) {
					Toast.makeText(
							this,
							"File does not exist: "
									+ customFile.getAbsolutePath(),
							Toast.LENGTH_SHORT).show();
					this.finish();
					return;
				}
				relativePathToFile = ODKFileUtils.asRelativePath(mAppName,
						customFile);
				// And now we need to add any potential query parameters that
				// were
				// originally passed in.
				String hashAndParameters = UrlUtils
						.getParametersFromSegment(this.mFileName);
				// Safe to append directly, as if there no parameters will
				// return an
				// empty string.
				relativePathToFile = relativePathToFile + hashAndParameters;
			} else {
				File defaultHomeScreen = new File(
						ODKFileUtils.getTablesHomeScreenFile(this.mAppName));
				relativePathToFile = ODKFileUtils.asRelativePath(mAppName,
						defaultHomeScreen);
				WebLogger.getLogger(mAppName).d(TAG,
						"homescreen file exists and is set to be used.");
			}

			Uri data = getIntent().getData();
			Bundle extras = getIntent().getExtras();

			Intent i = new Intent(this, WebViewActivity.class);
			if (data != null) {
				i.setData(data);
			}
			if (extras != null) {
				i.putExtras(extras);
			}
			i.putExtra(Constants.IntentKeys.APP_NAME, this.mAppName);
			i.putExtra(Constants.IntentKeys.FILE_NAME, relativePathToFile);
			startActivity(i);
		} else {
			WebLogger.getLogger(mAppName).d(TAG,
					"no homescreen file found, launching TableManager");
			// First set the prefs to false. This is useful in the case where
			// someone has configured an app to use a home screen and then
			// deleted that file out from under it.
			preferences.setUseHomeScreen(false);
			// Launch the TableManager.

			Uri data = getIntent().getData();
			Bundle extras = getIntent().getExtras();

			Intent i = new Intent(this, Login.class);
			if (data != null) {
				i.setData(data);
			}
			if (extras != null) {
				i.putExtras(extras);
			}
			i.putExtra(Constants.IntentKeys.APP_NAME, this.mAppName);
			startActivity(i);
		}
		finish();
	}

	protected boolean customFileSpecified() {
		return this.mFileName != null;
	}

	/**
	 * Sets if the default home screen should be launched.
	 * 
	 * @return
	 */
	protected boolean useDefaultHomeScreen() {
		Preferences preferences = this.createPreferences();
		File userHomeScreen = new File(
				ODKFileUtils.getTablesHomeScreenFile(this.mAppName));
		return preferences.getUseHomeScreen() && userHomeScreen.exists();
	}

	@Override
	public Preferences getPrefs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onImportsComplete() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onResume() {
		super.onResume();
		// Check to see if we need to initialize.
		if (Tables.getInstance().shouldRunInitializationTask(mAppName)) {
			this.startInitializationTask();
			//
		}
		// showDialogdangNhap();
	}
	private void startInitializationTask() {
		InitializeTask initializeTask = new InitializeTask(this,
				this.getAppName());
		InitializeTaskDialogFragment initializeTaskDialogFragment = new InitializeTaskDialogFragment();
		initializeTaskDialogFragment.setTask(initializeTask);
		initializeTaskDialogFragment.setCallbacks(this);
		initializeTaskDialogFragment.setCancelable(false);
		initializeTask.setDialogFragment(initializeTaskDialogFragment);
		FragmentManager fragmentManager = this.getFragmentManager();
		initializeTaskDialogFragment.show(fragmentManager,
				InitializeTaskDialogFragment.TAG_FRAGMENT);
		// fire off the initializeTask
		Void v = null;
		initializeTask.execute(v);
		// if initialization task dies, don't try to restart it...
		Tables.getInstance().clearRunInitializationTask(mAppName);
	}
}
