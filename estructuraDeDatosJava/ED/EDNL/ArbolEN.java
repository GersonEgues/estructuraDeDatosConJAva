package ED.EDNL;

class ArbolEN<T extends Comparable>{
  public T raiz;
  private ArbolEN<T> left;
  private ArbolEN<T> right;
  private int nl;
  private int nr;
  public ArbolEN(){
   raiz=null;
   left=null;
   right=null;  
   nl=0;
   nr=0;
  }
  private boolean empty(){
   return raiz==null;
  }
  private ArbolEN<T> buscarMasPequenoIzquierda(){
   ArbolEN<T> res = new ArbolEN<T>();
   if(!empty()){
    if(!left.empty()){
     res = left.buscarMasPequenoIzquierda();
    }else{
     res = this;
    }
   }
   return res;
  }
  private ArbolEN<T> buscarMasGrandeDerecha(){
   ArbolEN<T> res = new ArbolEN<T>();
   if(!empty()){
    if(!right.empty()){
     res = right.buscarMasGrandeDerecha();
    }
    else{
     res = this;
    }
   }
   return res;
  }
  //--------------------
  private void add(T dato){
   if(empty()){
    raiz = dato;
    left=new ArbolEN<T>();
    right=new ArbolEN<T>();
   }else{
    if(dato.compareTo(raiz)>0)
     right.add(dato);
    else
     left.add(dato);
    
   }
  }
}