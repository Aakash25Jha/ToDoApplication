package com.aakash.todo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aakash.todo.model.ToDoItems;
import com.aakash.todo.model.User;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);

    void saveUser(User user);

    Boolean removeAll();

    void removeById(Long id);

    User findById(Long id);

    Page<User> searchByTerm(String name, Pageable pageable);

    Page<User> listUsers(Pageable pageable);

    List<User> searchBy(String keyword, String criteria);

	List<ToDoItems> findByUserEmail(String name);

	void saveToDo(ToDoItems todo);

	void removeById(int id);
	
	ToDoItems findById(int id);
}
