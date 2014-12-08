package com.sicmsb.bean;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sicmsb.bean.Login;
import com.sicmsb.bean.HibernateUtil;
import com.sicmsb.form.SicmsbForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class RegisterService {
	
public boolean register(Login user){
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 if(isUserExists(user)) return false;	
	
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.saveOrUpdate(user);		
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }	
	 return true;
}

public boolean isUserExists(Login user){
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Login where username='"+user.getUsername()+"'");
		 Login u = (Login)query.uniqueResult();
		 tx.commit();
		 if(u!=null) result = true;
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return result;
}
}

//public ActionForward Register(ActionMapping mapping, ActionForm form,
//		HttpServletRequest request, HttpServletResponse response)
//		throws Exception {
//	SicmsbForm formr = (SicmsbForm) form;
//	try {
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//
//		Login login = new Login();
//
//		login.setUsername(formr.getUsername());
//		login.setPassword(formr.getPassword());
//
//		session.save(login);
//		session.getTransaction().commit();
//		formr.setMsg("Successfully Registered!");
//		response.sendRedirect("Action.do?method=First");
//
//	} catch (Exception e) {
//		log.error(e.getMessage(), e);
//		formr.setMsg("Failed Registration!");
//		response.sendRedirect("Action.do?method=preRegister");
//	}
//
//	return null;
//
//}
