package com.yammy.abecede.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySQLHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "data.db";
	public String activeTable;
	private static final int DB_VER = 1;
	public MySQLHelper(Context context){
		super(context, DB_NAME, null, DB_VER);		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/**
		 * sql - exec, per-table
		 */		
		//1st table
		String sql = "create table benda(" +
				"_id integer primary key autoincrement," +
				"nama text not null" +
				")";
		db.execSQL(sql);
		Log.d("Data", sql);
		
		//tabel bengkel
		//mutable data
		DataBenda mainData = new DataBenda();
		mainData.executeDB(db);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
				
	}
}
