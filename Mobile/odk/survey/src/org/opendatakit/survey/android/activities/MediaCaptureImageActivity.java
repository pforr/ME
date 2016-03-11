/*
 * Copyright (C) 2012-2013 University of Washington
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

package org.opendatakit.survey.android.activities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.opendatakit.common.android.utilities.MediaUtils;
import org.opendatakit.common.android.utilities.ODKFileUtils;
import org.opendatakit.common.android.utilities.WebLogger;
import org.opendatakit.survey.android.R;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images;
import android.widget.Toast;

/**
 * Simple shim for media interactions.
 *
 * @author mitchellsundt@gmail.com
 *
 */
public class MediaCaptureImageActivity extends Activity {
  private static final String t = "MediaCaptureImageActivity";

  private static final int ACTION_CODE = 1;
  private static final String MEDIA_CLASS = "image/";
  private static final String APP_NAME = "appName";
  private static final String URI_FRAGMENT = "uriFragment";
  private static final String CONTENT_TYPE = "contentType";

  private static final String TMP_EXTENSION = ".tmp.jpg";

  private static final String URI_FRAGMENT_NEW_FILE_BASE = "uriFragmentNewFileBase";
  private static final String HAS_LAUNCHED = "hasLaunched";
  private static final String AFTER_RESULT = "afterResult";
  private static final String ERROR_NO_FILE = "Media file does not exist! ";
  private static final String ERROR_COPY_FILE = "Media file copy failed! ";

  private String appName = null;
  private String uriFragmentNewFileBase = null;
  private String uriFragmentToMedia = null;
  private boolean afterResult = false;
  private boolean hasLaunched = false;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Bundle extras = getIntent().getExtras();
    if (extras != null) {
      appName = extras.getString(APP_NAME);
      uriFragmentToMedia = extras.getString(URI_FRAGMENT);
      hasLaunched = extras.getBoolean(HAS_LAUNCHED);
      afterResult = extras.getBoolean(AFTER_RESULT);
      uriFragmentNewFileBase = extras.getString(URI_FRAGMENT_NEW_FILE_BASE);
    }

    if (savedInstanceState != null) {
      appName = savedInstanceState.getString(APP_NAME);
      uriFragmentToMedia = savedInstanceState.getString(URI_FRAGMENT);
      hasLaunched = savedInstanceState.getBoolean(HAS_LAUNCHED);
      afterResult = savedInstanceState.getBoolean(AFTER_RESULT);
      uriFragmentNewFileBase = savedInstanceState.getString(URI_FRAGMENT_NEW_FILE_BASE);
    }

    if (appName == null) {
      throw new IllegalArgumentException("Expected " + APP_NAME
            + " key in intent bundle. Not found.");
    }

