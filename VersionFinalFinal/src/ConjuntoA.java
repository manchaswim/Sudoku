import java.util.Iterator;
/**
 *
 * @authors Diana Virginia Hernández Mejía , Cuauhtémoc Gonzalo Zamarripa Armida, 
 * Víctor Cuauhtémoc Vargas Ramírez, Marco Antonio Chacón Amaro  y 
 * Susana Muñoz Acosta 
 * @param <T>
 */
public class ConjuntoA<T> implements ConjuntoADT<T> {
    /**
     * Atributos
     */
    private T conj[];
    private int cardin;
    /**
     *Constructor por omision
     */
    public ConjuntoA(){
        conj = (T[]) new Object[10];
        cardin=0;
    }
    /**
     * Metodo: Iterator
     * @return IteratorArreglo
     */
    public Iterator<T> iterator(){
        return new IteradorArreglo(conj,cardin);
    }
    /**
     *Metodo: Agrega
     * @param <T> dato
     * @return boolean respuesta si se agrego o no
     */
    public boolean agrega(T dato){
        boolean resp=false;
        if(!contiene(dato)){
            resp=true;
            if(cardin==conj.length)
                expande();
            conj[cardin]=dato;
            cardin++;
        }
        return resp;
    }
    /**
     * Metodo: Busqueda de Elemento
     * @param <T> dato
     * @return int la posicion de elemento
     */
    private int buscaElem(T dato){
        int i;
        i=0;
        while(i<cardin && !conj[i].equals(dato)){
            i++;
        }
        if(i==cardin)
            i=-1;
        return i;
    }
    /**
     *Metodo: Quita Elemento
     * @param <T> dato
     * @return <T> el dato que quito
     */
    public T quita(T dato){
        T resul=null;
        int pos;
        pos=buscaElem(dato);
        if(pos>=0){
            resul=conj[pos];
            conj[pos]=conj[cardin-1];
            conj[cardin-1]=null;
            cardin--;
        }
        return resul;
    }
    /**
     *Metodo: Quita un metodo aletario
     * @return <T> el dato que quito
     */
    public T quitaAleat(){
        T resul=null;
        if(!estaVacio()){
            int elegido;
            elegido=(int) Math.floor(Math.random()*cardin);
            resul=conj[elegido];
            conj[elegido]=conj[cardin-1];
            conj[cardin-1]=null;
            cardin--;
        }
        return resul;
    }
    /**
     *Metodo: Contiene 
     * @param <T> dato
     * @return boolean respuesta de si esta o no esta
     */
    public boolean contiene(T dato){
        Iterator<T> it = this.iterator();
        boolean resp=false;
        while(it.hasNext()&&!resp)
            resp=it.next().equals(dato);
        return resp;
    }
    /**
     *Metodo: Equals
     * @param otro
     * @return boolean respuesta si es o no igual
     */
    public boolean equals(Object otro){
        boolean resp=true;
        try{
            ConjuntoADT<T> aux= ((ConjuntoADT<T>)otro);
            if(cardin==aux.getCardinalidad()){
                Iterator<T> it=iterator();
                while(it.hasNext() && resp)
                    if(!aux.contiene(it.next()))
                        resp=false;
            }
        }
        catch(Exception e){
            resp=false;
        }
        
        return resp;
    }
     /**
      * Metodo: Obtener cardinalidad
      * @return int de cardinalidad
      */
    public int getCardinalidad(){
        return cardin;
    }
    /**
     * Metodo: Esta vacio
     * @return boolean respuesta si esta o no vacio
     */
    public boolean estaVacio(){
        return cardin==0;
    }
    /**
     *Metodo: Expandir el conjunto
     */
    public void expande(){
        
        T nuevo[]=(T[]) new Object[conj.length*2];
        for(int i=0;i<=cardin;i++)
            nuevo[i]=conj[i];
        conj=nuevo;
    }
    /**
     * Metodo: toString
     * @return String del conjunto
     */
    public String toString(){
        StringBuilder cad = new StringBuilder();
        for(int i=0;i<cardin;i++)
            cad.append(conj[i]).append(" ");
        return cad.toString();
    }
    /**
     *Metodo: Union 
     * @param <T> otro
     * @return ConjuntoADT <T> de la union
     */
    public ConjuntoADT<T> union(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null)
            resul=null;
        else{
            resul=new ConjuntoA();
            int i;
            for(i=0;i<cardin;i++)
                resul.agrega(conj[i]);
            for(i=0;i<((ConjuntoA)otro).cardin;i++)
                resul.agrega(((ConjuntoA<T>)otro).conj[i]);
        }
        return resul;
    }
    /**
     *Metodo: Intersección
     * @param otro
     * @return ConjuntoADT<T> que contiene la intersección
     */
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null)
            resul=null;
        else{
            T aux;
            resul=new ConjuntoA();
            Iterator<T> it =iterator();
            while(it.hasNext()){
                aux=it.next();
                if(otro.contiene(aux))
                    resul.agrega(aux);
            }
        }
        return resul;
    }
    /**
     *Metodo: Diferencia
     * @param otro
     * @return ConjuntoADT <T> que contiene la diferencia
     */
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null)
            resul=null;
        else{
            T aux;
            resul=new ConjuntoA();
            Iterator<T> it =iterator();
            while(it.hasNext()){
                aux=it.next();
                if(!otro.contiene(aux))
                    resul.agrega(aux);
            }
        }
        return resul;
    }
}

