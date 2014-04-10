package com.example.secured.adapter;

import java.util.ArrayList;
import com.example.secured.R;

import com.example.secured.model.TotalPoint;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class GradeAdapter extends BaseAdapter {
	  private Context context;
	    private ArrayList<TotalPoint> TotalPointList;
	     
	    public GradeAdapter(Context context, ArrayList<TotalPoint> TotalPointList){
	        this.context = context;
	        this.TotalPointList = TotalPointList;
	    }
	 
	    @Override
	    public int getCount() {
	        return TotalPointList.size();
	    }
	 
	    @Override
	    public Object getItem(int position) {       
	        return TotalPointList.get(position);
	    }
	 
	    @Override
	    public long getItemId(int position) {
	        return position;
	    }
	 
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        if (convertView == null) {
	            LayoutInflater mInflater = (LayoutInflater)
	                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	            convertView = mInflater.inflate(R.layout.grade_entry, null);
	        }
	        
	        TextView id =(TextView) convertView.findViewById(R.id.id);
	        TextView name =(TextView) convertView.findViewById(R.id.name);
	        TextView value = (TextView) convertView.findViewById(R.id.value);
	                 
	        id.setText(String.valueOf(TotalPointList.get(position).getId()));
	        name.setText(TotalPointList.get(position).getName());
	        value.setText(String.valueOf(TotalPointList.get(position).getTotalPoint()));
         
	        return convertView;
	    }
}
