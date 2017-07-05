package fr.hackathon.server.ws.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.hackathon.client.util.DaoException;
import fr.hackathon.server.ws.model.Utilisateur;

@Repository
public class UtilisateurDAOImpl extends GenericDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Utilisateur getById(String idFB) {
		// tODO : atm c bouchonné
		Utilisateur user = new Utilisateur();
		user.setId(123456789);
		user.setIdFB(idFB);
		return user;
	}

	 /**
     * Insert a new Utilisateur into the database.
     * @param utilisateur
     */
    public void create(Utilisateur user) throws DaoException {
        super.saveOrUpdate(user);
    }


    /**
     * Delete a Utilisateur from the database.
     * @param utilisateur
     */
    public void delete(Utilisateur utilisateur) throws DaoException {
        super.delete(utilisateur);
    }

    /**
     * Find an Utilisateur by its primary key.
     * @param id - Integer
     * @return
     */
    public Utilisateur findById(Integer id) throws DaoException {
        return (Utilisateur) super.findById(Utilisateur.class, id);
    }

    /**
     * Updates the state of a Utilisateur.
     *
     * @param utilisateur
     */
    public void update(Utilisateur utilisateur) throws DaoException {
        super.saveOrUpdate(utilisateur);
    }

}
