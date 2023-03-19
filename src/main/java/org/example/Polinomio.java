package org.example;

import java.util.HashMap;

public class Polinomio implements IPolinomio {
    private int grado;
    private HashMap<Integer, DatoPolinomio> terminos;
    public Polinomio() {
        this.grado = 0;
        this.terminos = new HashMap<Integer, DatoPolinomio>();
    }
    @Override
    public void agregarTermino(int coeficiente,int exponente){
        if(coeficiente != 0){
            DatoPolinomio termino = new DatoPolinomio(coeficiente, exponente);
            this.terminos.put(exponente, termino);
            if(exponente > this.grado){
                this.grado = exponente;
            }
        }
    }
    @Override
    public void modificarTermino(int coeficiente, int exponente){
        if(this.terminos.containsKey(exponente)){
            if(coeficiente != 0){
                this.terminos.get(exponente).coeficiente = coeficiente;
            }else {
                  eliminarTermino(exponente);
            }
        }
    }
    @Override
    public int obtenerValor(int exponente){
        return this.terminos.getOrDefault(exponente, new DatoPolinomio(0, exponente)).coeficiente;
    }
    @Override
    public boolean existeTermino(int exponente){
        return this.terminos.containsKey(exponente);
    }
    @Override
    public void eliminarTermino(int exponente){
        this.terminos.remove(exponente);
    }
    @Override
    public IPolinomio sumar(IPolinomio otroPolinomio) {
        Polinomio resultado = new Polinomio();

        for (Integer exponente : this.terminos.keySet()) {
            int coeficiente = this.terminos.get(exponente).coeficiente;
            resultado.agregarTermino(coeficiente, exponente);
        }

        for (Integer exponente : ((Polinomio) otroPolinomio).terminos.keySet()) {
            int coeficiente = ((Polinomio) otroPolinomio).terminos.get(exponente).coeficiente;
            coeficiente += resultado.obtenerValor(exponente);
            resultado.modificarTermino(coeficiente, exponente);
        }

        return resultado;
    }

    @Override
    public IPolinomio multiplicar(IPolinomio otroPolinomio) {
        Polinomio resultado = new Polinomio();

        for (Integer exp1 : this.terminos.keySet()) {
            int coef1 = this.terminos.get(exp1).coeficiente;

            for (Integer exp2 : ((Polinomio) otroPolinomio).terminos.keySet()) {
                int coef2 = ((Polinomio) otroPolinomio).terminos.get(exp2).coeficiente;
                int nuevoCoeficiente = coef1 * coef2;
                int nuevoExponente = exp1 + exp2;

                nuevoCoeficiente += resultado.obtenerValor(nuevoExponente);
                resultado.modificarTermino(nuevoCoeficiente, nuevoExponente);
            }
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Polinomio{" +
                "grado=" + grado +
                ", terminos=" + terminos +
                '}';
    }

    @Override
    public void mostrar() {
        StringBuilder polinomioStr = new StringBuilder();

        for (Integer exponente : this.terminos.keySet()) {
            int coeficiente = this.terminos.get(exponente).coeficiente;
            if (coeficiente != 0) {
                polinomioStr.append(String.format("%+d", coeficiente));

                if (exponente > 0) {
                    polinomioStr.append("x");
                    if (exponente > 1) {
                        polinomioStr.append("^").append(exponente);
                    }
                }
            }
        }

        if (polinomioStr.length() == 0) {
            System.out.println("0");
        } else {
            System.out.println(polinomioStr.toString());
        }

    }
}


