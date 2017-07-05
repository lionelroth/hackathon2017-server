// default package
// Generated 5 juil. 2017 22:43:03 by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Combinaison.
 * @see .Combinaison
 * @author Hibernate Tools
 */
@Stateless
public class CombinaisonHome {

	private static final Log log = LogFactory.getLog(CombinaisonHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Combinaison transientInstance) {
		log.debug("persisting Combinaison instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Combinaison persistentInstance) {
		log.debug("removing Combinaison instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Combinaison merge(Combinaison detachedInstance) {
		log.debug("merging Combinaison instance");
		try {
			Combinaison result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Combinaison findById(Integer id) {
		log.debug("getting Combinaison instance with id: " + id);
		try {
			Combinaison instance = entityManager.find(Combinaison.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
