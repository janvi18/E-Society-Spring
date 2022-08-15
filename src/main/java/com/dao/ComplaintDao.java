package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ComplaintBean;

@Repository
public class ComplaintDao {
	@Autowired
	JdbcTemplate stmt;

	public boolean updateComplaint(ComplaintBean complaint) {
		stmt.update("update complaint set complaint = ? where complaintid = ?", complaint.getComplaint(),
				complaint.getComplaintId());
		return false;
	}

	public boolean addComplaint(ComplaintBean complaint) {
		stmt.update("insert into complaint(date,complaint,isresolved) values (?,?,?)", complaint.getDate(),
				complaint.getComplaint(), complaint.isIsresolved());

		return false;
	}

	public List<ComplaintBean> getAllComplaint() {
		List<ComplaintBean> complaint = stmt.query("select * from complaint",
				new BeanPropertyRowMapper<ComplaintBean>(ComplaintBean.class));
		return complaint;

	}

	public void deleteComplaint(int complaintId) {
		stmt.update("delete from complaint where complaintId = ?", complaintId);
	}

	public int updateComplaintForUser(int userId, int houseId, int complaintId) {
		return stmt.update("update complaint set  userid =   ?,houseid = ? where complaintid = ?", userId, houseId,
				complaintId);
	}
}
