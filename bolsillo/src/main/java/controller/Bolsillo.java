package controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class Bolsillo extends HttpServlet{
    
    BolsilloVO bolsilloVO = new BolsilloVO();
    BolsilloDAO bolsilloDAO = new BolsilloDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vistas = req.getParameter("accion");
        System.out.println(vistas);
    
        switch (vistas) {
            case "bolsillos":
            // req.getRequestDispatcher("views/bolsillo/bolsillo.jsp").forward(req, resp);
            listar(req, resp);
                break;
            case "bolsillos-add":
            req.getRequestDispatcher("views/bolsillo/bolsillo-add.jsp").forward(req, resp);
                break; 
            case "saldo":
            saldo(req, resp);
                break;
            case "recarga":
            String IdBolsillo = req.getParameter("idBolsillo");
                if (IdBolsillo != null && !IdBolsillo.isEmpty()) {
                    int idBolsillo = Integer.parseInt(IdBolsillo);
                    req.setAttribute("idBolsillo", idBolsillo);
                }
                req.getRequestDispatcher("views/bolsillo/recargar.jsp").forward(req, resp);
                break;
            case "retirar":
            String IdBolsillo2 = req.getParameter("IdBolsillo");
            if (IdBolsillo2 != null && !IdBolsillo2.isEmpty()) {
                int IdBolsilloo = Integer.parseInt(IdBolsillo2);
                req.setAttribute("IdBolsillo", IdBolsilloo);
            }
            req.getRequestDispatcher("views/bolsillo/retirar.jsp");

        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String metodos = req.getParameter("accion");
        System.out.println("Entro al Dopost");
    
        switch (metodos) {
            case "registrarBol":
                registrarBol(req, resp);
                break;
            case "actualizarBol":
                actualizarBol(req, resp);
                listar(req, resp);
                break;
            case "saldo":
                saldo(req, resp);
                break;
            case "recarga":
                recarga(req, resp);
                break; 
            case "retirar":
                retirar(req, resp);
                break; 
        }
    }

    private void registrarBol(HttpServletRequest req, HttpServletResponse res){
        
        bolsilloVO.setNombre(req.getParameter("Nombre"));
        bolsilloVO.setSaldo(Double.parseDouble( req.getParameter("Saldo")));
        if (req.getParameter("Estado") != null){
            bolsilloVO.setEstado(true);
        } else {
            bolsilloVO.setEstado(false);
        }

        try{
            bolsilloDAO.registrarBol(bolsilloVO);
            System.out.println("Registro insertado correctamente");

            listar(req, res);

        } catch (Exception e){
            System.out.println("Error al registrar");
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse res){
        try {
            List<BolsilloVO> bolsillo = bolsilloDAO.listarBol();
            req.setAttribute("bolsillos", bolsillo);
            System.out.println("Datos listados correctamente");
            req.getRequestDispatcher("views/bolsillo/bolsillo.jsp").forward(req, res);
        }catch (Exception e){
            System.out.println("Error al listar= "+e.getMessage().toString());
        } 
    }

    private void actualizarBol(HttpServletRequest req, HttpServletResponse res){

        int IdBolsillo = Integer.parseInt(req.getParameter("IdBolsillo"));
        String Nombre = req.getParameter("Nombre");
        Double Saldo = Double.parseDouble(req.getParameter("Saldo"));
        Boolean Estado = (true);

    try{
        bolsilloVO.setIdBolsillo(IdBolsillo);
        bolsilloVO.setNombre(Nombre);
        bolsilloVO.setSaldo(Saldo);
        bolsilloVO.setEstado(Estado);

        bolsilloDAO.actualizar(bolsilloVO);

        System.out.println("Actualizado correctamente");

        listar(req, res);

    } catch (Exception e){
        System.out.println("Error al actualizar "+e.getMessage().toString());
    }

    }

    public void recarga(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 
        int IdBolsillo = Integer.parseInt(req.getParameter("IdBolsillo"));
        double Recarga = Double.parseDouble(req.getParameter("Recarga"));


        try {
            req.getRequestDispatcher("views/listaBolsillo.jsp").forward(req, resp);
            bolsilloDAO.recargar(Recarga, IdBolsillo);
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        req.getRequestDispatcher("views/listaBolsillo.jsp").forward(req, resp);

    }

    public void retirar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 
        int idBolsillo = Integer.parseInt(req.getParameter("IdBolsillo"));
        double valorRetiro = Double.parseDouble(req.getParameter("Retiro"));


        try {
            
            bolsilloDAO.retirar(idBolsillo, valorRetiro);
            listar(req, resp);

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage().toString());
        }
        
        req.getRequestDispatcher("views/bolsillo/bolsillo.jsp").forward(req, resp);

    }

    public void saldo(HttpServletRequest req, HttpServletResponse res){

        int idBolsillo = Integer.parseInt(req.getParameter("idBolsillo"));
    
        try { 
            bolsilloVO.setIdBolsillo(idBolsillo);    
            double saldo = bolsilloDAO.mostrarSaldo(bolsilloVO);    
            req.setAttribute("saldo", saldo);
            req.getRequestDispatcher("views/bolsillo/saldo.jsp").forward(req, res);
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage().toString());
        }

    }

}
