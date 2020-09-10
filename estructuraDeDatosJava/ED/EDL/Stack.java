package ED.EDL;
public  class Stack<T>{
 private NodoSE<T> top;
 public Stack(){
  top=null;   
 }
 public void push(T dato){//add
  NodoSE<T> nuevo = new NodoSE<T>(dato);
  if(empty()){
    top=nuevo;
  }else{
   nuevo.setS(top);
   top=nuevo;
  }
 }
 public T pop(){//remove
  T res = null;
  if(!empty()){
   res = top.getD();
   top=top.getS();
  }   
  return res; 
 }
 public boolean empty(){
  return top==null;   
 }
 public T top(){//get
  T res = null;
  if(!empty()){
   res = top.getD();
  }
  return res;
 }
 //-----------------------------------------------
 //------------------------------------------------
 public Stack<T> invertir(){
   Stack<T> aux = new Stack<>();
   while(!empty())
    aux.push(pop());
   top = aux.top;
   return aux;
 }
 
}
