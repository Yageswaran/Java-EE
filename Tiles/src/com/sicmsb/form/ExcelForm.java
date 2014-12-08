package com.sicmsb.form;

import org.apache.struts.action.ActionForm;

public class ExcelForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private int year;
	private int month;
	
	public void setYear(int year){
		this.year = year;
		
	}
	
	public int getYear(){
		return year;
	}
	
	public void setMonth(int month){
		this.month = month;
		
	}
	
	public int getMonth(){
		return month;
	}

}
