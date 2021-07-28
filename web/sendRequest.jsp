<%-- 
    Document   : sendRequest
    Created on : 1 Feb, 2021, 6:43:21 PM
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
            var cname=document.sendRequest.cname.value;
            var csize=document.sendRequest.csize.value;
            var distance=document.sendRequest.distance.value;
            var id=document.sendRequest.id.value;
           
            if(id==(cname+"_"+csize+"_"+distance)){
                return true; 
            }
            else{
                alert("please enter id carefully..;")
                return false;
            } 
        }
        </script>
    <body style="background-color: darkgrey">
    <center>
        <h1>Send Request</h1>
        <h2>Your Request will be approved with in 2 days..</h2>
        <form action="sendRequestServlet" method="post" name="sendRequest" onsubmit="return validation()">
          <fieldset style="width: 700px">
            
              Consignment name:<input type="text" name="cname" value="" required=""><br/><br/>
              Consignment size(Kg's):<input type="number" name="csize" value="" required><br/><br/>
              Destination Distance(Km's):<input type="number" name="distance" value="" required=""><br/><br/>
              Enter Consignment Id as(Consignment name_size_distance):<br>
              <input type="text" name="id" value=""><br/><br/>
              <input type="submit" name="submit" value="Register"><br/><br/>
               
             
          </fieldset>
        </form>
        </center>
    </body>
</html>
