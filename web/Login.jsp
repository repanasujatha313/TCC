<%-- 
    Document   : Login
    Created on : 26 Jan, 2021, 5:41:01 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            a{
                text-decoration: none;
                font-size: 20px;
                padding: 10px 30px;
                color: black;
            }
            a:hover{
                color: #FFF;
            }
            </style>
    </head>
    <script>
        function validaton(){
            var fname=document.login.fname.value;
            var lname=document.login.lname.value;
            var uname=document.login.uname.value;
            var pwd=document.login.pwd.value;
            var pwd1=document.login.pwd1.value;
            var phno=document.login.phno.value;
            
            if(fname==null || fname=="" || fname=" "){
                alert("please enter first name...");
                return false;
            }
            else if(lname==null || lname=="" || lname=" ")
            {
                alert("please enter last name...");
                return false;
            }
            else if(!(fname.match("[A-Z]") ) || !(lname.match("[A-Z]"))){
                alert("please enter capital letters...");
                return false;
            }
            else if(pwd==null || pwd=="" || pwd=" "){
                alert("please enter password...");
                return false;
            }
            else if(pwd1==null || pwd1=="" || pwd1=" "){
                alert("please enter password...");
                return false;
            }
            else if(pwd.length<6 || pwd1.length<6){
                alert("password must contain atleast 6 characters..");
                return false;
            }
            else if(pwd.length<pwd1.length || pwd1.length<pwd.length){
                alert("password must be same....");
                return false;
            }
            else if(isNaN(phno)){
                document.getElementById("numloc");
                alert("enter number");
                return false;
            }
            return true;
        }
       
    </script>
    <body style="background-color:greenyellow">
    <center>
        
      <h1>Login TCC</h1><br /><br /><br />
      <form action="LoginValidate" method="post" name="login" onsubmit="return validation()">
          <fieldset style="width: 700px">
              <table>
                Email : <input type="email" name="uname" value=""><br /><br />
                Password : <input type="password" name="pwd" value=""><br /><br />
                <input type="submit" name="submit" value="Login">
                <a href="FrontPage.jsp">Create Account</a>
              </table>
          </fieldset>
        </form>
      </center>
    </body>
</html>
