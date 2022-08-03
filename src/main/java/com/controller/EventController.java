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
import org.springframework.web.bind.annotation.RestController;

import com.bean.EventBean;
import com.dao.EventDao;

@RestController
public class EventController {

	@Autowired
	EventDao eventDao;

	@PostMapping("/event")
	public ResponseEntity<?> addEvent(EventBean eventBean) {
		boolean ans = eventDao.addEvent(eventBean);
		return ResponseEntity.ok(eventBean);

	}

	@PutMapping("/event")
	public ResponseEntity<?> updateEvent(EventBean eventBean) {
		boolean ans = eventDao.updateEvent(eventBean);
		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(eventBean);
		}
	}

	@GetMapping("/event")
	public ResponseEntity<List<EventBean>> getAllEvent() {

		List<EventBean> event = eventDao.getAllEvent();
		return ResponseEntity.ok(event);
	}

	@DeleteMapping("/event/{eventId}")
	public String deleteEvent(@PathVariable("eventId") int eventId) {
		eventDao.deleteEvent(eventId);
		return "Deleted Event";
	}
}
