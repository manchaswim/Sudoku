/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploconjunto;

import java.util.Iterator;

/**
 *
 * @author manchaswim
 */
public interface ConjuntoADT<T> extends Iterable<T> {//extends porque son interfaces
    public Iterator<T> iterator();
    public boolean agrega(T dato);
    public T quita(T dato);
    public T quitaAleat();
    public boolean contiene(T dato);
    public int getCardinalidad();
    public boolean estaVacio();
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);
}
