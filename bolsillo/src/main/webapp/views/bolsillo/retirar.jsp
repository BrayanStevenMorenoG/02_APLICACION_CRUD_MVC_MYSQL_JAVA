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
        <h1 class="titulo">BOLSILLO</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
    <nav class="nav">
        <ul class="nav-links">
            <li><a href= "usuario?accion=entrar">Volver</a></li>
        </ul>
    </nav>

    <section class="form">

    <form action="bolsillo" method="post">

        <input type="hidden" class="formulario" name="IdBolsillo" value="${IdBolsillo}">

        <input type="number" class="formulario"  name="Retiro" placeholder="Cuanto desea retirar?">

        <button class="boton" type="submit" name="accion" value="retirar">Retirar</button>

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