package uiMain.opcionesConsola;

import baseDatos.BaseDeDatos;
import gestorAplicacion.master.Cine;
import gestorAplicacion.master.Empleado;
import gestorAplicacion.master.Funcion;

import java.util.Vector;

public class IngresoUsuario implements OpcionConsola{
    Cine cine = new Cine();
    MostrarCine mostrarCine = new MostrarCine();
    ConsultarReservas consultarReservas = new ConsultarReservas();
    int opcion;
    StringBuilder mensaje = new StringBuilder();
    {
        mensaje.append("1. Comprar boletos\n")
                .append("2. Consultar Reservas\n")
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
            case 2:
                consultarReservas.ejecutar();
        }
    }

    @Override
    public void volver(int opcion) {}
}
