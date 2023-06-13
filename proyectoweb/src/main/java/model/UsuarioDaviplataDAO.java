package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaviplataDAO {
    
    Connection con; 
    PreparedStatement ps;
    ResultSet rs; 
    String sql;
    int r; 

    public int registrar(UsuarioDaviplataVO usuario) throws SQLException{
        sql = "insert into UsuarioDaviplata (nombreUsuario,apellidoUsuario,cedula,contraseña) values (?,?,?,?)";
        try{
            con=Conexion.conectar();
            ps= con.prepareStatement(sql);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getApellidoUsuario());
            ps.setString(3, usuario.getCedula());
            ps.setString(4, usuario.getPassword());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro el usuario correctamente");
        } catch (Exception e){
            System.out.println("Error en el registro "+e.getMessage().toString());
        } finally {
            con.close();
        }
        return r;
    }

    public List<UsuarioDaviplataVO> listar() throws SQLException{
        List<UsuarioDaviplataVO> usuarios = new ArrayList<>();
        sql = "select * from UsuarioDaviplata";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                UsuarioDaviplataVO ListDaviplata = new UsuarioDaviplataVO();
                ListDaviplata.setIdUsuario(rs.getInt("idUsuario"));
                ListDaviplata.setNombreUsuario(rs.getString("nombreUsuario"));
                ListDaviplata.setApellidoUsuario(rs.getString("apellidoUsuario"));
                ListDaviplata.setCedula(rs.getString("cedula"));
                ListDaviplata.setPassword(rs.getString("contraseña"));

                usuarios.add(ListDaviplata);            
            }
            ps.close();
            System.out.println("Consulta exitosa");
        } catch (Exception e){
            System.out.println("Error en la consulta "+e.getMessage().toString());
        } finally {
            con.close();
        }

        return usuarios;
    }

    public int actualizar(UsuarioDaviplataVO usuarioDaviplataVO) throws SQLException{
        sql = "UPDATE usuarioDaviplata SET nombreUsuario=?, apellidoUsuario=?, cedula=?, contraseña=? WHERE idUsuario=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuarioDaviplataVO.getNombreUsuario());
            ps.setString(2, usuarioDaviplataVO.getApellidoUsuario());
            ps.setString(3, usuarioDaviplataVO.getCedula());
            ps.setString(4, usuarioDaviplataVO.getPassword());
            ps.setInt(5, usuarioDaviplataVO.getIdUsuario());

            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se actualizo correctamente");
        } catch (Exception e){
            System.out.println("Error al actualizar "+e.getMessage().toString());
        } finally {
            con.close();
        }
        return r;
    }

}
