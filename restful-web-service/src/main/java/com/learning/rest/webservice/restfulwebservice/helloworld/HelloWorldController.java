package com.learning.rest.webservice.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {
	
	//GET Method
	//URI = /hello-world
	//method - "Hello World"
	//@RequestMapping(method=RequestMethod.GET, path= "/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello Rishav!!";
	}
	
	//hello-world-bean
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello Rishav Kya Haal hai..!!");
	}
	
	//Passing path variable
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello Good Night!! , %s", name));
	}
	
	//Passing Exception
//	@GetMapping("/hello-world/path-variable/{name}")
//	public HelloWorldBean exception(@PathVariable String name) {
//		throw new RuntimeException("Something went wrong");
//	}
	
	//Retrieve all Todos for a User
	//GET /users/{user_name}/todos
	
	
	
	//Delete a Todo of a User
	//DELETE /users/{user_name}/todos/{todo_id}
	
	
	//Edit||Update a Todo
	//PUT /users/{user_name}/todos/{todo_id}
	
	//Create a new Todo
	// POST /users/{user_name}/todos/
	

}
