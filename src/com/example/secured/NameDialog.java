package com.example.secured;


import java.util.ArrayList;
import java.util.List;

import com.example.secured.model.TotalPoint;
import com.example.secured.sql.SecurEdDataSource;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.EditorInfo;


public class NameDialog extends DialogFragment implements OnClickListener{
	EditText name;
	private List<ChooseStory> listeners;
	SecurEdDataSource database;
	
	public NameDialog() {
	       listeners = new ArrayList<ChooseStory>();
 }
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.add_name_dialog, container);     
       name = (EditText) view.findViewById(R.id.txt_your_name);
       Button btn_save= (Button) view.findViewById(R.id.btn_save);
       getDialog().setTitle("Enter Your Name"); 
       btn_save.setOnClickListener(this);
       database = SecurEdDataSource.getInstance(getActivity().getApplicationContext());
       return view;
    }
	
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btn_save:
    	{
    		String userName = name.getText().toString();
    		TotalPoint totalPoint = database.getTotalPoint(database.getTotalPointCount());
    		totalPoint.setName(userName);
    		database.updateTotalPoint(totalPoint);
    		callDialogListeners();
    		break;
		}
		}
		
	}
	
	private void callDialogListeners()
	{
		for(int i = 0; i < listeners.size(); i++)
		{
			listeners.get(i).onDialogFinish();
		}
	}
	
	public void addDialogListener(ChooseStory chooseStory)
	{
		listeners.add(chooseStory);
	}
	
} 

   

    

