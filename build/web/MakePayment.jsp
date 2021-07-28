<%-- 
    Document   : MakePayment
    Created on : 5 Feb, 2021, 2:00:26 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: palegoldenrod">
        <center>
        
      <h1>Money Payment</h1><br /><br /><br />
      <form action="UpdatePayment" method="post" name="payment" onsubmit="return validation()">
          <fieldset style="width: 700px">
                Consignment id: <input type="text" name="id" value=""><br /><br />
                Money:<input type="text" name="money" value=""><br/><br/>
                <input type="submit" name="submit" value="submit">
          </fieldset>
        </form>
      </center>
    </body>
</html>
