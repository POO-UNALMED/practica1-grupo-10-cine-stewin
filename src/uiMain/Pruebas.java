package uiMain;


import baseDatos.Escribir;
import baseDatos.Leer;
import gestorAplicacion.master.Admin;

public class Pruebas extends Inicio {
    /*Clase para ejecutar todos los comandos a los cuales les quieran ver el funcionamiento
    * y/o probar cosas antes de implementarlas en la clase inicio*/
    public static void main(String[] args) {
        Leer.Leer();
        System.out.println(Admin.getClientes().size());
        Escribir.Escribir();
    }
}
