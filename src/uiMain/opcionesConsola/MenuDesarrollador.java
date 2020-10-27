package uiMain.opcionesConsola;

public class MenuDesarrollador implements OpcionConsola{
    StringBuilder mensaje = new StringBuilder();
    int opcion;
    {
        mensaje.append("1. Agergar un cine\n");
        mensaje.delete(mensaje.length() -1,mensaje.length());
    }
    @Override
    public void ejecutar() {
        System.out.println(separador);
        System.out.println(mensaje);
        System.out.println(separador);
        System.out.print("Ingrese la opcion deseada: ");
        opcion = dato.nextInt();
        System.out.println(separador);

    }

    @Override
    public void volver(int opcion) {

    }
}
