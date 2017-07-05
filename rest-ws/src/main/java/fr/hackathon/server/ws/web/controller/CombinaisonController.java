package fr.hackathon.server.ws.web.controller;

import java.util.LinkedList;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.hackathon.server.ws.dto.ButtonIdAndCombinaisonDTO;
import fr.hackathon.server.ws.model.Combinaison;
import fr.hackathon.server.ws.repository.CombinaisonDAOImpl;


@RestController
@RequestMapping(value="/server")
public class CombinaisonController {

	@Resource
	private CombinaisonDAOImpl combinaisonDAOImpl;
	
    /** Button call POST pour donner une combinaison */
 	@RequestMapping(value="/postCombinaison", method = RequestMethod.POST)
	public boolean add(@RequestBody ButtonIdAndCombinaisonDTO dto) {
 		Combinaison combinaison = new Combinaison();
 		combinaison.setCouleurs(dto.getCouleurs());
 		int buttonId = dto.getId();
 		System.out.println("buttonid : " + buttonId + "\nCombinaison : " + combinaison);
 		return combinaisonDAOImpl.persist(combinaison); 
 	}
 	
 	/** Button call POST pour donner une combinaison + id button */
 	@RequestMapping(value="/getCombinaison", method = RequestMethod.GET)
 	public ButtonIdAndCombinaisonDTO get() {
 		LinkedList<Integer> couleurs = new LinkedList<>();
 		couleurs.add(1);
 		couleurs.add(2);
		ButtonIdAndCombinaisonDTO dto = new ButtonIdAndCombinaisonDTO();
		dto.setCouleurs(couleurs);
		dto.setId(12345);
		return dto; 
 	}
 	
}