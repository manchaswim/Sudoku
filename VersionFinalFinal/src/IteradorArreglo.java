
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @authors Diana Virginia Hernández Mejía , Cuauhtémoc Gonzalo Zamarripa Armida, 
 * Víctor Cuauhtémoc Vargas Ramírez, Marco Antonio Chacón Amaro  y 
 * Susana Muñoz Acosta
 * @param <T>
 */
public class IteradorArreglo<T> implements Iterator<T> {
    /**
     * Atributos
     */
    private T colec[];
    private int total;
    private int actual;
    /**
     *Constructor por omision
     */
    public IteradorArreglo() {
    }
    /**
     *Constructor completo
     * @param <T> arre []
     * @param cantE int cantidad de elementos
     */
    public IteradorArreglo(T arre[], int cantE){
        colec = arre;
        total=cantE;
        actual=0;
        
    }
    /**
     *Metodo: HasNext
     * @return boolean si esta o no en un elemento
     */
    public boolean hasNext(){
        return actual<total;
    }
    /**
     * Metodo: Next 
     * @return <T> 
     */
    public T next(){
        if(!hasNext())
            throw new NoSuchElementException();
        else{
            T res = colec[actual];
            actual++;
            return res;
        }
            
    }
    /**
     *Metodo: Remove, quita un elemento
     */
    public void remove(){
        throw new UnsupportedOperationException();
    }
    
}
