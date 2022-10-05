package cine;

public class Pelicula {

    private String Nombre;
    private String Género;
//private int id; pasa a otra clase
//private int Sala;

    public Pelicula() {
    }

    public Pelicula(String Nombre, String Género) {
        this.Nombre = Nombre;
        this.Género = Género;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGénero() {
        return Género;
    }

    public void setGénero(String Género) {
        this.Género = Género;
    }

    @Override
    public String toString() {
        return "\nPelícula" + "\nNombre: " + Nombre + "\nG\u00e9nero: " + Género;
    }

}
