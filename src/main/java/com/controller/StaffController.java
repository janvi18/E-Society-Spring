package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.StaffBean;
import com.dao.StaffDao;

@RestController
public class StaffController {
	@Autowired
	StaffDao staffDao;

	@PostMapping("/staff")
	public ResponseEntity<?> addStaff(StaffBean staffBean) {
		boolean ans = staffDao.addStaff(staffBean);
		return ResponseEntity.ok(staffBean);

	}

	@PutMapping("/staff")
	public ResponseEntity<?> updateStaff(StaffBean staffBean) {
		int ans = staffDao.updateStaff(staffBean);
		if (ans < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(staffBean);
		}
	}

	@GetMapping("/staff")
	public ResponseEntity<List<StaffBean>> getAllStaff() {

		List<StaffBean> staffs = staffDao.getAllStaff();
		return ResponseEntity.ok(staffs);
	}

	@DeleteMapping("/staff/{staffId}")
	public String deleteStaff(@PathVariable("staffId") int staffId) {
		staffDao.deleteStaff(staffId);
		return "Deleted staff";
	}
	
}
