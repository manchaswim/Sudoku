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
    
    private void expande(){
        T nuevo[]=(T[]) new Object[conj.length*2];
        for(int i=0;i<=cardin;i++){
            nuevo[i]=conj[i];
        }
        conj=nuevo;
    }
    
    private int buscaElem(T dato){
        int i;
        i = 0;
        while(i<cardin&&!conj[i].equals(dato)){
            i++;
        }
        if(i==cardin){
            i=-1;
        }
        return i;
    }
    
    public boolean agrega(T dato){
        boolean resp=false;
        if(!contiene(dato)){
            resp=true;
            if(cardin==conj.length){
                expande();
            }
            conj[cardin]=dato;
            cardin++;
        }
        return resp;
    }
    
    public T quita(T dato){
        T resul=null;
        int pos;
        pos = buscaElem(dato);
        if(pos>=0){
            resul=conj[pos];
            conj[pos]=conj[cardin-1];
            conj[cardin-1]=null;
            cardin = cardin-1;
        }
        return resul;
    }
    
    public T quitaAleat(){
        T resul=null;
        if(!estaVacio()){
            int elegido;
            elegido = (int)Math.floor(Math.random()*cardin);
            resul=conj[elegido];
            conj[elegido]=conj[cardin-1];
            conj[cardin-1]=null;
            cardin--;
        }
        return resul;
    }
    
    public boolean contiene(T dato){
        Iterator<T> it = iterator();
        boolean resp=false;
        while(it.hasNext()&&!resp){
            resp=it.next().equals(dato);
        }
        return resp;
    }
    
    public int getCardinalidad(){
        return cardin;
    }
    
    public boolean estaVacio(){
        return cardin==0;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        for(int i=0;i<cardin;i++){
            cad.append(conj[i]).append(" ");
        }
        return cad.toString();
    }
    
    /*public String toString(){
        Iterator <T> it=iterator();
        
        while(it.hasNext()){
            cad.append(it.Next()).append(" ");
        }
        return cad.toString();
    }*/
    public ConjuntoADT<T> union(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null){
            resul=null;
        }
        else{
            resul = new ConjuntoA();
            int i;
            for(i=0;i<cardin;i++){
                resul.agrega(conj[i]);
            }
            for(i=0;i<((ConjuntoA)otro).cardin;i++){
                resul.agrega(((ConjuntoA<T>)otro).conj[i]);
            }
        }
        return resul;
    }
    
    /*public ConjuntoADT<T> union(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null){
            resul=null;
        }
        else{
            resul = new ConjuntoA();
            Iterator <T> it = this.iterator();
            while(it.hasNext()){
                resul.agrega(it.next());
            }
            it = otro.iterator();
            while(it.hasNext()){
                resul.agrega(it.next());
            }
        }
        return resul;
    }*/
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro){
       ConjuntoADT<T> resul;
        if(otro==null){
            resul=null;
        }
        else{
            resul = new ConjuntoA();
            for(int i=0;i<cardin;i++){
                if(otro.contiene(conj[i])){
                    resul.agrega(conj[i]);
                }
            }
        }
        return resul; 
    }
    
    /*public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro){
       ConjuntoADT<T> resul;
        if(otro==null){
            resul=null;
        }
        else{
            resul = new ConjuntoA();
            T aux;
            Iterator <T> it = this.iterator();
            while(it.hasNext()){
                aux = it.next();
                if(otro.contiene(aux)){
                    resul.agrega(aux);
                }
            }
        }
        return resul; 
    }*/
    
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null){
            resul=null;
        }
        else{
            resul = new ConjuntoA();
            
            for(int i=0;i<cardin;i++){
                if(!otro.contiene(conj[i])){
                    resul.agrega(conj[i]);
                }
            }
        }
        return resul;
    }
    
    /*public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro){
        ConjuntoADT<T> resul;
        if(otro==null){
            resul=null;
        }
        else{
            resul = new ConjuntoA();
            T aux;
            Iterator <T> it = this.iterator();
            while(it.hasNext()){
                aux = it.next();
                if(!otro.contiene(aux)){
                    resul.agrega(aux);
                }
            }
        }
        return resul;
    }*/
    
    public boolean equals(Object otro){
        boolean resp=true;
        if(this.getCardinalidad()==((ConjuntoADT<T>)otro).getCardinalidad()||otro!=null){
            Iterator <T> it = this.iterator();
            while(it.hasNext()||resp){
                if(((ConjuntoADT<T>)otro).contiene(it.next())){
                    resp=!resp;
                }
            }
        }
        else{
            resp=!resp;
        }
        return resp;
    }
    
        public boolean equals2(Object otro){
        boolean resp=false;
        if(otro!=null){
            if(otro instanceof ConjuntoADT){
                if(this.getCardinalidad()==((ConjuntoADT<T>)otro).getCardinalidad()){
                    if(diferencia((ConjuntoADT)otro).estaVacio()){
                        resp=!resp;
                    }
                }
            }
        }
        return resp;
    }
}
