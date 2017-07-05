package fr.hackathon.server.ws.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.hackathon.server.ws.model.HelloWorld;
import fr.hackathon.server.ws.repository.HelloWorldDAO;

@RestController
@RequestMapping(value="/api")
public class HelloWorldController {

    @Resource
    private HelloWorldDAO helloWorldDAO;
//	@Autowired
//    private HelloWorldDAO helloWorldDAO; //DAO hbm généré, vrai accès BDD

    @RequestMapping(value="/helloWorlds/get/{message}", method=RequestMethod.GET)
    public HelloWorld get(@PathVariable String message){
        return helloWorldDAO.get(message);
    }
//    @RequestMapping(value="/helloWorlds/get/{id}", method=RequestMethod.GET)
//    public HelloWorld get(@PathVariable Integer id){
//        return helloWorldDAO.findById(id);
//    }

    @RequestMapping(value="/helloWorlds/get", method=RequestMethod.GET)
    public List<HelloWorld> getAll(){
        return helloWorldDAO.getAll();
    }
    
// 	@RequestMapping(value="/helloWorlds/post", method=RequestMethod.POST)
// 	public Response createProductInJSON(HelloWorld helloWorld) {
//
// 		String result = "helloWorld created : " + helloWorld;
// 		return Response.status(201).entity(result).build();
//
// 	}
 	
 	@RequestMapping(value="/helloWorlds/post/{buttonId}", method = RequestMethod.POST)
	public boolean add(@PathVariable String buttonId, @RequestBody HelloWorld input) {
 		System.out.println("buttonid : " + buttonId + "\nHelloWorld : " + input);
 		return helloWorldDAO.set(input); 
 	}
    
}