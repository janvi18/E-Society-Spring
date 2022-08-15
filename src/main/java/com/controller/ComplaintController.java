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

import com.bean.ComplaintBean;
import com.dao.ComplaintDao;

@RestController
public class ComplaintController {
	@Autowired
	ComplaintDao complaintDao;

	@PostMapping("/complaint")
	public ResponseEntity<?> addComplaint(ComplaintBean complaintBean) {
		boolean ans = complaintDao.addComplaint(complaintBean);
		return ResponseEntity.ok(complaintBean);
	}

	@PutMapping("/complaint")
	public ResponseEntity<?> updateComplaint(ComplaintBean complaintBean) {
		boolean ans = complaintDao.updateComplaint(complaintBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(complaintBean);
		}
	}

	@GetMapping("/complaint")
	public ResponseEntity<List<ComplaintBean>> getAllComplaint() {

		List<ComplaintBean> complaints = complaintDao.getAllComplaint();
		return ResponseEntity.ok(complaints);
	}

	@DeleteMapping("/complaint/{complaintId}")
	public String deleteComplaint(@PathVariable("complaintId") int complaintId) {
		complaintDao.deleteComplaint(complaintId);
		return "Deleted Complaint";
	}

	@PostMapping("/mapcomplaint")
	public ResponseEntity<?> mapComplaint(@RequestParam("complaintId") int complaintId,
			@RequestParam("userId") int userId, @RequestParam("houseId") int houseId) {

		complaintDao.updateComplaintForUser(complaintId, userId, houseId);
		return ResponseEntity.ok("Complaint mapped");
	}
}