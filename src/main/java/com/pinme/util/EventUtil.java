package com.pinme.util;

import com.pinme.controllers.EventController;
import com.pinme.model.Address;
import com.pinme.model.Event;
import com.pinme.model.EventCategory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 *
 */
public class EventUtil {
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
            eventObj.put("isTokenized", event.isTokenized());
            return eventObj;
        }).forEach(eo -> jsonArray.add(eo));
        return jsonArray.toJSONString();
    }
}
