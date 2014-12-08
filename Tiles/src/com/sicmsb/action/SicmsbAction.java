package com.sicmsb.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sicmsb.bean.HibernateUtil;
import com.sicmsb.bean.Login;
import com.sicmsb.bean.LoginService;
import com.sicmsb.bean.RegisterService;
import com.sicmsb.bean.SendMail;
import com.sicmsb.bean.SicmsbDao;
import com.sicmsb.bean.SicmsbTb;
import com.sicmsb.form.FileUploadForm;
import com.sicmsb.form.SicmsbForm;
import com.sicmsb.hash.PasswordHash;

public class SicmsbAction extends DispatchAction {

	public ActionForward Start(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return mapping.findForward("first");

	}

	public ActionForward List(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

			SicmsbForm form_B = (SicmsbForm) form;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return mapping.findForward("list");

	}

	public ActionForward Insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SicmsbForm form_C = (SicmsbForm) form;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			SicmsbTb sic = new SicmsbTb();

			sic.setName(form_C.getName());
			sic.setEmail(form_C.getEmail());
			sic.setPhone(form_C.getPhone());
			sic.setDepartment(form_C.getDepartment());
			sic.setHometown(form_C.getHometown());

			session.save(sic);
			session.getTransaction().commit();
			form_C.setMsg("All data is Inserted into Database!");

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			form_C.setMsg("Failed to save!");
		}

		return mapping.findForward("insert");

	}

	public ActionForward Search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

			SicmsbForm form_D = (SicmsbForm) form;

			String userName = form_D.getName();
			SicmsbDao dao = new SicmsbDao();
			List<SicmsbTb> list = dao.findName(userName);
			for (SicmsbTb sic : list) {
				log.debug(sic.getName());
			}
			request.setAttribute("listSicmsb", list);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return mapping.findForward("search");

	}

	public ActionForward Details(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

			SicmsbForm form_E = (SicmsbForm) form;

			int id = form_E.getId();
			SicmsbDao dao = new SicmsbDao();
			SicmsbTb sic = dao.get(id);
			form_E.setName(sic.getName());
			form_E.setEmail(sic.getEmail());
			form_E.setPhone(sic.getPhone());
			form_E.setDepartment(sic.getDepartment());
			form_E.setHometown(sic.getHometown());

		} catch (Exception e) {
			log.error("ERROR");
		}
		return mapping.findForward("details");

	}

	public ActionForward Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SicmsbForm form_F = (SicmsbForm) form;
		try {

			int id = form_F.getId();
			SicmsbDao dao = new SicmsbDao();
			SicmsbTb sic = dao.get(id);
			if (form_F.getName() != "") {
				sic.setName(form_F.getName());
			}
			if (form_F.getEmail() != "") {
				sic.setEmail(form_F.getEmail());
			}
			if (form_F.getPhone() != "") {
				sic.setPhone(form_F.getPhone());
			}
			if (form_F.getDepartment() != "") {
				sic.setDepartment(form_F.getDepartment());
			}
			if (form_F.getHometown() != "") {
				sic.setHometown(form_F.getHometown());
			}
			dao.updateData(sic);
			form_F.setMsg("All data is Saved!");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("ERROR", e);
			form_F.setMsg("Not Saved!");

		}
		return mapping.findForward("update");

	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward preUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

			SicmsbForm formF = (SicmsbForm) form;
			int id = formF.getId();
			SicmsbDao dao = new SicmsbDao();
			SicmsbTb sic = dao.get(id);
			formF.setDepartment(sic.getDepartment());
			formF.setEmail(sic.getEmail());
			formF.setHometown(sic.getHometown());
			formF.setName(sic.getName());

		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("update");

	}

	public ActionForward preInsert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("insert");
	}

	public ActionForward Email(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("email");

	}

	public ActionForward Upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("upload");

	}

	public ActionForward SendEmail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SicmsbForm formEmail = (SicmsbForm) form;

		try {

			String recipient = formEmail.getRecipient();
			String subject = formEmail.getSubject();
			String content = formEmail.getContent();
			SendMail sendmail = new SendMail();
			sendmail.send(recipient, subject, content);
			formEmail.setMsg("Email Sent!");

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			formEmail.setMsg("ERROR! Email Not Sent!");
		}

		return mapping.findForward("email");

	}

	public ActionForward preLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("login");

	}

	public ActionForward preRegister(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("register");

	}

	public ActionForward Register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SicmsbForm formr = (SicmsbForm) form;
		try {

			String user = formr.getUsername();
			String password= PasswordHash.hash(formr.getPassword());
			Login login = new Login(user, password);
			RegisterService registerService = new RegisterService();
			boolean result = registerService.register(login);
			if (result) {
				response.sendRedirect("Action.do?method=First");
			}
			else{
				response.sendRedirect("Action.do?method=preRegister");
				//mapping.findForward("register");
				formr.setMsg("User already exist! Try another name!");
				System.out.println("User already exist! Try another name!");
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.sendRedirect("Action.do?method=preRegister");
			formr.setMsg("Failed!");
		}

		return null;

	}

	public ActionForward Login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SicmsbForm forml = (SicmsbForm) form;
		try {

			String user = forml.getUsername();
			String password = PasswordHash.hash(forml.getPassword());

			LoginService loginService = new LoginService();
			boolean result = loginService.authenticate(user, password);
			Login login = loginService.getUserByUserId(user);
			if (result == true) {
				response.sendRedirect("Action.do?method=First");
			} else {
				response.sendRedirect("Action.do?method=preLogin");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

	public ActionForward First(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("FirstLayout");

	}

}
