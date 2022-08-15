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

import com.bean.MaintenanceBean;
import com.dao.MaintenanceDao;

@RestController
public class MaintenanceController {
	@Autowired
	MaintenanceDao maintenanceDao;

	@PostMapping("/maintenance")
	public ResponseEntity<?> addMaintenance(MaintenanceBean maintenanceBean) {
		boolean ans = maintenanceDao.addMaintenance(maintenanceBean);
		return ResponseEntity.ok(maintenanceBean);
	}

	@PutMapping("/maintenance")
	public ResponseEntity<?> updateMaintenance(MaintenanceBean maintenanceBean) {
		boolean ans = maintenanceDao.updateMaintenance(maintenanceBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(maintenanceBean);
		}
	}

	@GetMapping("/maintenance")

	public ResponseEntity<List<MaintenanceBean>> getAllMaintenance() {

		List<MaintenanceBean> maintenances = maintenanceDao.getAllMaintenance();
		return ResponseEntity.ok(maintenances);
	}

	@DeleteMapping("/maintenances/{maintenanceId}")
	public String deleteMaintenances(@PathVariable("maintenanceId") int maintenanceId) {
		maintenanceDao.deleteMaintenance(maintenanceId);
		return "Deleted Maintenance";
	}

	@PostMapping("/mapmaintenance")
	public ResponseEntity<?> maphouse(@RequestParam("maintenanceid") int maintenanceId,
			@RequestParam("houseid") int houseId) {

		System.out.println(houseId);
		maintenanceDao.updateMaintenanceForUser(houseId, maintenanceId);
		return ResponseEntity.ok("House mapped");

	}
}