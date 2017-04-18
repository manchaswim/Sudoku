 import java.util.Iterator;
/**
 *
 * @authors Diana Virginia Hernández Mejía , Cuauhtémoc Gonzalo Zamarripa Armida, 
 * Víctor Cuauhtémoc Vargas Ramírez, Marco Antonio Chacón Amaro  y 
 * Susana Muñoz Acosta 
 * @param <T>
 */
public interface ConjuntoADT<T> extends Iterable<T> {
    /**
     *Metodo: Iterator
     * @return iterator <T>
     */
    public Iterator<T> iterator();
    /**
     *Metodo:Agrega
     * @param <T> dato
     * @return boolean si es posible o no agregar
     */
    public boolean agrega(T dato);
    /**
     *Metodo: Quita
     * @param <T> dato
     * @return <T> el dato que quita
     */
    public T quita(T dato);
    /**
     *Metood: Quitar Aleatoriamente
     * @return <T> del dalto que se quita
     */
    public T quitaAleat();
    /**
     *Metodo: Contiene
     * @param <T> dato
     * @return boolean si esta o no
     */
    public boolean contiene(T dato);
    /**
     *Metodo: Obtener la cardinalidad
     * @return int de la cantidad de elementos del conjunto
     */
    public int getCardinalidad();
    /**
     *Metodo: Esta vacio 
     * @return boolean si esta o no vacio
     */
    public boolean estaVacio();
    /**
     *Metodo: union
     * @param <T> otro
     * @return ConjuntoADT <T> de la union
     */
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    /**
     *Metodo: Interssección
     * @param <T> otro
     * @return ConjuntoADT<T> de la intersección
     */
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    /**
     *Metodo: Diferencia
     * @param <T> otro
     * @return ConjuntoADT <T> de la diferenica
     */
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);
}
