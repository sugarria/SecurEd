package com.example.secured;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.secured.adapter.GradeAdapter;
import com.example.secured.model.TotalPoint;
import com.example.secured.sql.SecurEdDataSource;
import com.example.secured.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Grade extends Activity implements OnClickListener{

	// The Intent is used to issue that an operation should
	// be performed

	Intent intent;
	TextView contactId;
	SecurEdDataSource database;
	ArrayList<TotalPoint> totalPointList;
	GradeAdapter totalPointAdapter;
	ListView view;



	// Called when the Activity is first called

	protected void onCreate(Bundle savedInstanceState) {
		// Get saved data if there is any

		super.onCreate(savedInstanceState);

		// Designate that edit_contact.xml is the interface used
		// is activity_main.xml
		
		setContentView(R.layout.grade_list);
		database = SecurEdDataSource.getInstance(this);
		Button end = (Button) findViewById(R.id.end_button);
		end.setOnClickListener(this);

		// Get the ListView and assign an event handler to it
		view = (ListView) findViewById(R.id.list_stat_view);
		//populate the totalpoints
		fillStats();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.end_button:
			database.resetForNewPlayer();
			Intent intent = new Intent(this, SecurEd.class);
			startActivity(intent);
			break;
		
		}
	}
	
	public void fillStats(){	
		Log.i("StatList", "before getAllStats");
		List<TotalPoint> allTotalPoints =  database.getAllTotalPoints();
		Log.i("StatList", "before loop");
		totalPointList = new ArrayList<TotalPoint>();
		for(int i = 0; i < allTotalPoints.size(); i++)
		{
			totalPointList.add(allTotalPoints.get(i));
		}
		Log.i("StatList", "before new StatListAdapter");
		totalPointAdapter = new GradeAdapter(getApplicationContext(), totalPointList);
		Log.i("StatList", "before setAdapter");
        view.setAdapter(totalPointAdapter);
		
	}

}
