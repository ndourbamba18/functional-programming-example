package com.ndourcodeur.functionalprogrammingdemo.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndourcodeur.functionalprogrammingdemo.message.Message;
import com.ndourcodeur.functionalprogrammingdemo.model.User;

/**
 * 
 * @author NdourCodeur
 * @version 1.0
 * @since 07/21/2022
 *
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	public static List<User> list = Arrays.asList(
			new User(1, "Moussa Boye", "boye.moussa@user.com", "+221778542101", true, 25),
			new User(2, "Binta Gaye", "gaye.binta@user.com", "+2217785465421", true, 24),
			new User(3, "Boubacar Samb", "samb.boubacar@user.com", "+221776542101", true, 12),
			new User(4, "Jone Doe", "doe.jone@user.com", "+221774520124", true, 34),
			new User(5, "Jane Silva", "silva.jane@user.com", "+221765421045", false, 45),
			new User(6, "Khadim Diop", "diop.khadim@user.com", "+221768542012", false, 44),
			new User(7, "Coumba Bah", "bah.coumba@user.com", "+221768952104", true, 44),
			new User(8, "Maimouna Wane", "wane.maimouna@user.com", "+221785420145", true, 14),
			new User(9, "Khady Ndiaye", "ndiaye.khady@user.com", "+221778546201", false, 35),
			new User(10, "Fatimata Ndiaye", "ndiaye.fatimata@user.com", "+221773215489", true, 75),
			new User(11, "Moussa Diouf", "diouf.moussa@user.com", "+221775462105", true, 34),
			new User(12, "Mouhamed Ndour", "ndour.mouhamed@user.com", "+221765849214", true, 48),
			new User(13, "Soda Ndoye", "ndoye.soda@user.com", "+221765482145", false, 25),
			new User(14, "Binta Mbaye", "mbaye.binta@user.com", "+221778542145", true, 13),
		        new User(15, "Adama Seck", "seck.adama@user.com", "+221778542145", true, 13),
		        new User(16, "Badara Camara", "camara.badara@user.com", "+221778542145", true, 13),
		        new User(17, "Aminata Sow", "sow.aminata@user.com", "+221778542145", true, 13),
		        new User(18, "Baye Mbaye", "baye.mbaye@user.com", "+221778542145", true, 13),
		        new User(19, "Mounass Bah", "bah.mounass@user.com", "+221778542145", true, 13),
		        new User(20, "Saliou Diop", "diop.saliou@user.com", "+221778542145", true, 13)
	);
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @Doc Getting all users from listUsers
	 * @URL http://localhost:8080/users/allList
	 * @return listUsers
	 */
	@GetMapping(path = "/allList")
	public ResponseEntity<?> getAllUsers(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(new Message("List empty"), HttpStatus.BAD_REQUEST);
		}
		List<User> listUsers = list.stream()
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @Doc Getting all users from listUsers with sorted
	 * @URL http://localhost:8080/users/allListWithSorted
	 * @return listUsers
	 */
	@GetMapping(path = "/allListWithSorted")
	public ResponseEntity<?> getUsersWithSorted(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(new Message("List empty"), HttpStatus.BAD_REQUEST);
		}
		List<User> listUsers = list.stream()
				.sorted(Comparator.comparing(User::getId).reversed())
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @URL http://localhost:8080/users/filterByAge
	 * @Doc Getting all users from listUser by age greater or equal than 18 and active
	 * @return listUsers
	 */
	@GetMapping(path = "/filterByAge")
	public ResponseEntity<List<User>> getAllUsersFilterByAge(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		List<User> listUsers = list.stream()
				.filter(user -> (user.getAge() >= 18 && user.isActive()==true))
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @URL http://localhost:8080/users/filterByAge
	 * @Doc Getting all users from listUser by name and age
	 * @return listUsers
	 */
	@GetMapping(path = "/filterByNameAndAge")
	public ResponseEntity<List<User>> getAllUsersFilterByNameAndAge(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		List<User> listUsers = list.stream()
				.filter(user -> (user.getName().equals("B") && user.getAge() >= 18))
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @URL http://localhost:8080/users/filterByIsActive
	 * @Doc Getting all users from listUsers by isActive
	 * @return listUsers
	 */
	@GetMapping(path = "/filterByIsActive")
	public ResponseEntity<List<User>> getAllUsersByFilterByActive(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		List<User> listUsers = list.stream()
				.filter(user -> (user.isActive()==true))
				.limit(5)
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @URL http://localhost:8080/users/filterByName
	 * @Doc Getting all users from listUser by name and start with N or B
	 * @return listUsers
	 */
	@GetMapping(path = "/filterByName")
	public ResponseEntity<List<User>> getAllUsersByFilterByName(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		List<User> listUsers = list.stream()
				.filter(user -> (user.getName().startsWith("B") || user.getName().startsWith("M")))
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @URL http://localhost:8080/users/mapToName
	 * @Doc Getting all users from listUsers and map to name
	 * @return listUsers
	 */
	@GetMapping(path = "/mapToName")
	public ResponseEntity<?> getAllUsersMapToName(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		List<String> listUsers = list.stream()
				.map(User::getName)
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @URL http://localhost:8080/users/mapToEmail
	 * Getting all users from listUsers map to email address
	 * @return listUsers
	 */
	@GetMapping(path = "/mapToEmail")
	public ResponseEntity<?> getAllUsersMapToEmail(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		List<String> listUsers = list.stream()
				.map(User::getEmail)
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @URL http://localhost:8080/users/mapSortedAndFilter
	 * @Doc Getting all users from listUsers with map to name and filter by name start with B or M
	 * @return listUsers
	 */
	@GetMapping(path = "/mapSortedAndFilter")
	public ResponseEntity<?> getAllUsersMapAndSorted(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		List<String> listUsers = list.stream()
				.sorted(Comparator.comparing(User::getName).reversed())
				.map(User::getName)
				.filter(user -> (user.startsWith("B") || user.startsWith("M")))
				.limit(5)
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}
	
	/**
	 * @author NdourCodeur
	 * @Version 1.0
	 * @since 07/21/2022
	 * @URL http://localhost:8080/users/sortedAndFilter
	 * @Doc Getting all users from listUsers with sorted and filter by name start with B or M
	 * @return listUsers
	 */
	@GetMapping(path = "/sortedAndFilter")
	public ResponseEntity<List<User>> getAllUsersWithSorted(){
		if(list.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		List<User> listUsers = list.stream()
				.sorted(Comparator.comparing(User::getId).reversed())
				.filter(user -> (user.getName().startsWith("B") || user.getName().startsWith("M")))
				.limit(5)
				.collect(Collectors.toList());
		return new ResponseEntity<>(listUsers, HttpStatus.OK);
	}

}
