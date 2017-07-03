package fr.hackathon.server.ws.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value="/helloWorld/{message}", method=RequestMethod.GET)
    public HelloWorld get(@PathVariable String message){
        return helloWorldDAO.get(message);
    }

    @RequestMapping(value="/helloWorlds", method=RequestMethod.GET)
    public List<HelloWorld> getAll(){
        return helloWorldDAO.getAll();
    }
    
}