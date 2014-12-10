package com.sicmsb.action;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.sicmsb.bean.Excel;
import com.sicmsb.form.ExcelForm;
import com.sicmsb.tsapp.util.Config;

public class ExcelAction extends DispatchAction {
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

			File theDir = new File("D:\\TimeSheet");
			if (!theDir.exists()) {
				System.out.println("creating directory: D:\\TimeSheet");
				boolean result = false;

				try {
					theDir.mkdirs();
					result = true;
				} catch (SecurityException se) {
					// handle it
				}
				if (result) {
					System.out.println("DIR created");
				}
			}
			ExcelForm forme = (ExcelForm) form;
			int month = forme.getMonth();
			int year = forme.getYear();
			System.out.println(month);
			System.out.println(year);
			Excel myReport = new Excel();
			myReport.createExcel(month, year);

		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("excel");
	}

	public ActionForward List(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return mapping.findForward("list");

	}

	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// return an application file instead of html page
		// FileUploadForm fform = new FileUploadForm();
		ExcelForm fform = (ExcelForm) form;
		String name = fform.getFileName();
		System.out.println(name);
		// name = "EMPLOYEE REFERRAL PROGRAM- 13 Feb 2014.pdf";
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + name);

		try {
			Config config = Config.getInstance();
			String path = config.getProperty("path", "D:\\Timesheet");
			System.out.println("path: " + path);
			// Get it from file system
			FileInputStream in = new FileInputStream(new File(path + name));

			ServletOutputStream out = response.getOutputStream();

			byte[] outputByte = new byte[4096];
			// copy binary content to output stream
			while (in.read(outputByte, 0, 4096) != -1) {
				out.write(outputByte, 0, 4096);
			}
			in.close();
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return mapping.findForward("download");
		return null;
	}
}
