package fr.hackathon.server.ws.dto;

import java.util.LinkedList;

public class ButtonIdAndCombinaisonDTO {

	private int id;
	
	private LinkedList<Integer> couleurs;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<Integer> getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(LinkedList<Integer> couleurs) {
		this.couleurs = couleurs;
	}

	@Override
	public String toString() {
		return "ButtonIdAndCombinaisonDTO [id=" + id + ", couleurs=" + couleurs + "]";
	}

}