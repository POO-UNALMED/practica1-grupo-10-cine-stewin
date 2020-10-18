package uiMain;

import baseDatos.BaseDeDatos;
import baseDatos.Escribir;
import baseDatos.Leer;

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
        consola.PantallaInicio();
        Escribir.Escribir();
    }
}
