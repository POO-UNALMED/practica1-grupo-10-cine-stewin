package gestorAplicacion.master;
import gestorAplicacion.usuario.Cliente;
import java.util.Random;

public class Reserva {
    // Attributes.
    private String codigoReserva;
    private Cliente persona;
    private Funcion funcion;
    private int asiento;

    // Esto es sólo para generar los numeros del codigoReserva. Que es sólo un numero aleatorio.
    Random random = new Random();

    // Constructor.
    public Reserva(Cliente persona, Funcion funcion, int asiento){
        codigoReserva = random.nextInt(10000) + "";
        this.persona = persona;
        this.funcion = funcion;
        this.asiento = asiento;
    }

    // Getters.
    public String getNumeroReserva(){
        return codigoReserva;
    }
    public Cliente getPersona(){
        return persona;
    }
    public Funcion getFuncion(){
        return funcion;
    }

    // Methods.


}
