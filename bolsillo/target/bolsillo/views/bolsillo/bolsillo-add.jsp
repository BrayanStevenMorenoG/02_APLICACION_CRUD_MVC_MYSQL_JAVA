<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bolsillos</title>
    <link rel="stylesheet" href="assets/css/Estilos.css">
</head>
<body>

    <header class="header">
        <div class="logo">
            <a href= "usuario?accion=index"><img src="assets/img/logo.png" alt="Logo marca"></a>
        </div>
        <h1 class="titulo">BOLSILLOS</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
    <nav class="nav">
        <ul class="nav-links">
            <li><a href= "usuario?accion=entrar">Volver</a></li>
        </ul>
    </nav>

<section class="form">

<h1 class="titulo">Cree un bolsillo</h1><br>

    <form action="bolsillo" method="post">

        <!-- <input type="text" name="Nombre" class="formulario" placeholder="Ingrese el bolsillo"> -->
        <select class="formulario" name="Nombre">
            <option name="Nombre" value="Nequi">Nequi</option>
            <option name="Nombre" value="Daviplata">Daviplata</option>
        </select>
        <input type="text" name="Saldo" class="formulario" value="0" placeholder="Su saldo sera 0">
        <input type="checkbox" name="Estado">

        <button class="boton" name="accion" value="registrarBol">Confirmar</button>

    </form>

</section>


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