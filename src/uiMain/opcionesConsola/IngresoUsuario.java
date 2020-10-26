package uiMain.opcionesConsola;

import baseDatos.BaseDeDatos;
import gestorAplicacion.master.Cine;
import gestorAplicacion.master.Empleado;
import gestorAplicacion.master.Funcion;

import java.util.Vector;

public class IngresoUsuario implements OpcionConsola{
    Cine cine = new Cine();
    MostrarCine mostrarCine = new MostrarCine();
    int opcion;
    StringBuilder mensaje = new StringBuilder();
    {
        mensaje.append("1. Comprar boletos\n")
                .append("2. Otra opcion\n")
                .append("3. Otra opcion\n")
                .append(separador);
    }
    @Override
    public void ejecutar() {
        System.out.println(mensaje.toString());
        System.out.print("Ingrese la opcion deseada: ");
        opcion = dato.nextInt();
        switch(opcion){
            case 1:
                mostrarCine.ejecutar();

                /*
                opcion = dato.nextInt();
                System.out.println(separador);
                Vector<Funcion> dia =cine.funcionesDelDia(salasXCiudad.get(opcion-1),0);
                System.out.println(cine.funcionesDelDia(dia));
                System.out.println(separador);

                 */
        }
    }

    @Override
    public void volver(int opcion) {}
}
