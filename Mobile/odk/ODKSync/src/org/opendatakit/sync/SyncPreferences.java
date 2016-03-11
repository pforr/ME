package org.opendatakit.sync;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.opendatakit.common.android.utilities.WebLogger;
import org.opendatakit.sync.exceptions.NoAppNameSpecifiedException;

import android.content.Context;

public class SyncPreferences {

  private static final String LOGTAG = SyncPreferences.class.getSimpleName();

  private static final String POST_FIX_FILE_NAME = "sync_pref";
  private static final String SERVER_URI_KEY = "serverUri";
  private static final String ACCOUNT_KEY = "account";
  private static final String AUTH_KEY = "auth";

  private final Properties prop;

  private final Context cntxt;

  private final String fileName;

  /**
   * Construct a sync preferences object that is based on appName that saves the
   * preferences to a file in internal Android storage
   * 
   * @param context
   * @param appName
   * @throws NoAppNameSpecifiedException
   * @throws IOException
   */

  public SyncPreferences(Context context, String appName) throws NoAppNameSpecifiedException,
      IOException {
    if (appName == null) {
      throw new NoAppNameSpecifiedException(
          "No appName specified so can't read in the SyncPreferences");
    }

    this.cntxt = context;
    this.prop = new Properties();
    this.fileName = appName + POST_FIX_FILE_NAME;

    FileInputStream in;
    try {
      in = cntxt.openFileInput(fileName);
      this.prop.load(in);
      in.close();
    } catch (FileNotFoundException e) {
      WebLogger.getLogger(appName).d(LOGTAG, "NO previously existing SyncPreferences File found");
    }

  }

  /**
   * THIS CONSTRUCTOR SHOULD BE USED FOR TESTING ONLY
   * 
   * @param context
   * @throws NoAppNameSpecifiedException
   * @throws IOException
   */
  SyncPreferences(Context context) throws NoAppNameSpecifiedException, IOException {
    this(context, "TEST_FRAMEWORK");
  }

  private void storePreferences() throws IOException {
    FileOutputStream out = cntxt.openFileOutput(fileName, Context.MODE_PRIVATE);
    this.prop.store(out, "Sync Properties");
    out.close();
  }

  public void setServerUri(String serverUri) throws IOException {
    if (serverUri != null) {
      this.prop.setProperty(SERVER_URI_KEY, serverUri);
    } else {
      this.prop.remove(SERVER_URI_KEY);
    }
    storePreferences();
  }

  public String getServerUri() {
    return prop.getProperty(SERVER_URI_KEY, null);
  }

  public void setAccount(String accountName) throws IOException {
    if (accountName != null) {
      this.prop.setProperty(ACCOUNT_KEY, accountName);
    } else {
      this.prop.remove(ACCOUNT_KEY);
    }
    storePreferences();
  }

  public String getAccount() {
    return prop.getProperty(ACCOUNT_KEY, null);
  }

  public void setAuthToken(String authToken) throws IOException {
    if (authToken != null) {
      this.prop.setProperty(AUTH_KEY, authToken);
    } else {
      this.prop.remove(AUTH_KEY);
    }
    storePreferences();
  }

  public String getAuthToken() {
    return prop.getProperty(AUTH_KEY, null);
  }
}
