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


<section class="listar">
    <table>
        <thead>
                    <tr>
                            <td>Id</td>
                            <td>Nombre</td>
                            <td>Apellido</td>
                            <td>Usuario</td>
                            <td>Contraseña</td>
                            <td>Estado</td>
                            <td>Actualizar</td>
                    </tr>
        </thead>
</thead>
        <tbody>
            <c:forEach var="usuarios" items="${usuarios}">         
                <form action="usuario" method="post">
                        <tr>
                            <td><input type="text" class="tablasid" name="Idusuario" value="${usuarios.getIdUsuario()}"></td>
                            <td><input type="text" class="tablas" name="Nombre" value="${usuarios.getNombre()}"></td>
                            <td><input type="text" class="tablas" name="Apellido" value="${usuarios.getApellido()}"></td>
                            <td><input type="text" class="tablas" name="Usuario" value="${usuarios.getUsuario()}"></td>
                            <td><input type="text" class="tablas" name="Contrasena" value="${usuarios.getContrasena()}"></td>
                            <td><input type="text" class="tablas" name="Estado" value="${usuarios.getEstado()}"></td>

                            <td><button class="boton2" name="accion" value="actualizarUsu">Actualizar</button></td>
                        </tr>
                    </form>
            </c:forEach>
        </tbody> 
</table>
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