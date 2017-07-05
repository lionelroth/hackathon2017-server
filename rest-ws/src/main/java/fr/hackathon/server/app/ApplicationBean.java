package fr.hackathon.server.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * IL EST DE RETOUUUUUR
 */
@Component
@Scope("singleton")
public class ApplicationBean {

	private boolean receptive = false;

	public boolean isReceptive() {
		return receptive;
	}

	public void setReceptive(boolean receptive) {
		this.receptive = receptive;
	}
	
}