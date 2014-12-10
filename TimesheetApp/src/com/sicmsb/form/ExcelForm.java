package com.sicmsb.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class ExcelForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private int year;
	private int month;
	private FormFile file;
	private String fileName;
	
	public FormFile getFile() {
		return file;
	}
 
	public void setFile(FormFile file) {
		this.file = file;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
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
