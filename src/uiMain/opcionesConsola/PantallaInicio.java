package uiMain.opcionesConsola;


public class PantallaInicio implements OpcionConsola{
    DatosInicio datosInicio = new DatosInicio();
    StringBuilder mensaje = new StringBuilder();
    {
        mensaje.append(separador+"\n").append("          Bienvenido a Cine STEWIN\n")
                .append(separador+ "\n").append("1. Usuario registrado\n")
                .append("2. Usuario no registrado\n").append("3. Autores\n")
                .append("4. Descripcion\n").append("5. Salir\n")
                .append(separador);
    }
    @Override
    public void ejecutar() {
        System.out.println(mensaje);
        datosInicio.ejecutar();
    }
    @Override
    public void volver(int opcion) {}
}
