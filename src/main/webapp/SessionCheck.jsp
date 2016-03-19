  <%  if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
	 // System.out.println(session.getAttribute("userid"));
	 response.sendRedirect("index.jsp");
	}  
%>
<script>
var USER_ID = <%=session.getAttribute("userid")%>
</script>