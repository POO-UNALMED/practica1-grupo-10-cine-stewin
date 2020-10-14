package gestorAplicacion.master;

public class Sala {

    // Methods.
    private String nombreSala;
    private Cine cine;
    private Funcion [] funcionesPorDia;

    // Constructor.
    public Sala(String nombreSala, Cine cine){
        this.nombreSala = nombreSala;
    }

    // Getters.
    public String getNombreSala(){
        return nombreSala;
    }
    public Cine getCine(){
        return cine;
    }

    // Setters.
    public void setNombreSala(String nombre){
        nombreSala = nombre;
    }
}
