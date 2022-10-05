package cine;

public class Pago {

    private int numEntradas;
    private String pelSelec;
    private double monto;
    private double precio;
    private Cliente c;

    public Pago() {
    }

    public Pago(int numEntradas, String pelSelec, double monto, double precio) {
        this.numEntradas = numEntradas;
        this.pelSelec = pelSelec;
        this.monto = monto;
        this.precio = precio;
    }

    public double getPagoMonto() {
        return monto;
    }

    public void setPagoMonto(double monto) {
        this.monto = monto;
    }

    public int getNumEntradas() {
        return numEntradas;
    }

    public void setNumEntradas(int numEntradas) {
        this.numEntradas = numEntradas;
    }

    public String getPelSelec() {
        return pelSelec;
    }

    public void setPelSelec(String pelSelec) {
        this.pelSelec = pelSelec;
    }

    @Override
    public String toString() {
        return "Pago:\n" + "Número de entradas: " + numEntradas + "\nPelícula seleccionada: " + pelSelec + "\nMonto unitario: " + precio + "\nMonto total: " + monto;
    }

}
