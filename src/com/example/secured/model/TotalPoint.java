package com.example.secured.model;

public class TotalPoint {
	private long id;
	private String name;
	private int totalPoint;
	private int visit1;
	private int visit2;
	private int visit3;
	private int visit4;
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setTotalPoint(int totalPoint){
		this.totalPoint = totalPoint;
	}
	
	public int getTotalPoint(){
		return this.totalPoint;
	}
	
	public void setVisit1(int visit1){
		this.visit1 = visit1;
	}
	
	public int getVisit1(){
		return this.visit1;
	}
	
	public void setVisit2(int visit2){
		this.visit2 = visit2;
	}
	
	public int getVisit2(){
		return this.visit2;
	}
	
	public void setVisit3(int visit3){
		this.visit3 = visit3;
	}
	
	public int getVisit3(){
		return this.visit3;
	}
	
	public void setVisit4(int visit4){
		this.visit4 = visit4;
	}
	
	public int getVisit4(){
		return this.visit4;
	}

}
