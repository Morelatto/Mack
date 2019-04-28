<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="index.css">
        <title>PETS</title>
    </head>
    <body>
        <c:if test="${empty listaPets}">
            <c:redirect url="Controller?command=getPets"></c:redirect>
        </c:if>
        <div id="container">
            <c:forEach var="pet" items="${sessionScope.listaPets}">
                <div class="box">
                    <span class="titulo"><strong>${pet.getName()}<br></strong></span>
                    <span class="texto">
                        <div class="foto">
                            <img src="${pet.getPhoto()}">
                        </div>
                        <i>${pet.getRace()} - ${pet.getAge()} anos</i>
                        <br>
                        <br>
                        ${pet.getDescription()}<br></span>
                    <span class="localizacao"><i>${pet.getCity()} - ${pet.getState().getInitials()} - ${pet.getCountry().getName()}</i></span>
                    <br>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
