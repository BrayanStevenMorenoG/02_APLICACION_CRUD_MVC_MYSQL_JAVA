<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Daviplata</title>
    <link rel="stylesheet" href="assets/css/Estilos.css">
</head>
<body>

    <header class="header">
        <div class="logo">
            <a href= "usuario?accion=index"><img src="assets/img/logo.png" alt="Logo marca"></a>
        </div>
        <h1 class="titulo">BIENVENIDO A DAVIPLATA</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>

    <section class="formularios">
    <section class="ingresar">
        <center><h1 class="titulo">INICIAR SESIÓN</h1>
    <!-- <form action="usuario" method="post"> -->
        <input class="formulario" type="text" name="cedula" placeholder="Ingrese su cedula">
        <input class="formulario" type="password" name="contra"placeholder="Ingrese su contraseña">
        <br><br>
        <!-- <center><a class="entrar" href= "bolsillo?accion=ingresarDaviplata"> Ingresar </a></center> -->
        <!-- <button class="boton" type="submit" name="accion" value="Ingresar Daviplata">Ingresar</button> -->
        <a style="color: black;" class="boton" href="usuario?accion=ingresarDaviplata">Ingresar</a>
        <a style="color: black;" class="boton" href="usuario?accion=RegistroUsuDaviplata">Registrarse</a>
    </center>

    <!-- </form> -->
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