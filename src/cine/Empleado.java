package cine;

public class Empleado {

    private int id;
    private int Cedula;
    private int Edad;
    private String Nombre;
    private String Puesto;

    public Empleado() {
    }

    public Empleado(int id, int Cedula) {
        this.id = id;
        this.Cedula = Cedula;
    }

    public Empleado(int id, int Cedula, int Edad) {
        this.id = id;
        this.Cedula = Cedula;
        this.Edad = Edad;
    }

    public Empleado(int id, int Cedula, int Edad, String Nombre) {
        this.id = id;
        this.Cedula = Cedula;
        this.Edad = Edad;
        this.Nombre = Nombre;
    }

    public Empleado(int id, int Cedula, int Edad, String Nombre, String Puesto) {
        this.id = id;
        this.Cedula = Cedula;
        this.Edad = Edad;
        this.Nombre = Nombre;
        this.Puesto = Puesto;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
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

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
