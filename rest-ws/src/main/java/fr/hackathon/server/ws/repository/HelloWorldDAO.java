package fr.hackathon.server.ws.repository;

import java.util.List;

import fr.hackathon.server.ws.model.HelloWorld;

public interface HelloWorldDAO {

	public HelloWorld get(String message);
	
	public List<HelloWorld> getAll();
	
}