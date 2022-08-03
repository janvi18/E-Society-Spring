package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.HouseBean;

@Repository
public class HouseDao {

	@Autowired
	JdbcTemplate stmt;

	public boolean addHouse(HouseBean house) {
		stmt.update("insert into house (title,contactNum) values (?,?) ", house.getTitle(), house.getContactNum());
		return false;
	}

	public List<HouseBean> getAllHouses() {
		List<HouseBean> houseslist = stmt.query("select * from house",
				new BeanPropertyRowMapper<HouseBean>(HouseBean.class));
		return houseslist;
	}

	public boolean updateHouse(HouseBean house) {
		stmt.update("update  house set  title =   ? where houseid = ? ", house.getTitle(), house.getContactNum());

		return false;
	}

	public void deleteHouse(int houseId) {
		stmt.update("delete from house where houseid = ?", houseId);

	}
}
