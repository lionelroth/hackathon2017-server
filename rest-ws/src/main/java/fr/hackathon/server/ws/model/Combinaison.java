package fr.hackathon.server.ws.model;

import java.util.LinkedList;

public class Combinaison {

	private LinkedList<Integer> couleurs;

	public LinkedList<Integer> getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(LinkedList<Integer> couleurs) {
		this.couleurs = couleurs;
	}

	@Override
	public String toString() {
		return "Combinaison [couleurs=" + couleurs + "]";
	}
	
}