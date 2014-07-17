package com.yammy.abecede;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Huruf extends Activity {
	Bundle bundle;
	int huruf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_huruf);
		bundle = getIntent().getExtras();
		huruf = bundle.getInt("huruf");
		huruf++;
		Toast.makeText(getApplicationContext(), huruf+"", Toast.LENGTH_LONG).show();
	}
}
