package com.pinme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.EventCategory;
import com.pinme.model.User;
import java.util.stream.*;


/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:32:31 PM fileUserDao.java
 *
 * @author Chintala Prathyusha, wrote routines to get event categories
 */
public class EventCategoryDao extends DBConnect {
    public static List<EventCategory> eventCategories = new ArrayList<EventCategory>();
    private static AtomicInteger uniqueId = new AtomicInteger();

    Connection dbConnection = getDBConnection();

    /**
     *
     */
    public EventCategoryDao() {

    }

    public int addEventCategory(EventCategory eventCategory) {
        eventCategory.setId(uniqueId.incrementAndGet());
        eventCategories.add(eventCategory);
        return eventCategory.getId();
    }

    public void removeEventCategory(int id) {
        for (EventCategory eventCatgoey : eventCategories) {
            if (eventCatgoey.getId() == (id)) {
                eventCategories.remove(eventCatgoey);
                return;
            }

        }

    }


    public EventCategory getCategory(int eventCategoryId) {
        for (EventCategory eventCatgoey : eventCategories) {
            if (eventCatgoey.getId() == (eventCategoryId)) {
                return eventCatgoey;
            }

        }
        return null;
    }

    public void updateCategory(int eventCategoryId, EventCategory updateEventCategory) {

        for (EventCategory eventCatgoey : eventCategories) {
            if (eventCatgoey.getId() == (eventCategoryId)) {
                eventCatgoey = updateEventCategory;
            }

        }

    }

    public EventCategory getEventCategoryById(int eventCategoryId){
        List<EventCategory> categories = getCategoriesFromDb();
        Stream<EventCategory> eventCategory = categories.stream().filter(ec -> ec.getId() == eventCategoryId);
        return eventCategory.findFirst().get();
    }

    public EventCategory getEventCategoryByName(String categoryName){
        if(categoryName != null){
            // I see just 4 categories; it's ok to get all of them to memory
            // Anyway, we are not planning to create millions of categories
            List<EventCategory> categories = getCategoriesFromDb();
            Stream<EventCategory> eventCategory = categories.stream().filter(ec -> ec.getName().equals(categoryName));
            return eventCategory.findFirst().get();
        }else{
            return null;
        }
    }
    
    public List<EventCategory> getCategoriesFromDb(){
        String sql = "Select * from event_category";
        List<EventCategory> eventCategoryList = new ArrayList<EventCategory>();
        PreparedStatement ecSelectStatement = null;
        try {
            ecSelectStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = ecSelectStatement.executeQuery();
            while (rs.next()) {
                EventCategory ec = new EventCategory();
                ec.setId(rs.getShort("id"));
                ec.setName(rs.getString("name"));
                ec.setDescription(rs.getString("description"));
                eventCategoryList.add(ec);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return eventCategoryList;
    }

    public List<EventCategory> getCatgories(){
        return eventCategories;
    }

}
