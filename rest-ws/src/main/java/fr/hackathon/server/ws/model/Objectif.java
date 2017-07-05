package fr.hackathon.server.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="objectif")
public class Objectif {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_objectif;
	
	@Column(name="nom_objectif", nullable=false, length=50)
	private String nom_objectif;
	
	@Column(name="description", nullable=false, length=200)
	private String description;
	
	/** valeurs : I=individuel / C=collectif / M=modele */
	@Column(name="type", nullable=false, length=1)
	private Character type;
	
	/** TODO : attention à la mousse */
//	@Column(name="id_admin", nullable=false)
//	private Utilisateur utilisateur;
	@JoinColumn(name="id_admin", nullable=false)
	private int id_admin;
	
	@Column(name="realise", nullable=false, precision=2)
	private float realise;

	public int getId_objectif() {
		return id_objectif;
	}

	public void setId_objectif(int id_objectif) {
		this.id_objectif = id_objectif;
	}

	public String getNom_objectif() {
		return nom_objectif;
	}

	public void setNom_objectif(String nom_objectif) {
		this.nom_objectif = nom_objectif;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public float getRealise() {
		return realise;
	}

	public void setRealise(float realise) {
		this.realise = realise;
	}

	@Override
	public String toString() {
		return "Objectif [id_objectif=" + id_objectif + ", nom_objectif=" + nom_objectif + ", description="
				+ description + ", type=" + type + ", id_admin=" + id_admin + ", realise=" + realise + "]";
	}
	
}