    if (uriFragmentToMedia == null) {
      if (uriFragmentNewFileBase == null) {
        throw new IllegalArgumentException("Expected " + URI_FRAGMENT_NEW_FILE_BASE
            + " key in intent bundle. Not found.");
      }
      afterResult = false;
      hasLaunched = false;
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (afterResult) {
      // this occurs if we re-orient the phone during the save-recording
      // action
      returnResult();
    } else if (!hasLaunched && !afterResult) {
      Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
      // workaround for image capture bug
      // create an empty file and pass filename to Camera app.
      if (uriFragmentToMedia == null) {
        uriFragmentToMedia = uriFragmentNewFileBase + TMP_EXTENSION;
      }
      // to make the name unique...
      File mediaFile = ODKFileUtils.getAsFile(appName, uriFragmentToMedia);
      if (!mediaFile.exists()) {
        boolean success = false;
        String errorString = " Could not create: " + mediaFile.getAbsolutePath();
        try {
          success = (mediaFile.getParentFile().exists() || mediaFile.getParentFile().mkdirs())
              && mediaFile.createNewFile();
        } catch (IOException e) {
          WebLogger.getLogger(appName).printStackTrace(e);
          errorString = e.toString();
        } finally {
          if (!success) {
            String err = getString(R.string.media_save_failed);
            WebLogger.getLogger(appName).e(t, err + errorString);
            deleteMedia();
            Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
            setResult(Activity.RESULT_CANCELED);
            finish();
            return;
          }
        }
      }
      i.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(mediaFile));

      try {
        hasLaunched = true;
        startActivityForResult(i, ACTION_CODE);
      } catch (ActivityNotFoundException e) {
        String err = getString(R.string.activity_not_found,
            android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        WebLogger.getLogger(appName).e(t, err);
        deleteMedia();
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
        setResult(Activity.RESULT_CANCELED);
        finish();
      }
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString(APP_NAME, appName);
    outState.putString(URI_FRAGMENT, uriFragmentToMedia);
    outState.putString(URI_FRAGMENT_NEW_FILE_BASE, uriFragmentNewFileBase);
    outState.putBoolean(HAS_LAUNCHED, hasLaunched);
    outState.putBoolean(AFTER_RESULT, afterResult);
  }

  private void deleteMedia() {
    if (uriFragmentToMedia == null) {
      return;
    }
    // get the file path and delete the file
    File f = ODKFileUtils.getAsFile(appName, uriFragmentToMedia);
    String path = f.getAbsolutePath();
    // delete from media provider
    int del = MediaUtils.deleteImageFileFromMediaProvider(this, appName, path);
    WebLogger.getLogger(appName).i(t, "Deleted " + del + " rows from image media content provider");
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent) {

    if (resultCode == Activity.RESULT_CANCELED) {
      // request was canceled -- propagate
      setResult(Activity.RESULT_CANCELED);
      finish();
      return;
    }

    if (uriFragmentToMedia == null) {
      // we are in trouble
      WebLogger.getLogger(appName).e(t, "Unexpectedly null uriFragmentToMedia!");
      setResult(Activity.RESULT_CANCELED);
      finish();
      return;
    }

    if (uriFragmentNewFileBase == null) {
      // we are in trouble
      WebLogger.getLogger(appName).e(t, "Unexpectedly null newFileBase!");
      setResult(Activity.RESULT_CANCELED);
      finish();
      return;
    }

    File f = ODKFileUtils.getAsFile(appName, uriFragmentToMedia);
    Uri mediaUri = Uri.fromFile(f);
    // we never have to deal with deleting, as the Camera is overwriting
    // this...

    // get the file path and create a copy in the instance folder
    String binaryPath = MediaUtils.getPathFromUri(this, (Uri)mediaUri, Images.Media.DATA);
    String extension = binaryPath.substring(binaryPath.lastIndexOf("."));

    File source = new File(binaryPath);
    File sourceMedia = ODKFileUtils.getAsFile(appName, uriFragmentNewFileBase + extension);
    try {
      FileUtils.copyFile(source, sourceMedia);
    } catch (IOException e) {
      WebLogger.getLogger(appName).e(t, ERROR_COPY_FILE + sourceMedia.getAbsolutePath());
      Toast.makeText(this, R.string.media_save_failed, Toast.LENGTH_SHORT).show();
      setResult(Activity.RESULT_CANCELED);
      finish();
      return;
    }

    if (sourceMedia.exists()) {
      // Add the copy to the content provier
      ContentValues values = new ContentValues(6);
      values.put(Audio.Media.TITLE, sourceMedia.getName());
      values.put(Audio.Media.DISPLAY_NAME, sourceMedia.getName());
      values.put(Audio.Media.DATE_ADDED, System.currentTimeMillis());
      values.put(Audio.Media.DATA, sourceMedia.getAbsolutePath());

      Uri MediaURI = getApplicationContext().getContentResolver().insert(
          Images.Media.EXTERNAL_CONTENT_URI, values);
      WebLogger.getLogger(appName).i(t, "Inserting IMAGE returned uri = " + MediaURI.toString());

      if (uriFragmentToMedia != null) {
        deleteMedia();
      }
      uriFragmentToMedia = ODKFileUtils.asUriFragment(appName,  sourceMedia);
      WebLogger.getLogger(appName).i(t, "Setting current answer to " + sourceMedia.getAbsolutePath());
    } else {
      if (uriFragmentToMedia != null) {
        deleteMedia();
      }
      uriFragmentToMedia = null;
      WebLogger.getLogger(appName).e(t, "Inserting Image file FAILED");
    }

    /*
     * We saved the image to the instance directory. Verify that it is there...
     */
    returnResult();
    return;
  }

  private void returnResult() {
    File sourceMedia = (uriFragmentToMedia != null) ?
        ODKFileUtils.getAsFile(appName, uriFragmentToMedia) : null;
    if (sourceMedia != null && sourceMedia.exists()) {
      Intent i = new Intent();
      i.putExtra(URI_FRAGMENT, ODKFileUtils.asUriFragment(appName, sourceMedia));
      String name = sourceMedia.getName();
      i.putExtra(CONTENT_TYPE, MEDIA_CLASS + name.substring(name.lastIndexOf(".") + 1));
      setResult(Activity.RESULT_OK, i);
      finish();
    } else {
      WebLogger.getLogger(appName).e(t, ERROR_NO_FILE
          + ((uriFragmentToMedia != null) ? sourceMedia.getAbsolutePath() : "null mediaPath"));
      Toast.makeText(this, R.string.media_save_failed, Toast.LENGTH_SHORT).show();
      setResult(Activity.RESULT_CANCELED);
      finish();
    }
  }

  @Override
  public void finish() {
    hasLaunched = false;
    afterResult = true;
    super.finish();
  }

}
