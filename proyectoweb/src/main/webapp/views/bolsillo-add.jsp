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
        <h1 class="titulo">CREAR BOLSILLO</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
<body>

<section class="nequi">

    <center><h1 class="titulo">Cree su bolsillo</h1>
        <br>
        <h1 class="titulo">Daviplata/Nequi</h1>
    <br>
<form action="bolsillo" method="post">

    <select class="formulario" name="Bolsillo" required>
        <option name="Bolsillo" value="Nequi">Nequi</option>
        <option name="Bolsillo" value="Daviplata">Daviplata</option>
    </select>

    <!-- <input type="text" class="formulario" name="Bolsillo" placeholder="Bolsillo"> -->

    <input class="formulario" type="number" name="Saldo" disabled placeholder="Saldo - Su saldo sera $0">

    <label class="texto" for="Estado">Activo</label>
    <input class="formulario" type="checkbox" name="Estado" required>

    <button type="submit" class="boton" name="accion" value="registrarBol">Registrar</button>
</form>
</center>

</section>

</body>
</html>