package uiMain;

import baseDatos.Escribir;
import baseDatos.Leer;
import gestorAplicacion.master.Admin;
import gestorAplicacion.usuario.Persona;

//Clase donde se ejecutara
public class Inicio {
    public static void main(String[] args) {
        Leer.Leer();
        //System.out.println(Admin.getClientes().get(1).getCuentaBancaria());
        System.out.println(Admin.getClientes().size());
        System.out.println(Admin.getCuentasBancarias().size());
        Admin admin = new Admin();
        Consola consola = new Consola();
        consola.PantallaInicio();
        Escribir.Escribir();
    }
}
