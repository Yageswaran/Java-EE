package com.sicmsb.bean;
import java.util.ArrayList;
import java.util.List;
import com.sicmsb.bean.Login;
import com.sicmsb.bean.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class LoginService {
public boolean authenticate(String username, String password) {
	 Login user = getUserByUserId(username);		
	 if(user!=null && user.getUsername().equals(username) && user.getPassword().equals(password)){
		 return true;
	 }else{
		 return false;
	 }
}
public Login getUserByUserId(String username) {
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 Transaction tx = null;
	 Login user = null;
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Login where username='"+username+"'");
		 user = (Login)query.uniqueResult();
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }
	 return user;
}

public List<Login> getListOfUsers(){
	 List<Login> list = new ArrayList<Login>();
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 list = session.createQuery("from Login").list();					
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }
	 return list;
}
}
