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

package org.opendatakit.survey.android.fragments;

import java.util.ArrayList;

import org.opendatakit.common.android.utilities.WebLogger;
import org.opendatakit.survey.android.R;
import org.opendatakit.survey.android.activities.ODKActivity;
import org.opendatakit.survey.android.fragments.AlertDialogFragment.ConfirmAlertDialog;
import org.opendatakit.survey.android.fragments.ProgressDialogFragment.CancelProgressDialog;
import org.opendatakit.survey.android.listeners.InitializationListener;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Attempt to initialize data directories using the APK Expansion files.
 *
 * @author mitchellsundt@gmail.com
 *
 */
public class InitializationFragment extends Fragment implements InitializationListener,
    ConfirmAlertDialog, CancelProgressDialog {

  private static final String t = "InitializationFragment";

  public static final int ID = R.layout.copy_expansion_files_layout;

  private static enum DialogState {
    Init, Progress, Alert, None
  };

  // keys for the data being retained

  private static final String DIALOG_TITLE = "dialogTitle";
  private static final String DIALOG_MSG = "dialogMsg";
  private static final String DIALOG_STATE = "dialogState";
  private static final String FRAGMENT_TO_SHOW_NEXT = "fragmentToShowNext";

  // data to retain across orientation changes

  private String mAlertTitle;
  private String mAlertMsg;
  private DialogState mDialogState = DialogState.Init;
  private String mFragmentToShowNext;

  // data that is not retained

  private View view;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public void setFragmentToShowNext(String nextFragment) {
    mFragmentToShowNext = nextFragment;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view = inflater.inflate(ID, container, false);

    if (savedInstanceState != null) {

      // to restore alert dialog.
      if (savedInstanceState.containsKey(DIALOG_TITLE)) {
        mAlertTitle = savedInstanceState.getString(DIALOG_TITLE);
      }
      if (savedInstanceState.containsKey(DIALOG_MSG)) {
        mAlertMsg = savedInstanceState.getString(DIALOG_MSG);
      }
      if (savedInstanceState.containsKey(DIALOG_STATE)) {
        mDialogState = DialogState.valueOf(savedInstanceState.getString(DIALOG_STATE));
      }

      if (savedInstanceState.containsKey(FRAGMENT_TO_SHOW_NEXT)) {
        mFragmentToShowNext = savedInstanceState.getString(FRAGMENT_TO_SHOW_NEXT);
      }
    }

    return view;
  }

  /**
   * Starts the download task and shows the progress dialog.
   */
  private void intializeAppName() {
    // set up the first dialog, but don't show it...
    mAlertTitle = getString(R.string.configuring_survey);
    mAlertMsg = getString(R.string.please_wait);
    mDialogState = DialogState.Progress;

    // launch the copy operation
    BackgroundTaskFragment f = (BackgroundTaskFragment) getFragmentManager().findFragmentByTag(
        "background");
    WebLogger.getLogger(((ODKActivity) getActivity()).getAppName()).i(t,
        "initializeAppName called ");
    f.initializeAppName(((ODKActivity) getActivity()).getAppName(), this);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (mAlertTitle != null) {
      outState.putString(DIALOG_TITLE, mAlertTitle);
    }
    if (mAlertMsg != null) {
      outState.putString(DIALOG_MSG, mAlertMsg);
    }
    outState.putString(DIALOG_STATE, mDialogState.name());
    outState.putString(FRAGMENT_TO_SHOW_NEXT, mFragmentToShowNext);
  }

  @Override
  public void onResume() {
    FragmentManager mgr = getFragmentManager();

    // re-attach to the background fragment for task notifications...
    BackgroundTaskFragment f = (BackgroundTaskFragment) mgr.findFragmentByTag("background");

    f.establishInitializationListener(this);

    super.onResume();

    if (mDialogState == DialogState.Init) {
      WebLogger.getLogger(((ODKActivity) getActivity()).getAppName()).i(t,
          "onResume -- calling initializeAppName");
      intializeAppName();
    }

    if (mDialogState == DialogState.Progress) {
      restoreProgressDialog();
    } else if (mDialogState == DialogState.Alert) {
      restoreAlertDialog();
    }
  }

  @Override
  public void onPause() {
    FragmentManager mgr = getFragmentManager();

    // dismiss dialogs...
    AlertDialogFragment alertDialog = (AlertDialogFragment) mgr.findFragmentByTag("alertDialog");
    if (alertDialog != null) {
      alertDialog.dismiss();
    }
    ProgressDialogFragment progressDialog = (ProgressDialogFragment) mgr
        .findFragmentByTag("progressDialog");
    if (progressDialog != null) {
      progressDialog.dismiss();
    }
    super.onPause();
  }

  @Override
  public void initializationComplete(boolean overallSuccess, ArrayList<String> result) {
    try {
      dismissProgressDialog();
    } catch (IllegalArgumentException e) {
      WebLogger.getLogger(((ODKActivity) getActivity()).getAppName()).i(t,
          "Attempting to close a dialog that was not previously opened");
    }

    BackgroundTaskFragment f = (BackgroundTaskFragment) getFragmentManager().findFragmentByTag(
        "background");
    f.clearInitializationTask();

    if (overallSuccess && result.isEmpty()) {
      // do not require an OK if everything went well
      Fragment progress = getFragmentManager().findFragmentByTag("progressDialog");
      if (progress != null) {
        ((ProgressDialogFragment) progress).dismiss();
        mDialogState = DialogState.None;
      }

      ((ODKActivity) getActivity()).initializationCompleted(mFragmentToShowNext);
      return;
    }

    StringBuilder b = new StringBuilder();
    for (String k : result) {
      b.append(k);
      b.append("\n\n");
    }

    createAlertDialog(overallSuccess ? getString(R.string.initialization_complete)
        : getString(R.string.initialization_failed), b.toString().trim());
  }

  private void restoreProgressDialog() {
    Fragment alert = getFragmentManager().findFragmentByTag("alertDialog");
    if (alert != null) {
      ((AlertDialogFragment) alert).dismiss();
    }

    Fragment dialog = getFragmentManager().findFragmentByTag("progressDialog");

    if (dialog != null && ((ProgressDialogFragment) dialog).getDialog() != null) {
      mDialogState = DialogState.Progress;
      ((ProgressDialogFragment) dialog).getDialog().setTitle(mAlertTitle);
      ((ProgressDialogFragment) dialog).setMessage(mAlertMsg);

    } else {

      ProgressDialogFragment f = ProgressDialogFragment
          .newInstance(getId(), mAlertTitle, mAlertMsg);

      mDialogState = DialogState.Progress;
      f.show(getFragmentManager(), "progressDialog");
    }
  }

  private void updateProgressDialogMessage(String message) {
    if (mDialogState == DialogState.Progress) {
      mAlertTitle = getString(R.string.configuring_survey);
      mAlertMsg = message;
      restoreProgressDialog();
    }
  }

  private void dismissProgressDialog() {
    if (mDialogState == DialogState.Progress) {
      mDialogState = DialogState.None;
    }
    Fragment dialog = getFragmentManager().findFragmentByTag("progressDialog");
    if (dialog != null) {
      ((ProgressDialogFragment) dialog).dismiss();
    }
  }

  private void restoreAlertDialog() {
    Fragment progress = getFragmentManager().findFragmentByTag("progressDialog");
    if (progress != null) {
      ((ProgressDialogFragment) progress).dismiss();
    }

    Fragment dialog = getFragmentManager().findFragmentByTag("alertDialog");

    if (dialog != null && ((AlertDialogFragment) dialog).getDialog() != null) {
      mDialogState = DialogState.Alert;
      ((AlertDialogFragment) dialog).getDialog().setTitle(mAlertTitle);
      ((AlertDialogFragment) dialog).setMessage(mAlertMsg);

    } else {

      AlertDialogFragment f = AlertDialogFragment.newInstance(getId(), mAlertTitle, mAlertMsg);

      mDialogState = DialogState.Alert;
      f.show(getFragmentManager(), "alertDialog");
    }
  }

  @Override
  public void okAlertDialog() {
    mDialogState = DialogState.None;
    ((ODKActivity) getActivity()).initializationCompleted(mFragmentToShowNext);
  }

  /**
   * Creates an alert dialog with the given tite and message. If shouldExit is
   * set to true, the activity will exit when the user clicks "ok".
   *
   * @param title
   * @param shouldExit
   */
  private void createAlertDialog(String title, String message) {
    mAlertMsg = message;
    mAlertTitle = title;
    restoreAlertDialog();
  }

  @Override
  public void initializationProgressUpdate(String displayString) {
    updateProgressDialogMessage(displayString);
  }

  @Override
  public void cancelProgressDialog() {
    BackgroundTaskFragment f = (BackgroundTaskFragment) getFragmentManager().findFragmentByTag(
        "background");
    WebLogger.getLogger(((ODKActivity) getActivity()).getAppName()).i(t,
        "cancelProgressDialog -- calling cancelInitializationTask");
    // signal the task that we want it to be cancelled.
    // but keep the notification path...
    // the task will call back with a copyExpansionFilesComplete()
    // to report status (cancelled).
    f.cancelInitializationTask();
  }

}