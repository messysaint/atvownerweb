<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>


<style type="text/css">

table, th, td {
    border: 1px solid white;
    border-collapse: collapse;
}

th, td {
    padding: 1px;
}

</style>

<%

	String IVWEB_VIN = (String) session.getAttribute( "IVWEB_VIN" ); // retrieve IVWEB_VIN from HTTP Session
	String sessiontimeout = "/atvownerweb/showError.jsp";

	// check for session timed out
	if( IVWEB_VIN == null ) {
		response.sendRedirect( sessiontimeout );
	}


 	String refreshDashBoard = "<A href=\"/atvownerweb/selectVehicle.jsp?v=" + IVWEB_VIN + "\"> <img border=\"0\" alt=\"Refresh\"src=\"/atvownerweb/images/refresh.png\"></A>&nbsp;&nbsp;";
	String viewToggleGraph  = "&nbsp;&nbsp;<A href=\"/atvownerweb/selectVehicle2.jsp?v=" + IVWEB_VIN + "\"><img border=\"0\" alt=\"Refresh\"src=\"/atvownerweb/images/graph.png\"></A>";	
%>	
    

<table style="width:100%">

  <tr>
    <th><%=refreshDashBoard%></th>      
    <th><%=viewToggleGraph%></th>
  </tr>
 
</table>

