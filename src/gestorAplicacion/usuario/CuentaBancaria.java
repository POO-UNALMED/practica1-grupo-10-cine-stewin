package gestorAplicacion.usuario;

import gestorAplicacion.master.Admin;

import java.io.Serializable;

public class CuentaBancaria implements Serializable {
    //Atributos de clase****
    private int numeroCuenta;
    private transient Persona titular;
    private int saldo;

    //Contructores de clase****

    public CuentaBancaria() {
        this.numeroCuenta = Admin.getCuentasBancarias().size();
        this.saldo = 1000000;
    }

    public CuentaBancaria( Persona titular) {
        this();
        this.titular = titular;
    }
    //Metodos GET and SET****

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }



    //Metodos de clase****


}
