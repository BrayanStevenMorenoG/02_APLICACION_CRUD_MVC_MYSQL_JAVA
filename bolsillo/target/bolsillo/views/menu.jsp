<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bolsillos digitales</title>
    <link rel="stylesheet" href="assets/css/Estilos.css">
</head>
<body>
    <header class="header">
        <div class="logo">
            <a href= "usuario?accion=index"><img src="assets/img/logo.png" alt="Logo marca"></a>
        </div>
        <h1 class="titulo">BIENVENIDO A BOLSILLOS DIGITALES</h1>
        <a href="#" class="btn"><button>Contacto</button></a>
    </header>
    <nav class="nav">
        <ul class="nav-links">
            <li class="dropdown"><a href= "#">Usuario</a>
                <ul class="dropdown-menu">
                    <li><a href= "usuario?accion=usuarios-add">Registrar usuario</a></li>
                    <li><a href= "usuario?accion=usuarios">Consultar usuarios</a></li> 
                </ul>
            </li>
            <li class="dropdown"><a href= "#">Bolsillo</a>
                <ul class="dropdown-menu">
                    <li><a href= "bolsillo?accion=bolsillos-add">Crear bolsillo</a></li>
                    <li><a href= "bolsillo?accion=bolsillos">Consultar bolsillos</a></li> 
                </ul>
            </li>
        </ul>
    </nav>

    <section class="contenido2">
        <div class="contenido11">
        <section class="contenido-section1">
            <center><img src="assets/img/nequi-logo.png" alt="Nequi logo" class="imagen2"></center>
            <br>
            <p class="texto">La palabra Nequi significa: compañero de viaje.</p>
            <p class="texto">Nequi es una plataforma financiera 100% digital, que busca que tengas una mejor relación con tu plata para que logres lo que quieres con ella. </p>
            <p class="texto">Tu Nequi es un depósito de bajo monto sin cuota de manejo o comisiones. Para abrirlo solo necesitas 5 minutos, conexión a Internet y tu cédula, tarjeta de identidad o cédula de extranjería. El número de tu Nequi es el mismo de tu cel.</p>
            <p class="texto">Nequi es el primer neobanco de Colombia, la encuentras en Play Store, App Store y App Gallery.</p>
        </section>
        </div>
    
        <div class="contenido11">
        <section class="contenido-section1">
            <center><img src="assets/img/daviplata-logo.png" alt="Daviplata logo" class="imagen2"></center>
            <p class="texto">DaviPlata es un producto que le permite manejar de forma fácil y gratis la plata desde su celular sin necesidad de tener una cuenta bancaria o tarjeta débito.</p>
            <p class="texto">Una vez activado el celular con DaviPlata se puede recibir y enviar dinero desde otros celulares con DaviPlata y cuentas de Davivienda, recibir giros internacionales, recibir consignaciones en efectivo en oficinas de servicio de Davivienda, pagar servicios públicos, recargar minutos celulares del mismo operador y/o retirar plata en los cajeros automáticos de la red de Davivienda.</p>
            <p class="texto">Es un depósito a la vista, diferente a la cuenta de ahorros y corriente, ofrecido por Davivienda a personas naturales, el cual se regirá por las disposiciones legales vigentes aplicables y por el contrato del producto.</p>
        </section>
        </div>
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