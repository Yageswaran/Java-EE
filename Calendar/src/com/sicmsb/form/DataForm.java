package com.sicmsb.form;

import org.apache.struts.action.ActionForm;


public class DataForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int i;
	private String username;
	private String password;
	private String date;
	private String remarks;
	private String msg;

	public DataForm() {
	}

	public DataForm(String username, String password, String date,
			String remarks) {
		this.username = username;
		this.password = password;
		this.date = date;
		this.remarks = remarks;
	}

	public Integer getId() {
		return this.id;
	}

	public void setI(Integer i) {
		this.i = i;
	}
	public Integer getI() {
		return this.i;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public void setMsg(String msg){
		this.msg= msg;
	}
	
	public String getMsg(){
		return msg;
	}
	
}
