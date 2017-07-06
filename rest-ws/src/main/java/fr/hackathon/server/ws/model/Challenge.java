package fr.hackathon.server.ws.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TODO A FINIR 
 * @author Lionel
 *
 */
@Entity
@Table(name="challenge")
public class Challenge {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="gratification")
	private BigDecimal gratification;
	
	@ManyToOne
	@JoinColumn(name="responsable", nullable=false)
	private Utilisateur responsable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Challenge [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
}
