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

		// TODO: Oppgave 3.3

		// TODO: Oppgave 3.4

		// TODO: Oppgave 2.2.a
	}

	private void initListeners() {
		buttonRefresh.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO: Oppgave 2.2.d
			}
		});
		
		buttonChange.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO: Oppgave 5.2
			}
		});
	}

	private class MyWebViewClient extends WebViewClient {

		// TODO: Oppgave 2.4
		
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		// TODO: Oppgave 2.3
		
		return super.onKeyDown(keyCode, event);
	}
}