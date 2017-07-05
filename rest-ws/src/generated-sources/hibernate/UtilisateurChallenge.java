// default package
// Generated 5 juil. 2017 22:43:03 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UtilisateurChallenge generated by hbm2java
 */
@Entity
@Table(name = "utilisateur_challenge", catalog = "hackathon_server")
public class UtilisateurChallenge implements java.io.Serializable {

	private Integer id;
	private int idChallenge;
	private int idUtilisateur;
	private Float gratification;
	private String combinaison;

	public UtilisateurChallenge() {
	}

	public UtilisateurChallenge(int idChallenge, int idUtilisateur) {
		this.idChallenge = idChallenge;
		this.idUtilisateur = idUtilisateur;
	}

	public UtilisateurChallenge(int idChallenge, int idUtilisateur, Float gratification, String combinaison) {
		this.idChallenge = idChallenge;
		this.idUtilisateur = idUtilisateur;
		this.gratification = gratification;
		this.combinaison = combinaison;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "id_challenge", nullable = false)
	public int getIdChallenge() {
		return this.idChallenge;
	}

	public void setIdChallenge(int idChallenge) {
		this.idChallenge = idChallenge;
	}

	@Column(name = "id_utilisateur", nullable = false)
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Column(name = "gratification", precision = 12, scale = 0)
	public Float getGratification() {
		return this.gratification;
	}

	public void setGratification(Float gratification) {
		this.gratification = gratification;
	}

	@Column(name = "combinaison", length = 50)
	public String getCombinaison() {
		return this.combinaison;
	}

	public void setCombinaison(String combinaison) {
		this.combinaison = combinaison;
	}

}