package gestorAplicacion.master;

import baseDatos.BaseDeDatos;
import gestorAplicacion.usuario.Cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Vector;

public class Reserva implements Serializable {
    // Attributes.
    private int codigo;
    private int codigoPersona;
    private String persona;
    private int numeroFuncion;
    private String nombreFuncion;
    private LocalDateTime fecha;
    private int numeroAsientos;
    private Vector<Integer> asientosElegidos = new Vector<Integer>();

    // Constructor.
    public Reserva() {
        this.codigo = BaseDeDatos.getReservas().size();
    }

    public Reserva(Cliente cliente, Funcion funcion, Vector<Integer> i) {
        this();
        this.codigoPersona = cliente.getID();
        this.persona = cliente.getNombre();
        this.numeroFuncion = funcion.getNumeroFuncion();
        this.nombreFuncion = funcion.getNombre();
        this.fecha = funcion.getFecha();
        this.numeroAsientos = i.size();
        this.asientosElegidos = i;
    }
    // Getters.

    public int getCodigoReserva() {
        return codigoPersona;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoPersona = codigoReserva;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public int getNumeroFuncion() {
        return numeroFuncion;
    }

    public void setNumeroFuncion(int numeroFuncion) {
        this.numeroFuncion = numeroFuncion;
    }

    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }


    // Methods.


    @Override
    /*Este toString se va a encargar de mostrar las reservas al usuario en este formato*/
    /*Ahora estoy imprimiendo los aientos revisar esto ...........................*/
    public String toString() {
        return "Reserva # " + codigo + ", " + numeroAsientos + " asientos para la funcion: \n"
                + "     " + nombreFuncion + " \n" + " numero de asientos " + asientosElegidos
                + "     el " + fecha.format(DateTimeFormatter.ofPattern("d/M/yyyy H:mm"));
    }
}
