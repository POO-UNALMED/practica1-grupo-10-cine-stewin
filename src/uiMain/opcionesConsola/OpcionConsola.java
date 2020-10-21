package uiMain.opcionesConsola;

import java.util.Scanner;

public interface OpcionConsola {
    String mensajeVolver = "         ¿Desea volver al menu alterior?\n"+
            "1. Si\n"+"2. No\n" + "==================================================";
    Scanner dato = new Scanner(System.in);
    String separador = "==================================================";
    void ejecutar();
    void volver(int opcion);
}
