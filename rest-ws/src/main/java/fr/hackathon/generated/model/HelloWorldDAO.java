package fr.hackathon.generated.model;
// Generated 4 juil. 2017 00:40:49 by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Home object for domain model class HelloWorld.
 * @see fr.hackathon.server.HelloWorld
 * @author Hibernate Tools
 */
@Stateless
@Repository("helloWorldDAO")
public class HelloWorldDAO {

	private static final Log log = LogFactory.getLog(HelloWorldDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public boolean persist(HelloWorld transientInstance) {
		log.debug("persisting HelloWorld instance");
		boolean success = false;
		try {
			entityManager.persist(transientInstance);
			success = true;
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		return success;
	}

	public void remove(HelloWorld persistentInstance) {
		log.debug("removing HelloWorld instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public HelloWorld merge(HelloWorld detachedInstance) {
		log.debug("merging HelloWorld instance");
		try {
			HelloWorld result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HelloWorld findById(Integer id) {
		log.debug("getting HelloWorld instance with id: " + id);
		try {
			HelloWorld instance = entityManager.find(HelloWorld.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}