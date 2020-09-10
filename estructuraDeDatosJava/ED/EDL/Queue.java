package ED.EDL;
public class Queue<T>{
  private NodoSE<T> inicio;
  private NodoSE<T> fin;
  public Queue(){
   inicio=null;
   fin=null;
  }
  public void push(T dato){//add
   if(empty()){
    NodoSE<T> nuevo = new NodoSE<>(dato);
    inicio=nuevo;
    fin=nuevo;
   }else{
    NodoSE<T> nuevo = new NodoSE<>(dato);
    fin.setS(nuevo);
    fin = nuevo;
   }
  }
  public boolean empty(){
   return inicio==null;
  }
  public T pop(){//remove
   T res = null;
   if(!empty()){
    res = inicio.getD();
    inicio = inicio.getS();
    if(inicio==null){
     fin=null;
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
