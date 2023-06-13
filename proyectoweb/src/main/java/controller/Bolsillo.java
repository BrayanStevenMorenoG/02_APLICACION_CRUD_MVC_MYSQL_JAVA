package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class Bolsillo extends HttpServlet{
    
    bolsilloVO bolsilloVO = new bolsilloVO();
    bolsilloDAO bolsilloDAO = new bolsilloDAO();    
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion=req.getParameter("accion");
        System.out.println(accion);
        switch (accion) {
            case "index":
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            break;
            case "volverNequi":
            req.getRequestDispatcher("views/inicioNequi.jsp").forward(req, resp);
            break;
            case "volverDaviplata":
            req.getRequestDispatcher("views/inicioDaviplata.jsp").forward(req, resp);
            break;
            case "RegistroBol":
            req.getRequestDispatcher("views/bolsillo-add.jsp").forward(req, resp);
            break;
            case "verBolNequi":
            listarBolNequi(req, resp);
            break;
            case "verBolDaviplata":
            listarBolDaviplata(req, resp);
            break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch(a){
            case "registrarBol":
            registrarBol(req, resp);
            break;
            case "ActualizarBolNequi":
            actualizarBolN(req, resp);
            listarBolNequi(req, resp);
            break;
            case "listarBolNequi":
            listarBolNequi(req, resp);
            break;
            case "ActualizarBolDaviplata":
            actualizarBolD(req, resp);
            listarBolDaviplata(req, resp);
            break;
            case "listarBolNequiDaviplata":
            listarBolDaviplata(req, resp);
            break;
    }
}

private void registrarBol(HttpServletRequest req, HttpServletResponse resp){

    if(req.getParameter("Bolsillo")!=null){
        bolsilloVO.setNombreBolsillo(req.getParameter("Bolsillo"));
    }
    if(req.getParameter("Saldo")!=null){
        bolsilloVO.setSaldo(Double.parseDouble(req.getParameter("Saldo")));
    }
    if(req.getParameter("Estado")!=null){
        bolsilloVO.setEstado(true);
    } else {
        bolsilloVO.setEstado(false);
    }
    try {
        bolsilloDAO.registrar(bolsilloVO);
        System.out.println("Registro insertado correctamente");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error en la inserción del registro "+e.getMessage().toString());
    }

}

private void listarBolNequi(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<bolsilloVO> bolsillo = bolsilloDAO.listarNequi();
        req.setAttribute("bolsillos", bolsillo);
        System.out.println("Datos listados correctamente");
        req.getRequestDispatcher("views/bolsilloNequi.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}

private void listarBolDaviplata(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<bolsilloVO> bolsillo = bolsilloDAO.listarDaviplata();
        req.setAttribute("bolsillos", bolsillo);
        System.out.println("Datos listados correctamente");
        req.getRequestDispatcher("views/bolsilloDaviplata.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}

private void actualizarBolN(HttpServletRequest req, HttpServletResponse resp){
    int idBolsillo = Integer.parseInt(req.getParameter("idBolsillo"));
    String nombreBolsillo = req.getParameter("nombreBolsillo");
    double saldo = Double.parseDouble(req.getParameter("saldo"));
    boolean estado = Boolean.parseBoolean(req.getParameter("estado"));

    try{
        bolsilloVO bolsilloVO = new bolsilloVO();

        bolsilloVO.setIdBolsillo(idBolsillo);
        bolsilloVO.setNombreBolsillo(nombreBolsillo);
        bolsilloVO.setSaldo(saldo);
        bolsilloVO.setEstado(estado);

        bolsilloDAO.actualizar(bolsilloVO);

        System.out.println("Actualizado");

        listarBolNequi(req, resp);

    } catch (Exception e) {
        System.out.println("Error al actualizar" +e.getMessage());
    }
}

private void actualizarBolD(HttpServletRequest req, HttpServletResponse resp){
    int idBolsillo = Integer.parseInt(req.getParameter("idBolsillo"));
    String nombreBolsillo = req.getParameter("nombreBolsillo");
    double saldo = Double.parseDouble(req.getParameter("saldo"));
    boolean estado = Boolean.parseBoolean(req.getParameter("estado"));

    try{
        bolsilloVO bolsilloVO = new bolsilloVO();

        bolsilloVO.setIdBolsillo(idBolsillo);
        bolsilloVO.setNombreBolsillo(nombreBolsillo);
        bolsilloVO.setSaldo(saldo);
        bolsilloVO.setEstado(estado);

        bolsilloDAO.actualizar(bolsilloVO);

        System.out.println("Actualizado");

        listarBolDaviplata(req, resp);

    } catch (Exception e) {
        System.out.println("Error al actualizar" +e.getMessage());
    }
}

}
