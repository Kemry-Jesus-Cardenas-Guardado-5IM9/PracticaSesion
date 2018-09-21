<%-- 
    Document   : index
    Created on : 20/09/2018, 09:03:28 PM
    Author     : Kemry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesiones</title>
    </head>
    <body>
        <center>
            <h1>Sesiones</h1>
            <br>
            <form action='Sesionserv' method='POST'>
                nombre<br>
                <input type="text" name="nomb"><br>
                apellido <br>
                <input type="text" name="apell"><br>
                <input type="submit" value="Validar">
            </form>
        </center>
    </body>
