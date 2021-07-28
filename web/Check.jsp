<%-- 
    Document   : Check
    Created on : 4 Feb, 2021, 11:07:55 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        function validation(){
            var dname=document.login.id.value;
            var vname=document.login.vname.value;
            if(dname==null || dname==" "|| dname==""){
                alert("enter your id");
                return false;
            }
            else if(vname==null || vname==" "|| vname==""){
                alert("enter vehicle name");
                return false;
            }
            return true;
        }
    </script>
    <body style="background-color: grey">
        <center>
        <h1>Check your work</h1>
        <form action="checkWork" method="post" name="check" onsubmit="return validation()">
            <fieldset style="width: 600px">
                enter id:<input type="text" name="id" value=""><br/><br/>
                enter vehicle name:<input type="text" name="vname" value=""><br/><br/>
                <input type="submit" name="submit" value="submit">
            </fieldset>
            </form>
        </center>
    </body>
</html>
