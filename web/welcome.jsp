<%-- 
    Document   : welcome
    Created on : 5 Jun, 2020, 6:28:46 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome <%=session.getAttribute("name")%> </title>
    </head>
    <body>
        <h3>Login Successful!!!</h3>
        <h4> Hello,<%=session.getAttribute("name")%></h4>
    </body>
</html>
