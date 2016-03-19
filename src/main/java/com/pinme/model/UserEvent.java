package com.pinme.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UserEvent {
    private User user;
    private List<Event> events = new ArrayList<Event>();

    public UserEvent(User user, List<Event> events){
        this.user = user;
        this.events = events;
    }


    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
