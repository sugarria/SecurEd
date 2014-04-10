package com.example.secured.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper{

	//Topic1answer
	public static final String TABLE_TOPIC1 = "topic1";
	public static final String TOPIC1_COLUMN_ID = "_id";
	public static final String TOPIC1_COLUMN_POINTS = "points";
	

	//Topic2answer
	public static final String TABLE_TOPIC2 = "topic2";
	public static final String TOPIC2_COLUMN_ID = "_id";
	public static final String TOPIC2_COLUMN_POINTS = "points";
	
	
	//Topic3answer
	public static final String TABLE_TOPIC3 = "topic3";
	public static final String TOPIC3_COLUMN_ID = "_id";
	public static final String TOPIC3_COLUMN_POINTS = "points";
	
	//Topic4answer
	public static final String TABLE_TOPIC4 = "topic4";
	public static final String TOPIC4_COLUMN_ID = "_id";
	public static final String TOPIC4_COLUMN_POINTS = "points";
	
	
	//Total Points
	public static final String TABLE_TOTALPOINT = "totalPoint";
	public static final String TOTALPOINT_COLUMN_ID = "_id";
	public static final String TOTALPOINT_COLUMN_NAME = "name";
	public static final String TOTALPOINT_COLUMN_TOTAL = "total";
	public static final String TOTALPOINT_COLUMN_VISIT1 = "visit1";
	public static final String TOTALPOINT_COLUMN_VISIT2 = "visit2";
	public static final String TOTALPOINT_COLUMN_VISIT3 = "visit3";
	public static final String TOTALPOINT_COLUMN_VISIT4 = "visit4";
	
	//Statement to create topic1 table
	public static final String TOPIC1_CREATE = "create table " 
			+ TABLE_TOPIC1 + " (" 
			+ TOPIC1_COLUMN_ID + " integer primary key autoincrement, "		
			+ TOPIC1_COLUMN_POINTS + " text);";
	
	//Statement to create topic2 table
		public static final String TOPIC2_CREATE = "create table " 
				+ TABLE_TOPIC2 + " (" 
				+ TOPIC2_COLUMN_ID + " integer primary key autoincrement, "		
				+ TOPIC2_COLUMN_POINTS + " text);";
		
		//Statement to create topic3 table
		public static final String TOPIC3_CREATE = "create table " 
				+ TABLE_TOPIC3 + " (" 
				+ TOPIC3_COLUMN_ID + " integer primary key autoincrement, "		
				+ TOPIC3_COLUMN_POINTS + " text);";
		//Statement to create topic4 table
		public static final String TOPIC4_CREATE = "create table " 
				+ TABLE_TOPIC4 + " (" 
				+ TOPIC4_COLUMN_ID + " integer primary key autoincrement, "		
				+ TOPIC4_COLUMN_POINTS + " text);";
		
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
	public static final int DATABASE_VERSION = 5;
	
	//SQLiteOpenHelper helps to create or open a database
	public MySQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	//the first time database is created
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("SQLSetup", "Creating databases");
		db.execSQL(TOPIC1_CREATE);
		db.execSQL(TOPIC2_CREATE);
		db.execSQL(TOPIC3_CREATE);
		db.execSQL(TOPIC4_CREATE);
		db.execSQL(TOTALPOINT_CREATE);
		
	}
	
	//used to drop tables, add tables
	//dropping the tables to delete the data
	//create onCreate to create new empty tables
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("SQLUpgrade", "Upgrading databases");
		String DROP_TOPIC1= "DROP TABLE IF EXISTS " + TABLE_TOPIC1;
		String DROP_TOPIC2= "DROP TABLE IF EXISTS " + TABLE_TOPIC2;
		String DROP_TOPIC3= "DROP TABLE IF EXISTS " + TABLE_TOPIC3;
		String DROP_TOPIC4= "DROP TABLE IF EXISTS " + TABLE_TOPIC4;
		String DROP_TOTALPOINT= "DROP TABLE IF EXISTS " + TABLE_TOTALPOINT;
		db.execSQL(DROP_TOPIC1);
		db.execSQL(DROP_TOPIC2);
		db.execSQL(DROP_TOPIC3);
		db.execSQL(DROP_TOPIC4);
		db.execSQL(DROP_TOTALPOINT);
		
		onCreate(db);
		
	}
	
	public void resetForNewPlayer(SQLiteDatabase db){
		Log.i("SQLUpgrade", "Upgrading databases");
		String DROP_TOPIC1= "DROP TABLE IF EXISTS " + TABLE_TOPIC1;
		String DROP_TOPIC2= "DROP TABLE IF EXISTS " + TABLE_TOPIC2;
		String DROP_TOPIC3= "DROP TABLE IF EXISTS " + TABLE_TOPIC3;
		String DROP_TOPIC4= "DROP TABLE IF EXISTS " + TABLE_TOPIC4;
		db.execSQL(DROP_TOPIC1);
		db.execSQL(DROP_TOPIC2);
		db.execSQL(DROP_TOPIC3);
		db.execSQL(DROP_TOPIC4);
		db.execSQL(TOPIC1_CREATE);
		db.execSQL(TOPIC2_CREATE);
		db.execSQL(TOPIC3_CREATE);
		db.execSQL(TOPIC4_CREATE);
	}

}
