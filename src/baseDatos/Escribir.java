package baseDatos;

import com.google.gson.Gson;
import gestorAplicacion.master.Admin;

import java.io.*;

public class Escribir {
    static Gson gson = new Gson();
    static File fichero = new File("");
    static PrintWriter pw;
    static FileWriter ficheros = null;

    //Metodo que se usara para guardar toda la informacion en la base de datos al salir
    public static void Escribir() {

        //Guardo el vector clientes de la clase ADMIN en usuarios.json
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/baseDatos/temp/usuarios.json"));
            bw.write("");
            bw.close();
            try {
                String json = gson.toJson(Admin.getClientes());
                ficheros = new FileWriter(fichero.getAbsolutePath()+"/src/baseDatos/temp/usuarios.json",true);
                pw=new PrintWriter(ficheros);
                pw.println(json);
                ficheros.close();
                if (null != ficheros) {
                    ficheros.close();}
            }catch(IOException e1) {
                System.out.println("Existe un error aca: "+e1);
            }


        }catch (Exception e1) {
            System.out.println("\n O existe un error aca?: " + e1);
            e1.printStackTrace();
        }
    }
}
