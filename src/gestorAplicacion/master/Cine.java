package gestorAplicacion.master;

import baseDatos.BaseDeDatos;

import java.io.Serializable;
import java.util.Vector;

public class Cine implements Serializable {
    //Atributos de clase****
    private String nombre;
    private Vector<String> ciudades = new Vector<String>();
    private String ciudad;
    private String direccion;
    private int cantidasSalas = 4;
    private transient Sala [] salas ;

    private static Vector<Funcion> funciones = new Vector<Funcion>();

    //Constructores de clase****
    public Cine() {

    }
    public Cine(String nombre, String ciudad, String direccion){
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.direccion=direccion;
        salas = new Sala[4];
        for(int i = 0; i < salas.length; i++){
            String nom = "S" + i + 1;
            salas[i] = new Sala(nom, this);
        }
    }
    //Metodos GET and SET****
    public String getNombre(){
        return nombre;
    }
    public String getCiudad(){
        return ciudad;
    }
    public String getDireccion(){
        return direccion;
    }
    public int getCantidasSalas(){
        return cantidasSalas;
    }
    public Sala[] getSalas(){
        return salas;
    }
    public Vector<String> getCiudades() {
        return ciudades;
    }

    protected void setNombre(String nombre){
        this.nombre=nombre;
    }
    protected void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    protected void setDireccion(String direccion){
        this.direccion=direccion;
    }
    protected void setCantidasSalas(int cantidadSalas){
        this.cantidasSalas=cantidadSalas;
    }

    //Metodos de clase****
    public Vector<Funcion> getFunciones(){
        return funciones;
    }
    protected void agregarFuncion(Funcion funcion){
        funciones.add(funcion);
    }
    protected void retirarFuncion(Funcion funcion){
        funciones.remove(funciones.indexOf(funcion));
    }
    protected static boolean estadoFuncion(String nombre){
        boolean estado=false;
        for(int i=0; i<=funciones.size(); i++){
            if(funciones.get(i).getNombre()==nombre){
                estado=funciones.get(i).isEstado();
            }
        }
        return estado;
    }
    //Metodo que me consulta las salas de cine en el pais --
    public String consultarCines(){
        StringBuilder s = new StringBuilder();
        s.append("Ciudades en las cuales tenemos cobertura: \n");
        for(Cine cine: BaseDeDatos.getCines()){
            if(!(ciudades.contains(cine.getCiudad()))){
                ciudades.add(cine.getCiudad());
            }
        }
        int contador = 1;
        for(String ciudad: ciudades){
            s.append(contador).append(". ").append(ciudad).append("\n");
            contador++;
        }
        s.delete(s.length()-1,s.length());
        return s.toString();
    }

    //Metodo que me muestra todas las salas de cine de la ciudad elegida
    public String cinesPorCiudad(String ciudad){
        StringBuilder s = new StringBuilder();
        s.append("Salas de dice disponibles en la ciudad: \n");
        int contador = 1;
        for(Cine cine: BaseDeDatos.getCines()){
           if(cine.getCiudad().equals(ciudad)){
               s.append(contador).append(". ");
               s.append(cine.getNombre());
               s.append("\n");
               contador += 1;
           }
        }
        s.delete(s.length()-1,s.length());
        return s.toString();
    }

    @Override
    //ToString para ver que si se esten guardando los cines de la forma correcta --
    public String toString() {
        return "Cine{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cantidasSalas=" + cantidasSalas +
                '}';
    }
}