package fr.hackathon.server.ws.repository;

import org.springframework.stereotype.Repository;

import fr.hackathon.server.ws.model.Utilisateur;

@Repository
public class UtilisateurDAOImpl {

	public Utilisateur getById(String idFB) {
		// tODO : atm c bouchonné
		Utilisateur user = new Utilisateur();
		user.setId(123456789);
		user.setIdFB("idFb");
		return user;
	}

}
