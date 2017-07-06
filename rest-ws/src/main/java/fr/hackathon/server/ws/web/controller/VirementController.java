package fr.hackathon.server.ws.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.hackathon.server.ws.dto.AllObjectifsDTO;
import fr.hackathon.server.ws.dto.VirementInputDTO;

@RestController
@RequestMapping(value="/server")
public class VirementController {

	@RequestMapping(value="/realiserChallenge/{idChallenge}", method = RequestMethod.POST)
	public AllObjectifsDTO effectuerVirement(@PathVariable int idChallenge) {
		chall		
//		String compteACrediter = inputDto.getCompteACrediter();
//		String compteACrediter = inputDto.getCompteACrediter();
////		String url
		return null;
	}
	
}
