package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.StaffBean;

@Repository
public class StaffDao {

	@Autowired
	JdbcTemplate stmt;

	public boolean addStaff(StaffBean staff) {
		stmt.update(
				"insert into staff (staffMemberName, type, entryTime, exitTime, contactNum, address, email, password, isAllowed, "
						+ "agencyName,	agencyContactNum) values (?,?,?,?,?,?,?,?,?,?,?) ",
				staff.getStaffMemberName(), staff.getType(), staff.getEntryTime(), staff.getExitTime(),
				staff.getContactNum(), staff.getAddress(), staff.getEmail(), staff.getPassword(), staff.getIsAllowed(),
				staff.getAgencyName(), staff.getAgencyContactNum());
		return false;
	}

	public List<StaffBean> getAllStaff() {
		List<StaffBean> staffList = stmt.query("select * from staff",
				new BeanPropertyRowMapper<StaffBean>(StaffBean.class));
		return staffList;
	}

	public void deleteStaff(int staffId) {
		stmt.update("delete from staff where staffid = ?", staffId);

	}

	public int updateStaff(StaffBean staff) {
		return stmt.update("update  staff set  staffMemberName =   ? where staffMemberName = ? ", staff.getEntryTime(),
				staff.getExitTime(), staff.getType());
	}

}
