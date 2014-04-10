package com.example.secured.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper{


	//Total Points
	public static final String TABLE_TOTALPOINT = "totalPoint";
	public static final String TOTALPOINT_COLUMN_ID = "_id";
	public static final String TOTALPOINT_COLUMN_NAME = "name";
	public static final String TOTALPOINT_COLUMN_TOTAL = "total";
	public static final String TOTALPOINT_COLUMN_VISIT1 = "visit1";
	public static final String TOTALPOINT_COLUMN_VISIT2 = "visit2";
	public static final String TOTALPOINT_COLUMN_VISIT3 = "visit3";
	public static final String TOTALPOINT_COLUMN_VISIT4 = "visit4";
	

		//Statement to create topic4 table
		public static final String TOTALPOINT_CREATE = "create table " 
				+ TABLE_TOTALPOINT + " (" 
				+ TOTALPOINT_COLUMN_ID + " integer primary key autoincrement, "	
				+ TOTALPOINT_COLUMN_NAME + " text,"
				+ TOTALPOINT_COLUMN_TOTAL + " integer," 
				+ TOTALPOINT_COLUMN_VISIT1 + " integer," 
				+ TOTALPOINT_COLUMN_VISIT2 + " integer,"
				+ TOTALPOINT_COLUMN_VISIT3 + " integer,"
				+ TOTALPOINT_COLUMN_VISIT4 + " integer);";
	
	
	
	public static final String DATABASE_NAME = "SecurEdDatabase.db";
	public static final int DATABASE_VERSION = 6;
	
	//SQLiteOpenHelper helps to create or open a database
	public MySQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	//the first time database is created
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("SQLSetup", "Creating databases");

		db.execSQL(TOTALPOINT_CREATE);
		
	}
	
	//used to drop tables, add tables
	//dropping the tables to delete the data
	//create onCreate to create new empty tables
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("SQLUpgrade", "Upgrading databases");

		String DROP_TOTALPOINT= "DROP TABLE IF EXISTS " + TABLE_TOTALPOINT;
		db.execSQL(DROP_TOTALPOINT);
		
		onCreate(db);
		
	}
	


}
