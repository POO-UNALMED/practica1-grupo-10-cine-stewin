package gestorAplicacion.usuario;

import gestorAplicacion.master.Reserva;

public class Cliente extends Persona{
    //Atributos de clase
    private CuentaPuntos cuentaPuntos;
    private Reserva cartera;

    //Constructores de clase
    public Cliente(int identificacion, String nombre, String correo, String direccion, String contrasenia) {
        super(identificacion, nombre, correo, direccion, contrasenia);
    }

    //Metodos GET and SET****

    //Metodos de clase****
}
