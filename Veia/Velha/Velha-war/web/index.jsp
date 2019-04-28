<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <title>Jogo da Velha</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body id="body" onload="myFunction()">
        <div class="head" onclick="window.location.assign('Controller?command=again');"><h1 class="curs">Jogo da Velha</h1></div>
        <div class="wrap">
            <c:forEach begin="0" end="2" var="i">
                <div class="row r${i}">
                    <c:set var="c" value="0"></c:set>
                    <c:forEach begin="${i*3}" end="${i*3+2}" var="j">
                        <div id="n${j}" class="el c${c} <c:if test="${j==0||j==4||j==8}">d1 </c:if><c:if test="${j==2||j==4||j==6}">d2 </c:if><c:if test="${ocupado.get(j)!='x'&&ocupado.get(j)!='o'}">free" onclick="window.location.assign('Controller?command=click&pos=' +${j});</c:if>">
                            <c:if test="${ocupado.get(j)=='x'}"><i class="fa fa-times"></i></c:if>
                            <c:if test="${ocupado.get(j)=='o'}"><i class="fa fa-circle-o"></i></c:if>
                            </div>
                        <c:set var="c" value="${c+1}"></c:set>
                    </c:forEach>
                </div>
            </c:forEach>
        </div>
        <div class="screen" onclick="window.location.assign('Controller?command=again');"></div>
        <div class="console pop-up" onclick="window.location.assign('Controller?command=again');">
            <div class="row">
                <div class="el-o"><c:if test="${winner=='t'}"><i class="fa fa-question"></i></c:if><c:if test="${winner=='o'}"><i class="fa fa-circle-o"></i></c:if><c:if test="${winner=='x'}"><i class="fa fa-times"></i></c:if></div>
                <h3 class="big inline out"><c:if test="${winner=='t'}">EMPATE!</c:if><c:if test="${winner!='t'}">VENCEU!</c:if></h3>
                </div>
                <h3 id="sub">Clique para jogar novamente!</h3>
            </div>
            <div class="select pop-up">
                <h3>SELECIONE:</h3>
                <div class="row">
                    <div id='x' class="el-s free" onclick="window.location.assign('Controller?command=start&player=x');"><i class="fa fa-times"></i></div>
                    <h3 class='inline'>OU</h3>
                    <div id ='o' class="el-s free" onclick="window.location.assign('Controller?command=start&player=o');"><i class="fa fa-circle-o"></i></div>
                </div>
            </div>
            <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <%@include file="/WEB-INF/jspf/indexJavaScript.jspf" %>
        <c:if test="${!continuar}"><style>.select{display: block;}.screen{display: block;}</style></c:if>
    </body>
</html>
