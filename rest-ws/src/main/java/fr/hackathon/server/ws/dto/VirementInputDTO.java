package fr.hackathon.server.ws.dto;

import java.math.BigDecimal;

public class VirementInputDTO {

	boolean success;
	
	String compteACrediter;
	
	BigDecimal montantACrediter;
	
	
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCompteACrediter() {
		return compteACrediter;
	}

	public void setCompteACrediter(String compteACrediter) {
		this.compteACrediter = compteACrediter;
	}

	public BigDecimal getMontantACrediter() {
		return montantACrediter;
	}

	public void setMontantACrediter(BigDecimal montantACrediter) {
		this.montantACrediter = montantACrediter;
	}
	
}
