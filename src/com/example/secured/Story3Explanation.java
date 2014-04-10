package com.example.secured;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Story3Explanation extends Activity implements OnClickListener {

	//Comment
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_topic3);
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
			Illustration3();
			break;
		}
		
	}
	
	public void Illustration3(){
		Intent intent = new Intent(this, Story3.class);
		startActivity(intent);
	}

}
