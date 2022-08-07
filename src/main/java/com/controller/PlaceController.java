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

import com.bean.PlaceBean;
import com.dao.PlaceDao;


@RestController
public class PlaceController {

	@Autowired
	PlaceDao placeDao;


	@PostMapping("/place")
	public ResponseEntity<?> addplace(PlaceBean placeBean) {

		boolean ans = placeDao.addPlace(placeBean);
			return ResponseEntity.ok(placeBean);
	}

	@PutMapping("/place")
	public ResponseEntity<?> updateplace(PlaceBean placeBean) {

		int ans = placeDao.updatePlace(placeBean);

		if (ans < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(placeBean);
		}
	}

	@GetMapping("/place")
	public ResponseEntity<List<PlaceBean>> getAllplace() {

		List<PlaceBean> places = placeDao.getAllplace();
		return ResponseEntity.ok(places);
	}

	@DeleteMapping("/place/{placeId}") 
	public String deleteplace(@PathVariable("placeId") int placeId) {
		placeDao.deleteplace(placeId);
		return "Deleted place";
	}
}






