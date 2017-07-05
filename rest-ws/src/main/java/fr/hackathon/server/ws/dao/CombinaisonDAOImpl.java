package fr.hackathon.server.ws.dao;

import org.springframework.stereotype.Component;

import fr.hackathon.client.util.DaoException;
import fr.hackathon.server.ws.model.Combinaison;

@Component
public class CombinaisonDAOImpl extends GenericDAO {

    public void create(Combinaison combi) throws DaoException {
    	System.out.println("persisting combinaison : " + combi);
        super.saveOrUpdate(combi);
    }


    public void delete(Combinaison combi) throws DaoException {
        super.delete(combi);
    }

    public Combinaison findById(Integer id) throws DaoException {
        return (Combinaison) super.findById(Combinaison.class, id);
    }
	
}