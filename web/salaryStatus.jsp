<%-- 
    Document   : salaryStatus
    Created on : 5 Feb, 2021, 5:52:56 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function validation(){
                var id=document.salary.Did.value;
                var d=document.salary.days.value;
                if( id==" "||id==null){
                    alert("Value can't be null Please enter id");
                    return false;
                }
                else if(d==" "||d==null){
                    alert("enter no.days");
                    return false;
                }
                else if(d>=31){
                    alert("one month consists 28 to 31 days..");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body style="background-color: darkgray">
         <center>
                <h1>Enter details..!</h1>
                <form action="Updatesalary" method="post" name="salary" onsubmit="return validation()">
                    Driver id:<input type="text" name="Did" value=""><br/><br/>
                    NO.of days worked in month:<input type="number" name="days" value=""><br/><br/>
                <input type="submit" name="submit" value="submit">
            </form>    
            </center>
       </body>
    </body>
</html>
