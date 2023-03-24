package com.learn.user.daorespostiory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.learn.controller.model.User;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount=0;
	static 
	{
	users.add(new User(++userCount,"Mounissamy",LocalDate.now().minusYears(30)));
	users.add(new User(++userCount,"Ranganatha",LocalDate.now().minusYears(30)));
	users.add(new User(++userCount,"Vikash",LocalDate.now().minusYears(9)));
	users.add(new User(++userCount,"Vinavi",LocalDate.now().minusYears(15)));

	
	/*
	 * users.stream().filter((s) -> s.startsWith("A"))
	 * .forEach(System.out::println);
	 */}
	public UserDaoService() {  
   }
	
	public List<User> findAll(){
		
		return users;
	}
    public User findOne(int id) {
		/*
		 * for (int i=0; i < users.size(); i++) { User u = users.get(i); if
		 * (u.getId().equals(id)) { return u; } } return null;
		 */	  
    	Predicate<? super User> predicate = user -> user.getId().equals(id); 
    		return users.stream().filter(predicate).findFirst().orElse(null);
    	  
    }
    
    public User save(User usr) {
    	usr.setId(++userCount);
    	users.add(usr);
    	return usr;
}

	public void deleteUserById(int id) {
		
		Predicate<? super User>  predicate = user -> user.getId().equals(id);
	users.removeIf(predicate);
		
	}
}