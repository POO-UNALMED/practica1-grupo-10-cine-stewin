package uiMain.opcionesConsola;

import uiMain.Inicio;

public class Autores implements OpcionConsola{
    int opcion;
    Salir salir = new Salir();
    StringBuilder mensaje = new StringBuilder();
    {
        mensaje.append(separador + "\n")
                .append("             Proyecto realizado por\n")
                .append("           ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n")
                .append("Molano Gamarra Kevin Andres\n") //No me se sus nombres completos, asi que terminen de completarlos
                .append("Moreno Gelier\n")               //En orden alfabetico
                .append("Ospina Amilder\n")
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
