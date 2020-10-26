package gestorAplicacion.usuario;

import baseDatos.BaseDeDatos;
import gestorAplicacion.master.Cine;
import gestorAplicacion.master.Funcion;
import gestorAplicacion.master.Reserva;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Cliente extends Persona{
    //Atributos de clase
    private CuentaPuntos cuentaPuntos;
    public transient Vector<Reserva> cartera = new Vector<Reserva>();
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

    public Vector<Reserva> getCartera() {
        return cartera;
    }

    public void setCartera(Vector<Reserva> cartera) {
        this.cartera = cartera;
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static void setClienteActual(Cliente clienteActual) {
        Cliente.clienteActual = clienteActual;
    }

    //Metodos de clase****

    public Vector<Funcion> consultarFunciones(int dia, Cine cine){
        return cine.getFunciones().get(dia);
    }

    public StringBuilder consultarFunciones(Vector<Funcion> funcionesDelDia){
        int contador = 1;
        StringBuilder s = new StringBuilder();
        for(Funcion funcion: funcionesDelDia){
            s.append(contador+". ")
                    .append(funcion)
                    .append("\n");
            contador++;
        }
        s.delete(s.length()-1,s.length());
        return s;
    }
    public void reservarPuestos(Vector<Integer> puestos, Funcion funcion){
        for(Integer puesto : puestos){
            if(funcion.getPuestos()[puesto] != 0){
                funcion.getPuestos()[puesto] = 0;
            }
        }
        int saldoActual = this.getCuentaBancaria().getSaldo();
        this.getCuentaBancaria().setSaldo(saldoActual-(funcion.getPrecio()*puestos.size()));
        crearReserva(this,funcion,puestos.size());
    }

    public void crearReserva(Cliente cliente,Funcion funcion, int numeroPuestos){
        Reserva reserva = new Reserva(cliente,funcion,numeroPuestos);
        agregarReserva(reserva);
        BaseDeDatos.addReserva(reserva);
    }
    public void agregarReserva(Reserva reserva){
        cartera.add(reserva);
    }

    public String consultarReservas() {
        StringBuilder s = new StringBuilder();
        if(this.cartera.size() == 0){
            s.append("El usuario no tiene reservas activas");
        }else{
            s.append("Reservas activas del usuario: \n");
            for(Reserva reserva : this.cartera){
                s.append(reserva.toString());
                s.append("\n");
            }
        }
        return s.toString();
    }
}
