package com.yammy.abecede;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yammy.abecede.db.MySQLHelper;

@SuppressLint("DefaultLocale")
public class Huruf extends Activity {
	Bundle bundle;	
	String strhuruf;
	TextView hurufView;
	ListView kataList;
	private MySQLHelper dbHelper;
	protected ListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int hurufNum;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_huruf);
		hurufView = (TextView) this.findViewById(R.id.teksGede);
		bundle = getIntent().getExtras();
		hurufNum = bundle.getInt("huruf");
		hurufView.setText(determineHuruf(hurufNum,2));
		
		this.kataList = (ListView) this.findViewById(R.id.LV1);
        this.kataList.setSelected(true);
        //onclick item listener belum
        dbHelper = new MySQLHelper(this);
        this.refreshList(determineHuruf(hurufNum,1));
	}
	
	private void refreshList(String hr) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		try{
			Cursor cursor = db.rawQuery("select * from benda where nama like '"+hr+"%'", null);
			adapter = new android.support.v4.widget.SimpleCursorAdapter(this, R.layout.view_kata, cursor, new String[] {"nama","eja"}, new int[] {R.id.namaBendaItem,R.id.ejaBendaItem}, 0);
			kataList.setAdapter(adapter);
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
}
