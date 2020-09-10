package ED.EDL;
public class Deque<T>{
 private NodoDE<T> inicio;
 private NodoDE<T> fin;
 public Deque(){
  inicio=null;
  fin=null;
 }
 public void push(T dato){
  if(empty()){
   NodoDE<T> nuevo = new NodoDE<T>(dato);
   inicio=nuevo;
   fin=nuevo;
  }else{
   NodoDE<T> nuevo = new NodoDE<T>(dato);
   fin.setS(nuevo);
   nuevo.setA(fin);
   fin=nuevo;
  }
 }
 public boolean empty(){
  return inicio==null;   
 }
 public T popFront(){
  T res = null;
  if(!empty()){
   res = inicio.getD();
   inicio = inicio.getS();
   if(inicio==null)
    fin=null;
   else
    inicio.setA(null);
  }
  return res;
 }
 public T popBack(){
  T res = null;
  if(!empty()){
   res = fin.getD();
   fin=fin.getA();
   if(fin==null){    
    inicio=null;
   }else{
    fin.setS(null);
   }
  }
  return res;
 }
 public T front(){
  T res = null;
  if(!empty())
   res = inicio.getD();
  return res;
 }
 public T back(){
  T res = null;
  if(!empty())
   res = fin.getD();
  return res;
 }
}
