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
        <h1 class="titulo">CONSULTA EN NEQUI</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
    <nav class="nav">
        <ul class="nav-links">
            <li><a href= "usuario?accion=Daviplata">Volver</a></li>
        </ul>
    </nav>
<body>

<section class="nequi">

    <center><h1 class="titulo">Registro de Usuarios Daviplata</h1></center>
    <br>
<form action="usuario" method="post">

    <!-- <label for="">Nombre</label> -->
    <input class="formulario" type="text"  name="nombre" required placeholder="Ingrese su nombre">
    <!-- <label for="">Apellido</label> -->
    <input class="formulario" type="text" name="apellido" required placeholder="Ingrese su apellido">
    <!-- <label for="">Cedula</label> -->
    <input class="formulario" type="number" name="cedula" required placeholder="Ingrese su cedula">
    <!-- <label for="">Contraseña</label> -->
    <input class="formulario" type="password" name="password" required placeholder="Cree su contraseña">

    <button type="submit" class="boton" name="accion" value="registrarDaviplata">Registrar</button>
</form>

</section>

</body>
</html>