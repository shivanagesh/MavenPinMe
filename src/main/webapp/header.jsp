	<header class="adjust">
<div class="icon">
<img src="images/icon.png" alt="pin image">
</div>
<h1 class="header">Pin Me!</h1>
        <div class="user">
            <button class="account"><i class="fa fa-user fa-3x"></i> <%=session.getAttribute("first_name")%></button>
           
            <div class="user-content">
                <ul>
             <li>
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="History.jsp">History</a></li>
                    <li><a href="postAd.jsp">Post Event</a></li>
                    <li><a href="CouponSearch.jsp">Find Event</a></li>
                    <li><a href="MyEvents.jsp"> My Events</a> </li>
                    <li><a href="Logout"> Logout</a> </li>
                      </ul>
            </div>
        </div>
    </header>
    
    <footer>
    @CopyRights:Pin Me
    <br> developed by Prathyusha Rani,Prathyusha,Shiva  Divya
</footer>