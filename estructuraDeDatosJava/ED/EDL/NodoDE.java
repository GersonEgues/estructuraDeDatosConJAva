package ED.EDL;
public class NodoDE<T>{
   private T dato;
   private NodoDE<T> sig;
   private NodoDE<T> ant;
   public NodoDE(T d){
    dato=d;
    sig=null;
    ant=null;
   }
   public void setD(T d){
    dato = d;
   }
   public T getD(){
    return dato; 
   }
   public NodoDE<T> getS(){
    return sig; 
   }
   public NodoDE<T> getA(){
    return ant; 
   }
   public void setS(NodoDE<T> n){
    sig=n;
   }
   public void setA(NodoDE<T> n){
    ant=n;
   }
}