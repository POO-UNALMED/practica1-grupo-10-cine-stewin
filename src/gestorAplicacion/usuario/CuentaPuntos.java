package gestorAplicacion.usuario;

public class CuentaPuntos {
    //Atributos de clase****
    private int cantidadCuentasPuntos;
    private int numeroCuenta;
    private Cliente titular;
    private int puntos;

    //Contructores de clase****
    public CuentaPuntos(int cantidadCP, int numeroCuenta, Cliente titular, int puntos) {
    	cantidadCuentasPuntos = cantidadCP;
    	this.numeroCuenta = numeroCuenta;
    	this.titular = titular;
    	this.puntos = puntos;
    }

    //Metodos GET and SET****
    public int getCantidadCuentasPuntos(){
        return cantidadCuentasPuntos;
    }
    public int getNumeroCuenta(){
        return numeroCuenta;
    }
    public Cliente getTitular(){
        return titular;
    }
    public int getPuntos(){
        return puntos;
    }
    public void setCantidadCuentasPuntos(int cantidadCuentasPuntos){
        this.cantidadCuentasPuntos=cantidadCuentasPuntos;
    }
    public void setNumeroCuenta(int numeroCuenta){
        this.numeroCuenta=numeroCuenta;
    }
    public void setTitular(Cliente tutilar){
        this.titular=tutilar;
    }
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }

    //Metodos de clase****
    public void agregarpuntos(int puntos){
        this.puntos+=puntos;
    }

}
