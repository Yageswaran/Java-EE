package com.sicmsb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.sicmsb.form.FileUploadForm;

public class SicmsbFileAction extends DispatchAction {
	public ActionForward UploadFilee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FileUploadForm fileUploadForm = (FileUploadForm) form;

		FormFile file = fileUploadForm.getFile();

		String filePath = getServlet().getServletContext().getRealPath("/")
				+ "upload";

		File folder = new File(filePath);
		if (!folder.exists()) {
			folder.mkdir();
		}

		String fileName = file.getFileName();

		if (!("").equals(fileName)) {

			System.out.println("Server path:" + filePath);
			File newFile = new File(filePath, fileName);

			if (!newFile.exists()) {
				FileOutputStream fos = new FileOutputStream(newFile);
				fos.write(file.getFileData());
				fos.flush();
				fos.close();
			}

			request.setAttribute("uploadedFilePath", newFile.getAbsoluteFile());
			request.setAttribute("uploadedFileName", newFile.getName());
		}
		return mapping.findForward("success");
	}

	public ActionForward Save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("download");
	}

	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// return an application file instead of html page
		// FileUploadForm fform = new FileUploadForm();
		FileUploadForm fform = (FileUploadForm) form;
		String name = fform.getFileName();
		System.out.println(name);
		//name = "EMPLOYEE REFERRAL PROGRAM- 13 Feb 2014.pdf";
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+name);

		try {
			// Get it from file system
			FileInputStream in = new FileInputStream(
					new File(
							"C:\\Users\\yageswaran.ramar\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Tiles\\upload\\"+name));

			// Get it from web path 
			// jndi:/localhost/StrutsExample/upload/superfish.zip
			// URL url = getServlet().getServletContext()
			// .getResource("upload/superfish.zip");
			// InputStream in = url.openStream();

			// Get it from bytes array
			// byte[] bytes = new byte[4096];
			// InputStream in = new ByteArrayInputStream(bytes);

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

		//return mapping.findForward("download");
		return null;
	}
}
