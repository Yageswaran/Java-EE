package com.sicmsb.bean;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class DataDao {
	public List<Data> findName(String name) {
		List<Data> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from Data where username like '%"+ name +"%'");
			list = (List<Data>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;

	}

}
