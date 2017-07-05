package fr.hackathon.server.ws.repository;

import org.springframework.stereotype.Component;

import fr.hackathon.server.ws.model.Combinaison;

@Component
public class CombinaisonDAOImpl {

	/** TODO */
	public boolean persist(Combinaison combinaison) {
		boolean success = false;
		
		System.out.println("Combinaison : ");
		success = true;
		return success;
	}
	
}
