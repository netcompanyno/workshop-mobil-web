package no.mesan.web.client;

import android.content.Context;
import android.widget.Toast;

public class ToastInterface {

	private Context context;

	public ToastInterface(Context context) {
		this.context = context;
	}

	public void showToast(String toast) {
		Toast.makeText(context, toast, Toast.LENGTH_LONG).show();
	}
}
