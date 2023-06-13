package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioNequiDAO{
    
    /* Atributos para realizar operaciones sobre la BD */

    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public int registrar(UsuarioNequiVO usuario) throws SQLException{
        sql="insert into UsuarioNequi (nombreUsuario,apellidoUsuario,numero,contraseña) values (?,?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getApellidoUsuario());
            ps.setString(3, usuario.getNumero());
            ps.setString(4, usuario.getpassword());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el usuario correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public List<UsuarioNequiVO> listar() throws SQLException{
        List<UsuarioNequiVO> usaurios=new ArrayList<>();
        sql="select * from UsuarioNequi";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                UsuarioNequiVO ListNequi=new UsuarioNequiVO();
                //Escribir  en el setter cada valor encontrado
                ListNequi.setIdUsuario(rs.getInt("idUsuario"));
                ListNequi.setNombreUsuario(rs.getString("nombreUsuario"));
                ListNequi.setApellidoUsuario(rs.getString("apellidoUsuario"));
                ListNequi.setNumero(rs.getString("numero"));
                ListNequi.setpassword(rs.getString("contraseña"));

                usaurios.add(ListNequi);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("Error en la consulta"+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return usaurios;
    }

    public int actualizar(UsuarioNequiVO usuarioVO) throws SQLException{
        sql = "UPDATE usuarioNequi SET nombreUsuario=?, apellidoUsuario=?, numero=?, contraseña=? WHERE idUsuario=?";
        try {
            con = Conexion.conectar();
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, usuarioVO.getNombreUsuario());
            ps.setString(2, usuarioVO.getApellidoUsuario());
            ps.setString(3, usuarioVO.getNumero());
            ps.setString(4, usuarioVO.getpassword());
            ps.setInt(5, usuarioVO.getIdUsuario());

            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se actualizo correctamente");
        } catch(Exception e){
            System.out.println("Error al actualizar = "+e.getMessage());
        } finally {
            con.close();
        }
        return r;
    }

}