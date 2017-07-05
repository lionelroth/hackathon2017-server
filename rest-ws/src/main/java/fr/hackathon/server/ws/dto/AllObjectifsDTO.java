package fr.hackathon.server.ws.dto;

import java.util.List;

import fr.hackathon.server.ws.model.Objectif;

public class AllObjectifsDTO {

	private boolean success = false;
	
	private List<Objectif> allObjectifs;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Objectif> getAllObjectifs() {
		return allObjectifs;
	}

	public void setAllObjectifs(List<Objectif> allObjectifs) {
		this.allObjectifs = allObjectifs;
	}

	@Override
	public String toString() {
		return "AllObjectifsDTO [success=" + success + ", allObjectifs=" + allObjectifs + "]";
	}
	
}
