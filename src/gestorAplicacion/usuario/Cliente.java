package gestorAplicacion.usuario;

import baseDatos.BaseDeDatos;
import gestorAplicacion.master.Cine;
import gestorAplicacion.master.Funcion;
import gestorAplicacion.master.Reserva;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;

public class Cliente extends Persona {
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

    public Vector<Funcion> consultarFunciones(int dia, Cine cine) {
        return cine.getFunciones().get(dia);
    }

    public StringBuilder consultarFunciones(Vector<Funcion> funcionesDelDia) {
        int contador = 1;
        StringBuilder s = new StringBuilder();
        for (Funcion funcion : funcionesDelDia) {
            //Le damos un estado a las funciones
            funcion.estado();
            if (funcion.isEstado() == true) {
                s.append(contador + ". ")
                        .append(funcion)
                        .append("\n");
                contador++;
            }
        }
        s.delete(s.length() - 1, s.length());
        return s;
    }

    public void reservarPuestos(Vector<Integer> puestos, Funcion funcion) {
        for (Integer puesto : puestos) {
            funcion.getPuestos()[puesto] = 0;
        }
        int saldoActual = this.getCuentaBancaria().getSaldo();
        this.getCuentaBancaria().setSaldo(saldoActual - (funcion.getPrecio() * puestos.size()));
        crearReserva(this, funcion, puestos.size());
    }

    public void crearReserva(Cliente cliente, Funcion funcion, int numeroPuestos) {
        Reserva reserva = new Reserva(cliente, funcion, numeroPuestos);
        agregarReserva(reserva);
        BaseDeDatos.addReserva(reserva);
    }

    public void agregarReserva(Reserva reserva) {
        cartera.add(reserva);
    }

    public String consultarReservas() {
        StringBuilder s = new StringBuilder();
        s.append("1. Reservas activas\n");
        Vector<Reserva> activas = new Vector<Reserva>();
        Vector<Reserva> vencidad = new Vector<Reserva>();
        LocalDateTime hoy = LocalDateTime.now();
        if(cartera.size() == 0){
            s.append("El usuario no tiene reservas activas");
        }else{
            for (Reserva reserva : cartera) {
                if(reserva.getFecha().compareTo(hoy)==-1){
                    vencidad.add(reserva);
                }else{
                    activas.add(reserva);
                }
            }
            for(Reserva reserva: activas){
                s.append(reserva.toString()).append("\n");
            }
            s.append("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
            s.append("2. Reservas vencidas\n");
            for(Reserva reserva: vencidad){
                s.append(reserva.toString()).append("\n");
            }
        }
        return s.toString();
    }
}
