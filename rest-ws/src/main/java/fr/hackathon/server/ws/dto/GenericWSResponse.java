package fr.hackathon.server.ws.dto;

public class GenericWSResponse {

	private boolean success;
	
	private Object valeur;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getValeur() {
		return valeur;
	}

	public void setValeur(Object valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return "GenericWSResponse [success=" + success + ", valeur=" + valeur + "]";
	}
	
}