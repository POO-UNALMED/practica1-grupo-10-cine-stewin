package uiMain;

import baseDatos.Escribir;
import baseDatos.Leer;
import gestorAplicacion.master.Admin;
import gestorAplicacion.usuario.Persona;

//Clase donde se ejecutara
public class Inicio {
    public static void main(String[] args) {
        Leer.Leer();
        Admin admin = new Admin();
        admin.relacionar();
        System.out.println(Admin.getClientes().size()); //Linea de prueba
        System.out.println(Admin.getCuentasBancarias().size()); //Linea de prueba
        //Probando que si se esten relacionando bien los objetos
        System.out.println(Admin.getClientes().get(0).getCuentaBancaria()); //Linea de prueba

        Consola consola = new Consola();
        consola.PantallaInicio();
        Escribir.Escribir();
    }
}
