package uiMain.opcionesConsola;

/*Esta clase es la encargada de tomar el dato(Opcion) que el usuario elija
  y redireccionarlo hacia la pantalla/clase correspondiente*/
public class DatosInicio implements OpcionConsola{
    int opcion;

    @Override
    public void ejecutar() {
        System.out.print("Ingrese la opcion deseada: ");
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
                /*Muestra una pantalla con una descripcion sobre el proyecto*/
                descripcion.ejecutar();
                break;
            case 5:
                desarrollador.ejecutar();
                break;
            case 6:
                /*Ejecuta el metodo de la pantalla para salir*/
                salir.ejecutar();
                break;
        }
    }

    @Override
    public void volver(int opcion) {}
}
