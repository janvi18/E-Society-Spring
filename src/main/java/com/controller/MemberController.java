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

import com.bean.MemberBean;
import com.dao.MemberDao;

@RestController
public class MemberController {
	@Autowired
	MemberDao memberDao;

	@PostMapping("/member")
	public ResponseEntity<?> addmember(MemberBean memberBean) {
		boolean ans = memberDao.addMember(memberBean);
		return ResponseEntity.ok(memberBean);

	}

	@PutMapping("/member")
	public ResponseEntity<?> updateMember(MemberBean memberBean) {
		int ans = memberDao.updateMember(memberBean);
		if (ans < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(memberBean);
		}
	}

	@GetMapping("/member")
	public ResponseEntity<List<MemberBean>> getAllMember() {

		List<MemberBean> members = memberDao.getAllMember();
		return ResponseEntity.ok(members);
	}

	@DeleteMapping("/member/{memberId}")
	public String deleteMember(@PathVariable("memberId") int memberId) {
		memberDao.deleteMember(memberId);
		return "Deleted Member";
	}
	@PostMapping("/mapmember")
	public ResponseEntity<?> mapHouse(@RequestParam("houseId") int houseId,@RequestParam("memberId") int memberId) {
		System.out.println(houseId);
		memberDao.updateMemberForHouse(houseId, memberId);
		return ResponseEntity.ok("Member mapped into house");
	}
	
}
