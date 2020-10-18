package baseDatos;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaBancaria;

import java.io.*;

public class Leer {
    static File arhivo = new File("");

    public static void Leer(){

        //Leemos los clientes de la base de datos
        try{
            File usuarios = new File(arhivo.getAbsolutePath()+ "/baseDatos/temp/usuarios.txt");
            if(usuarios.length() != 0){
                FileInputStream datosUsuarios = new FileInputStream(arhivo.getAbsolutePath()+ "/baseDatos/temp/usuarios.txt");
                ObjectInputStream objetosUsuarios = new ObjectInputStream(datosUsuarios);

                Object aux = objetosUsuarios.readObject();
                try{
                    while(aux != null){
                        BaseDeDatos.addCliente((Cliente) aux);
                        aux = objetosUsuarios.readObject();
                    }
                }catch(java.io.IOException e){

                }
                datosUsuarios.close();
                objetosUsuarios.close();
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        //Leemos las cuentas bancarias de la base de datos
        try{
            File cuentasBancarias = new File(arhivo.getAbsolutePath()+ "/baseDatos/temp/cuentasBancarias.txt");
            if(cuentasBancarias.length() != 0){
                FileInputStream datosCB = new FileInputStream(arhivo.getAbsolutePath()+ "/baseDatos/temp/cuentasBancarias.txt");
                ObjectInputStream objetosCB = new ObjectInputStream(datosCB);

                Object aux1 = objetosCB.readObject();
                try{
                    while(aux1 != null){
                        BaseDeDatos.addCuentaBancaria((CuentaBancaria) aux1);
                        aux1 = objetosCB.readObject();
                    }
                }catch(java.io.IOException e){

                }
                datosCB.close();
                objetosCB.close();
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
