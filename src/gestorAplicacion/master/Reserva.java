package gestorAplicacion.master;
import gestorAplicacion.usuario.Cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Reserva implements Serializable {
    // Attributes.
    private int codigoReserva;
    private String persona;
    private int numeroFuncion;
    private String nombreFuncion;
    private LocalDateTime fecha;
    private int numeroAsientos;

    // Constructor.
    public Reserva() {

    }
    public Reserva(Cliente cliente,Funcion funcion,int i){
        this();
        this.codigoReserva = cliente.getID();
        this.persona = cliente.getNombre();
        this.numeroFuncion = funcion.getNumeroFuncion();
        this.nombreFuncion = funcion.getNombre();
        this.fecha = funcion.getFecha();
        this.numeroAsientos = i;
    }
    // Getters.

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
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
    public String toString() {
        return "Reserva{" +
                "codigoReserva=" + codigoReserva +
                ", persona=" + persona +
                ", numeroFuncion=" + numeroFuncion +
                ", nombreFuncion='" + nombreFuncion + '\'' +
                ", fecha=" + fecha +
                ", numeroAsientos=" + numeroAsientos +
                '}';
    }
}
