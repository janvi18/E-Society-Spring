package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.MemberBean;

@Repository
public class MemberDao {

	@Autowired
	JdbcTemplate stmt;

	public boolean addMember(MemberBean member) {
		stmt.update("insert into member (membername,dob,age,contactnum) values (?,?,?,?) ", 
				member.getMembername(),
				member.getDob(), 
				member.getAge(), 
				member.getContactnum());
		return false;
	}

	public boolean updateMember(MemberBean member) {
		stmt.update("update  member set  title =   ? where memberid = ? ", member.getMembername(), member.getDob(),
				member.getAge(), member.getContactnum());

		return false;
	}

	public List<MemberBean> getAllMember() {
		List<MemberBean> memberlist = stmt.query("select * from member",
				new BeanPropertyRowMapper<MemberBean>(MemberBean.class));
		return memberlist;
	}

	public void deleteMember(int memberId) {
		stmt.update("delete from member where memberid = ?", memberId);

	}

}
