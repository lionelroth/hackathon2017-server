package fr.hackathon.server.ws.dto;

import java.util.ArrayList;

public class ButtonIdAndCombinaisonDTO {

	private boolean success;
	private int id;
	private ArrayList<Integer> couleurs;
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(ArrayList<Integer> couleurs) {
		this.couleurs = couleurs;
	}

	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ButtonIdAndCombinaisonDTO [id=" + id + ", couleurs=" + couleurs + "]";
	}

}