
package ejemploconjunto;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorArreglo<T> implements Iterator<T> {
    
    private T colec[];
    private int total;
    private int actual;
    
    public IteradorArreglo(T arre[], int cantE){
        colec = arre;
        total=cantE;
        actual=0;
        
    }
    public boolean hasNext(){
        return actual<total;
    }
    
    public T next(){
        if(!hasNext())
            throw new NoSuchElementException();
        else{
            T res = colec[actual];
            actual++;
            return res;
        }
            
    }
    
    public void remove(){
        throw new UnsupportedOperationException();
    }
}


