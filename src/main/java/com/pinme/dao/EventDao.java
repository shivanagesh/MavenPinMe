package com.pinme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.Event;
import com.pinme.model.EventCategory;
import com.pinme.model.UserEvent;

/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:32:31 PM fileUserDao.java
 *
 * @author Chintala Prathyusha, wrote routines to persist event info
 */
public class EventDao extends DBConnect {
	public static List<Event> events = new ArrayList<Event>();
	private static AtomicInteger uniqueId = new AtomicInteger();
	private Connection dbConnection = getDBConnection();

	/**
	 *
	 */
	public EventDao() {

	}

	public int pinEvent(int userId, int eventId) {
		if (getEvent(eventId) == null) {
			return -1;
		}
		String sql = "INSERT INTO user_event VALUES (?, ?)";
		PreparedStatement pinEventStmt = null;
		int result = -1;
		try {
			pinEventStmt = dbConnection.prepareStatement(sql);
			pinEventStmt.setInt(1, userId);
			pinEventStmt.setInt(2, eventId);
			result = pinEventStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}

	public List<Event> getPinnedEventsByUserId(int userId) {
		String sql = "SELECT * FROM user_event WHERE user_id=?";
		PreparedStatement userEventQuery = null;
		List<Event> userEvents = new ArrayList<Event>();
		try {
			userEventQuery = dbConnection.prepareStatement(sql);
			userEventQuery.setInt(1, userId);
			ResultSet rs = userEventQuery.executeQuery();
			while (rs.next()) {
				int eventId = rs.getInt("event_id");
				userEvents.add(getEvent(eventId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userEvents;

	}

	public int addEvent(Event event) {
		String sql = "INSERT INTO event(name, start_time, end_time, description, token_limit, is_tokenized, "
				+ "address_id, user_id, event_category ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement evntInstStmt = null;
		int eventId = -1;
		try {
			System.out.println(dbConnection);
			evntInstStmt = dbConnection.prepareStatement(sql);
			evntInstStmt.setString(1, event.getName());
			evntInstStmt.setString(2, event.getStartDateTime());
			evntInstStmt.setString(3, event.getEndDateTime());
			evntInstStmt.setString(4, event.getDescription());
			evntInstStmt.setInt(5, event.getTokenLimit());
			evntInstStmt.setBoolean(6, event.isTokenized());
			evntInstStmt.setInt(7, event.getAddressId());
			evntInstStmt.setInt(8, event.getUserId());
			evntInstStmt.setInt(9, event.getCategoryId());

			eventId = evntInstStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			eventId = -1;
		}
		return eventId;
	}

	public List<Event> findAllEventsFromDB() {
		List<Event> allEvents = new ArrayList<Event>();
		String sql = "Select * from event";
		PreparedStatement eventsQueryStmt = null;
		try {
			eventsQueryStmt = dbConnection.prepareStatement(sql);
			ResultSet rs = eventsQueryStmt.executeQuery();
			while (rs.next()) {
				Event event = new Event();
				event.setId(rs.getInt("id"));
				event.setAddressId(rs.getInt("address_id"));
				event.setUserId(rs.getInt("user_id"));
				event.setCategoryId(rs.getInt("event_category"));
				event.setTokenized(rs.getBoolean("is_tokenized"));
				event.setTokenLimit(rs.getInt("token_limit"));
				event.setDescription(rs.getString("description"));
				event.setStartDateTime(rs.getString("start_time"));
				event.setEndDateTime(rs.getString("end_time"));
				event.setName(rs.getString("name"));
				allEvents.add(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allEvents;

	}

	public List<Event> findEventsByUserId(int userId) {
		List<Event> userEvents = new ArrayList<Event>();
		if (userId > 0) {
			String sql = "Select * from event where user_id=?";
			PreparedStatement eventsQueryStmt = null;
			try {
				eventsQueryStmt = dbConnection.prepareStatement(sql);
				eventsQueryStmt.setInt(1, userId);
				ResultSet rs = eventsQueryStmt.executeQuery();
				while (rs.next()) {
					Event event = new Event();
					event.setId(rs.getInt("id"));
					event.setAddressId(rs.getInt("address_id"));
					event.setUserId(rs.getInt("user_id"));
					event.setCategoryId(rs.getInt("event_category"));
					event.setTokenized(rs.getBoolean("is_tokenized"));
					event.setTokenLimit(rs.getInt("token_limit"));
					event.setDescription(rs.getString("description"));
					event.setStartDateTime(rs.getString("start_time"));
					event.setEndDateTime(rs.getString("end_time"));
					event.setName(rs.getString("name"));
					userEvents.add(event);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return userEvents;
	}

	public int removeEvent(int id) {
		String sql = "DELETE from event where id = ? ";
		PreparedStatement eventDeleteStatement = null;
		try {
			eventDeleteStatement = dbConnection.prepareStatement(sql);
			eventDeleteStatement.setInt(1, id);
			return eventDeleteStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
			
		}

	}

	public Event getEvent(int id) {
		List<Event> userEvents = new ArrayList<Event>();
		if (id > 0) {
			String sql = "Select * from event where id=?";
			PreparedStatement eventsQueryStmt = null;
			try {
				eventsQueryStmt = dbConnection.prepareStatement(sql);
				eventsQueryStmt.setInt(1, id);
				ResultSet rs = eventsQueryStmt.executeQuery();
				while (rs.next()) {
					Event event = new Event();
					event.setId(rs.getInt("id"));
					event.setAddressId(rs.getInt("address_id"));
					event.setUserId(rs.getInt("user_id"));
					event.setCategoryId(rs.getInt("event_category"));
					event.setTokenized(rs.getBoolean("is_tokenized"));
					event.setTokenLimit(rs.getInt("token_limit"));
					event.setDescription(rs.getString("description"));
					event.setStartDateTime(rs.getString("start_time"));
					event.setEndDateTime(rs.getString("end_time"));
					event.setName(rs.getString("name"));
					userEvents.add(event);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return userEvents.size() > 0 ? userEvents.get(0) : null;

	}

	public List<Event> getEvents() {
		return events;
	}

	public List<Event> getUserEvents(int userId) {
		List<Event> userEvents = new ArrayList<Event>();
		for (Event event : events) {
			if (event.getUserId() == userId) {
				userEvents.add(event);
			}
		}
		return userEvents;
	}

	public List<Event> getEventsByCategory(int categoryId) {
		List<Event> categorEvents = new ArrayList<Event>();
		for (Event event : events) {
			if (event.getCategoryId() == categoryId) {
				categorEvents.add(event);
			}
		}
		return categorEvents;
	}

	public void updateEvent(int eventId, Event updateEvent) {

		for (Event event : events) {
			if (event.getId() == eventId) {
				if (updateEvent.getName() != null) {
					event.setName(updateEvent.getName());
				}
				if (updateEvent.getStartDateTime() != null) {
					event.setStartDateTime(updateEvent.getStartDateTime());
				}
				if (updateEvent.getEndDateTime() != null) {
					event.setEndDateTime(updateEvent.getEndDateTime());
				}
				if (updateEvent.getDescription() != null) {
					event.setDescription(updateEvent.getDescription());
				}
				if (updateEvent.getTokenLimit() != -1) {
					event.setTokenLimit(updateEvent.getTokenLimit());
				}

				if (updateEvent.isTokenized()) {
					event.setTokenized(updateEvent.isTokenized());
				}

			}
		}

	}

	public List<Event> getEventsBySearch(String event) {
		String eventid = "SELECT id FROM event_category WHERE name=%" + event + "%;";
		String sql = "SELECT * FROM event WHERE event_category=" + eventid + ";";
		PreparedStatement userEventQuery = null;
		List<Event> userSearchEvents = new ArrayList<Event>();
		try {
			userEventQuery = dbConnection.prepareStatement(sql);
			ResultSet rs = userEventQuery.executeQuery();
			while (rs.next()) {
				int eventId = rs.getInt("event_id");
				userSearchEvents.add(getEvent(eventId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userSearchEvents;

	}

}
