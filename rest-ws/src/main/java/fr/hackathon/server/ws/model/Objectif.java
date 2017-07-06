package fr.hackathon.server.ws.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name="admin", nullable=false)
	private Utilisateur admin;
	
	@OneToMany(mappedBy="objectif")
//	@JoinColumn(name="objectif")
	private Set<Challenge> challenges;
	
	// TODO INVITÉS
	// TODO GROUPES/MEMBRES
//	@OneToMany
//	@JoinColumn
//	private Set<Utilisateur> participants;
	
	@Column(name="realise", nullable=false, precision=2)
	private BigDecimal realise;
	
	@Column(name="montant_vise", nullable=false, precision=2)
	private BigDecimal montant_vise;
	
	@Column(name="date_debut", nullable=false)
	private Date date_debut;
	
	@Column(name="date_fin", nullable=false)
	private Date date_fin;
	
	@Column(name="beneficiaire", nullable=false)
	private String beneficiaire;
	
	
	
	
	
	
	

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

	public Utilisateur getAdmin() {
		return admin;
	}

	public void setAdmin(Utilisateur admin) {
		this.admin = admin;
	}

	
	public Set<Challenge> getChallenges() {
		return challenges;
	}

	public void setChallenges(Set<Challenge> challenges) {
		this.challenges = challenges;
	}

	public BigDecimal getRealise() {
		return realise;
	}

	public void setRealise(BigDecimal realise) {
		this.realise = realise;
	}

	public BigDecimal getMontant_vise() {
		return montant_vise;
	}

	public void setMontant_vise(BigDecimal montant_vise) {
		this.montant_vise = montant_vise;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		return "Objectif [id_objectif=" + id_objectif + ", nom_objectif=" + nom_objectif + ", description="
				+ description + ", type=" + type + ", admin=" + admin + ", challenges=" + challenges + ", realise="
				+ realise + ", montant_vise=" + montant_vise + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", beneficiaire=" + beneficiaire + "]";
	}

}