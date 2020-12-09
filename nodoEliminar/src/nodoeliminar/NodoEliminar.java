/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoeliminar;

import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class NodoEliminar {
   
    Scanner sc = new Scanner(System.in);
    
    static class Nodo {
        String dato;
        Nodo sig;
    }
    
    Nodo fin = null;

    public void agregar() {
        Nodo temp;
        String msg;
        System.out.println("agregar el dato ");
        if (fin == null) {
            fin = new Nodo();
            fin.dato = sc.nextLine();
            fin.sig = null;
        } else {
            temp = new Nodo();
            temp.dato = sc.nextLine();
            temp.sig = fin;
            fin = temp;
        }
    }

    public void mostrar() {
        Nodo actual = new Nodo();
        actual = fin;
        if (fin != null) {
            while (actual != null) {
                System.out.print(" DATO " + "[" + actual.dato + "]");
                actual = actual.sig;
            }
        } else {
            System.out.println("\n La lista se encuentra vacia\n");
        }
    }
    
    public void eliminarU(){
        Nodo eliminarU = new Nodo(); //creamos un nuevo nodo
        eliminarU = fin.sig; //aqui va a sustituir un nodo vacio por el ultimo
        fin = eliminarU; //aqui se hace la sustitucion del nodo para mostrar en pantalla
    }
    
    public void eliminarP(){
            fin = fin.sig; //recorremos el nodo desde null > dato > dato > dato > null 
            fin.sig = null; //va pasando el nodo haciendo cada dato un null (null > null > dato > null > null) 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        String dato;
        NodoEliminar n = new NodoEliminar();
        do {
            System.out.println("1 add \n"
                    + "2 mostrar \n"
                    + "3 eliminar ambos nodos (atras y adelante) \n"
                    + "4 eliminar ultimo nodo\n"
                    + "5 salir");
            switch (opt = sc.nextInt()) {
                case 1:
                    n.agregar();
                    break;

                case 2:
                    n.mostrar();
                    break;
                    
                case 3:
                    n.eliminarP();
                    break;
                    
                case 4:
                    n.eliminarU();
                    break;
            }
        } while (opt != 5);
    }
}