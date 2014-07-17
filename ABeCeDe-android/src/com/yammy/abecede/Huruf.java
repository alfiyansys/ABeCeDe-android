package com.yammy.abecede;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

@SuppressLint("DefaultLocale")
public class Huruf extends Activity {
	Bundle bundle;	
	String strhuruf;
	TextView hurufView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int hurufNum;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_huruf);
		hurufView = (TextView) this.findViewById(R.id.teksGede);
		bundle = getIntent().getExtras();
		hurufNum = bundle.getInt("huruf");
		hurufView.setText(determineHuruf(hurufNum));
	}
	
	private String determineHuruf(int i){
		String hurufs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String hurufk = hurufs.charAt(i)+"";
		hurufk = hurufk.toLowerCase();
		return hurufs.charAt(i)+hurufk;
	}
}
