package no.mesan.web.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.widget.Button;

/**
 * Activity to handle webview
 * 
 * @author Thomas Pettersen
 * 
 */
public class IndexActivity extends Activity {
	private WebView webView;
	private Button buttonRefresh;
	private Button buttonChange;
	private static final String HOST = "10.0.2.2";
	private static final String PORT = ":8080";
	private static final String URL = "http://" + HOST + PORT;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initGui();
		initListeners();
	}

	private void initGui() {
		buttonRefresh = (Button) findViewById(R.id.buttonRefresh);
		buttonChange = (Button) findViewById(R.id.buttonChange);

		webView = (WebView) findViewById(R.id.webView);
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);		
		
		webView.setWebViewClient(new MyWebViewClient());		

		// TODO: Oppgave 2.5
		webView.getSettings().setJavaScriptEnabled(true);

		// TODO: Oppgave 3.3
		webView.getSettings().setDatabaseEnabled(true);
		String databasePath = this.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
		webView.getSettings().setDatabasePath(databasePath);
		webView.getSettings().setDomStorageEnabled(true);

		// TODO: Oppgave 3.4
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		webView.getSettings().setGeolocationEnabled(true);
		webView.getSettings().setGeolocationDatabasePath("/data/data/no.mesan.web.client");
		
		webView.setWebChromeClient(new WebChromeClient() {
			public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
				callback.invoke(origin, true, false);
			}

			public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota,
					QuotaUpdater quotaUpdater) {
				quotaUpdater.updateQuota(5 * 1024 * 1024);
			}
		});

		// TODO: Oppgave 2.2.a
		webView.loadUrl(URL);
	}

	private void initListeners() {
		buttonRefresh.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO: Oppgave 2.2.d
				webView.clearCache(true);
				webView.loadUrl(URL);
			}
		});
		
		buttonChange.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO: Oppgave 5.2
				webView.loadUrl("javascript:changeTitle('Endret tittel')");
			}
		});
	}

	private class MyWebViewClient extends WebViewClient {

		// TODO: Oppgave 2.4
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			if (Uri.parse(url).getHost().equals(HOST)) {
				return false;
			}

			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			startActivity(intent);
			return true;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		// TODO: Oppgave 2.3
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}