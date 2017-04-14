import java.util.Iterator;
public class ConjuntoA<T> implements ConjuntoADT<T> {
    private T conj[];
    private int cardin;
    
    public ConjuntoA(){
        conj = (T[]) new Object[10];
        cardin=0;
    }
    
    public Iterator<T> iterator(){
        return new IteradorArreglo(conj,cardin);
    }
    
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
    
    public boolean contiene(T dato){
        Iterator<T> it = this.iterator();
        boolean resp=false;
        while(it.hasNext()&&!resp)
            resp=it.next().equals(dato);
        return resp;
    }
    
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
    
    public boolean equals2(Object otro){
        boolean res=false;
        if(otro!=null)
            if(otro instanceof ConjuntoADT)
                if(cardin==((ConjuntoADT)otro).getCardinalidad())
                    if(diferencia((ConjuntoADT)otro).estaVacio())
                        res=true;
        return res;
    }
    
    public int getCardinalidad(){
        return cardin;
    }
    
    public boolean estaVacio(){
        return cardin==0;
    }
    
    public void expande(){
        
        T nuevo[]=(T[]) new Object[conj.length*2];
        for(int i=0;i<=cardin;i++)
            nuevo[i]=conj[i];
        conj=nuevo;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        for(int i=0;i<cardin;i++)
            cad.append(conj[i]).append(" ");
        return cad.toString();
    }
    
    public String toString2(){
        StringBuilder cad = new StringBuilder();
        Iterator <T> it = iterator();
        while(it.hasNext())
            cad.append(it.next()).append(" ");
        return cad.toString();
    }
    
    public ConjuntoADT<T> union(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null)
            resul=null;
        else{
            resul=new ConjuntoA();
            int i;
            for(i=0;i<cardin;i++)
                resul.agrega(conj[i]);
            //2da opción
            /*Iterator <T> it = iterator();
            while(it.hasNext())
                resul.agrega(it.next());
            it=otro.iterator();
            while (it.hasNext())
                resul.agrega(it.next());*/
            //
            for(i=0;i<((ConjuntoA)otro).cardin;i++)
                resul.agrega(((ConjuntoA<T>)otro).conj[i]);
        }
        return resul;
    }
    //Hacer intersección de tarea:
    
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
    
    public ConjuntoADT<T> diferenciaRec(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null)
            resul=null;
        else{
            resul=new ConjuntoA();
            Iterator<T> it =iterator();
            return diferenciaAux(resul,otro,it);
        }
        return resul;
    }
    
    private ConjuntoADT<T> diferenciaAux(ConjuntoADT<T> resul, ConjuntoADT<T> otro, Iterator<T> it){
        if(it.hasNext()){
            T aux;
            aux=it.next();
            if(!otro.contiene(aux))
                resul.agrega(aux);
            return diferenciaAux(resul,otro,it);
        }
        else
            return resul;
    }
}

