package fr.hackathon.server.ws.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.hackathon.server.ws.model.HelloWorld;

@Repository
public class HelloWorldDAOImpl implements HelloWorldDAO {

	@Override
	public HelloWorld get(String message) {
		HelloWorld hello = null;
		
		switch (message) {
		case "hello":
			hello = generateHelloWorld();
			break;
		case "goodbye":
			hello = generateByeWorld();
			break;
		default:
			hello = generateStandardHelloWorld();
			break;
		}
		return hello;
	}

	@Override
	public List<HelloWorld> getAll() {
		List<HelloWorld> allHelloWorld = new ArrayList<HelloWorld>();
		allHelloWorld.add(generateStandardHelloWorld());
		allHelloWorld.add(generateHelloWorld());
		allHelloWorld.add(generateByeWorld());
		return allHelloWorld;
	}
	
	private static HelloWorld generateHelloWorld() {
		HelloWorld hello = new HelloWorld();
		hello.setMessage("APPELEZ LES HENDEKS !");
		return hello;
	}
	private static HelloWorld generateByeWorld() {
		HelloWorld hello = new HelloWorld();
		hello.setMessage("F5 F5 F5");
		return hello;
	}
	private static HelloWorld generateStandardHelloWorld() {
		HelloWorld hello = new HelloWorld();
		hello.setMessage("Hello World !");
		return hello;
	}
}