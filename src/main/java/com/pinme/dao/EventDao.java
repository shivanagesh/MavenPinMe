package com.pinme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.Event;
import com.pinme.model.EventCategory;
import com.pinme.model.UserEvent;

/**
 *
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

    public int updateEvent(int eventId, Event event){
        String sql = "update event set name = ?, start_time = ?, end_time = ?, description = ?, " +
                "token_limit = ?, is_tokenized = ?, "
                + "address_id = ?, user_id = ?, event_category = ? where id = ?";
        PreparedStatement eventUpdateStmt = null;
        int result = -1;
        try {
            System.out.println(dbConnection);
            eventUpdateStmt = dbConnection.prepareStatement(sql);
            eventUpdateStmt.setString(1, event.getName());
            eventUpdateStmt.setString(2, event.getStartDateTime());
            eventUpdateStmt.setString(3, event.getEndDateTime());
            eventUpdateStmt.setString(4, event.getDescription());
            eventUpdateStmt.setInt(5, event.getTokenLimit());
            eventUpdateStmt.setBoolean(6, event.isTokenized());
            eventUpdateStmt.setInt(7, event.getAddressId());
            eventUpdateStmt.setInt(8, event.getUserId());
            eventUpdateStmt.setInt(9, event.getCategoryId());
            eventUpdateStmt.setInt(10, eventId);

            result = eventUpdateStmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = -1;
        }
        return result;
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
			System.out.println(event.isTokenized());
			if (event.isTokenized())
				evntInstStmt.setInt(6, 1);
			else
				evntInstStmt.setInt(6, 0);
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



	public void updateCouponCount(int eventId, int tokenLimit) {
		String sql = "UPDATE event SET token_limit = ? WHERE id = ?";
		PreparedStatement eventTokenStatement = null;
		try {
			eventTokenStatement = dbConnection.prepareStatement(sql);
			eventTokenStatement.setInt(1, tokenLimit);
			eventTokenStatement.setInt(2, eventId);
			eventTokenStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Event> getEventsBySearch(String event) {
		// SELECT * FROM event WHERE UPPER(name)='%'+UPPER("s")+'%'
		String sql = "SELECT * FROM event WHERE name LIKE '%" + event + "%'";
		System.out.println(sql);
		Statement userEventQuery = null;
		List<Event> userSearchEvents = new ArrayList<Event>();
		try {
			userEventQuery = dbConnection.createStatement();

			ResultSet rs = userEventQuery.executeQuery(sql);

			while (rs.next()) {
				Event event1 = new Event();
				event1.setId(rs.getInt("id"));
				event1.setAddressId(rs.getInt("address_id"));
				event1.setUserId(rs.getInt("user_id"));
				event1.setCategoryId(rs.getInt("event_category"));
				event1.setTokenized(rs.getBoolean("is_tokenized"));
				event1.setTokenLimit(rs.getInt("token_limit"));
				event1.setDescription(rs.getString("description"));
				event1.setStartDateTime(rs.getString("start_time"));
				event1.setEndDateTime(rs.getString("end_time"));
				event1.setName(rs.getString("name"));
				userSearchEvents.add(event1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userSearchEvents;

	}

	public List<Event> getPinedEvents(int userId) {
		List<Event> userEvents = new ArrayList<Event>();
		if (userId > 0) {
			String sql = "Select e.id,e.address_id,e.user_id,e.event_category,e.is_tokenized,e.token_limit,"
					+ "e.description,e.start_time,e.end_time,e.name from event e, token t where t.event_id = e.id and t.user_id = ?";
			System.out.println(sql);
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


    public List<Event> getEventCategories(String data){
//    	SELECT id FROM event_category where name = "food"
    	String sql;

        
        if((data).equals("All")){
         sql="Select * from event";
        }else{
         String id = "Select id from event_category where name = \""+data+"\"";
         System.out.println("id"+id);
         sql="Select * from event where event_category=("+id+")";
        }
        System.out.println("sql"+sql);
        Statement userEventQuery = null;
        List<Event> userCategoryEvents = new ArrayList<Event>();
        try{
            userEventQuery =  dbConnection.createStatement();
            
            ResultSet rs = userEventQuery.executeQuery(sql);
            
            while (rs.next()) {                    
            Event event1 = new Event();
            event1.setId(rs.getInt("id"));
            event1.setAddressId(rs.getInt("address_id"));
            event1.setUserId(rs.getInt("user_id"));
            event1.setCategoryId(rs.getInt("event_category"));
            if(rs.getInt("is_tokenized") == 0){
            	event1.setTokenized(false);
            }else{
            	event1.setTokenized(true);
            }
            event1.setTokenLimit(rs.getInt("token_limit"));
            event1.setDescription(rs.getString("description"));
            event1.setStartDateTime(rs.getString("start_time"));
            event1.setEndDateTime(rs.getString("end_time"));
            event1.setName(rs.getString("name"));
            userCategoryEvents.add(event1);
    }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userCategoryEvents;
    }

}
