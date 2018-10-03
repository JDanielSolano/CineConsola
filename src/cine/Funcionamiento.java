package cine;

import java.util.Calendar;

public class Funcionamiento {

    private Calendar hora;
    private Sala sala;
    private Pelicula pelicula;
    private String empleadoEncargado;
    private double precioTiquete;
    private boolean entradas[][];
    private int Num20 = 0;
    private String letra;

    private final static char FILAS[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'X', 'W', 'Y', 'Z'};

    public Funcionamiento() {
    }

    public Funcionamiento(Sala sala, Pelicula pelicula, double precioTiquete) {
        this(Calendar.getInstance(), sala, pelicula, "N/A", precioTiquete);
    }

    public Funcionamiento(Calendar hora, Sala sala, Pelicula pelicula, double precioTiquete) {
        this(hora, sala, pelicula, "N/A", precioTiquete);
    }

    public Funcionamiento(Calendar hora, Sala sala, Pelicula pelicula, String empleadoEncargado, double precioTiquete) {
        this.hora = hora;
        this.sala = sala;
        this.pelicula = pelicula;
        this.empleadoEncargado = empleadoEncargado;
        this.precioTiquete = precioTiquete;
        this.entradas = new boolean[sala.getFilas()][sala.getColumnas()];
    }

    public String getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(String empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String toString() {
        return "Sala: " + sala.getNumSala() + "\nHora: " + hora.get(Calendar.HOUR) + hora.get(Calendar.MINUTE) + "\nPelícula: " + pelicula.getNombre() + "\nPrecio: " + getPrecioTiquete() + "\nEmpleado Encargado: " + getEmpleadoEncargado() + "\n";
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecio() {
        return getPrecioTiquete();
    }

    public void setPrecio(double precio) {
        this.setPrecioTiquete(precio);
    }

    public double getPrecioTiquete() {
        return precioTiquete;
    }

    public void setPrecioTiquete(double precioTiquete) {
        this.precioTiquete = precioTiquete;
    }

    public boolean anadirEntradas(String fila, int columna) {
        Num20 = columna + 1;
        letra = fila;
        System.out.println("Asiento: " + letra + Num20);
        boolean find = false;
        int i = 0;
        while (!find && i < FILAS.length) {
            find = fila.charAt(0) == FILAS[i];
            if (!find) {
                i++;
            }
        }
        if (!entradas[i][columna]) {
            entradas[i][columna] = true;
            return true;
        } else {
            return false;
        }
    }

    public String imprimirAsientos() {
        String valor = " ";
        for (int i = 0; i < entradas[0].length; i++) {
            valor += (i + 1) + (i < entradas[0].length - 1 ? "," : "");
        }
        valor += "\n";
        for (int i = 0; i < entradas.length; i++) {
            valor += FILAS[i] + " ";
            for (int j = 0; j < entradas[i].length; j++) {
                valor += (entradas[i][j] ? "X" : "O") + (j < (entradas[i].length - 1) ? "," : "");
            }
            valor += "\n";
        }
        return valor;
    }
}
