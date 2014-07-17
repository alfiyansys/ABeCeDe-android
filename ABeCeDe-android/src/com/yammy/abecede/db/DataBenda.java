package com.yammy.abecede.db;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;

public class DataBenda {
	List<Benda> data = new ArrayList<Benda>();
	
	public DataBenda(){
		data.add(new Benda("Apel"));
		data.add(new Benda("Batu"));
	}
	
	public void executeDB(SQLiteDatabase db){
		String sql;
		for(Benda element: this.data){
			sql = "insert into benda(nama) values('"+element.nama+"')";
			db.execSQL(sql);
		}
	}
}

class Benda{
	String nama;
	public Benda(String nama){
		this.nama = nama;
	}
}