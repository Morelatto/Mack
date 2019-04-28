/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressao;

/**
 *
 * @author Pedro
 * @param <E>
 */
public class Pilha<E> {

    private final E elementos[];
    private int topo;

    public Pilha(int N) {
        this.elementos = (E[]) new Object[N];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public void push(E elemento) {
        this.elementos[++topo] = elemento;
    }

    public E pop() {
        return this.elementos[topo--];
    }

    public E getTopo() {
        return (topo != -1) ? this.elementos[topo] : this.elementos[topo + 1];
    }

}
