package uiMain.opcionesConsola;

import baseDatos.BaseDeDatos;
import baseDatos.Escribir;
import gestorAplicacion.usuario.Cliente;

public class Salir implements OpcionConsola{
    StringBuilder mensaje = new StringBuilder();
    @Override
    public void ejecutar() {
        mensaje.append(separador+ "\n").append("              Se ha finalizado sesion\n")
                .append(separador);
        System.out.println(mensaje.toString());
        Escribir.Escribir();
        System.exit(1);
    }
    @Override
    public void volver(int opcion) {}
}
