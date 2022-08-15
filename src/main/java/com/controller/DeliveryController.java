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

import com.bean.DeliveryBean;
import com.dao.DeliveryDao;

@RestController
public class DeliveryController {
	@Autowired
	DeliveryDao deliveryDao;

	@PostMapping("/delivery")
	public ResponseEntity<?> addDelivery(DeliveryBean deliveryBean) {
		boolean ans = deliveryDao.addDelivery(deliveryBean);
		return ResponseEntity.ok(deliveryBean);
	}

	@PutMapping("/delivery")
	public ResponseEntity<?> updateDelivery(DeliveryBean deliveryBean) {
		boolean ans = deliveryDao.updateDelivery(deliveryBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(deliveryBean);
		}
	}

	@GetMapping("/delivery")

	public ResponseEntity<List<DeliveryBean>> getAllDelivery() {

		List<DeliveryBean> delivery = deliveryDao.getAllDelivery();
		return ResponseEntity.ok(delivery);
	}

	@DeleteMapping("/delivery/{deliveryId}")
	public String deleteDeliverys(@PathVariable("deliveryId") int deliveryId) {
		deliveryDao.deleteDelivery(deliveryId);
		return "Deleted Delivery";
	}

	@PostMapping("/mapdelivery")
	public ResponseEntity<?> mapdelivery(@RequestParam("deliveryid") int deliveryId, @RequestParam("userid") int userId,
			@RequestParam("houseid") int houseId) {
		System.out.println(userId);
		System.out.println(houseId);
		deliveryDao.updateDeliveryForUser(userId, houseId, deliveryId);
		return ResponseEntity.ok("User mapped");
	}

}