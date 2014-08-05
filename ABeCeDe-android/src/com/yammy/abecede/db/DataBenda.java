package com.yammy.abecede.db;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;

public class DataBenda {
	List<Benda> data = new ArrayList<Benda>();
	
	public DataBenda(){
		data.add(new Benda("Apel","A-pel"));
		data.add(new Benda("Ayam","A-yam"));
		data.add(new Benda("Batu","Ba-tu"));
		data.add(new Benda("Bola","Bo-la"));
		data.add(new Benda("Cicak","Ci-cak"));
		data.add(new Benda("Coklat","Cok-lat"));
		data.add(new Benda("Domba","Dom-ba"));
		data.add(new Benda("Dolar","Do-lar"));
		data.add(new Benda("Elang","E-lang"));
		data.add(new Benda("Emas","E-mas"));
		data.add(new Benda("Foto","Fo-to"));
		data.add(new Benda("Futsal","Fut-sal"));
		data.add(new Benda("Gajah","Ga-jah"));
		data.add(new Benda("Gendang","Gen-dang"));
		data.add(new Benda("Hiu","Hi-u"));
		data.add(new Benda("Hantu","Han-tu"));
		data.add(new Benda("Ipin","I-pin"));
		data.add(new Benda("Ijat","I-jat"));
		data.add(new Benda("Jagung","Jagung"));
		data.add(new Benda("Jambu","Jam-bu"));
		data.add(new Benda("Katak","Ka-tak"));
		data.add(new Benda("Kumbang","Kum-bang"));
		data.add(new Benda("Lonceng","Lon-ceng"));
		data.add(new Benda("Limba","Lim-ba"));
		data.add(new Benda("Mangga","Mang-ga"));
		data.add(new Benda("Melon","Melon"));
		data.add(new Benda("Nanas","Na-nas"));
		data.add(new Benda("Nasi","Nasi"));
		data.add(new Benda("Oli","o-li"));
		data.add(new Benda("Ombak","Om-bak"));
		data.add(new Benda("Perak","Pe-rak"));
		data.add(new Benda("Padi","Pa-di"));
		data.add(new Benda("Quran","Qur-an"));
		data.add(new Benda("Q","Q"));
		data.add(new Benda("Rusa","Ru-sa"));
		data.add(new Benda("Rayap","Ra-yap"));
		data.add(new Benda("Sapi","Sa-pi"));
		data.add(new Benda("Sholat","Sholat"));
		data.add(new Benda("Topi","To-pi"));
		data.add(new Benda("Tali","Ta-li"));
		data.add(new Benda("Upin","U-pin"));
		data.add(new Benda("Ular","U-lar"));
		data.add(new Benda("Violet","Vio-let"));
		data.add(new Benda("V","V"));
		data.add(new Benda("Wayang","Wa-yang"));
		data.add(new Benda("Warna","War-na"));
		data.add(new Benda("X","X"));
		data.add(new Benda("X","X"));
		data.add(new Benda("Yoyo","Yo-yo"));
		data.add(new Benda("Yuppy","Yup-py"));
		data.add(new Benda("Zebra","Ze-bra"));
		data.add(new Benda("Zidane","Zi-dane"));
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