package fr.hackathon.server.ws.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import fr.hackathon.server.util.DaoException;
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
	
    public Combinaison findByCombinaison(String combinaison) throws DaoException {
    	ArrayList<Combinaison> allCombis = (ArrayList<Combinaison>) super.findAll(Combinaison.class);
    	System.out.println(allCombis);
    	for (Combinaison combi : allCombis) {
    		if (combi.getCouleurs().equals(combinaison)) {
    			return combi;
    		}
    	}
    	return null;
    }
    
}