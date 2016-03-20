package com.pinme.util;

import com.pinme.controllers.EventController;
import com.pinme.model.Address;
import com.pinme.model.Event;
import com.pinme.model.EventCategory;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 */
public class EventUtil {

    public static List<Event> filterNonExpiredEvents(List<Event> events){
       return events.stream().filter(event -> event.getStartDateTime() != null)
            .filter(event -> {
            LocalDate today = LocalDate.now();
            Date eventStartDate = MySqlUtil.getLocalDate(event.getStartDateTime());
            LocalDate eventLocalDate = eventStartDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long hours = ChronoUnit.DAYS.between(eventLocalDate, today);
            return hours < 1;
        }).collect(Collectors.toList());

    }



    public static String populateJsonFromEvents(List<Event> events){
        JSONArray jsonArray = new JSONArray();
        events.stream().map(event -> {
            JSONObject eventObj = new JSONObject();
            Address address = EventController.getInstance().getEventAddress(event);
            EventCategory eventCategory = EventController.getInstance().getEventCategoryById(event.getCategoryId());
            eventObj.put("Id", event.getId()) ;
            eventObj.put("Name", event.getName());
            eventObj.put("Date", MySqlUtil.getDate(event.getStartDateTime()));
            eventObj.put("Time", MySqlUtil.getTime(event.getStartDateTime()) +"-" +  MySqlUtil.getTime(event.getEndDateTime()));
            eventObj.put("Description", event.getDescription());
            eventObj.put("Location", address.getStreet());
            eventObj.put("category", eventCategory.getName());
            eventObj.put("Limit", event.getTokenLimit());
            return eventObj;
        }).forEach(eo -> jsonArray.add(eo));
        return jsonArray.toJSONString();
    }
}
