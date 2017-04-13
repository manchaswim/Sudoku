 import java.util.Iterator;

public interface ConjuntoADT<T> extends Iterable<T> {
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
