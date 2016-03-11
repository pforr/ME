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

package org.opendatakit.survey.android.views;

import org.opendatakit.common.android.utilities.StaticStateManipulator;
import org.opendatakit.common.android.utilities.StaticStateManipulator.IStaticFieldManipulator;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.VideoView;

public class ODKWebChromeClient extends WebChromeClient implements
    MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, OnPreparedListener {

  private static final String t = "ODKWebChromeClient";
  private ODKWebView wrappedWebView;
  private VideoView video = null;
  private MediaPlayer mediaPlayer = null;
  private WebChromeClient.CustomViewCallback callback = null;

  private static VideoView lastVideo = null;
  private static MediaPlayer lastMediaPlayer = null;
  
  static {
    StaticStateManipulator.get().register(75, new IStaticFieldManipulator() {

      @Override
      public void reset() {
        if ( lastVideo != null ) {
          if ( lastVideo.isPlaying() ) {
            lastVideo.stopPlayback();
          }
          safeReset(lastMediaPlayer);
        }
      }});
  }

  public ODKWebChromeClient(ODKWebView wrappedWebView) {
    this.wrappedWebView = wrappedWebView;
    if ( lastVideo != null ) {
      if ( lastVideo.isPlaying() ) {
        lastVideo.stopPlayback();
      }
      safeReset(lastMediaPlayer);
    }
  }

  private static void safeReset(MediaPlayer mp) {
    if (mp != null) {
      try {
        if ( mp.isPlaying() ) {
          mp.stop();
        }
      } catch ( IllegalStateException e) {
        // ignore
      }
      mp.reset();
    }
  }

  @Override
  public void onShowCustomView(View view, CustomViewCallback callback) {
    if (this.callback != null) {
      this.callback.onCustomViewHidden();
    }
    this.callback = callback;
    if (view instanceof FrameLayout) {
      FrameLayout frame = (FrameLayout) view;
      if (frame.getFocusedChild() instanceof VideoView) {
        wrappedWebView.getLogger().i(t, "onShowCustomView: FrameLayout Video");
        video = (VideoView) frame.getFocusedChild();
        if ( lastVideo != null && lastVideo != video) {
          if ( lastVideo.isPlaying() ) {
            lastVideo.stopPlayback();
          }
        }
        lastVideo = video;
        video.setOnCompletionListener(this);
        video.setOnErrorListener(this);
        video.setOnPreparedListener(this);
        wrappedWebView.swapToCustomView(view);
        super.onShowCustomView(view, callback);
        // video.seekTo(0);// reset to start of video...
        // video.start();
      } else {
        wrappedWebView.getLogger().i(t, "onShowCustomView: FrameLayout not Video "
            + frame.getFocusedChild().getClass().getCanonicalName());
        wrappedWebView.swapToCustomView(view);
        super.onShowCustomView(view, callback);
      }
    } else {
      wrappedWebView.getLogger().i(t, "onShowCustomView: not FrameLayout " + view.getClass().getCanonicalName());
      wrappedWebView.swapToCustomView(view);
      super.onShowCustomView(view, callback);
    }
  }

  @Override
  public void onHideCustomView() {
    wrappedWebView.getLogger().d(t, "onHideCustomView");
    wrappedWebView.swapOffCustomView();
    if (video != null && video.isPlaying()) {
      video.stopPlayback();
    }
    video = null;
    if (callback != null) {
      callback.onCustomViewHidden();
      callback = null;
    }
  }

  @Override
  public void onPrepared(MediaPlayer mp) {
    wrappedWebView.getLogger().d(t, "Video prepared");
    lastMediaPlayer = mp;
  }

  @Override
  public void onCompletion(MediaPlayer mp) {
    wrappedWebView.getLogger().d(t, "Video ended");
    safeReset(lastMediaPlayer);
    lastMediaPlayer = mp;
    safeReset(mp);
    onHideCustomView();
  }

  @Override
  public boolean onError(MediaPlayer mp, int what, int extra) {
    wrappedWebView.getLogger().w(t, "Video error");
    safeReset(lastMediaPlayer);
    lastMediaPlayer = mp;
    safeReset(mp);
    onHideCustomView();
    return true;
  }

  /**
   * Ask the browser for an icon to represent a <video> element. This icon will
   * be used if the Web page did not specify a poster attribute.
   *
   * @return Bitmap The icon or null if no such icon is available.
   */
  @Override
  public Bitmap getDefaultVideoPoster() {
    return wrappedWebView.getDefaultVideoPoster();
  }

  /**
   * Ask the host application for a custom progress view to show while a <video>
   * is loading.
   *
   * @return View The progress view.
   */
  @Override
  public View getVideoLoadingProgressView() {
    return wrappedWebView.getVideoLoadingProgressView();
  }

  @Override
  public void getVisitedHistory(ValueCallback<String[]> callback) {
    callback.onReceiveValue(new String[] {});
  }

  @Override
  public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
    if (consoleMessage.sourceId() == null || consoleMessage.sourceId().length() == 0) {
      wrappedWebView.getLogger().e(t, "onConsoleMessage: Javascript exception: " + consoleMessage.message());
      return true;
    } else {
      if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.DEBUG) {
        wrappedWebView.getLogger().d(t, consoleMessage.message());
      } else if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
        wrappedWebView.getLogger().e(t, consoleMessage.message());
      } else if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.LOG) {
        wrappedWebView.getLogger().i(t, consoleMessage.message());
      } else if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.TIP) {
        wrappedWebView.getLogger().t(t, consoleMessage.message());
      } else if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
        wrappedWebView.getLogger().w(t, consoleMessage.message());
      } else {
        wrappedWebView.getLogger().e(t, consoleMessage.message());
      }
      return true;
    }
  }

  @Override
  public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota,
      long estimatedSize, long totalUsedQuota, QuotaUpdater quotaUpdater) {
    long space = (4 + (currentQuota / 65536L)) * 65536L;
    wrappedWebView.getLogger().i(t, "Extending Database quota to: " + Long.toString(space));
    quotaUpdater.updateQuota(space);
  }

  @Override
  public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota,
      QuotaUpdater quotaUpdater) {
    long space = (4 + (spaceNeeded / 65536L)) * 65536L;
    wrappedWebView.getLogger().i(t, "Extending AppCache quota to: " + Long.toString(space));
    quotaUpdater.updateQuota(space);
  }

  @Override
  public void onConsoleMessage(String message, int lineNumber, String sourceID) {
    wrappedWebView.getLogger().i(t, sourceID + "[" + lineNumber + "]: " + message);
  }

  @Override
  public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
    wrappedWebView.getLogger().w(t, url + ": " + message);
    return false;
  }

}
