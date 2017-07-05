package fr.hackathon.server.ws.model;

/**
 * TODO à compléter
 */
public class Utilisateur {

	private int id;
	
	private String idFB;

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

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", idFB=" + idFB + "]";
	}
	
}