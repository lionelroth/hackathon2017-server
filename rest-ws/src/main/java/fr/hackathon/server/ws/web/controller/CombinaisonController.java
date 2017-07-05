package fr.hackathon.server.ws.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.hackathon.server.ws.dao.CombinaisonDAOImpl;
import fr.hackathon.server.ws.dto.ButtonIdAndCombinaisonDTO;
import fr.hackathon.server.ws.model.Combinaison;


@RestController
@RequestMapping(value="/server")
public class CombinaisonController {

	@Resource
	private CombinaisonDAOImpl combinaisonDAOImpl;
	
    /** Button call POST pour donner une combinaison */
 	@RequestMapping(value="/postCombinaison", method = RequestMethod.POST)
	public boolean add(@RequestBody ButtonIdAndCombinaisonDTO dto) {
 		try {
 			Combinaison combinaison = new Combinaison();
 			combinaison.setCouleurs(Combinaison.getCouleursAsString(dto.getCouleurs()));
 			int buttonId = dto.getId();
 			System.out.println("buttonid : " + buttonId + "\nCombinaison : " + combinaison);
 			combinaisonDAOImpl.create(combinaison); 
 			return true;
 		}
 		catch (Exception e) {
			// TODO: handle exception
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