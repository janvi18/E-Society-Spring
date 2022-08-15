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

import com.bean.SuggestionBean;
import com.dao.SuggestionDao;

@RestController
public class SuggestionController {
	@Autowired
	SuggestionDao suggestionDao;

	@PostMapping("/suggestion")
	public ResponseEntity<?> addSuggestion(SuggestionBean suggestionBean) {
		boolean ans = suggestionDao.addSuggestion(suggestionBean);
		return ResponseEntity.ok(suggestionBean);
	}

	@PutMapping("/suggestion")
	public ResponseEntity<?> updateSuggestion(SuggestionBean suggestionBean) {
		boolean ans = suggestionDao.updateSuggestion(suggestionBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(suggestionBean);
		}
	}

	@GetMapping("/suggestion")

	public ResponseEntity<List<SuggestionBean>> getAllSuggestion() {

		List<SuggestionBean> suggestions = suggestionDao.getAllSuggestion();
		return ResponseEntity.ok(suggestions);
	}

	@DeleteMapping("/suggestions/{suggestionId}")
	public String deleteSuggestions(@PathVariable("suggestionId") int suggestionId) {
		suggestionDao.deleteSuggestion(suggestionId);
		return "Deleted Suggestion";
	}

	@PostMapping("/mapsuggestion")
	public ResponseEntity<?> mapsuggestion(@RequestParam("suggestionid") int suggestionId,
			@RequestParam("userid") int userId, @RequestParam("houseid") int houseId) {
		System.out.println(userId);
		System.out.println(houseId);
		suggestionDao.updateSuggestionForUser(userId, houseId, suggestionId);
		return ResponseEntity.ok("User mapped");
	}

}