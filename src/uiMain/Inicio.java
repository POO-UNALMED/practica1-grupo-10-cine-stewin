package uiMain;

import baseDatos.BaseDeDatos;
import baseDatos.Escribir;
import baseDatos.Leer;
import gestorAplicacion.master.Cine;
import gestorAplicacion.usuario.Persona;

//Clase donde se ejecutara
public class Inicio {
    public static void main(String[] args) {
        Leer.Leer();
        System.out.println(BaseDeDatos.getCines().size());
        Consola consola = new Consola();
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        baseDeDatos.relacionar();
        System.out.println(BaseDeDatos.getClientes().get(0).getNombre());
        //System.out.println(BaseDeDatos.getClientes().size()); //Linea de prueba
        //System.out.println(BaseDeDatos.getCuentasBancarias().size()); //Linea de prueba
        //System.out.println(BaseDeDatos.getClientes().get(0).getCuentaBancaria()); //Linea de prueba
        /*Cine cine1 = new Cine("STEWIN la Estacion","Ibague","Calle 60 con Ambala");
        BaseDeDatos.addCine(cine1);
        Cine cine2 = new Cine("STWEIN el Tesoro","Medellin","calle 10");
        BaseDeDatos.addCine(cine2);
        Cine cine3 = new Cine("STWEIN DonMatias","Don Matias","Parque principal");
        BaseDeDatos.addCine(cine3);
        Cine cine4 = new Cine("STWEIN Viva Centro","Riohacha","Cl. 15 ##18-274");
        BaseDeDatos.addCine(cine4);
        Cine cine5 = new Cine("STEWIN plazas","Ibague","Calle 60 con Ambala");
        BaseDeDatos.addCine(cine5);
        Cine cine6 = new Cine("STWEIN la 10","Ibague","calle 10");
        BaseDeDatos.addCine(cine6);
        Cine cine7 = new Cine("STWEIN florida","Medellin","Parque principal");
        BaseDeDatos.addCine(cine7);
        Cine cine8 = new Cine("STWEIN la 65","Medellin","Cl. 15 ##18-274");
        BaseDeDatos.addCine(cine8);*/
        consola.PantallaInicio();
        Escribir.Escribir();
    }
}
