package uiMain.opcionesConsola;

import gestorAplicacion.master.Cine;

/*Esta clase es la encargada de mostrar el menu con las diferentes
  opciones disponibles para el usuario*/
public class IngresoUsuario implements OpcionConsola{
    Cine cine = new Cine();
    int opcion;
    StringBuilder mensaje = new StringBuilder();
    {
        mensaje.append("1. Comprar boletos\n")
                .append("2. Consultar Reservas\n")
                .append("3. Consultar saldo/puntos\n")
                .append("4. Salir\n")
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
                break;
            case 2:
                consultarReservas.ejecutar();
                break;
            case 3:
                puntos.ejecutar();
                break;
            case 4:
                salir.ejecutar();
        }
    }

    @Override
    public void volver(int opcion) {}
}
