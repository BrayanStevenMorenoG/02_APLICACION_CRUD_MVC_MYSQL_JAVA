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
            <a href= "usuario?accion=index"><img src="assets/img/logo.png" alt="Logo marca"></a>
        </div>
        <h1 class="titulo">USUARIOS NEQUI</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
    <nav class="nav">
        <ul class="nav-links">
            <li><a href= "usuario?accion=volverNequi">Volver</a></li>
        </ul>
    </nav>
<body>

<section class="nequi">
    <div class="tabla">
    <table class="table" >
        <thead>
                    <tr>
                            <td>Id</td>
                            <td>Nombres</td>
                            <td>Apellidos</td>
                            <td>Numero</td>
                            <td>Contraseña</td>
                            <td>Actualizar</td>
                    </tr>
        </thead>
</thead>
<tbody class="tbody">
<c:forEach var="usuarios" items="${usuarios}">         
    <form method="POST" action="usuario">
            <tr>
                <td><input class="tablasid" type="number" name="idUsuario"  value="${usuarios.getIdUsuario()}" hidden><input value="${usuarios.getIdUsuario()}" disabled></td>
                <td><input class="tablas" type="text" name="nombreUsuario"  value="${usuarios.getNombreUsuario()}"></td>
                <td><input class="tablas" type="text" name="apellidoApellido"  value="${usuarios.getApellidoUsuario()}"></td>
                <td><input class="tablas" type="text" name="numero"  value="${usuarios.getNumero()}"></td>
                <td><input class="tablas" type="password" name="password"  value="${usuarios.getpassword()}"></td>
                <td><button class="tablas" type="submit" name="accion" value="ActualizarUsuNequi">Actualizar</button></td>
            </tr>
        </form>
</c:forEach>
</tbody>
</table>
</div>
</section>
</body>
</html>