package baseDatos;

import com.google.gson.Gson;
import gestorAplicacion.master.Admin;
import gestorAplicacion.usuario.Cliente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Leer {
    //Metodo que se usara para leer toda la informacion en la base de datos antes de iniciar el programa
    public static void Leer() {

        /*Lee toda la informacion de usuarios.json para ingresarlos
         en el atributo <CLIENTES> de la clase ADMIN*/
        String jsonUsuarios = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/baseDatos/temp/usuarios.json"));
            String line;
            while ((line = reader.readLine()) != null) {
                jsonUsuarios += line;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Cliente[] clientes = gson.fromJson(jsonUsuarios, Cliente[].class);

        if(clientes != null){
            for(Cliente j : clientes) {
                new Admin().addCliente(j);
            }
        }

    }
}
