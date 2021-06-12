package com.learning.rest.webservice.restfulwebservice.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Component;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter=0;
	
	static {
		todos.add(new Todo(++idCounter,"Rishav","Springboot Learning", new Date(),false));
		todos.add(new Todo(++idCounter,"Rishav","React Learning", new Date(),false));
		todos.add(new Todo(++idCounter,"Rishav","DevOps Learning", new Date(),false));
		todos.add(new Todo(++idCounter,"Rishav","DataStructure Learning", new Date(),false));
		todos.add(new Todo(++idCounter,"Rishav","Core Java Learning", new Date(),false));
	
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public  Todo deleteById(long id) {
		Todo todo=findById(id);
		if(todo==null)
			return null;
		if(todos.remove(todo))
		return todo;
		
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id)
				return todo;
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public Todo save(Todo todo) {
		System.out.println(todo.getId());
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
			
		}else {
			deleteById(todo.getId());
				todos.add(todo);
		}
		return todo;
	}
	
}
