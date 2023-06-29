<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


<section class="listar">
    <table>
        <thead>
                    <tr>
                            <td>Id</td>
                            <td>Bolsillo</td>
                            <td>Saldo</td>
                            <td>Estado</td>
                            <td colspan="4">Acciones</td>
                    </tr>
        </thead>
</thead>
        <tbody>

            <c:forEach var="bolsillos" items="${bolsillos}">
                    <form action="bolsillo" method="post">
                        <tr>
                            <td><input type="text" class="tablasid" name="IdBolsillo" value="${bolsillos.getIdBolsillo()}"></td>
                            <td><input type="text" class="tablas" name="Nombre" value="${bolsillos.getNombre()}"></td>
                            <td><input type="text" class="tablas" name="Saldo" value="${bolsillos.getSaldo()}"></td>
                            <td><input type="text" class="tablas" name="Estado" value="${bolsillos.getEstado()}"></td>

                            <td><button class="boton2" name="accion" value="actualizarBol">Actualizar</button></td>
                            <!-- <td><button class="boton2" name="accion" value="recarga">Recargar</button></td> -->
                            <!-- <td><button class="boton2"><a href="bolsillo?accion=recarga&IdBolsillo">Recargar</a></button></td> -->
                            <td><button class="boton2" name="accion" value="bolsillo?accion=recargar&IdBolsillo=<c:out value='${bolsillo.IdBolsillo}'/>"></button></td>
                            <td><button class="boton2"><a href="bolsillo?accion=retirar&IdBolsillo">Retirar</a></button></td>

                            <input type="hidden" name="idBolsillo" value="${bolsillos.getIdBolsillo()}">
                            <td><button class="boton2" type="submit" name="accion" value="saldo">Consultar</button></td>
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