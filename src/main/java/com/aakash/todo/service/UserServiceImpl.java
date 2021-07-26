package com.aakash.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aakash.todo.model.ToDoItems;
import com.aakash.todo.model.User;
import com.aakash.todo.repository.ToDoRepository;
import com.aakash.todo.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<ToDoItems> findByUserEmail(String email){
    	return toDoRepository.findByUserEmail(email);
    }
 
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(Boolean.TRUE);
        }
        userRepository.save(user);
    }



    @Override
    public Page<User> listUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }



    @Override
    public Page<User> searchByTerm(String name, Pageable pageable) {
        return userRepository.searchByTerm(name, pageable);
    }



    @Override
    public Boolean removeAll() {
        userRepository.deleteAll();
        return Boolean.TRUE;
    }



    @Override
    public void removeById(Long id) {
        userRepository.deleteById(id);
    }



    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
    
    @Override
    public ToDoItems findById(int id) {
    	return toDoRepository.findById((long) id).get();
    }


    @Override
    public List<User> searchBy(String keyword, String criteria) {
        if ("firstName".equals(criteria)) {
            return userRepository.findByFirstNameIgnoreCaseContaining(keyword);
        } else if ("lastName".equals(criteria)) {
            return userRepository.findByLastNameIgnoreCaseContaining(keyword);
        } else if ("email".equals(criteria)) {
            return userRepository.findByEmailIgnoreCaseContaining(keyword);
        }
        return new ArrayList<>();

    }

	@Override
	public void saveToDo(ToDoItems todo) {
	        toDoRepository.save(todo);
		
	}

	@Override
	public void removeById(int id) {
		toDoRepository.deleteById((long) id);
		
	}

}
