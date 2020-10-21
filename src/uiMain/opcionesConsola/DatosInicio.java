package uiMain.opcionesConsola;

public class DatosInicio implements OpcionConsola{
    UsuarioRegistrado registrado = new UsuarioRegistrado();
    Salir salir = new Salir();
    Descripcion descripcion = new Descripcion();
    Autores autores = new Autores();
    UsuarioNoRegistrado registrar = new UsuarioNoRegistrado();
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
                registrado.ejecutar();
                break;
            case 2:
                registrar.ejecutar();
                break;
            case 3:
                autores.ejecutar();
                break;
            case 4:
                descripcion.ejecutar();
                break;
            case 5:
                salir.ejecutar();
                break;
        }
    }

    @Override
    public void volver(int opcion) {}
}
