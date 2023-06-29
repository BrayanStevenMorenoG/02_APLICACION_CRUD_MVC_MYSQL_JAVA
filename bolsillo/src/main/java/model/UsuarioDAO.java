package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    Connection con; 
    PreparedStatement ps;
    ResultSet rs; 
    String sql = null; 
    int r;

    public int registrarUsu(UsuarioVO usuario) throws SQLException{

    sql = "insert into usuario (Nombre, Apellido, Usuario, Contraseña, Estado) values (?,?,?,?,?);";

        try{
            con= Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getContrasena());
            ps.setBoolean(5, usuario.getEstado());
            
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Insertado correctamente");
        } catch (Exception e){
            System.out.println("Error al registrar= "+e.getMessage().toString());
        }finally {
            con.close();
        }

    return r;

    }

    public List<UsuarioVO> listarUsu() throws SQLException{
        List<UsuarioVO> usuario = new ArrayList<>();
        sql = "select * from Usuario";

    try{
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);

        while(rs.next()){
            UsuarioVO listUsu = new UsuarioVO();

            listUsu.setIdUsuario(rs.getInt("IdUsuario"));
            listUsu.setNombre(rs.getString("Nombre"));
            listUsu.setApellido(rs.getString("Apellido"));
            listUsu.setUsuario(rs.getString("Usuario"));
            listUsu.setContrasena(rs.getString("Contraseña"));
            listUsu.setEstado(rs.getBoolean("Estado"));

            usuario.add(listUsu);

        }

        ps.close();

        System.out.println("Lista exitosa");

    } catch (Exception e){
        System.out.println("Error al listarr = "+e.getMessage().toString());
    } finally {
        con.close();
    }

        return usuario; 
    }


    public int actualizar(UsuarioVO usuarioVO) throws SQLException{

        sql = "update usuario set Nombre=?,Apellido=?,Usuario=?,Contraseña=?,Estado=? where IdUsuario=?";

        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuarioVO.getNombre());
            ps.setString(2, usuarioVO.getApellido());
            ps.setString(3, usuarioVO.getUsuario());
            ps.setString(4, usuarioVO.getContrasena());
            ps.setBoolean(5, false);
            ps.setInt(6, usuarioVO.getIdUsuario());

            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Actualizado correctamente");

        } catch (Exception e){
            System.out.println("Error al actualizar= "+e.getMessage().toString());
        } finally {
            con.close();
        }
        return r; 
    }

public int iniciarSesion(UsuarioVO usuarioVO) throws SQLException {
    String sql = "SELECT * FROM usuario WHERE Usuario = ? AND Contraseña = ?";
    int resultado = 0;

    try {
        con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuarioVO.getUsuario());
        ps.setString(2, usuarioVO.getContrasena());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            resultado = 1;
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    return resultado;
}


}
