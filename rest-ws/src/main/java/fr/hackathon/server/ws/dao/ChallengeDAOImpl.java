package fr.hackathon.server.ws.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.hackathon.server.util.DaoException;
import fr.hackathon.server.ws.model.Challenge;

@Repository
public class ChallengeDAOImpl extends GenericDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	 /**
     * Insert a new Challenge into the database.
     * @param challenge
     */
    public void create(Challenge user) throws DaoException {
        super.saveOrUpdate(user);
    }


    /**
     * Delete a Challenge from the database.
     * @param challenge
     */
    public void delete(Challenge challenge) throws DaoException {
        super.delete(challenge);
    }

    /**
     * Find an Challenge by its primary key.
     * @param id - Integer
     * @return
     */
    public Challenge findById(Integer id) throws DaoException {
        return (Challenge) super.findById(Challenge.class, id);
    }

    /**
     * Updates the state of a Challenge.
     *
     * @param challenge
     */
    public void update(Challenge challenge) throws DaoException {
        super.saveOrUpdate(challenge);
    }
    
    public List<Challenge> getAll() {
    	List<Challenge> allObj = new ArrayList<Challenge>();
    	try {
    		allObj = (List<Challenge>) super.findAll(Challenge.class);
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return allObj;
    }

}