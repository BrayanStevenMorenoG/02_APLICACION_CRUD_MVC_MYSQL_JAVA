package model;

public class bolsilloVO {
    
    private int idBolsillo;
    private String nombreBolsillo;
    private double saldo; 
    private boolean estado;

    public bolsilloVO(){

    }

    public bolsilloVO(int idBolsillo, String nombreBolsillo, double saldo, boolean estado) {
        this.idBolsillo = idBolsillo;
        this.nombreBolsillo = nombreBolsillo;
        this.saldo = saldo;
        this.estado = estado;
    }

    public int getIdBolsillo() {
        return idBolsillo;
    }

    public void setIdBolsillo(int idBolsillo) {
        this.idBolsillo = idBolsillo;
    }

    public String getNombreBolsillo() {
        return nombreBolsillo;
    }

    public void setNombreBolsillo(String nombreBolsillo) {
        this.nombreBolsillo = nombreBolsillo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

}
