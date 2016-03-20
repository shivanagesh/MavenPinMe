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
        <form action="Event" method="POST" onSubmit="return checkpattern()">
    <fieldset class="postingAd">
    <div>
        <label>Event Name<sup>*</sup>:<input type="text" name="event" id="eventname" placeholder="Story Telling" required></label>
        </div><div>
        <label>Event Date<sup>*</sup>: <input type="date" name="eventdate" id="eventdate" placeholder="mm-dd-yy" required></label>
          </div><div>
        <label>Event Time<sup>*</sup>:<input type="time" name="eventtime" id="eventtime" required></label>
          </div><div>
      <fieldset>
      <legend>Location</legend>
      <section class="Location">
      <div>
          <label>Address<sup>*</sup>:<input type="text" name="address" id="address" placeholder="1303 oakcircle st" required></label>
            </div><div>
          <label>City<sup>*</sup>:<input type="text" name="city" id="city" placeholder="SFO" required></label>
            </div><div>
          <label>ZipCode<sup>*</sup>:<input type="text" name="zipcode" id="zipcode" placeholder="12345" required></label>
            </div><div>
          <label>Addition Landmarks:<input type="text" name="landmarks" id="landmarks" placeholder="near school"></label>
          </div>
          </section>
      </fieldset>
        </div>
        
        <div>
      <label>Category<sup>*</sup>
      <select name="Catergory" id="Catergory" class="select" required>
        <option value="Food" selected="selected">Food</option>
        <option value="Clothing">Clothing</option>
        <option value="Entertainment">Entertainment</option>
        <option value="recreation">recreation</option>
       </select>
       </label>
         </div><div>
    <label>Do you want to Limit your resource?
    <select  id="settinglimit" name="settinglimit" onchange="setLimit()">
    <option value="yes" id="yes">Yes</option>
    <option value="No" id="no" selected="selected">No</option>
    </select>
    </label>
         </div><div id="limit" class="limit">
         <label>Set Maximum Value
         <input type="number" id="limit" name="limit" min="0"></label>
         </div><div>
      <label>Description<br>
          <textarea name="description" rows="5" cols="50" placeholder="Additional Description of the event"></textarea></label>
      </div><div>
      <button type="submit" class="button submit">Post</button>
      <button type="reset" value="Reset" class="button reset"> Reset</button>
      </div>
    </fieldset>
    </form>
        </section>
    <script type="text/javascript" src="js/app.js"></script>
    </body>
    </html>
