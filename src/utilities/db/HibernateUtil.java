package utilities.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			buildSessionFactory();
		}
		return sessionFactory;
	}

	private static void buildSessionFactory() {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.err.println("sessionFactory error " + e);
		}
	}

	public static Session getCurrentSession() {
		return session;
	}
}
