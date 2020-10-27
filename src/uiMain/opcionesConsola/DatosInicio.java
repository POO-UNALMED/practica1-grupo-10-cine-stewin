package uiMain.opcionesConsola;

public class DatosInicio implements OpcionConsola{
    StringBuilder mensaje = new StringBuilder();
    int opcion;
    {
        mensaje.append("Ingrese la opcion deseada: ");
    }
    @Override
    public void ejecutar() {
        System.out.print(mensaje.toString());
        opcion = dato.nextInt();
        switch(opcion){
            case 1:
                usuarioRegistrado.ejecutar();
                break;
            case 2:
                usuarioNoRegistrado.ejecutar();
                break;
            case 3:
                autores.ejecutar();
                break;
            case 4:
                descripcion.ejecutar();
                break;
            case 5:
                desarrollador.ejecutar();
                break;
            case 6:
                salir.ejecutar();
                break;
        }
    }

    @Override
    public void volver(int opcion) {}
}
