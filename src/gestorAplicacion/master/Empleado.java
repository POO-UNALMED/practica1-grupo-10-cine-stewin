package gestorAplicacion.master;

import baseDatos.BaseDeDatos;
import gestorAplicacion.usuario.*;

import java.time.LocalDateTime;
import java.util.Vector;

/*La clase empleado sera la encargada de mostrarle muchos datos al usuario para que el pueda
  interactuar con los mismos y editar/cambiar/crear la configuracion del cine(opciones)*/
public class Empleado extends Persona {

    //Atributos de clase****

    //Contructores de clase****
    public Empleado() {

    }

    public Empleado(String nombre) {
        this();
        this.setNombre(nombre);
    }
    //Metodos GET and SET****

    //Metodos de clase****

    /*Este metodo se ejecuta al inicio del programa sera el encargado de asignarle
     a cada cine que se lea en la base de datos, sus respectivas funciones,
     todos los datos cada generados son totalmente aleatorios*/
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
                Vector<Integer> numeroAleatorio = new Vector<>();
                Vector<Funcion> funcioness = new Vector<>();
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

    /*Metodo que se encarga de comprarar si el usuario que intenta ingresar esta registrado en la base de datos*/
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

    /*Metodo encargado de registrar clientes*/
    public static void registarCliente(int identificacion, String nombre, String correo, String direccion) {
        Cliente usuario = new Cliente(identificacion, nombre, correo, direccion);
        CuentaBancaria cuentasBancaria = new CuentaBancaria(usuario);
        CuentaPuntos cuentaPuntos = new CuentaPuntos(usuario);
        usuario.setCuentaBancaria(cuentasBancaria);
        usuario.setCuentaPuntos(cuentaPuntos);
        BaseDeDatos.addCliente(usuario);
        BaseDeDatos.addCuentaBancaria(cuentasBancaria);
        BaseDeDatos.addCuentaPuntos(cuentaPuntos);
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
        Vector<Cine> cines = new Vector<>();
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
            s.append(contador).append(". ").append(cine.getNombre()).append("\n");
            contador += 1;
        }
        s.delete(s.length() - 1, s.length());
        return s.toString();
    }

    public String registrarCine(String nombre, String ciudad, String direccion) {
        Cine cine = new Cine(nombre, ciudad, direccion);
        BaseDeDatos.addCine(cine);
        return "            Cine agregado correctamente";
    }

    /*Metodo que se encargara de que no se registren/ingresen usuarios duplicados
      (mismo numero de identidificacion) en la base de datos*/
    public boolean comprobarIdentificacion(int identificacion) {
        boolean estado = false;
        for (Cliente cliente : BaseDeDatos.getClientes()) {
            if (cliente.getIdentificacion() == identificacion) {
                estado = true;
                break;
            }
        }
        return estado;
    }


    // desde aca es codigo para el cabio de asientos//////////////////////////////////////////


    //comprueba si el numero dado corresponde a una funcion en reserva
    public boolean probarFuncion(int numero, Cliente cliente){
        if (numero>cliente.cartera.size()){
            return true;
        }
        else{
            return false;
        }
    }
    //retorna la cantidad de asintos con los que cunta reservados para la funcion a cambiar
    public int numeroDeAsientos(Cliente cliente, int numero){
        return cliente.cartera.get(numero).getNumeroAsientos();
    }
    //confirma si el numero de asintos a cambiar con el numero de asientos en propiedad
    public boolean confirmar(Cliente cliente, int numero){
        if (numero>cliente.cartera.size()){
            return true;
        }
        else{
            return false;
        }
    }

}
