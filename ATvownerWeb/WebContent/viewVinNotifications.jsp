<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page errorPage="showError.jsp" %>

<html>
<head>
<title>View VIN Notifications</title>
</head>
<body>

<sql:setDataSource dataSource="jdbc/abrstech_obd2db" />

<sql:query var="rs">    
    SELECT vin, logfilename, loglinecount, paramname, message, currentvalue, email 
    from car_notifications_history 
    where vin=? 
    ORDER BY seqno DESC 
    LIMIT 200
    <sql:param value="${param.v}" />            
</sql:query>


<c:forEach var="row" items="${rs.rows}">    
	To: ${row.email} &nbsp; <BR>	
    ${row.paramname} &nbsp; <BR>    
    <font style="font-size:20px" face="verdana" color="black">
    ${row.message} &nbsp; <BR>
    </font>
    <font style="font-size:40px" face="verdana" color="green">
    <a href="/atvownerweb/selectParamTrend.jsp?v=${row.vin}&p=${row.paramname}"><img src="/atvownerweb/images/trend2.png" border="0"></a>  
    ${row.currentvalue} &nbsp; 
    </font>           
    <br> <br>
</c:forEach>

</body>
</html>