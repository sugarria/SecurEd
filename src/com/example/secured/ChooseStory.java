package com.example.secured;


import com.example.secured.model.TotalPoint;
import com.example.secured.sql.SecurEdDataSource;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChooseStory extends FragmentActivity  implements OnClickListener {

	Button goTopic1;
	Button  goTopic2;
	Button goTopic3;
	Button goTopic4;
	SecurEdDataSource database;

	//Comment
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_story);
		database =SecurEdDataSource.getInstance(this);
		goTopic1 = (Button) findViewById(R.id.button1);
		goTopic1.setOnClickListener(this);
		goTopic2 = (Button) findViewById(R.id.button2);
		goTopic2.setOnClickListener(this);
		goTopic3 = (Button) findViewById(R.id.button3);
		goTopic3.setOnClickListener(this);
		goTopic4 = (Button) findViewById(R.id.button4);
		goTopic4.setOnClickListener(this);
		Button grade = (Button) findViewById(R.id.grade_button);
		grade.setOnClickListener(this);
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
		case R.id.button1:
			goTopic1();
			break;
		case R.id.button2:
			goTopic2();
			break;
		case R.id.button3:
			goTopic3();
			break;
		case R.id.button4:
			goTopic4();
			break;
		case R.id.grade_button:
			gradeActivity();
			break;
		}
		
	}
	
	public void gradeActivity(){
		 FragmentManager fm = getSupportFragmentManager();
	     NameDialog enterNameDialog = new NameDialog();
	     enterNameDialog.addDialogListener(this);
	     enterNameDialog.show(fm, "fragment_enter_name");
	}
	
	public void goTopic1(){
		Intent intent = new Intent(this, Story1Explanation.class);
		startActivity(intent);
	}
	
	public void goTopic2(){
		Intent intent = new Intent(this, Story2Explanation.class);
		startActivity(intent);
	}
	
	public void goTopic3(){
		Intent intent = new Intent(this, Story3Explanation.class);
		startActivity(intent);
	}
	public void goTopic4(){
		Intent intent = new Intent(this, Story4Explanation.class);
		startActivity(intent);
	}
	
	public void onDialogFinish() {
		Intent intent = new Intent(this, Grade.class);
		startActivity(intent);
			
	}

}
