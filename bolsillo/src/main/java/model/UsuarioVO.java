package model;

public class UsuarioVO {
    
    private int IdUsuario; 
    private String Nombre; 
    private String Apellido;
    private String Usuario;
    private String Contrasena; 
    private Boolean Estado; 

    public UsuarioVO(){

    }

    public UsuarioVO(int idUsuario, String nombre, String apellido, String usuario, String contrasena, Boolean estado) {
        IdUsuario = idUsuario;
        Nombre = nombre;
        Apellido = apellido;
        Usuario = usuario;
        Contrasena = contrasena;
        Estado = estado;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }

    

}
