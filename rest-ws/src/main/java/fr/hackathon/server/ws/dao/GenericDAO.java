package fr.hackathon.server.ws.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.hackathon.server.util.DaoException;
import fr.hackathon.server.util.HibernateUtil;

/**
 * Generic class for all the DAOs of the app.
 * Declares generic CRUD methods and contains an implementation of some hibernate methods 
 */
public abstract class GenericDAO {
	private Session session;
	private Transaction transaction;

	public GenericDAO() {
		HibernateUtil.buildIfNeeded();
	}

	protected void saveOrUpdate(Object obj) {
		try {
			startOperation();
			session.saveOrUpdate(obj);
			transaction.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}

	protected void delete(Object obj) {
		try {
			startOperation();
			session.delete(obj);
			transaction.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}

	protected Object findById(Class<?> className, Serializable id) {
		Object obj = null;
		try {
			startOperation();
			obj = session.load(className, id);
			transaction.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
		return obj;
	}

	protected List<?> findAll(Class<?> classs) {
		List<?> objects = null;
		try {
			startOperation();
			Query query = session.createQuery("from " + classs.getName());
			objects = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
		return objects;
	}

	/**
	 * This function handles any {@link HibernateException} caught in the process, by doing a rollback on the transaction
	 * to prevent any changes, and converting the received exception into a {@link DaoException}
	 * @param e
	 * @throws DaoException
	 */
	protected void handleException(HibernateException e) throws DaoException {
		HibernateUtil.rollback(transaction);
		throw new DaoException(e);
	}

	/**
	 * Uses {@link HibernateUtil} methods to open a session and begin a transaction.
	 * @throws HibernateException
	 */
	protected void startOperation() throws HibernateException {
		session = HibernateUtil.openSession();
		transaction = session.beginTransaction();
	}
}
