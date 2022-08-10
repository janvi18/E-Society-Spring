package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.MemberBean;
import com.bean.PlaceBean;

@Repository
public class PlaceDao {
	
	@Autowired
	JdbcTemplate stmt;


	public boolean addPlace(PlaceBean place) {
		stmt.update("insert into place (placeName) values (?) ", place.getPlaceName());
		return false;
	}

	public int updatePlace(PlaceBean place) {
		return stmt.update("update  place set  title =   ? where placeid = ? ", place.getPlaceName());
	}

	public void deleteplace(int placeId) {
		stmt.update("delete from place where placeid = ?", placeId);
		
	}

	public List<PlaceBean> getAllplace() {
		List<PlaceBean> placelist = stmt.query("select * from place",
				new BeanPropertyRowMapper<PlaceBean>(PlaceBean.class));
		return placelist;
	}

}
