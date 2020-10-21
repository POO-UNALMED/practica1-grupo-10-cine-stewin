package uiMain.opcionesConsola;

import uiMain.Inicio;

public class Descripcion implements OpcionConsola{
    Salir salir = new Salir();
    StringBuilder mensaje = new StringBuilder();
    int opcion;
    {
        mensaje.append(separador+ "\n")
                .append("                 Cine STEWIN\n")
                .append(" Bienvendios! esta aplicacion le permitira hacer \n")
                .append(" una gestion completa de los servicios que presta\n")
                .append(" un cine a travez de las diferentes opciones que \n")
                .append(" se emplean durante su uso.\n")
                .append(separador + "\n").append(mensajeVolver);
    }
    @Override
    public void ejecutar() {
        System.out.println(mensaje.toString());
        opcion = dato.nextInt();
        volver(opcion);
    }

    @Override
    public void volver(int opcion) {
        if(opcion == 1){
            Inicio.main(null);
        }else{
            salir.ejecutar();
        }
    }
}