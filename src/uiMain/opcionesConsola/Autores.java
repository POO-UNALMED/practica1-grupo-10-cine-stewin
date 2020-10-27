package uiMain.opcionesConsola;

import uiMain.Inicio;

public class Autores implements OpcionConsola{
    int opcion;
    StringBuilder mensaje = new StringBuilder();
    {
        mensaje.append(separador + "\n")
                .append("             Proyecto realizado por\n")
                .append("           ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n")
                .append("Molano Gamarra Kevin Andres\n") //No me se sus nombres completos, asi que terminen de completarlos
                .append("Moreno Gómez Gelier Esteban\n")               //En orden alfabetico
                .append("Ospina Tobon Amilder Stewin \n")
                .append("Sepulveda Ochoa Daniel Alejandro\n")
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
            System.exit(0);
        }else{
            salir.ejecutar();
        }
    }
}
