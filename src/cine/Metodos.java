package cine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Metodos {

    public static final String INGRESAR_NOMBRE = "Ingrese su nombre";
    public static final String INGRESAR_CEDULA = "Ingrese su cédula";
    public static final String INGRESAR_EDAD = "Ingrese su edad";
    public static final String CANTIDAD_ENTRADAS = "¿Cuántas entradas desea?";
    public static int id = 0;
    public static int salaID = 0;

    private static Cliente clientes[] = new Cliente[20];
    private static Empleado empleados[] = new Empleado[2];
    private static Pelicula peliculas[] = new Pelicula[4];
    private static Sala salas[] = new Sala[8];
    private static Funcionamiento funcionamiento[] = new Funcionamiento[4];
    private static List pagos = new ArrayList();

    public static void llenarFuncionamiento() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 18);
        c.set(Calendar.MINUTE, 30);
        funcionamiento[0] = new Funcionamiento(c, salas[0], peliculas[0], salas[0].getEmpleadoEncargado(), 1500);
        c = Calendar.getInstance();
        c.set(Calendar.HOUR, 19);
        c.set(Calendar.MINUTE, 00);
        funcionamiento[1] = new Funcionamiento(c, salas[1], peliculas[1], salas[1].getEmpleadoEncargado(), 1500);
        c = Calendar.getInstance();
        c.set(Calendar.HOUR, 20);
        c.set(Calendar.MINUTE, 40);
        funcionamiento[2] = new Funcionamiento(c, salas[2], peliculas[2], salas[2].getEmpleadoEncargado(), 3500);
        c = Calendar.getInstance();
        c.set(Calendar.HOUR, 21);
        c.set(Calendar.MINUTE, 15);
        funcionamiento[3] = new Funcionamiento(c, salas[0], peliculas[3], salas[0].getEmpleadoEncargado(), 1500);
    }

    public static void llenarPelicula() {
        peliculas[0] = new Pelicula("Batman vs Superman", "PG");
        peliculas[1] = new Pelicula("Kung Fu Panda", "PG");
        peliculas[2] = new Pelicula("Zootopia 3D", "PG");
        peliculas[3] = new Pelicula("Deadpool", "M+18");
    }

    public static void llenarEmpleado() {
        empleados[0] = new Empleado(2341231, 11673445, 20, "Carlos Vargas", "Gerente");
        empleados[1] = new Empleado(321565, 121342213, 29, "Natasha Saavedra", "Administradora");
    }

    public static void llenarCliente() {
        clientes[0] = new Cliente(1, 121728192, "Gabriel Abarca", 23);
        clientes[1] = new Cliente(2, 9282944, "Daniel Dumas", 22);
        id = 1;
    }

    public static void llenarSalas() {
        salas[0] = new Sala(10, 6, "ACT", "Miguel", 1);
        salas[1] = new Sala(12, 5, "ACT", "Roberto", 2);
        salas[2] = new Sala(4, 7, "ACT", "María", 3);
        salaID = 2;
    }

    public static void llenarCLiente(int cedula, String nombre, int edad) {
        id++;
        clientes[id] = new Cliente(id + 1, cedula, nombre, edad);
    }

    public static int demeInfo(String mensaje) {
        try {
            String s = javax.swing.JOptionPane.showInputDialog(mensaje);
            if (s == null) {
                return -1;
            }
            int n = Integer.parseInt(s);
            return n;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una opción valida", "Error", JOptionPane.ERROR_MESSAGE, null);
            return demeInfo(mensaje);
        }
    }

    public static void Menu() {
        Metodos.llenarCliente();
        llenarEmpleado();
        llenarPelicula();
        llenarSalas();
        llenarFuncionamiento();
        while (true) {
            String s = "1. Ingresar Datos. \n"
                    + "2. Comprar entradas de la película \n"
                    + "3. Imprimir \n"
                    + "4. Salir";
            int opciones = demeInfo(s);

            switch (opciones) {
                case 1:
                    int cedula = demeInfo(INGRESAR_CEDULA),
                     edad = demeInfo(INGRESAR_EDAD);
                    String nombre = javax.swing.JOptionPane.showInputDialog(INGRESAR_NOMBRE);
                    //System.out.println(INGRESAR_DATOSPERSONALES);
                    //int i = demeInfo(INGRESAR_DATOSPERSONALES);
                    Metodos.llenarCLiente(cedula, nombre, edad);
                    break;

                case 2:
                    String opcionPeliculasMensaje = "Seleccione la película \n" + obtenerPelicula();
                    int indicePelicula = demeInfo(opcionPeliculasMensaje);
                    if (indicePelicula > peliculas.length || indicePelicula <= 0) {
                        javax.swing.JOptionPane.showMessageDialog(null, "Película no existente", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (indicePelicula > 0) {
                        Pelicula p = peliculas[indicePelicula - 1];
                        //seleccionar funcion
                        String funcionesString = obtenerFuncionesXPelicula(p);
                        if (funcionesString == null) {
                            break;
                        }
                        int seleccionDeFuncion = demeInfo(funcionesString);
                        Funcionamiento f = obtenerFuncionSelecciona(p, seleccionDeFuncion);
                        //Seleccionar las entradas.
                        //TODO validar la cantidad de entradas.
                        int entradas = demeInfo(CANTIDAD_ENTRADAS);

                        if (entradas <= 0) {
                            JOptionPane.showMessageDialog(null, "Numero de Entradas Inválido", "ERROR", JOptionPane.ERROR_MESSAGE);
                        } else {
                            //TODO validar la cantidad de entradas vendidas
                            anadirEntradas(f, entradas);

                            //TODO montrar resultado de la compra
                            Pago pago = new Pago(entradas, p.getNombre(), entradas * f.getPrecio(), f.getPrecio());
                            //TODO guardar pago
                            System.out.println(pago.toString());
                            pagos.add(pago);
                        }
                    }
                    break;

                case 3:
                    String opcionImprimir = "1. Imprimir Clientes. \n"
                            + "2. Imprimir Películas \n"
                            + "3. Imprimir Funciones  \n"
                            + "4. Imprimir Recibos \n"
                            + "5. Salir \n";
                    switch (demeInfo(opcionImprimir)) {
                        case 1:
                            String clientesImp = "";
                            for (int i = 0; i < clientes.length; i++) {
                                if (clientes[i] != null) {
                                    clientesImp += clientes[i].toString() + "\n";
                                }
                            }
                            System.out.print(clientesImp);
                            break;
                        case 2: //Peliculas
                            String pelSelec = "";
                            for (int i = 0; i < peliculas.length; i++) {
                                if (peliculas[i] != null) {
                                    pelSelec += peliculas[i].toString() + "\n";
                                }
                            }
                            System.out.println(pelSelec);
                            break;
                        case 3: //Funciones
                            String funcionImp = "";
                            for (int i = 0; i < funcionamiento.length; i++) {
                                if (funcionamiento[i] != null) {
                                    funcionImp += funcionamiento[i].toString() + "\n";

                                }
                                System.out.println(funcionImp);
                            }
                        case 4: //Pagos
                            String entradasImp = "";
                            for (int i = 0; i < pagos.size(); i++) {
                                entradasImp += pagos.get(i).toString() + "\n";
                            }
                            System.out.println(entradasImp);
                            break;

                    }
                    break;
                case -1:
                case 4:
                    System.exit(0);

            }

        }
    }

    public static String obtenerSalas() {
        String salasValue = "";
        for (int i = 0; i < salas.length; i++) {
            if (salas[i] != null) {
                salasValue += salas[i].getNumSala() + "\n";
            }
        }
        return salasValue;
    }

    public static String obtenerPelicula() {
        String peliculasValue = "";
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                peliculasValue += (i + 1) + ". " + peliculas[i].getNombre() + "\n";
            }
        }
        return peliculasValue;
    }

    public static String obtenerFuncionesXPelicula(Pelicula p) {
        String funcionesValue = "";
        int posicion = 0;
        for (int i = 0; i < funcionamiento.length; i++) {
            if (funcionamiento[i] != null && funcionamiento[i].getPelicula().getNombre() == p.getNombre()) {
                funcionesValue += (posicion + 1) + ". " + funcionamiento[i].toString() + "\n";
                posicion++;
            }
        }
        return funcionesValue;
    }

    public static Funcionamiento obtenerFuncionSelecciona(Pelicula p, int seleccion) {
        Funcionamiento[] funcionesXPelicula = new Funcionamiento[funcionamiento.length];
        int posicion = 0;
        for (int i = 0; i < funcionamiento.length; i++) {
            if (funcionamiento[i] != null && funcionamiento[i].getPelicula().getNombre() == p.getNombre()) {
                funcionesXPelicula[posicion] = funcionamiento[i];
            }
        }
        return funcionesXPelicula[seleccion - 1];
    }

    public static void anadirEntradas(Funcionamiento f, int cantidadEntradas) {
        System.err.println(f.imprimirAsientos());
        int i = 0;
        while (i < cantidadEntradas) {
            String posicion = JOptionPane.showInputDialog(null, "Digite la posición", "");
            String fila = posicion.toUpperCase().substring(0, 1);
            String columna = posicion.substring(1, posicion.length());
            boolean anadido = f.anadirEntradas(fila, Integer.parseInt(columna) - 1);
            if (anadido) {
                i++;
                System.err.println(f.imprimirAsientos());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Inválido", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
