package fr.hackathon.server.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO à compléter
 */
@Entity
@Table(name="utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="id_facebook", length=50)
	private String idFB;
	
	@Column(name="compte")
	private String compte;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdFB() {
		return idFB;
	}

	public void setIdFB(String idFB) {
		this.idFB = idFB;
	}

	public String getCompte() {
		return compte;
	}

	public void setCompte(String compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", idFB=" + idFB + ", compte=" + compte + "]";
	}

}