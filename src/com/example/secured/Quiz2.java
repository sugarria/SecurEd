package com.example.secured;

import com.example.secured.model.TotalPoint;
import com.example.secured.sql.SecurEdDataSource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz2 extends Activity implements OnClickListener {
	private RadioGroup question1;
	private RadioButton answer1;
	private RadioGroup question2;
	private RadioButton answer2;
	private RadioGroup question3;
	private RadioButton answer3;
	private RadioGroup question4;
	private RadioButton answer4;
	private RadioGroup question5;
	private RadioButton answer5;
	private RadioGroup question6;
	private RadioButton answer6;
	private RadioGroup question7;
	private RadioButton answer7;
	private RadioGroup question8;
	private RadioButton answer8;
	private RadioGroup question9;
	private RadioButton answer9;
	private RadioGroup question10;
	private RadioButton answer10;
	public SecurEdDataSource database;
	public int points = 0;
	public TotalPoint totalPoint;
	
	//Comment
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz_2);
		database = SecurEdDataSource.getInstance(this);
		totalPoint = database.getTotalPoint(database.getTotalPointCount());
		Button pergi = (Button) findViewById(R.id.next_button);
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
		case R.id.next_button:
			question1 = (RadioGroup) findViewById(R.id.radioGroup1);
			  // get selected radio button from radioGroup
			int selectedId = question1.getCheckedRadioButtonId();
			if(selectedId == R.id.radio1){
				points++;
			}
			// find the radiobutton by returned id
		    answer1 = (RadioButton) findViewById(selectedId);
		    
		    question2 = (RadioGroup) findViewById(R.id.radioGroup2);
			  // get selected radio button from radioGroup
			int selectedId2 = question2.getCheckedRadioButtonId();
			if(selectedId2 == R.id.radio8){
				points++;
			}
			// find the radiobutton by returned id
		    answer2 = (RadioButton) findViewById(selectedId2);
		    
		    question3 = (RadioGroup) findViewById(R.id.radioGroup3);
			  // get selected radio button from radioGroup
			int selectedId3 = question3.getCheckedRadioButtonId();
			if(selectedId3 == R.id.radio9){
				points++;
			}
			// find the radiobutton by returned id
		    answer3 = (RadioButton) findViewById(selectedId3);
		    
		    question4 = (RadioGroup) findViewById(R.id.radioGroup4);
			  // get selected radio button from radioGroup
			int selectedId4 = question4.getCheckedRadioButtonId();
			if(selectedId4 == R.id.radio16){
				points++;
			}
			// find the radiobutton by returned id
		    answer4 = (RadioButton) findViewById(selectedId4);
		    
		    question5 = (RadioGroup) findViewById(R.id.radioGroup5);
			  // get selected radio button from radioGroup
			int selectedId5 = question5.getCheckedRadioButtonId();
			if(selectedId5 == R.id.radio20){
				points++;
			}
			// find the radiobutton by returned id
		    answer5 = (RadioButton) findViewById(selectedId5);
		    
		    question6 = (RadioGroup) findViewById(R.id.radioGroup6);
			  // get selected radio button from radioGroup
			int selectedId6 = question6.getCheckedRadioButtonId();
			if(selectedId6 == R.id.radio23){
				points++;
			}
			// find the radiobutton by returned id
		    answer6 = (RadioButton) findViewById(selectedId6);
		    
		    question7 = (RadioGroup) findViewById(R.id.radioGroup7);
			  // get selected radio button from radioGroup
			int selectedId7 = question7.getCheckedRadioButtonId();
			if(selectedId7 == R.id.radio26){
				points++;
			}
			// find the radiobutton by returned id
		    answer7 = (RadioButton) findViewById(selectedId7);
		    
		    question8 = (RadioGroup) findViewById(R.id.radioGroup8);
			  // get selected radio button from radioGroup
			int selectedId8 = question8.getCheckedRadioButtonId();
			if(selectedId8 == R.id.radio30){
				points++;
			}
			// find the radiobutton by returned id
		    answer8 = (RadioButton) findViewById(selectedId8);
		    
		    question9 = (RadioGroup) findViewById(R.id.radioGroup9);
			  // get selected radio button from radioGroup
			int selectedId9 = question9.getCheckedRadioButtonId();
			if(selectedId9 == R.id.radio33){
				points++;
			}
			// find the radiobutton by returned id
		    answer9 = (RadioButton) findViewById(selectedId9);
		    
		    question10 = (RadioGroup) findViewById(R.id.radioGroup10);
			  // get selected radio button from radioGroup
			int selectedId10 = question10.getCheckedRadioButtonId();
			if(selectedId10 == R.id.radio38){
				points++;
				
			}
			// find the radiobutton by returned id
		    answer10 = (RadioButton) findViewById(selectedId10);
		    
		    int total = points + database.getTotalPoint(database.getTotalPointCount()).getTotalPoint();
		    totalPoint.setTotalPoint(total);
		    
		    if(totalPoint.getVisit2() == 0){
		    	totalPoint.setVisit2(1);
		    	database.updateTotalPoint(totalPoint);
		    	
		    }
		    
		    
		   
			finish_quiz();
			break;
		}
		
	}
	
	public void finish_quiz(){
		Intent intent = new Intent(this, Quiz2Explanation.class);
		startActivity(intent);
	}

}
