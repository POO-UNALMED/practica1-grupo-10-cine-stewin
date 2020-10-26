package baseDatos;

import gestorAplicacion.master.Cine;
import gestorAplicacion.master.Funcion;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaBancaria;

import java.util.Vector;

public class BaseDeDatos {
    //Atributos de clase****
    private static Vector<Cliente> clientes = new Vector<>(); /*Aca se guardaran todos los clientes
    para su posterior uso*/
    private static Vector<CuentaBancaria> cuentasBancarias = new Vector<>(); /*Vector donde tenemos la informacion
    de todas las cuentas bancarias*/
    private static Vector<Cine> cines = new Vector<>(); /*Vector donde se guardaran los cines*/
    private static Vector<Funcion> funciones = new Vector<>(); /*Vector donde se guardaran las funciones*/

    //Contructores de clase****
    //Solo me interesa el constructores por defecto (Por el momento)

    //Metodos GET and SET****
    public static Vector<Cliente> getClientes() {
        return clientes;
    }

    public static Vector<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public static Vector<Cine> getCines() {
        return cines;
    }

    public static Vector<Funcion> getFunciones() {
        return funciones;
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
    //Metodo para agregar cines al atributo CINES
    public static void addCine(Cine cine){
        cines.add(cine);
    }
    public static void addFuncion(Funcion funcion){
        funciones.add(funcion);
    }

    //Metodo que relaciona todos los atributos(Cliente con cuentaBancaria)
    public static void relacionar(){
        for(int i =0; i <BaseDeDatos.getClientes().size();i++){
            //Al cliente i lo asocio a la cuenta i
            clientes.get(i).setCuentaBancaria(cuentasBancarias.get(i));
            //A la cuenta i la asocio al cliente i
            cuentasBancarias.get(i).setTitular(clientes.get(i));
        }
    }
}
