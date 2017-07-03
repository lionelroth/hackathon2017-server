package fr.hackathon.server;
// Generated 4 juil. 2017 00:40:49 by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class HelloWorld.
 * @see fr.hackathon.server.HelloWorld
 * @author Hibernate Tools
 */
@Stateless
public class HelloWorldHome {

	private static final Log log = LogFactory.getLog(HelloWorldHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(HelloWorld transientInstance) {
		log.debug("persisting HelloWorld instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
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
