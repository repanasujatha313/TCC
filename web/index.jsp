<%-- 
    Document   : index
    Created on : 15 Jun, 2020, 8:42:37 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index Page</title>
        <style>
            *{
                margin:0;
                padding:0;
                box-sizing: border-box;
            }
            a{
                text-decoration: none;
                font-size: 20px;
                color: #FFF;
            }
            ul,li{
                               list-style:none;
            }
            .head{
                width:100%;
                
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: lightyellow;
                font-size: 20px;
                padding: 10px 30px;
                font-weight: 700;
            }
            .menu ul li{
                margin:0;
                display:inline-block;
                margin: 5px 10px 5px 10px;
                padding: 0 10px 0 10px;
                font-weight: bold;
          
            }
            a:hover{
                color:blue;
            }
            .logo{
                flex: 1 1 auto;
               margin: 5px 10px 5px 10px              
               /*text-transform: uppercase;
                letter-spacing: 1px;
                font-weight: bold;
                font-size: 35px;*/
            }
            a{
                margin: 2px;
                color: #000;
                text-decoration: none;
                text-transform: uppercase;
            }
            body{
                background-image: url("src/truck_1.png");
                background-attachment: fixed;
                background-size: 100% 100%
            }
        </style>
    </head>
    <body style="background-color: powderblue">
       
    <center>
        <h1>Transport Company Computerization</h1>
    </center>
        <div class="head">
        <div class="menu">
            <ul>
                <li><a href="#" class="logo"><img style="width:50px;height: 50px;border-radius:50px;" src="src/logo.png"</a></li>
                <li><a href="Login.jsp">Sender</a></li>
                <li><a href="DriverLogin.jsp">Driver</a></li>
                <li><a href="managerLogin.jsp">Manager</a></li>
                <li><a href="FrontPage.jsp">Register</a></li>
                <li><a href="About">About</a></li>
            </ul>
        </div>
        </div>
  
    </body>
</html>
