package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bean.SocietyBean;

@Repository
public class SocietyDao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addSociety(SocietyBean society) {
		stmt.update("insert into society(name,address,city,pincode,noofhouse) values (?,?,?,?,?)", society.getName(),
				society.getAddress(), society.getCity(), society.getPincode(), society.getNoofhouse());

		return false;
	}

	public void deleteSociety(int societyId) {
		stmt.update("delete society where societyid = ?", societyId);

	}

	public boolean updateSociety(SocietyBean society) {
		// TODO Auto-generated method stub
		stmt.update("update society set name = ? where societyid = ?", society.getName(), society.getSocietyid());
		return false;
	}

	public List<SocietyBean> getAllSociety() {
		List<SocietyBean> society = stmt.query("select * from society",
				new BeanPropertyRowMapper<SocietyBean>(SocietyBean.class));
		return society;
	}

}