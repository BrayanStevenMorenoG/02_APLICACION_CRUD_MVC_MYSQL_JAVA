package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bolsilloDAO {
    
    /* Atributos para realizar operaciones sobre la BD */

    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public int registrar(bolsilloVO usuario) throws SQLException{
        sql = "insert into bolsillo (nombreBolsillo,saldo,estado) values (?,?,?)";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombreBolsillo());
            ps.setDouble(2, 0);
            ps.setBoolean(3, usuario.getEstado());

            ps.executeUpdate();
            System.out.println(ps);

            ps.close();

            System.out.println("Se registro el bolsillo correctamente");

        } catch(Exception e) {
            System.out.println("Error al registrar bolsillo = "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;   
    }

    public List<bolsilloVO> listarNequi() throws SQLException{
        List<bolsilloVO> bolsillos = new ArrayList<>();
        sql = "select * from bolsillo where nombreBolsillo='Nequi'";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                bolsilloVO listBolsillo = new bolsilloVO();

                listBolsillo.setIdBolsillo(rs.getInt("idBolsillo"));
                listBolsillo.setNombreBolsillo(rs.getString("nombreBolsillo"));
                listBolsillo.setSaldo(rs.getDouble("saldo"));
                listBolsillo.setEstado(rs.getBoolean("estado"));

                bolsillos.add(listBolsillo);
            }

            ps.close();

            System.out.println("Consulta exitosa");

        } catch (Exception e){
            System.out.println("Error en la consulta = "+e.getMessage().toString());
        }finally{
            con.close();
        }

        return bolsillos;

    }

    public List<bolsilloVO> listarDaviplata() throws SQLException{
        List<bolsilloVO> bolsillos = new ArrayList<>();
        sql = "select * from bolsillo where nombreBolsillo='Daviplata'";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                bolsilloVO listBolsillo = new bolsilloVO();

                listBolsillo.setIdBolsillo(rs.getInt("idBolsillo"));
                listBolsillo.setNombreBolsillo(rs.getString("nombreBolsillo"));
                listBolsillo.setSaldo(rs.getDouble("saldo"));
                listBolsillo.setEstado(rs.getBoolean("estado"));

                bolsillos.add(listBolsillo);
            }

            ps.close();

            System.out.println("Consulta exitosa");

        } catch (Exception e){
            System.out.println("Error en la consulta = "+e.getMessage().toString());
        }finally{
            con.close();
        }

        return bolsillos;

    }
    
    public int actualizar(bolsilloVO bolsilloVO) throws SQLException{
        sql = "update bolsillo set nombreBolsillo=?, saldo=?, Estado=? WHERE idBolsillo=?";
    
    try{
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, bolsilloVO.getNombreBolsillo());
        ps.setDouble(2, bolsilloVO.getSaldo());
        ps.setBoolean(3, bolsilloVO.getEstado());
        ps.setInt(4, bolsilloVO.getIdBolsillo());

        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se actualizo correctamente");

    } catch(Exception e) {
        System.out.println("Error al actualizar "+e.getMessage());
    } finally {
        con.close();
    }
    return r;
}

}
