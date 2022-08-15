package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.VisitorBean;

@Repository
public class VisitorDao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addVisitor(VisitorBean visitor) {
		stmt.update("insert into visitor(visitorname,arrivingtime,isallowed) values (?,?,?)", visitor.getVisitorname(),
				visitor.getArrivingtime(), visitor.isIsallowed());

		return false;
	}

	public boolean updateVisitor(VisitorBean visitor) {
		stmt.update("update visitor set visitorname = ? where visitorid = ?", visitor.getVisitorname(),
				visitor.getVisitorId());
		return false;
	}

	public List<VisitorBean> getAllVisitor() {
		List<VisitorBean> visitor = stmt.query("select * from visitor",
				new BeanPropertyRowMapper<VisitorBean>(VisitorBean.class));
		return visitor;
	}

	public void deleteVisitor(int visitorId) {
		stmt.update("delete from visitor where visitorid = ?", visitorId);

	}

	public int updateVisitorForUser(int userId, int houseId, int visitorId) {
		return stmt.update("update visitor set  userid =   ?,houseid = ? where visitorid = ?", userId, houseId,
				visitorId);
	}
}