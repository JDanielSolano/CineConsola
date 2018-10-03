package cine;

public class Cliente {

    private int id;
    private int Cedula;
    private String Nombre;
    private int Edad;

    public Cliente() {
    }

    public Cliente(int id, int Cedula) {
        this.id = id;
        this.Cedula = Cedula;
    }

    public Cliente(int id, int Cedula, String Nombre) {
        this.id = id;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
    }

    public Cliente(int id, int Cedula, String Nombre, int Edad) {
        this.id = id;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Edad = Edad;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String toString() {
        return "ID: " + id + "\nCédula: " + Cedula + "\nNombre: " + Nombre + "\nEdad " + Edad;
    }

}
