package com.sicmsb.bean;

import org.apache.struts.action.ActionForm;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {

			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			return sf;
		} catch (Throwable ex) {

			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {

		getSessionFactory().close();
	}
}
