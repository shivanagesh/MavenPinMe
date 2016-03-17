    package com.pinme.dao;

    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;

    import java.util.List;
    import java.util.concurrent.atomic.AtomicInteger;

    import com.pinme.model.Event;
    import com.pinme.model.EventCategory;


    /**
     * @author Shivanagesh Chandra Mar 7, 2016 11:32:31 PM fileUserDao.java
     *
     * @author Chintala Prathyusha, wrote routines to persist event info
     */
    public class EventDao extends DBConnect {
        public static List<Event>	events = new ArrayList<Event>();
        private static AtomicInteger uniqueId = new AtomicInteger();

        /**
         *
         */
        public EventDao() {

        }

        public int addEvent(Event event) {
            String sql = "INSERT INTO event(name, start_time, end_time, description, token_limit, is_tokenized, " +
                    "address_id, user_id, event_category ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

        public List<Event> findAllEventsFromDB(){
            List<Event> allEvents = new ArrayList<Event>();
            String sql = "Select * from event";
            PreparedStatement eventsQueryStmt = null;
            try{
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
            } catch (Exception e){
                e.printStackTrace();
            }
            return allEvents;

        }

        public List<Event> findEventsByUserId(int userId){
            List<Event> userEvents = new ArrayList<Event>();
            if(userId > 0) {
                String sql = "Select * from event where user_id=?";
                PreparedStatement eventsQueryStmt = null;
                try{
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
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
            return userEvents;
        }

        public void removeEvent(int id) {
            for (Event event : events) {
                if (event.getId() == (id)) {
                    events.remove(event);
                    return;
                }

            }

        }

        public Event getEvent(int id) {
            for (Event event : events) {
                if (event.getId() == (id)) {
                    return event;
                }

            }
            return null;

        }

        public List<Event> getEvents(){
            return events;
        }

        public List<Event> getUserEvents(int userId){
            List<Event> userEvents = new ArrayList<Event>();
            for (Event event : events) {
                if(event.getUserId() ==  userId){
                    userEvents.add(event);
                }
            }
            return userEvents;
        }

        public List<Event> getEventsByCategory(int categoryId){
            List<Event> categorEvents = new ArrayList<Event>();
            for (Event event : events) {
                if(event.getCategoryId() ==  categoryId){
                    categorEvents.add(event);
                }
            }
            return categorEvents;
        }


        public void updateEvent(int eventId, Event updateEvent){

            for (Event event : events) {
                if(event.getId() ==  eventId){
                    if(updateEvent.getName() != null){
                        event.setName(updateEvent.getName());
                    }
                    if(updateEvent.getStartDateTime() != null){
                        event.setStartDateTime(updateEvent.getStartDateTime());
                    }
                    if(updateEvent.getEndDateTime() !=null){
                        event.setEndDateTime(updateEvent.getEndDateTime());
                    }
                    if(updateEvent.getDescription() !=null){
                        event.setDescription(updateEvent.getDescription());
                    }
                    if(updateEvent.getTokenLimit() != -1){
                        event.setTokenLimit(updateEvent.getTokenLimit());
                    }

                    if(updateEvent.isTokenized()){
                        event.setTokenized(updateEvent.isTokenized());
                    }

                }
            }

        }



    }
