package com.aakash.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aakash.todo.model.ToDoItems;

@Repository("toDoRepository")
public interface ToDoRepository extends JpaRepository<ToDoItems, Long> {
	
	List<ToDoItems> findByUserEmail(String email);
	
	//ToDoItems findById(int id);
}
