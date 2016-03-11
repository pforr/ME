/*
 * Copyright 2011 Google Inc. All rights reserved.
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

import org.opendatakit.common.android.utilities.WebLogger;
import org.opendatakit.survey.android.R;
import org.opendatakit.survey.android.application.Survey;
import org.opendatakit.survey.android.logic.PropertiesSingleton;
import org.opendatakit.survey.android.preferences.PreferencesActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Provides a popup listing of the accounts on the phone that we can
 * authenticate against.
 *
 * @author cswenson@google.com (Christopher Swenson)
 */
public class AccountList extends ListActivity {
  private static final String t = "AccountList";

  protected AccountManager accountManager;

  private String mAppName;

  /**
   * Called to initialize the activity the first time it is run.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mAppName = this.getIntent().getStringExtra(MainMenuActivity.APP_NAME);
    if ( mAppName == null || mAppName.length() == 0 ) {
    	mAppName = "survey";
    }
    WebLogger.getLogger(mAppName).i(t, t + ".onCreate appName=" + mAppName);

    setTitle(mAppName + " > " + getString(R.string.google_account));
  }

  /**
   * Called when the activity is resumed.
   */
  @Override
  public void onResume() {
    super.onResume();
    accountManager = AccountManager.get(getApplicationContext());
    final Account[] accounts = accountManager.getAccountsByType("com.google");
    this.setListAdapter(new ArrayAdapter<Account>(this, R.layout.account_chooser, accounts) {
      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
        View row;

        if (convertView == null) {
          row = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
              R.layout.account_chooser, null);
        } else {
          row = convertView;
        }
        TextView vw = (TextView) row.findViewById(android.R.id.text1);
        vw.setTextSize(Survey.getQuestionFontsize(mAppName));
        String selected = PropertiesSingleton.getProperty(mAppName, PreferencesActivity.KEY_ACCOUNT);
        if (accounts[position].name.equals(selected)) {
          vw.setBackgroundColor(Color.LTGRAY);
        } else {
          vw.setBackgroundColor(Color.WHITE);
        }
        vw.setText(getItem(position).name);

        return row;
      }
    });
  }

  /**
   * When the user clicks an item, authenticate against that account.
   */
  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    Account account = (Account) getListView().getItemAtPosition(position);
    PropertiesSingleton.removeProperty(mAppName, PreferencesActivity.KEY_AUTH);
    PropertiesSingleton.setProperty(mAppName, PreferencesActivity.KEY_ACCOUNT, account.name);
    PropertiesSingleton.writeProperties(mAppName);

    Intent intent = new Intent(this, AccountInfo.class);
    // TODO: convert this activity into a preferences fragment
    intent.putExtra(MainMenuActivity.APP_NAME, mAppName);
    intent.putExtra("account", account);
    startActivity(intent);
    finish();
  }
}
