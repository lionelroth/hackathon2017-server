package fr.hackathon.server.ws.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.hackathon.server.ws.dto.GenericWSResponse;
import fr.hackathon.server.ws.model.Utilisateur;
import fr.hackathon.server.ws.repository.UtilisateurDAOImpl;


@RestController
@RequestMapping(value="/server")
public class IdentificationController {

	@Resource
	private UtilisateurDAOImpl utilisateurDAOImpl;
	
    /** Button call POST pour donner une combinaison */
 	@RequestMapping(value="/utilisateur/{idFB}", method = RequestMethod.GET)
	public GenericWSResponse getUserFromIdFB(@PathVariable String idFB) {
 		GenericWSResponse response = new GenericWSResponse(); 		
 		Utilisateur user = utilisateurDAOImpl.getById(idFB);
 		response.setValeur(user);
 		response.setSuccess(true);
 		return response;
 	}
 	
}