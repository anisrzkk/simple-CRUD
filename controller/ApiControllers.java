package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.models.User;
import net.javaguides.springboot.repository.UserReposity;
import java.util.List;

@RestController
public class ApiControllers {

	@Autowired
	private UserReposity userRepo;
	@GetMapping(value = "/")
	public String getPage()
	{
		return "Welcome";
	}
	
	@GetMapping(value = "/users")
	public List<User> getUsers()
	{
		return userRepo.findAll();
	}
	
	@PostMapping(value="/save")
	public String saveUser(@RequestBody User user)
	{
		userRepo.save(user);
		return "savedd..";
	}
	
	@PutMapping(value= "update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user)
	{
		User updateUser = userRepo.findById(id).get();
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setOccupation(user.getOccupation());
		updateUser.setAge(user.getAge());
		userRepo.save(updateUser);
		return "updatee";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable long id)
	{
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "deletee" + id;
	}
}
