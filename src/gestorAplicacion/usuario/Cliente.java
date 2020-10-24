package gestorAplicacion.usuario;

import baseDatos.BaseDeDatos;
import gestorAplicacion.master.Reserva;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona{
    //Atributos de clase
    private CuentaPuntos cuentaPuntos;
    private ArrayList<Reserva> cartera = new ArrayList<Reserva>();
    private transient static Cliente clienteActual; /*Este atributo lo usaremos para una vez se ingresa como cliente o empleado,
     se tenga el indice del vector en el cual estara*/

    //Constructores de clase

    public Cliente() {
    }

    public Cliente(int identificacion, String nombre, String correo, String direccion) {
        super(identificacion, nombre, correo, direccion);
    }

    //Metodos GET and SET****

    public CuentaPuntos getCuentaPuntos() {
        return cuentaPuntos;
    }

    public void setCuentaPuntos(CuentaPuntos cuentaPuntos) {
        this.cuentaPuntos = cuentaPuntos;
    }

    public ArrayList<Reserva> getCartera() {
        return cartera;
    }

    public void setCartera(ArrayList<Reserva> cartera) {
        this.cartera = cartera;
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static void setClienteActual(Cliente clienteActual) {
        Cliente.clienteActual = clienteActual;
    }

    //Metodos de clase****

    //Metodo que comprueba la identificacion/contraseña para entrar
    public boolean comprobarRegistro(int identificacion) {
        boolean confirmaContrasenia = false;
        for(Cliente cliente: BaseDeDatos.getClientes()){
            if(cliente.getIdentificacion() == identificacion){
                confirmaContrasenia = true;
                Cliente.setClienteActual(cliente);
            }
        }
        return confirmaContrasenia;
    }
    //Metodo para registrar clientes
    public static void registarCliente(int identificacion, String nombre, String correo, String direccion) {
        Cliente a = new Cliente(identificacion, nombre, correo, direccion);
        CuentaBancaria b = new CuentaBancaria(a);
        a.setCuentaBancaria(b);
        //b.setTitular(a); no es necesario ya que en la linea 56 se asocia.
        //Agregar cliente al vector <CLIENTES>
        BaseDeDatos.addCliente(a);
        //Agregar la cuenta al vector <CuentasBancarias>
        BaseDeDatos.addCuentaBancaria(b);
    }

    // Cliente debe tener un método "reservar" para crear la Reserva y conectarla a una Funcion.
}
