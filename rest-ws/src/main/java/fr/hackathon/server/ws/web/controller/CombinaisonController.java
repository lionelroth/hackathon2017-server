package fr.hackathon.server.ws.web.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.hackathon.server.app.ApplicationBean;
import fr.hackathon.server.ws.dao.CombinaisonDAOImpl;
import fr.hackathon.server.ws.dto.ButtonIdAndCombinaisonDTO;
import fr.hackathon.server.ws.model.Combinaison;


@RestController
@RequestMapping(value="/server")
public class CombinaisonController {

	@Resource
	private CombinaisonDAOImpl combinaisonDAOImpl;
	
	@Resource
	private ApplicationBean applicationBean;
	
    /** Button call POST pour donner une combinaison (user teste combi pour valider challenge ou user enregistre une nouvelle combi) */
 	@RequestMapping(value="/postCombinaison", method = RequestMethod.POST)
	public boolean createOrValidate(@RequestBody ButtonIdAndCombinaisonDTO dto) {
 		try {
 			Combinaison combinaison = new Combinaison();
 			ArrayList<Integer> couleurs = dto.getCouleurs();
			String couleursAsString = Combinaison.getCouleursAsString(couleurs);
			combinaison.setCouleurs(couleursAsString);
 			int buttonId = dto.getId();
 			System.out.println("buttonid : " + buttonId + "\nCombinaison : " + combinaison);
 			if (applicationBean.isReceptive()) {
 				System.out.println("L'appli était réceptive, la combi va être persistée.");
 				combinaisonDAOImpl.create(combinaison); 
 				applicationBean.setReceptive(false);
 			} else {
 				System.out.println("Non persistée, validity check...");
 				Combinaison combi = combinaisonDAOImpl.findByCombinaison(couleursAsString);
 				if (combi == null) {
 					System.out.println("Combi not found : " + couleursAsString);
 					return false;
 				}
 				//sinon return true psk on a trouvé la combinaison
 				System.out.println("Combinaison validée");
 			}
 			return true;
 		}
 		catch (Exception e) {
			e.printStackTrace();
 			return false;
		}
 	}
 	
 	/** TODO REMOVE TEST ONLY*/
 	@RequestMapping(value="/AllCombi", method = RequestMethod.GET)
 	public boolean getAll( ) {
 		combinaisonDAOImpl.findByCombinaison(null);
 		return true;
 	}
 	
 	
 	/** méthode appellée par app pour prévenir le server que user va saisir une combi sur le btn */
 	@RequestMapping(value="/enregistrerNvelleCombinaison", method = RequestMethod.GET)
 	public boolean setAppliReceptive() {
 		try {
 			applicationBean.setReceptive(true);
 			return true;
 		}
 		catch (Exception e) {
 			e.printStackTrace();
			return false;
		}
 	}
 	
 	/** Button call POST pour donner une combinaison + id button */
 	@RequestMapping(value="/getCombinaison", method = RequestMethod.GET)
 	public ButtonIdAndCombinaisonDTO get() {
 		System.out.println("tente de récup une combi");
 		Combinaison combi = combinaisonDAOImpl.findById(1);
 		System.out.println("combi récupérée : "+ combi);
 		Combinaison combinaison = combinaisonDAOImpl.findById(1);
 		
 		ButtonIdAndCombinaisonDTO dto = new ButtonIdAndCombinaisonDTO();
 		String couleurs = combinaison.getCouleurs();
		dto.setCouleurs(Combinaison.getCouleursAsList(couleurs));
 		dto.setId(1);;
		if (couleurs == null) {
			dto.setSuccess(false);
		} 
		else {
			dto.setSuccess(true);
		}
		
		return dto; 
 	}
 	
}