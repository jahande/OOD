package db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import utilities.HibernateUtil;

public abstract class BaseDao<T extends BaseEntity<PKType>, PKType extends Serializable> {

	protected T findById(Class<T> clazz, PKType id) {
		Session session = null;
		T result = null;
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			result = (T) session.load(clazz, id);
			session.getTransaction().commit();
		} catch (ObjectNotFoundException e) {
			System.out.println("Object not found. id = " + id + e);
			e.printStackTrace();
			if (tx != null && !tx.wasCommitted())
				tx.rollback();
		} catch (HibernateException e) {
			System.out.println("Hibernate exception" + e);
			e.printStackTrace();
			if (tx != null && !tx.wasCommitted())
				tx.rollback();
		} finally {
			// if (session.isOpen())
			// session.flush();
			session.close();
		}
		return result;
	}

	protected List<T> findByParameter(Class<T> clazz, String parameter, Object value) {
		Session session = null;
		List<T> result = null;
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(clazz);
			crit.add(Restrictions.eq(parameter, value)); // Like condition
			result = (List<T>) crit.list();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate exception" + e);
			e.printStackTrace();
			if (tx != null && !tx.wasCommitted())
				tx.rollback();
		} finally {
			if (session.isOpen())
				session.flush();
		}
		return result;
	}

	protected List<T> fetchAll(Class<T> clazz) {
		Session session = null;
		List<T> result = null;
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(clazz).addOrder(Order.asc("id"));
			result = (List<T>) crit.list();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate exception" + e);
			e.printStackTrace();
			if (tx != null && !tx.wasCommitted())
				tx.rollback();
		} finally {
			if (session.isOpen())
				session.flush();
		}
		return result;
	}

	public boolean save(T entity) {
		Session session = null;
		boolean result = false;
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.clear();
			session.save(entity);
			tx.commit();
			result = true;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception" + e);
			e.printStackTrace();
			if (tx != null && !tx.wasCommitted())
				tx.rollback();
		} finally {
			if (session.isOpen())
				session.flush();
		}
		return result;
	}

	public boolean update(T entity) {
		Session session = null;
		boolean result = false;
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.merge(entity);
			tx.commit();
			result = true;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception" + e);
			e.printStackTrace();
			if (tx != null && !tx.wasCommitted())
				tx.rollback();
		} finally {
			if (session.isOpen())
				session.flush();
		}
		return result;
	}

	public boolean delete(T entity) {
		Session session = null;
		boolean result = false;
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.clear();
			session.delete(entity);
			tx.commit();
			result = true;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception :\t" + e);
			e.printStackTrace();
			if (tx != null && !tx.wasCommitted())
				tx.rollback();
		} finally {
			if (session.isOpen())
				session.flush();
		}
		return result;
	}
}
