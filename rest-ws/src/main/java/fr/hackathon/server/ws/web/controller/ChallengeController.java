package fr.hackathon.server.ws.web.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.hackathon.client.OBPClient;
import fr.hackathon.server.ws.dao.ChallengeDAOImpl;
import fr.hackathon.server.ws.dao.ObjectifDAOImpl;
import fr.hackathon.server.ws.model.Challenge;
import fr.hackathon.server.ws.model.Objectif;
import fr.hackathon.server.ws.model.Utilisateur;

@RestController
@RequestMapping(value="/server")
public class ChallengeController {

	@Resource
	private ChallengeDAOImpl challengeDAOImpl;
	
	@Resource
	private ObjectifDAOImpl objectifDAOImpl;
	
	@RequestMapping(value="/realiserChallenge/{idChallenge}", method = RequestMethod.POST)
	public boolean effectuerVirement(@PathVariable int idChallenge) {

		boolean success = false;
		try {
			Challenge challenge = challengeDAOImpl.findById(idChallenge);
			BigDecimal montantAVirer = challenge.getGratification();
			Utilisateur responsable = challenge.getResponsable();
			String compteADebiter = responsable.getCompte();
			
			OBPClient.effectuerVirement(montantAVirer.floatValue(), compteADebiter, OBPClient.COMPTE_A_CREDITER);
			Objectif objectif = challenge.getObjectif();
			BigDecimal realise = objectif.getRealise();
			objectif.setRealise(realise.add(montantAVirer));	// on màj le réalisé de l'objectif pour qu'il soit tjrs à jour dans l'appli mobile
			success = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
}