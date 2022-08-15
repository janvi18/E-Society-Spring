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

import com.bean.VisitorBean;
import com.dao.VisitorDao;

@RestController
public class VisitorController {
	@Autowired
	VisitorDao visitorDao;

	@PostMapping("/visitor")
	public ResponseEntity<?> addVisitor(VisitorBean visitor) {
		boolean ans = visitorDao.addVisitor(visitor);
		return ResponseEntity.ok(visitor);
	}

	@PutMapping("/visitor")
	public ResponseEntity<?> updateVisitor(VisitorBean visitor) {
		boolean ans = visitorDao.updateVisitor(visitor);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(visitor);
		}
	}

	@GetMapping("/visitor")
	public ResponseEntity<List<VisitorBean>> getAllVisitor() {
		
		List<VisitorBean> visitor = visitorDao.getAllVisitor();
		return ResponseEntity.ok(visitor);
	}

	@DeleteMapping("/visitor/{visitorId}")
	public String deletevisitors(@PathVariable("visitorId") int visitorId) {
		visitorDao.deleteVisitor(visitorId);
		return "Deleted Visitor";
	}

	@PostMapping("/mapvisitor")
	public ResponseEntity<?> mapvisitor(@RequestParam("userId") int userId, @RequestParam("houseId") int houseId,
			@RequestParam("visitorId") int visitorId) {

		visitorDao.updateVisitorForUser (userId, houseId,visitorId);
		return ResponseEntity.ok("Visitor mapped");
	}
}