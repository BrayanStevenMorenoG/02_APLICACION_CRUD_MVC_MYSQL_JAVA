package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;



public class Usuario extends HttpServlet{
    
    UsuarioNequiVO usuarioNequiVO = new UsuarioNequiVO();
    UsuarioNequiDAO usuarioNequiDAO = new UsuarioNequiDAO();
    UsuarioDaviplataVO usuarioDaviplataVO = new UsuarioDaviplataVO();
    UsuarioDaviplataDAO usuarioDaviplataDAO = new UsuarioDaviplataDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion=req.getParameter("accion");
        System.out.println(accion);
        switch (accion) {
            case "ingresarNequi":
            req.getRequestDispatcher("views/inicioNequi.jsp").forward(req, resp);
                break;
            case "ingresarDaviplata":
            req.getRequestDispatcher("views/inicioDaviplata.jsp").forward(req, resp);
                break;
            case "Nequi":
            req.getRequestDispatcher("views/Nequi.jsp").forward(req, resp);
                break;
            case "Daviplata":
            req.getRequestDispatcher("views/Daviplata.jsp").forward(req, resp);
                break;
            case "recargaNequi":
            req.getRequestDispatcher("views/recargaNequi.jsp").forward(req, resp);
                break;
            case "recargaDaviplata":
            req.getRequestDispatcher("views/recargaDaviplata.jsp").forward(req, resp);
                break;
            case "retiroNequi":
            req.getRequestDispatcher("views/retiroNequi.jsp").forward(req, resp);
                break;
            case "retiroDaviplata":
            req.getRequestDispatcher("views/retiroDaviplata.jsp").forward(req, resp);
                break;
            case "consultarNequi":
            req.getRequestDispatcher("views/consultarNequi.jsp").forward(req, resp);
                break;
            case "consultarDaviplata":
            req.getRequestDispatcher("views/consultarDaviplata.jsp").forward(req, resp);
                break;
            case "index":
            req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "volverNequi":
            req.getRequestDispatcher("views/inicioNequi.jsp").forward(req, resp);
                break;
            case "volverDaviplata":
            req.getRequestDispatcher("views/inicioDaviplata.jsp").forward(req, resp);
                break;
            case "RegistroUsuNequi":
            req.getRequestDispatcher("views/usuarioNequi-add.jsp").forward(req, resp);
            break;
            case "verUsuNequi":
            listarUsuNequi(req, resp);
            break;
            case "RegistroBol":
            req.getRequestDispatcher("views/bolsillo-add.jsp").forward(req, resp);
            break;
            case "RegistroUsuDaviplata":
            req.getRequestDispatcher("views/usuarioDaviplata-add.jsp").forward(req, resp);
            break;
            case "verUsuDaviplata":
            listarUsuDaviplata(req, resp);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch(a){
            case "registrarUsuNequi":
            registrarUsuNequi(req,resp);
            break;
            case "registrarDaviplata":
            registrarUsuDaviplata(req,resp);
            break;
            case "ActualizarUsuNequi":
            actualizarUsuNequi(req, resp);
            listarUsuNequi(req, resp);
            break;
            case "ActualizarUsuDaviplata":
            actualizarUsuDaviplata(req, resp);
            listarUsuDaviplata(req, resp);
            break;
            case "ListarNequi":
            listarUsuNequi(req,resp);
            break;
            case "ListarDaviplata":
            listarUsuDaviplata(req,resp);
            break;
    }
}
    private void registrarUsuNequi(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombre")!=null){
            usuarioNequiVO.setNombreUsuario(req.getParameter("nombre"));
        }
        if(req.getParameter("apellido")!=null){
            usuarioNequiVO.setApellidoUsuario(req.getParameter("apellido"));
        }
        if(req.getParameter("numero")!=null){
            usuarioNequiVO.setNumero(req.getParameter("numero"));
        }
        if(req.getParameter("password")!=null){
            usuarioNequiVO.setpassword(req.getParameter("password"));
        }
        try {
            usuarioNequiDAO.registrar(usuarioNequiVO);
            System.out.println("Registro insertado correctamente");
            req.getRequestDispatcher("views/inicioNequi.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listarUsuNequi(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<UsuarioNequiVO> usuarios=usuarioNequiDAO.listar();
            req.setAttribute("usuarios", usuarios);
            System.out.println("Datos listados correctamente");
            req.getRequestDispatcher("views/usuarioNequi.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
}

    private void actualizarUsuNequi(HttpServletRequest req, HttpServletResponse resp){
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        String nombreUsuario = req.getParameter("nombreUsuario");
        String apellidoUsuario = req.getParameter("apellidoApellido");
        String numero = req.getParameter("numero");
        String password = req.getParameter("password");

        try{
            usuarioNequiVO.setIdUsuario(idUsuario);
            usuarioNequiVO.setNombreUsuario(nombreUsuario);
            usuarioNequiVO.setApellidoUsuario(apellidoUsuario);
            usuarioNequiVO.setNumero(numero);
            usuarioNequiVO.setpassword(password);

            usuarioNequiDAO.actualizar(usuarioNequiVO);

            System.out.println("actualizado");

            listarUsuNequi(req, resp);

        }catch(Exception e){
            System.out.println("Error al actualizar = "+ e.getMessage());
        }
    }

    private void registrarUsuDaviplata(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("nombre")!=null){
            usuarioDaviplataVO.setNombreUsuario(req.getParameter("nombre"));
        }
        if(req.getParameter("apellido")!=null){
            usuarioDaviplataVO.setApellidoUsuario(req.getParameter("apellido"));
        }
        if(req.getParameter("cedula")!=null){
            usuarioDaviplataVO.setCedula(req.getParameter("cedula"));
        }
        if(req.getParameter("password")!=null){
            usuarioDaviplataVO.setPassword(req.getParameter("password"));
        }
        try {
            usuarioDaviplataDAO.registrar(usuarioDaviplataVO);
            System.out.println("Registro insertado correctamente");
            req.getRequestDispatcher("views/inicioDaviplata.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listarUsuDaviplata(HttpServletRequest req, HttpServletResponse resp){
        try {
            List<UsuarioDaviplataVO> usuarios=usuarioDaviplataDAO.listar();
            req.setAttribute("usuarios", usuarios);
            System.out.println("Datos listados correctamente");
            req.getRequestDispatcher("views/usuarioDaviplata.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void actualizarUsuDaviplata(HttpServletRequest req, HttpServletResponse resp){
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        String nombreUsuario = req.getParameter("nombreUsuario");
        String apellidoUsuario = req.getParameter("apellidoApellido");
        String cedula = req.getParameter("cedula");
        String password = req.getParameter("password");

        try{
            usuarioDaviplataVO.setIdUsuario(idUsuario);
            usuarioDaviplataVO.setNombreUsuario(nombreUsuario);
            usuarioDaviplataVO.setApellidoUsuario(apellidoUsuario);
            usuarioDaviplataVO.setCedula(cedula);
            usuarioDaviplataVO.setPassword(password);

            usuarioDaviplataDAO.actualizar(usuarioDaviplataVO);

            System.out.println("actualizado");

            listarUsuDaviplata(req, resp);

        }catch(Exception e){
            System.out.println("Error al actualizar = "+ e.getMessage());
        }
    }

}