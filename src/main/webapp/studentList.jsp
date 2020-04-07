<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Web - laboratorium 5</title>
    </head>
    <body>
        Lista studentów:<br>
        <table border="1">
        <tr>
            <th>Imię</th><th>Nazwisko</th><th>Email</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr><td>${student.firstName}</td><td>${student.lastName}</td><td>${student.emailAddress}</td></tr>
        </c:forEach>
        </table><br>
        <br>
        <form action='/TPSI_5/studentAdd' method='post'>
        Imie: <input type='text' name='firstName'><br>
        Nazwisko: <input type='text' name='lastName'><br>
        Email: <input type='email' name='emailAddress'><br>
        <input type='submit' value='Dodaj studenta'>
        </form><br>
        <br>
        Licznik odwiedzin: ${visitCounter};
    </body>
</html>