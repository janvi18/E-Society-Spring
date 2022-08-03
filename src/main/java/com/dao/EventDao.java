package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EventBean;

@Repository
public class EventDao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addEvent(EventBean event) {
		stmt.update("insert into event (eventDate,eventEndDate,eventDetails,rent,isAvailable) values (?,?,?,?,?) ",
				event.getEventDate(), event.getEventEndDate(), event.getEventDetails(), event.getRent(),
				event.getIsAvailable());
		return false;
	}

	public boolean updateEvent(EventBean event) {
		stmt.update("update  event set  title =   ? where eventid = ? ", event.getEventDate(), event.getEventEndDate(),
				event.getEventDetails());
		return false;
	}

	public List<EventBean> getAllEvent() {
		List<EventBean> eventList = stmt.query("select * from event",
				new BeanPropertyRowMapper<EventBean>(EventBean.class));
		return eventList;
	}

	public void deleteEvent(int eventId) {
		stmt.update("delete from event where eventid= ?", eventId);

	}

}
