<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nequi</title>
    <link rel="stylesheet" href="assets/css/Estilos.css">
</head>
<body>

    <header class="header">
        <div class="logo">
            <a href= "bolsillo?accion=index"><img src="assets/img/logo.png" alt="Logo marca"></a>
        </div>
        <h1 class="titulo">BOLSILLOS</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
    <nav class="nav">
        <ul class="nav-links">
            <li><a href= "bolsillo?accion=volverDaviplata">Volver</a></li>
        </ul>
    </nav>
<body>

<section class="nequi">
    <div class="tabla">
    <table class="table" >
        <thead>
                    <tr>
                            <td>Id</td>
                            <td>Bolsillo</td>
                            <td>Saldo</td>
                            <td>Estado</td>
                            <td>Actualizar</td>
                    </tr>
        </thead>
</thead>
<tbody class="tbody">
<c:forEach var="bolsillo" items="${bolsillos}">         
    <form method="POST" action="bolsillo">
        <tr>
                <td><input class="tablasid" type="number" name="idBolsillo" value="${bolsillo.getIdBolsillo()}" hidden><input value="${bolsillo.getIdBolsillo()}" disabled></td>
                <td><input class="tablas" type="text" name="nombreBolsillo" value="${bolsillo.getNombreBolsillo()}" hidden><input value="${bolsillo.getNombreBolsillo()}" disabled></td>
                <td><input class="tablas" type="text" name="saldo" value="${bolsillo.getSaldo()}" hidden><input value="${bolsillo.getSaldo()}" disabled></td>
                <td><input class="tablas" type="checkbox" name="estado" value="${bolsillo.getEstado()}" ></td>
                <td><button class="tablas" type="submit" name="accion" value="ActualizarBolDaviplata">Actualizar</button></td>
            </tr>
        </form>
</c:forEach>
</tbody>
</table>
</div>
</section>
</body>
</html>