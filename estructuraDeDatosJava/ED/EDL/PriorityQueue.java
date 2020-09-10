package ED.EDL;
public class PriorityQueue<T extends Comparable<T>>{
  private NodoDE<T> inicio;
  private NodoDE<T> fin;
  public PriorityQueue(){
   inicio=null;
   fin=null;
  }
  public void push(T dato){
   if(empty()){
    NodoDE<T> nuevo = new NodoDE<>(dato);
    inicio=nuevo;
    fin = nuevo;
   }else{
    NodoDE<T> finn = fin;
    push(this,dato,finn);
   }
  }
  private void push(PriorityQueue<T> queue,T dato,NodoDE<T> aux){
    if(aux==null){
     NodoDE<T> nuevo = new NodoDE<>(dato);
     nuevo.setS(inicio);
     inicio.setA(nuevo);
     inicio = nuevo;
    }else{
     if(dato.compareTo(aux.getD())>0){
      aux = aux.getA();
      push(queue,dato,aux);        
     }else{
      NodoDE<T> nuevo = new NodoDE<>(dato);
      if(aux.getS()==null){
       aux.setS(nuevo);
       nuevo.setA(aux);
       fin = nuevo;
      }else{
       nuevo.setS(aux.getS());
       aux.getS().setA(nuevo);
       aux.setS(nuevo);
       nuevo.setA(aux);
      }
     }
    }
  }
  public boolean empty(){
   return inicio==null;  
  }
  public T pop(){
    T res = null;
    if(!empty()){
     res = inicio.getD();
     inicio = inicio.getS();
     if(inicio==null){
      fin = null;
     }else{
      inicio.setA(null);   
     }
    }
    return res;
  }
  public T front(){//get
    T res = null;
    if(!empty()){
     res = inicio.getD();
    }
    return res;
  }
}
