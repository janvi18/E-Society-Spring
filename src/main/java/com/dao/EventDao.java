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

	public int updateEvent(EventBean event) {

		return stmt.update("update  event set  eventdate=?, eventenddate=? where eventid=? ", event.getEventDate(),
				event.getEventEndDate(), event.getEventId());

	}

	public List<EventBean> getAllEvent() {
		List<EventBean> eventList = stmt.query("select * from event",
				new BeanPropertyRowMapper<EventBean>(EventBean.class));
		return eventList;
	}

	public void deleteEvent(int eventId) {
		stmt.update("delete from event where eventid= ?", eventId);
	}

	public int updateEventForMember(int eventId, int houseId, int userId, int placeId) {
		return stmt.update("update event set  houseid =  ? , userid = ? , placeid = ? where eventid = ? ", houseId,
				userId, placeId, eventId);
	}

}
