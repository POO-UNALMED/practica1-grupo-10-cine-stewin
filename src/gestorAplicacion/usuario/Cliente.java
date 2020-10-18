package gestorAplicacion.usuario;

import baseDatos.BaseDeDatos;
import gestorAplicacion.master.Reserva;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {
    //Atributos de clase
    private CuentaPuntos cuentaPuntos;
    private ArrayList<Reserva> cartera = new ArrayList<Reserva>();

    //Constructores de clase

    public Cliente() {
    }

    public Cliente(int identificacion, String nombre, String correo, String direccion, String contrasenia) {
        super(identificacion, nombre, correo, direccion, contrasenia);
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

    //Metodos de clase****

    //Metodo que comprueba la identificacion/contraseña para entrar
    public boolean ComprobarRegistro(int identificacion) {
        boolean confirmaContrasenia = false;
        for (int i = 0; i < BaseDeDatos.getClientes().size(); i++) {
            if(BaseDeDatos.getClientes().get(i).getIdentificacion() == identificacion){
                confirmaContrasenia = true;
                Persona.setClienteActual(i); /*De esta forma podemos obtener los datos
                en los otros vectores*/
            }
        }
        return confirmaContrasenia;
    }
    //Metodo para registrar clientes
    public static void RegistarCliente(int identificacion, String nombre, String correo, String direccion, String contrasenia) {
        Cliente a = new Cliente(identificacion, nombre, correo, direccion, contrasenia);
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
