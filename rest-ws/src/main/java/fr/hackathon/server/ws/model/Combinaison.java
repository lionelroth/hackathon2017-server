package fr.hackathon.server.ws.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="combinaison")
public class Combinaison {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
		ListIterator<Integer> iterator = couleurs.listIterator();
		while (iterator.hasNext()) {
			if ( ! iterator.hasPrevious()) {
				sb.append(iterator.next());
			} else {
				sb.append(",");
				sb.append(iterator.next());
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