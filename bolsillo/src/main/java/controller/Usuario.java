package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class Usuario extends HttpServlet{

    UsuarioVO usuarioVO = new UsuarioVO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vistas=req.getParameter("accion");
        System.out.println(vistas);
        switch (vistas) {
            case "index":
            req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "ingresar":
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
            case "usuarios-add":
            req.getRequestDispatcher("views/usuario/usuario-add.jsp").forward(req, resp);
                break;            
            case "usuarios":
            // req.getRequestDispatcher("views/usuario/usuario.jsp").forward(req, resp);
            listar(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String metodos=req.getParameter("accion");
        System.out.println("Entro al Dopost");

        switch(metodos){
            case "registrarUsu":
                registrarUsu(req, resp);
            break; 
            case "actualizarUsu":
                actualizar(req, resp);
                listar(req, resp);
            break; 
            case "entrar":
            login(req, resp);
            break;
        }

    }

    private void registrarUsu(HttpServletRequest req, HttpServletResponse res){

        if(req.getParameter("Nombre") != null){
            usuarioVO.setNombre(req.getParameter("Nombre"));
        }
        if(req.getParameter("Apellido") != null){
        usuarioVO.setApellido(req.getParameter("Apellido"));
        }
        if(req.getParameter("Usuario") != null){
        usuarioVO.setUsuario(req.getParameter("Usuario"));
        }
        if(req.getParameter("Contrasena") != null){
        usuarioVO.setContrasena(req.getParameter("Contrasena"));
        }if(req.getParameter("Estado") != null){
        usuarioVO.setEstado(true);
        } else {
        usuarioVO.setEstado(false);
        }

        try {
            usuarioDAO.registrarUsu(usuarioVO);
            System.out.println("Registro insertado correctemente");
            listar(req, res);
        } catch (Exception e){
            System.out.println("Error al registrar");
        }

    }

    private void listar(HttpServletRequest req, HttpServletResponse res){
        try {
            List<UsuarioVO> usuario = usuarioDAO.listarUsu();
            req.setAttribute("usuarios", usuario);
            System.out.println("Datos listados correctamente");
            req.getRequestDispatcher("views/usuario/usuario.jsp").forward(req, res);
        } catch (Exception e){
            System.out.println("Error al lista = "+e.getMessage().toString());
        }
    }

    private void actualizar(HttpServletRequest req, HttpServletResponse res){

        int IdUsuario = Integer.parseInt(req.getParameter("Idusuario"));
        String Nombre = req.getParameter("Nombre");
        String Apellido = req.getParameter("Apellido");
        String Usuario = req.getParameter("Usuario");
        String Contrasena = req.getParameter("Contrasena");
        Boolean Estado = (true);

    try{
        usuarioVO.setIdUsuario(IdUsuario);
        usuarioVO.setNombre(Nombre);
        usuarioVO.setApellido(Apellido);
        usuarioVO.setUsuario(Usuario);
        usuarioVO.setContrasena(Contrasena);
        usuarioVO.setEstado(Estado);

        usuarioDAO.actualizar(usuarioVO);

        System.out.println("Actualizado correctamente");

        listar(req, res);

    } catch (Exception e){
        System.out.println("Error al actualziar= "+e.getMessage().toString());
    }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) {
        String usuario = req.getParameter("Usuario");
        String contrasena = req.getParameter("Contrasena");
        usuarioVO.setUsuario(usuario);
        usuarioVO.setContrasena(contrasena);
    
        try {
            int resultado = usuarioDAO.iniciarSesion(usuarioVO);
            if (resultado == 1) {
                req.getRequestDispatcher("views/menu.jsp").forward(req, resp);
            } else {
                req.setAttribute("Error", "Datos erróneos, verifique e inténtelo nuevamente");
                req.getRequestDispatcher("views/login.jsp").forward(req, resp);                
            }
        } catch (SQLException | ServletException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}