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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.HouseBean;
import com.bean.RoleBean;
import com.dao.HouseDao;

@RestController
public class HouseController {

	@Autowired
	HouseDao houseDao;

	@PostMapping("/house")
	public ResponseEntity<?> addHouse(HouseBean houseBean) {

		boolean ans = houseDao.addHouse(houseBean);

		return ResponseEntity.ok(houseBean);
	}

	@PutMapping("/house")
	public ResponseEntity<?> updateHouse(HouseBean houseBean) {

		int ans = houseDao.updateHouse(houseBean);

		if (ans < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(houseBean);
		}
	}

	@GetMapping("/house")
	public ResponseEntity<List<HouseBean>> getAllHouse() {

		List<HouseBean> house = houseDao.getAllHouses();
		return ResponseEntity.ok(house);
	}

	@DeleteMapping("/house/{houseId}")
	public String deleteHouse(@PathVariable("houseId") int houseId) {
		houseDao.deleteHouse(houseId);
		return "Deleted House";
	}


}