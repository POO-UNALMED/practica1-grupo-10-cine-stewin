package uiMain;

import baseDatos.Escribir;
import baseDatos.Leer;
import gestorAplicacion.master.Admin;

//Clase donde se ejecutara
public class Inicio {
    public static void main(String[] args) {
        Leer.Leer(); /*Leemos toda la informacion en la base de datos
                     (Por el momento solo estan los usuarios)*/
        Admin user = new Admin();  //Clase encargada de manejar toda la formacion
        Consola.PantallaInicio();
        //Lo demas
        Escribir.Escribir(); /*Guardamos toda la informacion almacenada(Hasta el momento,
                             solo se guardara el/los usuarios que creemos)*/
    }
}
