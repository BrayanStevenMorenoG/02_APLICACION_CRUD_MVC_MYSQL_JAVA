package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BolsilloDAO{

    Connection con; 
    PreparedStatement ps;
    ResultSet rs; 
    String sql = null; 
    int r; 


    //registrar bolsillo
    public int registrarBol(BolsilloVO bolsillo)throws SQLException{

    sql = "insert into bolsillo (Nombre, Saldo, Estado) values (?,?,?)";

    try{
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, bolsillo.getNombre());
        ps.setDouble(2, bolsillo.getSaldo());
        ps.setBoolean(3, bolsillo.getEstado());

        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Insertado correctamente");
    } catch (Exception e){
        System.out.println("Error al registrar= "+e.getMessage().toString());
    } finally {
        con.close();
    }

        return r;

    }

    //Listar bolsillos
    public List<BolsilloVO> listarBol() throws SQLException{
        List<BolsilloVO> bolsillo = new ArrayList<>();
        sql = "select * from bolsillo";

        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            while(rs.next()){
                BolsilloVO listBol = new BolsilloVO();

                listBol.setIdBolsillo(rs.getInt("IdBolsillo"));
                listBol.setNombre(rs.getString("Nombre"));
                listBol.setSaldo(rs.getDouble("Saldo"));
                listBol.setEstado(rs.getBoolean("Estado"));

                bolsillo.add(listBol);
            }

            ps.close();

            System.out.println("Lista exitosa");

        } catch (Exception e){
            System.out.println("Error al listar "+e.getMessage().toString());
        } finally {
            con.close();
        }

        return bolsillo;

    }

    //Actualizar bolsillos
    public int actualizar(BolsilloVO bolsilloVO) throws SQLException{

        sql = "update bolsillo set Nombre=?,Saldo=?,Estado=? where IdBolsillo=?";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, bolsilloVO.getNombre());
            ps.setDouble(2, bolsilloVO.getSaldo());
            ps.setBoolean(3, bolsilloVO.getEstado());
            ps.setInt(4, bolsilloVO.getIdBolsillo());

            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Actualizado correctamente");

        } catch (Exception e){
            System.out.println("Error al actualizar= "+e.getMessage().toString());
        } finally{
            con.close();
        }

        return r;

    }

    //Metodo para recargar saldo
    public int recargar(double Recarga, int IdBolsillo) throws SQLException {
        String sql = "UPDATE bolsillo SET Saldo = Saldo + ? WHERE IdBolsillo = ?";
        int r = 0;
    
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, Recarga);
            ps.setInt(2, IdBolsillo);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    
        return r;
    }
    

    // Metodo para retirar saldo
    public int retirar(int IdBolsillo, double Retiro) throws SQLException {
        sql = "UPDATE bolsillo SET saldo = saldo - ? WHERE idBolsillo = ?";
        int filas = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.conectar(); 
            ps = con.prepareStatement(sql);
    
            double Saldo = valorSaldo(con, IdBolsillo);
            if (Saldo >= Retiro) {
                ps.setDouble(1, Retiro);
                ps.setInt(2, IdBolsillo);
                filas = ps.executeUpdate();
            } else {
              
                System.out.println("Saldo insuficiente para realizar el retiro.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    
        return filas;
    }

    //Metodo para optener el valor del saldo actual
    private double valorSaldo(Connection con, int idBolsillo) throws SQLException {
        String sql = "select saldo from bolsillo where IdBolsillo = ?";
        double Saldo = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idBolsillo);
            rs = ps.executeQuery();
    
            if (rs.next()) {
                Saldo = rs.getDouble("saldo");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    
        return Saldo;
    }

    //Metodo para consultar el saldo
    public double mostrarSaldo(BolsilloVO bolsilloVO) throws SQLException{


        sql = "select saldo from bolsillo where idBolsillo = ?";

        double saldo = 0;

        try {

            con = Conexion.conectar(); 
            ps = con.prepareStatement(sql);

            ps.setInt(1, bolsilloVO.getIdBolsillo());

            rs = ps.executeQuery();
    
            if (rs.next()) {                
                saldo = rs.getDouble("saldo");
            }

        } catch (Exception e) {

            System.out.println("ERROR"+e.getMessage().toString());

        } finally{

            try {
                if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (con != null) {
                con.close();
            }

            } catch (Exception e) {
                System.out.println("ERROR"+e.getMessage().toString());
            }
        } 
        return saldo;
    }

}

