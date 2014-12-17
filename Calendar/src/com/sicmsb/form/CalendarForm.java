package com.sicmsb.form;

import org.apache.struts.action.ActionForm;

public class CalendarForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String remark;

	public void setRemark(String remark) {

		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}
}
