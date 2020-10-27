package baseDatos;

import gestorAplicacion.master.Cine;
import gestorAplicacion.master.Funcion;
import gestorAplicacion.master.Reserva;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaBancaria;
import gestorAplicacion.usuario.CuentaPuntos;

import java.util.Vector;

public class BaseDeDatos {
    //Atributos de clase****
    private static Vector<Cliente> clientes = new Vector<>(); /*Aca se guardaran todos los clientes
    para su posterior uso*/
    private static Vector<CuentaBancaria> cuentasBancarias = new Vector<>(); /*Vector donde tenemos la informacion
    de todas las cuentas bancarias*/
    private static Vector<CuentaPuntos> cuentasPuntos = new Vector<>();
    private static Vector<Cine> cines = new Vector<>(); /*Vector donde se guardaran los cines*/
    private static Vector<Funcion> funciones = new Vector<>(); /*Vector donde se guardaran las funciones*/
    private static Vector<Reserva> reservas = new Vector<>(); /*Vector donde se guardan las reservas*/

    //Contructores de clase****
    //Solo me interesa el constructores por defecto (Por el momento)

    //Metodos GET and SET****


    public static Vector<CuentaPuntos> getCuentasPuntos() {
        return cuentasPuntos;
    }

    public static Vector<Reserva> getReservas() {
        return reservas;
    }

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
    public static void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public static void addCuentaPuntos(CuentaPuntos cuentaPuntos){
        cuentasPuntos.add(cuentaPuntos);
    }

    //Metodo que relaciona todos los atributos(Cliente con cuentaBancaria)
    public static void relacionar(){
        for(Cliente cliente : clientes){
            cliente.cartera = new Vector<Reserva>();
        }
        for(int i =0; i <BaseDeDatos.getClientes().size();i++){
            //Al cliente i lo asocio a la cuenta i
            clientes.get(i).setCuentaBancaria(cuentasBancarias.get(i));
            clientes.get(i).setCuentaPuntos(cuentasPuntos.get(i));
            //A la cuenta i la asocio al cliente i
            cuentasBancarias.get(i).setTitular(clientes.get(i));
            if(reservas.size() != 0){
                for(Reserva reserva: reservas){
                    clientes.get(reserva.getCodigoReserva()).agregarReserva(reserva);
                }
            }
        }
    }


}
