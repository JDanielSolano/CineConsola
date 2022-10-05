package cine;

public class Sala {

    private String estadoDeSala;
    private String empleadoEncargado;
    private int numSala;
    private int filas;
    private int columnas;

    public Sala(int filas, int columnas, String estadoDeSala, String empleadoEncargado, int numSala) {
        this.estadoDeSala = estadoDeSala;
        this.numSala = numSala;
        this.empleadoEncargado = empleadoEncargado;
        this.filas = filas;
        this.columnas = columnas;
    }

    public String getEstadoDeSala() {
        return estadoDeSala;
    }

    public void setEstadoDeSala(String estadoDeSala) {
        this.estadoDeSala = estadoDeSala;
    }

    public String getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(String empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    @Override
    public String toString() {
        return "Sala" + "\nNúmero de asientos: " + (filas * columnas) + "\nEstado de la sala: " + estadoDeSala + "\nEmpleado Encargado: " + empleadoEncargado + "\nNúmero de Sala: " + numSala;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

}
