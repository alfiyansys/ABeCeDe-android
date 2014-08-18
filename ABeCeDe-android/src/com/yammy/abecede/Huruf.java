package com.yammy.abecede;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.yammy.abecede.db.MySQLHelper;

@SuppressLint("DefaultLocale")
public class Huruf extends Activity implements OnInitListener {
	Bundle bundle;	
	String strhuruf;
	TextView hurufView;
	ListView kataList;
	private MySQLHelper dbHelper;
	protected ListAdapter adapter;
	Cursor mainCursor;
	TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int hurufNum;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_huruf);
		
		tts = new TextToSpeech(this,this);
		
		hurufView = (TextView) this.findViewById(R.id.teksGede);
		bundle = getIntent().getExtras();
		hurufNum = bundle.getInt("huruf");
		hurufView.setText(determineHuruf(hurufNum,2));
		
		this.kataList = (ListView) this.findViewById(R.id.LV1);
        this.kataList.setSelected(true);
        this.kataList.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				mainCursor.moveToPosition(arg2);
				if(tts != null){
					if (!tts.isSpeaking()){
						tts.speak(mainCursor.getString(1), TextToSpeech.QUEUE_FLUSH, null);
					}
				}
			}
        });
        dbHelper = new MySQLHelper(this);
        this.refreshList(determineHuruf(hurufNum,1));
	}
	
	private void refreshList(String hr) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		try{
			Cursor cursor = db.rawQuery("select * from benda where nama like '"+hr+"%'", null);
			adapter = new android.support.v4.widget.SimpleCursorAdapter(this, R.layout.view_kata, cursor, new String[] {"nama","eja"}, new int[] {R.id.namaBendaItem,R.id.ejaBendaItem}, 0);
			kataList.setAdapter(adapter);
			mainCursor = cursor;
		}catch(Exception e){
			Log.d("Exception", e.toString());
		}
	}
	
	private String determineHuruf(int i, int par){
		String hurufs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String hurufk = hurufs.charAt(i)+"";
		hurufk = hurufk.toLowerCase();
		if(par == 2){
			return hurufs.charAt(i)+hurufk;
		}else{
			return hurufs.charAt(i)+"";
		}
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if(status == TextToSpeech.SUCCESS){
			tts.setLanguage(Locale.getDefault());
		}else{
			Toast.makeText(this, "TTS error", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	protected void onDestroy(){
		if(tts != null){
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}
}
