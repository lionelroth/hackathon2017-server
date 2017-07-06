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
	@JoinColumn(name="objectif")
	private Objectif objectif;
	
	@ManyToOne
	@JoinColumn(name="responsable")
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

	public BigDecimal getGratification() {
		return gratification;
	}

	public void setGratification(BigDecimal gratification) {
		this.gratification = gratification;
	}

	public Utilisateur getResponsable() {
		return responsable;
	}

	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	@Override
	public String toString() {
		return "Challenge [id=" + id + ", nom=" + nom + ", gratification=" + gratification + ", objectif=" + objectif
				+ ", responsable=" + responsable + "]";
	}

}