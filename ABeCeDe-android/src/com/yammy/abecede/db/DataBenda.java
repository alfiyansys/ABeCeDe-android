package com.yammy.abecede.db;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;

public class DataBenda {
	List<Benda> data = new ArrayList<Benda>();
	
	public DataBenda(){
		data.add(new Benda("Apel", "a-pel"));
		data.add(new Benda("Batu", "ba-tu"));
	}
	
	public void executeDB(SQLiteDatabase db){
		String sql;
		for(Benda element: this.data){
			sql = "insert into benda(nama,eja) values('"+element.nama+"','"+element.eja+"')";
			db.execSQL(sql);
		}
	}
}

class Benda{
	String nama;
	String eja;
	public Benda(String nama, String eja){
		this.nama = nama;
		this.eja = eja;
	}
}