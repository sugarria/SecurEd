package com.example.secured;

import com.example.secured.model.TotalPoint;
import com.example.secured.sql.SecurEdDataSource;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecurEd extends Activity implements OnClickListener {
	SecurEdDataSource database;
	TotalPoint totalPoint;
	//Comment
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_play);
		database = SecurEdDataSource.getInstance(this);
		totalPoint = new TotalPoint();
		totalPoint.setName("");
		totalPoint.setTotalPoint(0);
		totalPoint.setVisit1(0);
		totalPoint.setVisit2(0);
		totalPoint.setVisit3(0);
		totalPoint.setVisit4(0);
		database.insertTotalPoint(totalPoint);
		Button pergi = (Button) findViewById(R.id.play_button);
		pergi.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.secur_ed, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.play_button:
			playButton();
			break;
		}
		
	}
	
	public void playButton(){
		Intent intent = new Intent(this, WhatIsSecurity.class);
		startActivity(intent);
	}
	
	protected void onStart() {
		Log.i("Lifecycle", "on start....");
		super.onStart();
	}

	protected void onStop() {
		Log.i("Lifecycle", "on stop....");
		super.onStop();

	}

	protected void onDestroy(){
		Log.i("Lifecycle", "on destroy....");
		super.onDestroy();
	}
	
	protected void onPause(){
		Log.i("Lifecycle", "on pause....");
		super.onPause();
	}
	
	protected void onResume(){
		Log.i("Lifecycle", "on resume....");
		super.onResume();
	}
}
