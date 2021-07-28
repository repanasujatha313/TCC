<%-- 
    Document   : FrontPage
    Created on : 15 Jun, 2020, 8:10:59 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Front Page</title>
    </head>
    <script>
        function validation(){
            var name=document.login.uname.value;
            var password1=document.login.pwd.value;
            var password2=document.login.pwd1.value;
            var phone=document.login.phno.value;
            if(name==null || name==""){
                alert("name can't be blank");
                return false;
            }
            else if(password1.length<6){
                alert("password must be more than 6 lettes..");
                return false;
            }
            else if(password1!=password2){
                alert("password must be same...!");
                return false;
            }
            else if(isNaN(phone)){
                document.getElementById("numloc").innerHTML="enter numerics only..";
                return false;
            }
            else
            {
                return true;
            }
        }
    </script>
    <body style="background-color:greenyellow">
    <center>
        
      <h1>Registration Form</h1><br /><br /><br />
      <form action="StoreInServlet" method="post" name="login" onsubmit="return validation()">
          <fieldset style="width: 700px">
            
              UserName :<input type="text" name="uname" value="" required><br /><br/>
                Email : <input type="email" name="email" value=""required><br /><br />
                Create Password : <input type="password" name="pwd" value="" required><br /><br />
                Verify Password: <input type="password" name="pwd1" value="" required><br /><br />
                Gender:<input type="radio" name="male" value="Male"><label>Male</label><input type="radio" name="female" value="Female"><label>Female</label><br/><br/>
                Phone Number :<input type="text" name="phno" value=""><span id="numloc"></span><br /><br/>
                Address:<input typt="text" name="addr" value="" required><br/><br/>
                <input type="submit" name="submit" value="Register"><br/><br/>
                <a href="Login.jsp">Already have Account</a>
             
          </fieldset>
        </form>
        </center>
    </body>
</html>
