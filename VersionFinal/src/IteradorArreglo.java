/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Cuauhtémoc Zamarripa
 */
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
