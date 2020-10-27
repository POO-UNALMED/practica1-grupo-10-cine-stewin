package gestorAplicacion.master;

import baseDatos.BaseDeDatos;
import gestorAplicacion.usuario.*;

import java.time.LocalDateTime;
import java.util.Vector;

public class Empleado extends Persona {
    //Atributos de clase****

    //Contructores de clase****

    //Metodos GET and SET****

    //Metodos de clase****
    //Metodo el cual se encarg de asignarle las respectivas funciones a cada cine que lee en la base de datos
    public void enlazarFuncionesYCines() {
        for (Cine cine : BaseDeDatos.getCines()) {
            cine.funciones = new Vector<>();
            for (int i = 0; i < 7; i++) {
                Vector<String> nombreFunciones = new Vector<>();
                nombreFunciones.add("Pelicula 1");
                nombreFunciones.add("Pelicula 2");
                nombreFunciones.add("Pelicula 3");
                nombreFunciones.add("Pelicula 4");
                nombreFunciones.add("Pelicula 5");
                nombreFunciones.add("Pelicula 6");
                nombreFunciones.add("Pelicula 7");
                nombreFunciones.add("Pelicula 8");
                nombreFunciones.add("Pelicula 9");
                nombreFunciones.add("Pelicula 10");
                Vector<Integer> numeroAleatorio = new Vector<Integer>();
                Vector<Funcion> funcioness = new Vector<Funcion>();
                for (int j = 0; j < 5; j++) {
                    int funcion;
                    funcion = (int) Math.floor(Math.random() * nombreFunciones.size());
                    if (!(numeroAleatorio.contains(funcion))) {
                        numeroAleatorio.add(funcion);
                    }
                }
                for (Integer numeroFuncion : numeroAleatorio) {
                    funcioness.add(new Funcion(nombreFunciones.get(numeroFuncion), numeroFuncion % 4, (numeroFuncion * 14) % 23));
                }
                cine.funciones.add(funcioness);
            }
        }
    }

    /*Cuando se crean las funciones en el metodo de arriba, todas se crean con la fecha actual
    este metodo se encarga de crear las funciones disponibles de los proximos 7 dias */
    public void definirSemanaFunciones() {
        for (Cine cine : BaseDeDatos.getCines()) {
            int dia = 0;
            for (Vector<Funcion> a : cine.getFunciones()) {
                for (Funcion funcion : a) {
                    funcion.sumarFecha(dia);
                }
                dia++;
            }
        }
    }

    /*Metodo que se encarga de comprar si el usuario que intenta ingresar esta registrado en la base de datos*/
    public boolean comprobarRegistro(int identificacion) {
        boolean confirmaContrasenia = false;
        for (Cliente cliente : BaseDeDatos.getClientes()) {
            if (cliente.getIdentificacion() == identificacion) {
                confirmaContrasenia = true;
                Cliente.setClienteActual(cliente);
            }
        }
        return confirmaContrasenia;
    }

    //Metodo para registrar clientes
    public static void registarCliente(int identificacion, String nombre, String correo, String direccion) {
        Cliente a = new Cliente(identificacion, nombre, correo, direccion);
        CuentaBancaria b = new CuentaBancaria(a);
        a.setCuentaBancaria(b);
        BaseDeDatos.addCliente(a);
        BaseDeDatos.addCuentaBancaria(b);
    }

    /*Metodo el cual se encarga de mostrar todas las ciudades en las cuales hay salas de cine disponibles*/
    public String consultarCines() {
        StringBuilder s = new StringBuilder();
        s.append("     Ciudades en las cuales tenemos cobertura: \n");
        s.append("    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
        for (Cine cine : BaseDeDatos.getCines()) {
            if (!(Cine.getCiudades().contains(cine.getCiudad()))) {
                Cine.getCiudades().add(cine.getCiudad());
            }
        }
        int contador = 1;
        for (String ciudad : Cine.getCiudades()) {
            s.append(contador).append(". ").append(ciudad).append("\n");
            contador++;
        }
        s.delete(s.length() - 1, s.length());
        return s.toString();
    }

    /*Metodo que se encarga de mostrarle al usuario todas las salas de cine en la ciudad elegida (En un vector)*/
    public Vector<Cine> cinesPorCiudad(String ciudad) {
        Vector<Cine> cines = new Vector<Cine>();
        for (Cine cine : BaseDeDatos.getCines()) {
            if (cine.getCiudad().equals(ciudad)) {
                cines.add(cine);
            }
        }
        return cines;
    }

    /*Metodo que se encarga de mostrarle al usuario todas las salas de cine en la ciudad elegida
    (En forma de lista para imprimir en consola)*/
    public String cinesPorCiudad(Vector<Cine> ciudades) {
        int contador = 1;
        StringBuilder s = new StringBuilder();
        for (Cine cine : ciudades) {
            s.append(contador + ". " + cine.getNombre() + "\n");
            contador += 1;
        }
        s.delete(s.length() - 1, s.length());
        return s.toString();
    }
}
