package com.example.secured.sql;

import java.util.ArrayList;
import java.util.List;
import com.example.secured.model.Topic1answer;
import com.example.secured.model.Topic2answer;
import com.example.secured.model.Topic3answer;
import com.example.secured.model.Topic4answer;
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

//fields for the topic 1 table
private String[] topic1Columns = {MySQLiteOpenHelper.TOPIC1_COLUMN_ID, 
		MySQLiteOpenHelper.TOPIC1_COLUMN_POINTS};

//fields for the topic 2 table
private String[] topic2Columns = {MySQLiteOpenHelper.TOPIC2_COLUMN_ID, 
		MySQLiteOpenHelper.TOPIC2_COLUMN_POINTS};

//fields for the topic 3 table
private String[] topic3Columns = {MySQLiteOpenHelper.TOPIC3_COLUMN_ID, 
		MySQLiteOpenHelper.TOPIC3_COLUMN_POINTS};

//fields for the topic 4 table
private String[] topic4Columns = {MySQLiteOpenHelper.TOPIC4_COLUMN_ID, 
		MySQLiteOpenHelper.TOPIC4_COLUMN_POINTS};

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

public void resetForNewPlayer(){
	dbHelper.resetForNewPlayer(database);
}

//insert topic 1 answers
	public void insertTopic1Answer(Topic1answer topic1){
		ContentValues values = new ContentValues();
		values.put(MySQLiteOpenHelper.TOPIC1_COLUMN_POINTS,topic1.getPoints());
		
	
		//insert it into the table and set the insert id
		long insertId = database.insert(MySQLiteOpenHelper.TABLE_TOPIC1,  null,  values);
		topic1.setId(insertId);
		
	}
	//insert topic 2 answers
	public void insertTopic2Answer(Topic2answer topic2){
		ContentValues values = new ContentValues();
		values.put(MySQLiteOpenHelper.TOPIC2_COLUMN_POINTS,topic2.getPoints());
		//insert it into the table and set the insert id
		long insertId = database.insert(MySQLiteOpenHelper.TABLE_TOPIC2,  null,  values);
		topic2.setId(insertId);
			
		}
		
	//insert topic 3 answers
		public void insertTopic3Answer(Topic3answer topic3){
		ContentValues values = new ContentValues();
		values.put(MySQLiteOpenHelper.TOPIC3_COLUMN_POINTS,topic3.getPoints());
		//insert it into the table and set the insert id
		long insertId = database.insert(MySQLiteOpenHelper.TABLE_TOPIC3,  null,  values);
		topic3.setId(insertId);
					
	}
	//insert topic 4 answers
		public void insertTopic4Answer(Topic4answer topic4){
		ContentValues values = new ContentValues();
		values.put(MySQLiteOpenHelper.TOPIC4_COLUMN_POINTS,topic4.getPoints());
		//insert it into the table and set the insert id
		long insertId = database.insert(MySQLiteOpenHelper.TABLE_TOPIC4,  null,  values);
		topic4.setId(insertId);
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
		 
		 public int getTotalPoint1Count() {
			 	int count = 0;
		        String countQuery = "SELECT  * FROM " + MySQLiteOpenHelper.TABLE_TOPIC1;
		        Cursor cursor = database.rawQuery(countQuery, null);
		        if(cursor != null && !cursor.isClosed()){
		            count = cursor.getCount();
		            cursor.close();
		        } 
		        // return count
		        return count;
		    }
		 
		 public int getTotalPoint2Count() {
			 	int count = 0;
		        String countQuery = "SELECT  * FROM " + MySQLiteOpenHelper.TABLE_TOPIC2;
		        Cursor cursor = database.rawQuery(countQuery, null);
		        if(cursor != null && !cursor.isClosed()){
		            count = cursor.getCount();
		            cursor.close();
		        } 
		        // return count
		        return count;
		    }
		 
		 public int getTotalPoint3Count() {
			 	int count = 0;
		        String countQuery = "SELECT  * FROM " + MySQLiteOpenHelper.TABLE_TOPIC3;
		        Cursor cursor = database.rawQuery(countQuery, null);
		        if(cursor != null && !cursor.isClosed()){
		            count = cursor.getCount();
		            cursor.close();
		        } 
		        // return count
		        return count;
		    }
		 public int getTotalPoint4Count() {
			 	int count = 0;
		        String countQuery = "SELECT  * FROM " + MySQLiteOpenHelper.TABLE_TOPIC4;
		        Cursor cursor = database.rawQuery(countQuery, null);
		        if(cursor != null && !cursor.isClosed()){
		            count = cursor.getCount();
		            cursor.close();
		        } 
		        // return count
		        return count;
		    }
		//get answer1 points according to  id
			public Topic1answer getAnswer1Point(long Id){
				String where = MySQLiteOpenHelper.TOPIC1_COLUMN_ID + " = " + Id;
				Cursor cursor = database.query(MySQLiteOpenHelper.TABLE_TOPIC1, topic1Columns, where, null, null, null,null);
				Topic1answer foundTotal1= new Topic1answer();
				if(cursor.getCount() == 0){
					foundTotal1 = null;
				} else {
					cursor.moveToFirst();
					foundTotal1.setId(cursor.getLong(0));
					foundTotal1.setPoints(Integer.parseInt(cursor.getString(1)));
				
								
				}
				return foundTotal1;
			}
			//get answer2 points according to  id
			public Topic2answer getAnswer2Point(long Id){
				String where = MySQLiteOpenHelper.TOPIC2_COLUMN_ID + " = " + Id;
				Cursor cursor = database.query(MySQLiteOpenHelper.TABLE_TOPIC2, topic2Columns, where, null, null, null,null);
				Topic2answer foundTotal2= new Topic2answer();
				if(cursor.getCount() == 0){
					foundTotal2 = null;
				} else {
					cursor.moveToFirst();
					foundTotal2.setId(cursor.getLong(0));
					foundTotal2.setPoints(Integer.parseInt(cursor.getString(1)));
						
				}
				return foundTotal2;
			}
			//get answer3 points according to  id
			public Topic3answer getAnswer3Point(long Id){
				String where = MySQLiteOpenHelper.TOPIC3_COLUMN_ID + " = " + Id;
				Cursor cursor = database.query(MySQLiteOpenHelper.TABLE_TOPIC3, topic3Columns, where, null, null, null,null);
				Topic3answer foundTotal3 = new Topic3answer();
				if(cursor.getCount() == 0){
					foundTotal3 = null;
				} else {
					cursor.moveToFirst();
					foundTotal3.setId(cursor.getLong(0));
					foundTotal3.setPoints(Integer.parseInt(cursor.getString(1)));
								
				}
				return foundTotal3;
			}
			//get answer4 points according to  id
			public Topic4answer getAnswer4Point(long Id){
				String where = MySQLiteOpenHelper.TOPIC4_COLUMN_ID + " = " + Id;
				Cursor cursor = database.query(MySQLiteOpenHelper.TABLE_TOPIC4, topic4Columns, where, null, null, null,null);
				Topic4answer foundTotal4= new Topic4answer();
				if(cursor.getCount() == 0){
					foundTotal4 = null;
				} else {
					cursor.moveToFirst();
					foundTotal4.setId(cursor.getLong(0));
					foundTotal4.setPoints(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(MySQLiteOpenHelper.TOPIC4_COLUMN_POINTS))));
						
				}
				return foundTotal4;
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
