<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html>
<head>
    <%@ include file="import.jsp" %>
    <%@ include file="header.jsp" %>
    <%@ include file="SessionCheck.jsp" %>
</head>
<body class="padding">
<section class="divider">
</section>
<section>
    <form action="Event" method="POST">
        <fieldset class="postingAd">

            <div>
                <label>Event Name:<input type="text" name="event" id="eventname"
                                         placeholder="Story Telling" value="${event.name}"></label>
            </div><div>
            <label>Event Date : <input type="date" name="eventdate" id="eventdate"
                                       placeholder="mm-dd-yy" value="${event.formattedDate}"></label>
        </div><div>
            <label>Event Time :<input type="time" name="eventtime" id="eventtime"
                                      value="${event.formattedTime}"></label>
        </div><div>
            <fieldset>
                <legend>Location</legend>
                <section class="Location">
                    <div>
                        <label>Address:<input type="text" name="address" id="address"
                                              placeholder="1303 oakcircle st" value="${address.street}"></label>
                    </div><div>
                    <label>City:<input type="text" name="city" id="city"
                                       placeholder="SFO" value="${address.city}"></label>
                </div><div>
                    <label>ZipCode:<input type="text" name="zipcode" id="zipcode"
                                          placeholder="12345" value="${address.zipcode}"></label>
                </div><div>
                    <label>Addition Landmarks:<input type="text" name="landmarks" id="landmarks"
                                                     placeholder="near school" value="${address.state}"></label>
                </div>
                </section>
            </fieldset>
        </div>

            <div>
                <label>Category
                    <select name="Catergory" class="select">
                        <option value="Food" ${eventCategory.name == "Food" ? 'selected="selected"' :''}>Food</option>
                        <option value="Clothing" ${eventCategory.name == "Clothing" ? 'selected="selected"' :''}>Clothing</option>
                        <option value="Entertainment" ${eventCategory.name == "Entertainment" ? 'selected="selected"' :''}>Entertainment</option>
                        <option value="recreation" ${eventCategory.name == "recreation" ? 'selected="selected"' :''}>recreation</option>
                    </select>
                </label>
            </div><div>
            <label>Do you want to Limit your resource?
                <select  id="settinglimit" name="settinglimit" onchange="setLimit()">
                    <option value="yes" id="yes" ${event.isTokenized() ? 'selected="selected"': ''}>Yes</option>
                    <option value="No" id="no" ${!event.isTokenized() ? 'selected="selected"': ''}>No</option>
                </select>
            </label>
        </div><div id="limit" class="limit">
            <label>Set Maximum Value
                <input type="number" id="limit" name="limit" min="0"
                        value="${event.tokenLimit}"></label>
        </div><div>
            <label>Description<br>
                <textarea name="description" rows="5" cols="50"
                          placeholder="Additional Description of the event">
${event.description}</textarea></label>
        </div><div>
            <input type="hidden" id="eventId" name="eventId" value="${event.id}">
            <input type="hidden" id="addressId" name="addressId" value="${address.id}">
            <input type="hidden" id="addressId" name="categoryId" value="${eventCategory.id}">
            <button type="submit" class="button submit">Post</button>
            <button type="reset" value="Reset" class="button reset"> Reset</button>
        </div>
        </fieldset>
    </form>
</section>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
      setLimit();
    });
</script>
</body>
</html>
