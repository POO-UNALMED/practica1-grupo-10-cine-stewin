package gestorAplicacion.master;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaBancaria;
import gestorAplicacion.usuario.Persona;
import uiMain.Consola;

import java.util.Scanner;
import java.util.Vector;

public class Admin {
    //Atributos de clase****
    private static Vector<Cliente> clientes = new Vector<>(); /*Aca se guardaran todos los clientes
    para su posterior uso*/
    private static Consola consola; /*Guardamos la consola para invocarla
    despues para no tener metodos estaticos*/
    private static Vector<CuentaBancaria> cuentasBancarias = new Vector<>(); /*Vector donde tenemos la informacion
    de todas las cuentas bancarias*/


    //Contructores de clase****
    //Solo me interesa el constructores por defecto (Por el momento)
    public Admin(){
        Consola.admin = this;
    }

    //Metodos GET and SET****
    public static Vector<Cliente> getClientes() {
        return clientes;
    }
    public static Consola getConsola() {
        return Admin.consola;
    }
    public static void setConsola(Consola consola){
        Admin.consola = consola;
    }

    public static Vector<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    //Metodos de clase****
    //Metodo para agregar clientes en el atributo CLIENTES
    public static void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    //Metodo para agregar cuentasBancarias al atributo CUENTASBANCARIAS
    public static void addCuentaBancaria(CuentaBancaria cuentaBancaria){
        cuentasBancarias.add(cuentaBancaria);
    }
    //Metodo que relaciona todos los atributos(Cliente con cuentaBancaria)
    public void relacionar(){
        for(int i =0; i <Admin.getClientes().size();i++){
            //Al cliente i lo asocio a la cuenta i
           clientes.get(i).setCuentaBancaria(cuentasBancarias.get(i));
           //A la cuenta i la asocio al cliente i
           cuentasBancarias.get(i).setTitular(clientes.get(i));
        }
    }
}