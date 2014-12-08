package com.sicmsb.bean;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SicmsbDao {
	public void Insert(String name, String email, String phone,
			String department, String hometown) {
		try {

			Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = configuration.buildSessionFactory();

		
			Session session = sessionFactory.openSession();

			
			Transaction transaction = session.beginTransaction();
			SicmsbTb user = new SicmsbTb();
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setDepartment(department);
			user.setHometown(hometown);
			session.save(user);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}
	
	public SicmsbTb get(Integer id) {
		SicmsbTb bean = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			
			bean = (SicmsbTb) session.get(SicmsbTb.class,id);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return bean;
	}
	
	public List<SicmsbTb> findName(String name) {
		List<SicmsbTb> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session
					.createQuery("from SicmsbTb where name like '%" + name
							+ "%'");
			list = (List<SicmsbTb>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;

	}
	
	public void updateData(SicmsbTb sic) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.update(sic);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	}
	

