package br.com.clubeapp.a52semanas.Activitys.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteBD extends SQLiteOpenHelper {

	public SQLiteBD(Context context, String name, int version) {

		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	public final String[] scriptCriaBD = new String[] {
			"CREATE TABLE IF NOT EXISTS objetivo (_id integer primary key autoincrement,nome text not null,dataInicial text not null,dataVencimento text not null,valor double not null,visualizacao integer not null,pocentagem integer not null,semana integer not null);" };
	
	public final String scriptApagaBD = "DROP TABLE IF EXISTS objetivo,semanas";

	@Override
	public void onCreate(SQLiteDatabase vrDB){
		for (int iIndex = 0; iIndex < scriptCriaBD.length; iIndex++) {
			vrDB.execSQL(scriptCriaBD[iIndex]);
//		vrDB.execSQL(scriptApagaBD);
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase vrDB, int oldVersion, int newVersion) {
		vrDB.execSQL(scriptApagaBD);
		// ..

	}
}