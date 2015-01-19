package com.sicmsb.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sicmsb.bean.Data;
import com.sicmsb.bean.DataDao;
import com.sicmsb.bean.HibernateUtil;
import com.sicmsb.bean.Logon;
import com.sicmsb.bean.LoginService;
import com.sicmsb.bean.RegisterService;
import com.sicmsb.form.CalendarForm;
import com.sicmsb.form.DataForm;
import com.sicmsb.servlet.CalEventServlet;
import com.sicmsb.bean.PasswordHash;

public class CalendarAction extends DispatchAction {

	String action_user = "";

	public ActionForward preCalendar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			DataForm f = (DataForm) form;
			f.setUsername(action_user);
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("new");
	}

	public ActionForward Remark(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			DataForm formr = (DataForm) form;
			// System.out.println(formr.getDate());
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return mapping.findForward("remark");
	}

	public ActionForward Save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			DataForm formc = (DataForm) form;
			Data dat = new Data();

			dat.setRemarks(formc.getRemarks());
			dat.setUsername(action_user);
			dat.setStartdate(formc.getDate());
			dat.setStarttime(formc.getStarttime());
			dat.setEnddate(formc.getEnddate());
			dat.setEndtime(formc.getEndtime());

			// System.out.println(dat.getUsername());
			// System.out.println(dat.getStartdate());
			// System.out.println(dat.getRemarks());

			session.save(dat);
			session.getTransaction().commit();

		} catch (Exception e) {
			log.error("ERROR", e);
		}
		response.sendRedirect("Calendar.do?method=NewCalendar");
		return null;

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
		DataForm formr = (DataForm) form;
		try {

			String user = formr.getUsername();
			String password = PasswordHash.hash(formr.getPassword());
			Logon login = new Logon(user, password);
			RegisterService registerService = new RegisterService();
			boolean result = registerService.register(login);
			if (result) {
				response.sendRedirect("Calendar.do?method=preLogin");
			} else {
				response.sendRedirect("Calendar.do?method=preRegister");
				// mapping.findForward("register");
				formr.setMsg("User already exist! Try another name!");
				System.out.println("User already exist! Try another name!");
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.sendRedirect("Calendar.do?method=preRegister");
			formr.setMsg("Failed!");
		}

		return null;

	}

	public ActionForward Login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DataForm forml = (DataForm) form;
		try {

			String user = forml.getUsername();
			String password = PasswordHash.hash(forml.getPassword());

			LoginService loginService = new LoginService();
			boolean result = loginService.authenticate(user, password);
			Logon login = loginService.getUserByUserId(user);
			if (result == true) {
				action_user = user;
				CalEventServlet.setUsername(user);
				response.sendRedirect("Calendar.do?method=preCalendar");
			} else {
				response.sendRedirect("Calendar.do?method=preLogin");
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

	public ActionForward List(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

			DataDao dao = new DataDao();
			List<Data> list = dao.findName(action_user);
			for (Data dat : list) {
				log.debug(dat.getUsername());
			}
			request.setAttribute("listRemarks", list);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return mapping.findForward("list");

	}

	public ActionForward NewCalendar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("new");

	}

	public ActionForward EventShow(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			List<Data> list = null;
			String param = request.getParameter("id");
			System.out.println(param);
			Query query = session.createQuery("from Data where id like '%"
					+ param + "%'");
			list = (List<Data>) query.list();
			session.getTransaction().commit();
			for (Data dat : list) {
				// log.debug(dat.getStartdate());

				DataForm eventform = (DataForm) form;
				eventform.setId(dat.getId());
				eventform.setStartdate(dat.getStartdate());
				eventform.setEnddate(dat.getEnddate());
				eventform.setStarttime(dat.getStarttime());
				eventform.setEndtime(dat.getEndtime());
				eventform.setRemarks(dat.getRemarks());
				eventform.setUsername(dat.getUsername());

			}

			request.setAttribute("list", list);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			session.getTransaction().rollback();
		}

		return mapping.findForward("event");

	}

	public ActionForward Delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String del = request.getParameter("id");

		String sql = "delete from Data where id =" + del;
		Query query = session.createQuery(sql);
		int row = query.executeUpdate();
		if (row == 0)
			System.out.println("Doesnt deleted any row!");
		else
			System.out.println("Deleted Row: " + row);
		session.getTransaction().commit();
		session.close();

		return mapping.findForward("delete");

	}

}
