package fr.hackathon.server.ws.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.hackathon.server.util.DaoException;
import fr.hackathon.server.ws.model.Objectif;

@Repository
public class ObjectifDAOImpl extends GenericDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	 /**
     * Insert a new Objectif into the database.
     * @param objectif
     */
    public void create(Objectif user) throws DaoException {
        super.saveOrUpdate(user);
    }


    /**
     * Delete a Objectif from the database.
     * @param objectif
     */
    public void delete(Objectif objectif) throws DaoException {
        super.delete(objectif);
    }

    /**
     * Find an Objectif by its primary key.
     * @param id - Integer
     * @return
     */
    public Objectif findById(Integer id) throws DaoException {
        return (Objectif) super.findById(Objectif.class, id);
    }

    /**
     * Updates the state of a Objectif.
     *
     * @param objectif
     */
    public void update(Objectif objectif) throws DaoException {
        super.saveOrUpdate(objectif);
    }
    
    public List<Objectif> getAll() {
    	List<Objectif> allObj = new ArrayList<Objectif>();
    	try {
    		allObj = (List<Objectif>) super.findAll(Objectif.class);
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return allObj;
    }

}
