<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <h1 class="titulo">RECARGA A NEQUI</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
    <nav class="nav">
        <ul class="nav-links">
            <li><a href= "usuario?accion=volverNequi">Volver</a></li>
        </ul>
    </nav>

    <section class="formularios">
        <section class="recargar">
            <center><img src="assets/img/nequi-logo.png" alt="Nequi logo" class="imagen2"></center>
        <form action="usuario" method="post">
            <input class="formulario" type="number" name="recarga" placeholder="Ingrese la cantidad de dinero que desea recargar">
            <button class="boton" type="submit" name="accion" value="Recarga Nequi">Recargar</button>
            
        </form>
            </section>
    </section>

<br><br><br>

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