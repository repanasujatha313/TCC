<%-- 
    Document   : managerLogin
    Created on : 27 Feb, 2021, 11:31:02 AM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: khaki">
        <center>
        
        <h1>Login TCC</h1><br /><br /><br />
        <form action="ManagerLoginValidate" method="" name="Driverlogin">
            <fieldset style="width: 700px">
                <table>
                  Id: <input type="text" name="uname" value=""><br /><br />
                  Password : <input type="password" name="pwd" value=""><br /><br />
                  <input type="submit" name="submit" value="Login">

                </table>
            </fieldset>
          </form>
        </center>
      </body>
</html>
