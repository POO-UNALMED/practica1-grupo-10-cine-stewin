package gestorAplicacion.usuario;

import gestorAplicacion.master.Admin;
import gestorAplicacion.master.Reserva;

public class Cliente extends Persona{
    //Atributos de clase
    private CuentaPuntos cuentaPuntos;
    private Reserva cartera;

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

    public Reserva getCartera() {
        return cartera;
    }

    public void setCartera(Reserva cartera) {
        this.cartera = cartera;
    }

    //Metodos de clase****

    //Metodo que comprueba la identificacion/contraseña para entrar
    public boolean ComprobarRegistro(int identificacion, String contrasenia) {
        boolean confirmaContrasenia = false;
        for (int i = 0; i < Admin.getClientes().size(); i++) {
            if(Admin.getClientes().get(i).getContrasenia().equals(contrasenia) &&
                    Admin.getClientes().get(i).getIdentificacion() == identificacion){
                confirmaContrasenia = true;
                Persona.setNumeroDeUsuario(i); /*De esta forma podemos obtener los datos
                en los otros vectores*/
            }
        }
        return confirmaContrasenia;
    }
    //Metodo para registrar clientes
    public void RegistarCliente(int identificacion, String nombre, String correo, String direccion, String contrasenia) {
        Cliente a = new Cliente(identificacion, nombre, correo, direccion, contrasenia);
        CuentaBancaria b = new CuentaBancaria(a);
        a.setCuentaBancaria(b);
        //b.setTitular(a); no es necesario ya que en la linea 56 se asocia.
        //Agregar cliente al vector <CLIENTES>
        Admin.addCliente(a);
        //Agregar la cuenta al vector <CuentasBancarias>
        Admin.addCuentaBancaria(b);
    }
}
