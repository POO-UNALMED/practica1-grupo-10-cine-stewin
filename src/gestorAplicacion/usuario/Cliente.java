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
}
