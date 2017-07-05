package fr.hackathon.server.ws.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.hackathon.server.app.ApplicationBean;
import fr.hackathon.server.ws.dao.ObjectifDAOImpl;
import fr.hackathon.server.ws.dto.AllObjectifsDTO;
import fr.hackathon.server.ws.model.Objectif;


@RestController
@RequestMapping(value="/server")
public class ObjectifController {

	@Resource
	private ObjectifDAOImpl objectifDAOImpl;
	
	@Resource
	private ApplicationBean applicationBean;
	
	/** get ALL obj dispo ds BDD */
 	@RequestMapping(value="/objectifs", method = RequestMethod.GET)
	public AllObjectifsDTO getAll() {
 		boolean success = false;
 		List<Objectif> allObj = new ArrayList<Objectif>();
 		try {
 			allObj = objectifDAOImpl.getAll();
 			System.out.println();
 			success = true;
 		}
 		catch (Exception e) {
			e.printStackTrace();
		}
 		AllObjectifsDTO dto = new AllObjectifsDTO();
 		dto.setAllObjectifs(allObj);
 		dto.setSuccess(success);
 		
 		return dto;
 	}
 	
 	/** Tous les obj de l'utilisateur demandé TODO : atm juste si user est admin*/
 	@RequestMapping(value="/objectifs/user/{userId}", method = RequestMethod.GET)
 	public AllObjectifsDTO getAllObjForUser(@PathVariable int userId) {
 		List<Objectif> objForUser = new ArrayList<Objectif>();
 		boolean success = false;
 		try {
 			List<Objectif> allObjectifs = this.getAll().getAllObjectifs();
 			for (Objectif obj : allObjectifs) {
 				if (obj.getId_admin() == userId) {	//TODO à compléter
 					objForUser.add(obj);
 				}
 			}
 			success = true;
 		} catch (Exception e) {
			e.printStackTrace();
		}
 		AllObjectifsDTO dto = new AllObjectifsDTO();
 		dto.setAllObjectifs(objForUser);
 		dto.setSuccess(success);
 		return dto;
 	}
 	
}