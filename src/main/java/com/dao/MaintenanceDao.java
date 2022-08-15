package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.MaintenanceBean;
import com.bean.SuggestionBean;

@Repository
public class MaintenanceDao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addMaintenance(MaintenanceBean maintenance) {
		stmt.update(
				"insert into maintenance(creationdate,month,maintenanceamt,maintenancepaid,paymentdate,lastedate,penalty) values (?,?,?,?,?,?,?)",
				maintenance.getCreationdate(), maintenance.getMonth(), maintenance.getMaintenanceamt(),
				maintenance.isMaintancepaid(), maintenance.getPaymentdate(), maintenance.getLastdate(),
				maintenance.getPenalty());
		return false;
	}

	public boolean updateMaintenance(MaintenanceBean maintenance) {
		stmt.update("update maintenance set creationdate = ? where maintenanceid = ?", maintenance.getCreationdate(),
				maintenance.getMaintenanceid());
		return false;
	}

	public List<MaintenanceBean> getAllMaintenance() {
		List<MaintenanceBean> maintenance = stmt.query("select * from maintenance",
				new BeanPropertyRowMapper<MaintenanceBean>(MaintenanceBean.class));
		return maintenance;
	}

	public void deleteMaintenance(int maintenanceId) {
		stmt.update("delete from maintenance where maintenanceid = ?", maintenanceId);

	}

	public int updateMaintenanceForUser(int houseId, int maintenanceId) {
		return stmt.update("update maintenance set  houseid = ? where maintenanceid = ?", houseId,maintenanceId);
	}

}