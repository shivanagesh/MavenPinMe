    <!Doctype html>
    <html>

    <head>
    <%@ include file="import.jsp" %>
      <%@ include file="header.jsp" %>
    </head>
    <body class="padding">
  
        <section class="divider">
    </section>
        <section>
        <form action="Event" method="POST">
    <fieldset class="postingAd">
    <div>
        <label>Event Name:<input type="text" name="event" id="eventname" placeholder="Story Telling"></label>
        </div><div>
        <label>Event Date : <input type="date" name="eventdate" id="eventdate" placeholder="mm-dd-yy"></label>
          </div><div>
        <label>Event Time :<input type="time" name="eventtime" id="eventtime"></label>
          </div><div>
      <fieldset>
      <legend>Location</legend>
      <div>
          <label>Address:<input type="text" name="address" id="address" placeholder="1303 oakcircle st"></label>
            </div><div>
          <label>City:<input type="text" name="city" id="city" placeholder="SFO"></label>
            </div><div>
          <label>ZipCode:<input type="text" name="zipcode" id="zipcode" placeholder="12345"></label>
            </div><div>
          <label>Addition Landmarks:<input type="text" name="landmarks" id="landmarks" placeholder="near school"></label>
          </div>
      </fieldset>
        </div><div>
      <label>Catergory
      <select name="Catergory" class="select">
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
        <footer>
    @CopyRights:Pin Me <br>
     developed by Prathyusha Rani,Prathyusha,Shiva & Divya
    </footer>
    <script type="text/javascript" src="js/app.js"></script>
    </body>
    </html>
