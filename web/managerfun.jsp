<%-- 
    Document   : managerfun
    Created on : 30 Jan, 2021, 6:32:28 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>manager functionalities</title>
        <style>
            *{
                margin:0;
                padding:0;
                box-sizing: border-box;
            }
            a{
                text-decoration: none;
                font-size: 20px;
                color:#FFF;
            }
            ul,li{
                list-style:none;
            }
            .head{
                width:100%;
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: green;
                font-size: 20px;
                padding: 5px 5px;
                font-weight: 700;
            }
            .menu ul li{
                margin:0;
                display:inline-block;
                margin: 5px 10px;
                padding: 0 10px 0 10px;
            }
            a:hover{
                color:black;
            }
        </style>
    </head>
    <body style="background-color:gold">
       <center>
        <h1>Manager Functionalities...!</h1>
        </center>
        <div class="head">
        <div class="menu">
            <ul>
                <li><a href="ViewRequests">ViewRequest&Approve</a></li>
                <li><a href="ViewDrivers">ViewDrivers</a></li>
                <li><a href="ViewVehicles">ViewVehicles</a></li>
                <li><a href="PreparePayment">PreparePayment</a></li>
                <li><a href="index.jsp">Logout</a></li>
            </ul>
        </div>
        </div>
    </body>
</html>
