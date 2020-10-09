package baseDatos;

import gestorAplicacion.master.Admin;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaBancaria;

import java.io.*;

public class Escribir {
    static File fichero = new File("");

    public static void Escribir(){

        //Guardamos los clientes en la base de datos
        if(Admin.getClientes().size() != 0){
            try{
                FileOutputStream fs = new FileOutputStream(fichero.getAbsolutePath()+"/src/baseDatos/temp/usuarios.ser");//Creamos el archivo
                ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
                for(Cliente i: Admin.getClientes()){
                    os.writeObject(i);
                }
                os.close();//Hay que cerrar siempre el archivo
                fs.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        //Guardamos las cuentas bancarias en la base de datos
        if(Admin.getCuentasBancarias().size() != 0){
            try{
                FileOutputStream fs = new FileOutputStream(fichero.getAbsolutePath()+"/src/baseDatos/temp/cuentasBancarias.ser");//Creamos el archivo
                ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
                for(CuentaBancaria i: Admin.getCuentasBancarias()){
                    os.writeObject(i);
                }
                os.close();//Hay que cerrar siempre el archivo
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}

