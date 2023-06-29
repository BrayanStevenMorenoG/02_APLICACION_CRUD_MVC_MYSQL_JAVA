<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
    <link rel="stylesheet" href="assets/css/Estilos.css">
</head>
<body>

    <header class="header">
        <div class="logo">
            <a href= "usuario?accion=index"><img src="assets/img/logo.png" alt="Logo marca"></a>
        </div>
        <h1 class="titulo">USUARIOS</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
    <nav class="nav">
        <ul class="nav-links">
            <li><a href= "usuario?accion=entrar">Volver</a></li>
        </ul>
    </nav>

<section class="form">

<h1 class="titulo">Cree su usuario</h1><br>

    <form action="usuario" method="post">

        <input type="text" name="Nombre" class="formulario" placeholder="Ingrese su nombre">
        <input type="text" name="Apellido" class="formulario" placeholder="Ingrese su apellido">
        <input type="text" name="Usuario" class="formulario" placeholder="Ingrese nombre de usuario">
        <input type="text" name="Contrasena" class="formulario" placeholder="Ingrese contraseña">
        <input type="checkbox" name="Estado">

        <button class="boton" name="accion" value="registrarUsu">Confirmar</button>

    </form>

</section>

<p>
<% String error = (String) request.getAttribute("Error"); %>
<% if (error != null) { %>
  <p class="error"><%= error %></p>
<% } %>
</p>


<footer class="footer">
    <center>
    <P> 
    <p><b>Correo:</b>brasmoreno5@soy.sena.com</p>
      <br>
    <p><b>Celular:</b> 123456789</p>
      <br>
    <b> Copyright &copy; 2023 - BOGOTÁ</b>
</center>
</footer>

</body>
</html>