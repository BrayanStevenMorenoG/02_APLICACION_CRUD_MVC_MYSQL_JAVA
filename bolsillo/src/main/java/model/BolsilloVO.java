package model;

public class BolsilloVO {
    
    private int IdBolsillo; 
    private String Nombre; 
    private Double Saldo; 
    private Boolean Estado; 

    public BolsilloVO(){

    }

    public BolsilloVO(int idBolsillo, String nombre, Double saldo, Boolean estado) {
        IdBolsillo = idBolsillo;
        Nombre = nombre;
        Saldo = saldo;
        Estado = estado;
    }

    public int getIdBolsillo() {
        return IdBolsillo;
    }

    public void setIdBolsillo(int idBolsillo) {
        IdBolsillo = idBolsillo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }

    

}
