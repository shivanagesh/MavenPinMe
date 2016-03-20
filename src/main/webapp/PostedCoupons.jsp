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
    <table class="table">
        <thead class="thead-inverse">
        <tr>
            <th>#</th>
            <th>Event Name</th>
            <th>Description</th>
            <th>Start Time</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${sessionScope.userEvents}" var="userEvent">
            <tr>
                <th scope="row"> <c:out value="${userEvent.id}"/> </th>
                <td><c:out value="${userEvent.name}"/></td>
                <td><c:out value="${userEvent.description}"/></td>
                <td><c:out value="${userEvent.startDateTime}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</section>
<script type="text/javascript" src="js/app.js"></script>
</body>
</html>
