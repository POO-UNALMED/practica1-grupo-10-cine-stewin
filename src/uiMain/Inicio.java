package uiMain;

import baseDatos.BaseDeDatos;
import baseDatos.Escribir;
import baseDatos.Leer;
import gestorAplicacion.master.Cine;

//Clase donde se ejecutara
public class Inicio {
    public static void main(String[] args) {
        Leer.Leer();
        Consola consola = new Consola();
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        baseDeDatos.relacionar();
        //System.out.println(BaseDeDatos.getClientes().size()); //Linea de prueba
        //System.out.println(BaseDeDatos.getCuentasBancarias().size()); //Linea de prueba
        //System.out.println(BaseDeDatos.getClientes().get(0).getCuentaBancaria()); //Linea de prueba
        System.out.println(BaseDeDatos.getCines().get(0));
        consola.PantallaInicio();
        Escribir.Escribir();
    }
}
