package ED.EDL;
public class NodoSE<T>{
   private T dato;
   private NodoSE<T> sig;
   public NodoSE(T d){
    dato=d;
    sig=null;
   }
   public void setD(T d){
    dato = d;
   }
   public T getD(){
    return dato; 
   }
   public NodoSE<T> getS(){
    return sig; 
   }
   public void setS(NodoSE<T> n){
    sig=n;
   }
}
