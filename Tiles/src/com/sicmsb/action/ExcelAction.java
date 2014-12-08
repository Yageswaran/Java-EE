package com.sicmsb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.sicmsb.bean.Excel;
import com.sicmsb.form.ExcelForm;

public class ExcelAction extends DispatchAction{
	public ActionForward preExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("excel");
	}
	
	public ActionForward Excel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
          ExcelForm forme = (ExcelForm) form;
          int month = forme.getMonth();
          int year = forme.getYear();
          System.out.println(month);
          System.out.println(year);
          Excel myReport = new Excel();
          myReport.createExcel(month,year);
          
          
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("excel");
	}
}
