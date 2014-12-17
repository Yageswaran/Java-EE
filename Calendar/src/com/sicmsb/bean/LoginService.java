package com.sicmsb.bean;
import java.util.ArrayList;
import java.util.List;
import com.sicmsb.bean.Logon;
import com.sicmsb.bean.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class LoginService {
public boolean authenticate(String username, String password) {
	 Logon user = getUserByUserId(username);		
	 if(user!=null && user.getUsername().equals(username) && user.getPassword().equals(password)){
		 return true;
	 }else{
		 return false;
	 }
}
public Logon getUserByUserId(String username) {
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 Transaction tx = null;
	 Logon user = null;
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Logon where username='"+username+"'");
		 user = (Logon)query.uniqueResult();
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

public List<Logon> getListOfUsers(){
	 List<Logon> list = new ArrayList<Logon>();
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 list = session.createQuery("from Logon").list();					
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
