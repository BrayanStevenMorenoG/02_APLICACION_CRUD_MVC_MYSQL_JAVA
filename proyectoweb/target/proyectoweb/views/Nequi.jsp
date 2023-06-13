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
        <h1 class="titulo">BIENVENIDO A NEQUI</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>

    <section class="formularios">
    <section class="ingresar">
        <center><h1 class="titulo">INICIAR SESIÓN</h1>
    <!-- <form action="usuario" method="post"> -->
        <input class="formulario" type="text" name="celular" placeholder="Ingrese su numero de celular">
        <input class="formulario" type="password" name="contra" placeholder="Ingrese su contraseña">
        <br><br>
        <!-- <button class="boton" type="submit" name="accion" value="Ingresar Nequi">Ingresar</button> -->
        <a style="color: black;" class="boton" href="usuario?accion=ingresarNequi">Ingresar</a>
        
        <!-- <button class="boton" href="usuario?accion=ingresarNequi">Ingresar</button> -->
    <!-- </form> --> 
    <a style="color: black;" class="boton" href="usuario?accion=RegistroUsuNequi">Registrarse</a>
    <!-- <button class="boton" href="usuario?accion=RegistroUsu">Registrar</button> -->
    </center>
    </section>

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