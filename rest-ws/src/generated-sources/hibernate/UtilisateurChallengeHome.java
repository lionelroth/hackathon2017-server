// default package
// Generated 5 juil. 2017 22:43:03 by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class UtilisateurChallenge.
 * @see .UtilisateurChallenge
 * @author Hibernate Tools
 */
@Stateless
public class UtilisateurChallengeHome {

	private static final Log log = LogFactory.getLog(UtilisateurChallengeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UtilisateurChallenge transientInstance) {
		log.debug("persisting UtilisateurChallenge instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UtilisateurChallenge persistentInstance) {
		log.debug("removing UtilisateurChallenge instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UtilisateurChallenge merge(UtilisateurChallenge detachedInstance) {
		log.debug("merging UtilisateurChallenge instance");
		try {
			UtilisateurChallenge result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UtilisateurChallenge findById(Integer id) {
		log.debug("getting UtilisateurChallenge instance with id: " + id);
		try {
			UtilisateurChallenge instance = entityManager.find(UtilisateurChallenge.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
