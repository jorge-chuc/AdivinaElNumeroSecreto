/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinaadivinador;

import java.util.Random;

/**
 *
 * @author JorgeLuis
 */
public class NumeroSecreto {
    private static final int LIM_INF_PREDET = 1;
    private static final int LIM_SUP_PREDET = 100;
    private int numero;
    private int limiteInferior;
    private int limiteSuperior;
    private Random generador;
    
    public NumeroSecreto() {
        this(LIM_INF_PREDET, LIM_SUP_PREDET);
    }
    
    public NumeroSecreto(int limiteInferior, int limiteSuperior) {
        this.setRango(limiteInferior, limiteSuperior);
        this.generador = new Random();
        this.generar();
    }
    
    public final void setRango(int limiteInferior, int limiteSuperior) {
        if (limiteInferior > limiteSuperior) {
            this.limiteInferior = LIM_INF_PREDET;
            this.limiteSuperior = LIM_SUP_PREDET;
        }
        else {
            this.limiteInferior = limiteInferior;
            this.limiteSuperior = limiteSuperior;
        }
    }
    
    public final void generar() {
        this.numero = generador.nextInt(limiteSuperior) + 1;
    }
    
    public int getNumeroSecreto() {
        return this.numero;
    }
    
    public int getLimiteInferior() {
        return this.limiteInferior;
    }
    
    public int getLimiteSuperior() {
        return this.limiteSuperior;
    }
    
    public boolean esMayor(int numero) {
        boolean elNumeroSecretoEsMayor;
        if (this.numero > numero) {
            elNumeroSecretoEsMayor = true;
        }
        else {
            elNumeroSecretoEsMayor = false;
        }
        return elNumeroSecretoEsMayor;
    }
    
    public boolean esMenor(int numero) {
        boolean elNumeroSecretoEsMenor = false;
        if (this.numero < numero) {
            elNumeroSecretoEsMenor = true;
        }
        return elNumeroSecretoEsMenor;
    }
    
    public boolean esIgual(int numero) {
        return (this.numero == numero);
    }
    
    public static void main(String[] args) {
        NumeroSecreto ns = new NumeroSecreto(1000, 1);
        int numero = ns.getNumeroSecreto();
        System.out.println("El número secreto es " + numero);
        System.out.println("Límite inferior del número secreto: " + 
                ns.getLimiteInferior());
        System.out.println("Límite superior del número secreto: " + 
                ns.getLimiteSuperior());
        if (ns.esIgual(numero) == true) {
            System.out.println("\t" + numero + " es igual al número secreto");
        }
        else {
            System.out.println("\t" + numero + " NO es igual al número secreto");
        }
        if (ns.esIgual(-1) == true) {
            System.out.println("\t" + numero + " es igual al número secreto");
        }
        else {
            System.out.println("\t-1 NO es igual al número secreto");
        }
        if (ns.esMenor(numero + 1) == true) {
            System.out.println("\tEl número secreto es menor que el número " 
                    + (numero + 1));
        }
        else {
            System.out.println("\tEl número secreto NO es menor que el número " 
                    + (numero + 1));
        }
        if (ns.esMenor(numero) == true) {
            System.out.println("\tEl número secreto es menor que el número " 
                    + numero);
        }
        else {
            System.out.println("\tEl número secreto NO es menor que el número " 
                    + numero);
        }
        if (ns.esMayor(numero - 1) == true) {
            System.out.println("\tEl número secreto es mayor que el número " 
                    + (numero - 1));
        }
        else {
            System.out.println("\tEl número secreto NO es mayor que el número " 
                    + (numero - 1));
        }
        if (ns.esMayor(numero) == true) {
            System.out.println("\tEl número secreto es mayor que el número " 
                    + numero);
        }
        else {
            System.out.println("\tEl número secreto NO es mayor que el número " 
                    + numero);
        }
    }
}
