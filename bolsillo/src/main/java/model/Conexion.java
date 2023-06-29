package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private static final String bbdd = "jdbc:mysql://127.0.0.1:3306/bolsillo";
    private static final String usuario="root";
    private static final String clave ="brayansm";
    private static Connection con;
    
    public static Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(bbdd, usuario, clave);
            System.out.println("Conexión Exitosa");
        }catch(Exception e){
            System.out.println("Error de conexión a la base de datos "+e.getMessage().toString());
        }
        return con;
    }

}
