package uiMain.opcionesConsola;

import java.util.Scanner;

public interface OpcionConsola {
    Autores autores = new Autores();
    ConsultarReservas consultarReservas = new ConsultarReservas();
    DatosInicio datosInicio = new DatosInicio();
    Descripcion descripcion = new Descripcion();
    DiaFuncion diaFuncion = new DiaFuncion();
    IngresoUsuario ingresoUsuario = new IngresoUsuario();
    MostrarCine mostrarCine = new MostrarCine();
    PantallaInicio pantallaInicio = new PantallaInicio();
    Puntos puntos = new Puntos();
    MenuDesarrollador desarrollador = new MenuDesarrollador();
    Salir salir = new Salir();
    UsuarioNoRegistrado usuarioNoRegistrado = new UsuarioNoRegistrado();
    UsuarioRegistrado usuarioRegistrado = new UsuarioRegistrado();
    String mensajeVolver = "         ¿Desea volver al menu alterior?\n"+
            "1. Si\n"+"2. No\n" + "==================================================";
    Scanner dato = new Scanner(System.in);
    String separador = "==================================================";
    void ejecutar();
    void volver(int opcion);
}
