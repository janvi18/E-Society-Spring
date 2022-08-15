package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.DeliveryBean;

@Repository
public class DeliveryDao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addDelivery(DeliveryBean delivery) {
		stmt.update("insert into delivery(couriertype,isallowed,status) values (?,?,?)", delivery.getCouriertype(),

				delivery.isIsallowed(), delivery.getStatus());
		return false;
	}

	public boolean updateDelivery(DeliveryBean delivery) {
		stmt.update("update delivery set couriertype = ? where deliveryid = ?", delivery.getCouriertype(),
				delivery.getDeliveryId());
		return false;
	}

	public List<DeliveryBean> getAllDelivery() {
		List<DeliveryBean> delivery = stmt.query("select * from delivery",
				new BeanPropertyRowMapper<DeliveryBean>(DeliveryBean.class));
		return delivery;
	}

	public void deleteDelivery(int deliveryId) {
		stmt.update("delete from delivery where deliveryid = ?", deliveryId);

	}

	public int updateDeliveryForUser(int userId, int houseId, int deliveryId) {
		return stmt.update("update delivery set  userid =   ?,houseid = ? where deliveryid = ?",userId, houseId, deliveryId);
	}

}