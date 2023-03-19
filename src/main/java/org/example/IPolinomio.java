package org.example;

public interface IPolinomio {
    void agregarTermino(int coeficiente, int exponente);
    void eliminarTermino(int exponente);
    void modificarTermino(int coeficiente, int exponente);
    int obtenerValor(int exponente);
    boolean existeTermino(int exponente);
    IPolinomio sumar(IPolinomio polinomio);
    IPolinomio multiplicar(IPolinomio polinomio);
    void mostrar();
}
