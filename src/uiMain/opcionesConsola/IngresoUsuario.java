package uiMain.opcionesConsola;

import gestorAplicacion.master.Cine;

import java.util.Vector;

public class IngresoUsuario implements OpcionConsola{
    Cine cine = new Cine();
    int opcion;
    StringBuilder mensaje = new StringBuilder();
    {
        mensaje.append("1. Consultar salas de cine en el pais\n")
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
                System.out.println(separador);
                System.out.println(cine.consultarCines());
                System.out.println(separador);
                System.out.println("En que ciudad desea ver nuestras salas disponibles: ");
                opcion = dato.nextInt();
                System.out.println(separador);
                String salasXCiudad = cine.cinesPorCiudad(cine.getCiudades().get(opcion-1));
                System.out.println(salasXCiudad);
                //Aca voy ////////////////////////////////
        }
    }

    @Override
    public void volver(int opcion) {}
}
