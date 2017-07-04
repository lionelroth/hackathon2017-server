package fr.hackathon.server.ws.model;

public class HelloWorld {
	
	private long id;
	
	private String message;

	
	public HelloWorld() {
		
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorld [id=" + id + ", message=" + message + "]";
	}
	
}