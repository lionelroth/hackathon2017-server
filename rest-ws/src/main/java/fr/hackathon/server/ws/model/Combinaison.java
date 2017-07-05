package fr.hackathon.server.ws.model;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="combinaison")
public class Combinaison {

	@Id
	private int id;
	
	@Column(name="couleurs")
	private String couleurs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(String couleurs) {
		this.couleurs = couleurs;
	}

	public static String getCouleursAsString(ArrayList<Integer> couleurs) {
		StringBuilder sb = new StringBuilder();
		for (Integer couleur : couleurs) {
			sb.append(couleur);
			if (couleurs.size() >= couleurs.indexOf(couleur)) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	public static ArrayList<Integer> getCouleursAsList(String couleurs) {
		ArrayList<Integer> couleursListe = new ArrayList<>();
		
		for (String couleur : couleurs.split(",+")) {
			couleursListe.add(Integer.parseInt(couleur));
		}
		return couleursListe;
	}

	@Override
	public String toString() {
		return "Combinaison [id=" + id + ", couleurs=" + couleurs + "]";
	}
	
}