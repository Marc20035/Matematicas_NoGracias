package org.example;

public abstract class Termino {
    protected int coeficiente;
    protected int exponente;

    public Termino(int coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
}
