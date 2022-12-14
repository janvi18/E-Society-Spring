package com.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;;

@RestController
public class SessionController {

	@Autowired
	UserDao userDao;

	@PostMapping("/signup")
	public ResponseEntity<?> signup() {
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/user")
	public ResponseEntity<?> addUser(UserBean userBean) {

		userBean.setRoleId(4);// user role
		boolean ans = userDao.addUser(userBean);
		return ResponseEntity.ok(userBean);
	}

	@PutMapping("/user")
	public ResponseEntity<?> updateUser(UserBean userBean) {

		int ans = userDao.updateUser(userBean);

		if (ans < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(userBean);
		}
	}

	@GetMapping("/user")
	public ResponseEntity<List<UserBean>> getAllUser() {

		List<UserBean> users = userDao.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {
		userDao.deleteUser(userId);
		return "Deleted User";
	}

	@PostMapping("/mapuser")
	public ResponseEntity<?> mapUser(@RequestParam("roleId") int roleId, 
			@RequestParam("houseId") int houseId,@RequestParam("userId") int userId) {

		userDao.updateHouseForUser(roleId, houseId, userId);
		return ResponseEntity.ok("User mapped");
	}

}
