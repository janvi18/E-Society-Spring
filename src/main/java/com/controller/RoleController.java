package com.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.bean.RoleBean;
import com.bean.UserBean;
import com.dao.RoleDao;

@RestController
public class RoleController {

	@Autowired
	RoleDao roleDao;
	
	@PostMapping("/login")
	public ResponseEntity<?> login() {
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/role") 
	public ResponseEntity<?> addRole(RoleBean roleBean) {

		boolean ans = roleDao.addRole(roleBean);


			return ResponseEntity.ok(roleBean);
		}

	
	@PutMapping("/role")
	public ResponseEntity<?> updateRole(RoleBean roleBean) {

		int ans = roleDao.updateRole(roleBean);

		if (ans < 0) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(roleBean);
		}
	}

	@GetMapping("/role")
	public ResponseEntity<List<RoleBean>> getAllRole() {

		List<RoleBean> roles = roleDao.getAllRole();
		return ResponseEntity.ok(roles);
	}

	
	
	@DeleteMapping("/role/{roleId}")
	public String deleteRole(@PathVariable("roleId") int roleId) {
		roleDao.deleteRole(roleId);
		return "Deleted Role";
	}

}
