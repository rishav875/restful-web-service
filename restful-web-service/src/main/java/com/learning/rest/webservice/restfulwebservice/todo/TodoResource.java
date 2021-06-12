package com.learning.rest.webservice.restfulwebservice.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.rest.webservice.restfulwebservice.todo.Todo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {
	
	@Autowired
	private TodoHardCodedService todoService;
	
	//Retrieve all Todos for a User
		//GET /users/{user_name}/todos
		
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		//Thread.sleep(3000);    throws InterruptedException
		return todoService.findAll();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username ,@PathVariable int id){
		//Thread.sleep(3000);    throws InterruptedException
		return todoService.findById(id);
	}
	

	//Delete a Todo of a User
	//DELETE /users/{user_name}/todos/{todo_id}
	
	//Two option to give respone
	//1.Success 
	//2. No Content Back
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable int id){
		
		Todo todo=todoService.deleteById(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	//Edit||Update a Todo
	//PUT /users/{user_name}/todos/{todo_id}
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable int id,@RequestBody Todo todo){
		Todo todoUpdated = todoService.save(todo);
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
	//Create a new Todo
	// POST /users/{user_name}/todos/
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@RequestBody Todo todo){
		Todo createdTodo = todoService.save(todo);
		//Location
		//Get current resource url
		//{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
