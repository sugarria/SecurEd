package com.example.secured.sql;

import java.util.ArrayList;
import java.util.List;
import com.example.secured.model.TotalPoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SecurEdDataSource {
	//make it a singleton
	private static SecurEdDataSource instance;
	private SecurEdDataSource(Context context)
	{
		dbHelper = new MySQLiteOpenHelper(context);
	}
		
	public static SecurEdDataSource getInstance(Context context)
	{
		if(instance == null)
		{
			instance = new SecurEdDataSource(context);
			instance.open();
		}
		return instance;
	}
//Database helper
private SQLiteDatabase database;
private MySQLiteOpenHelper dbHelper;

//fields for the TOTAL POINT table
private String[] totalPointColumns = {MySQLiteOpenHelper.TOTALPOINT_COLUMN_ID, 
		MySQLiteOpenHelper.TOTALPOINT_COLUMN_TOTAL,
		MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT1,
		MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT2,
		MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT3,
		MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT4};




public void open() throws SQLException {
	Log.i("SQLSetup", "Calling getWritableDatabase");
	database = dbHelper.getWritableDatabase();
	Log.i("SQLSetup", "After getWritableDatabase");
}

public void close() {
	dbHelper.close();
}

public void resetDatabase(){
	dbHelper.onUpgrade(database, 0, 0);
}


	//username and total point
		public void insertTotalPoint(TotalPoint totalPoint){
		ContentValues values = new ContentValues();
		values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_NAME,totalPoint.getName());
		values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_TOTAL,totalPoint.getTotalPoint());
		values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT1,totalPoint.getVisit1());
		values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT2,totalPoint.getVisit2());
		values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT3,totalPoint.getVisit3());
		values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT4,totalPoint.getVisit4());
		//insert it into the table and set the insert id
		long insertId = database.insert(MySQLiteOpenHelper.TABLE_TOTALPOINT,  null,  values);
		totalPoint.setId(insertId);
		}
		
		//update total point
		public void updateTotalPoint(TotalPoint totalPoint){
			ContentValues values = new ContentValues();
			values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_NAME,totalPoint.getName());
			values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_TOTAL,totalPoint.getTotalPoint());
			values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT1,totalPoint.getVisit1());
			values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT2,totalPoint.getVisit2());
			values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT3,totalPoint.getVisit3());
			values.put(MySQLiteOpenHelper.TOTALPOINT_COLUMN_VISIT4,totalPoint.getVisit4());
				
			long id = totalPoint.getId();
			database.update(MySQLiteOpenHelper.TABLE_TOTALPOINT, values,  MySQLiteOpenHelper.TOTALPOINT_COLUMN_ID + " = " + id, null);
		}
	
		 public int getTotalPointCount() {
			 	int count = 0;
		        String countQuery = "SELECT  * FROM " + MySQLiteOpenHelper.TABLE_TOTALPOINT;
		        Cursor cursor = database.rawQuery(countQuery, null);
		        if(cursor != null && !cursor.isClosed()){
		            count = cursor.getCount();
		            cursor.close();
		        } 
		        // return count
		        return count;
		    }
		 
	
		//get totalPoint according to totalPoint's id
			public TotalPoint getTotalPoint(long Id){
				String selectQuery = "SELECT * FROM totalPoint WHERE _id=" + Id;
				
				Cursor cursor = database.rawQuery(selectQuery, null);
			
				TotalPoint foundTotalPoint = new TotalPoint();
				if(cursor.getCount() == 0){
					foundTotalPoint = null;
				} else {
					cursor.moveToFirst();
					foundTotalPoint.setId(cursor.getLong(0));
					foundTotalPoint.setName(cursor.getString(1));
					foundTotalPoint.setTotalPoint(Integer.parseInt(cursor.getString(2)));	
					foundTotalPoint.setVisit1(Integer.parseInt(cursor.getString(3)));	
					foundTotalPoint.setVisit2(Integer.parseInt(cursor.getString(4)));	
					foundTotalPoint.setVisit3(Integer.parseInt(cursor.getString(5)));	
					foundTotalPoint.setVisit4(Integer.parseInt(cursor.getString(6)));	
					
				}
				return foundTotalPoint;
			}
		//get all activities
		public List<TotalPoint> getAllTotalPoints(){
			List <TotalPoint> totalPointList = new ArrayList<TotalPoint>();
			//Select all query
			String selectQuery = "SELECT * FROM " + MySQLiteOpenHelper.TABLE_TOTALPOINT;
			Cursor cursor = database.query(MySQLiteOpenHelper.TABLE_TOTALPOINT, totalPointColumns, null, null, null, null, MySQLiteOpenHelper.TOTALPOINT_COLUMN_TOTAL+" DESC", "5");
			//Cursor cursor = database.rawQuery(selectQuery, null);
			//looping through all rows and adding to list
			if(cursor.moveToFirst()){
				do{
					TotalPoint activityData = getTotalPoint(cursor.getLong(0));
					totalPointList.add(activityData);
						
				}while(cursor.moveToNext());
			}
			cursor.close();
			return totalPointList;
		}
}
