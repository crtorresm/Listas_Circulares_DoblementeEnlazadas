/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdoblemente;

/**
 *
 * @author christom
 */
public class LCDE {

    private Nodo cabecera;

    public LCDE() {
        cabecera = null;
    }

    public boolean esVacia() {
        return cabecera == null;
    }

    public void InsertarInicio(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(valor);
        if (esVacia()) {
            cabecera = nuevo;
            nuevo.setAnterior(cabecera);
            nuevo.setSiguiente(cabecera);

        } else {
            nuevo.setAnterior(cabecera.getAnterior());
            nuevo.setSiguiente(cabecera);
            cabecera.getAnterior().setSiguiente(nuevo);
            cabecera.setAnterior(nuevo);
            cabecera = nuevo; // Actualiza el nuevo nodo como la cabecera
        }

    }

    public void InsertarFinal(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(valor);
        if (esVacia()) {
            nuevo.setAnterior(cabecera);
            nuevo.setSiguiente(cabecera);
        } else {
            nuevo.setAnterior(cabecera.getAnterior());
            nuevo.setSiguiente(cabecera);
            cabecera.getAnterior().setSiguiente(nuevo);
            cabecera.setAnterior(nuevo);
        }
    }

    public void InsertarAntesdeunNodo(int valorReferido, int valorInsertar) {

        if (!esVacia()) {
            Nodo aux = cabecera;
            do {
                if (aux.getDato() == valorReferido) {
                    Nodo nuevo = new Nodo();
                    nuevo.setDato(valorInsertar);
                    nuevo.setAnterior(aux.getAnterior());
                    nuevo.getAnterior().setSiguiente(nuevo);
                    nuevo.setSiguiente(aux);
                    aux.setAnterior(nuevo);
                    System.out.println("Se inserto con exito");
                    return;

                } else {
                    aux = aux.getSiguiente();
                }
            } while (aux != cabecera);
        }
        System.out.println("No se pudo insertar, no existe valor referido");
    }

    public void InsertarDespuesdeunNodo(int valorReferido, int valorInsertar) {

        if (!esVacia()) {
            Nodo aux = cabecera;
            do {
                if (aux.getDato() == valorReferido) {
                    Nodo nuevo = new Nodo();
                    nuevo.setDato(valorInsertar);
                    nuevo.setSiguiente(aux.getSiguiente());
                    nuevo.getSiguiente().setAnterior(nuevo);
                    nuevo.setAnterior(aux);
                    aux.setSiguiente(nuevo);
                    System.out.println("Se inserto con exito");
                    return;
                } else {
                    aux = aux.getSiguiente();
                }
            } while (aux != cabecera);
        }
        System.out.println("No se pudo insertar, no existe valor referido");
    }
//Mostrar hacia adelante la lista

    public void Mostrar1() {
        if (esVacia()) {
            return;
        }
        Nodo aux = cabecera;
        do {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        } while (aux != cabecera);
    }

    //Mostrar hacia atras la lista
    public void Mostrar2() {
        if (esVacia()) {
            return;
        }
        Nodo aux = cabecera.getAnterior();
        do {
            System.out.println(aux.getDato());
            aux = aux.getAnterior();
        } while (aux != cabecera.getAnterior());
    }

    public void borrarlista() {
        cabecera = null;
    }

    public void borrarPrimero() {
        if (!esVacia()) {
            Nodo aux = cabecera.getAnterior();
            aux.setSiguiente(cabecera.getSiguiente());
            cabecera.getSiguiente().setAnterior(aux);
            //se abandona el primer nodo
            cabecera = aux.getSiguiente();

            //Se valida que no tenga un solo nodo
            if (cabecera == (cabecera.getSiguiente())) {
                cabecera = null;
            }
        System.out.println("Se ha borrado el primer nodo de la LCD");
        }
    }

    public void borrarUltimo() {
        if (!esVacia()) {
            Nodo aux = cabecera.getAnterior();
            aux.getAnterior().setSiguiente(cabecera);
            cabecera.setAnterior(aux.getAnterior());

            cabecera.getAnterior().getAnterior().setSiguiente(cabecera);
            cabecera.setAnterior(cabecera.getAnterior().getAnterior());

//Se valida que no tenga un solo nodo
            if (cabecera == cabecera.getSiguiente()) {
                cabecera = null;
            }
            System.out.println("Se ha borrado un nodo al final de la LCD");
        }
    }

    public void eliminar(int valor) {
        if (esVacia()) {
            System.out.println("No hay datos..");
            return;
        }
        Nodo aux = cabecera;
        do {
            if (aux.getDato() == valor) {

                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());

                if (aux == cabecera) {
                    cabecera = aux.getSiguiente();
                }
                if (aux == cabecera) {
                    cabecera = null;
                }
                System.out.println("Dato eliminado");
                return;
            } else {
                aux = aux.getSiguiente();
            }
            System.out.println("No existe esa informacion en la lista...");
        } while (aux != cabecera);

        cabecera = cabecera.getSiguiente();
    }

}
