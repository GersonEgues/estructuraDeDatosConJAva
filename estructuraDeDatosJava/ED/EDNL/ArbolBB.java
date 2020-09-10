package ED.EDNL;
import ED.EDL.*;
public class ArbolBB<T extends Comparable<T>>{
 private T raiz;
 private ArbolBB<T> left;
 private ArbolBB<T> right;
 public void add(T dato){
  if(empty()){
   raiz = dato;
   left=new ArbolBB<T>();
   right=new ArbolBB<T>();
  }else{
   if(dato.compareTo(raiz)>0){
    right.add(dato);
   }else{
    left.add(dato);
   }
  }
 }
 public boolean empty(){
  return raiz==null;
 }
 public ListaSE<T> preOrden(){
  ListaSE<T> res = new ListaSE<T>();
  if(!empty()){
    res.add(raiz);
    res.addAll(left.preOrden());
    res.addAll(right.preOrden());
  }
  return res; 
 }
 public ListaSE<T> postOrden(){
  ListaSE<T> res = new ListaSE<T>();
  if(!empty()){
    res.addAll(left.postOrden());
    res.addAll(right.postOrden());
    res.add(raiz);
  }
  return res;
 }
 public ListaSE<T> inOrden(){
  ListaSE<T> res = new ListaSE<T>();
  if(!empty()){
    res.addAll(left.inOrden());
    res.add(raiz);
    res.addAll(right.inOrden()); 
  }
  return res;
 }
 public ListaSE<T> inOrdenDesc(){
  ListaSE<T> res = new ListaSE<T>();
  if(!empty()){
    res.addAll(right.inOrdenDesc());
    res.add(raiz);
    res.addAll(left.inOrdenDesc()); 
  }
  return res; 
 }
 public boolean contains(T dato){
  boolean res = false;
  if(!empty()){
   if(raiz.equals(dato)){
    res = true; 
   }else{
    res = left.contains(dato);
    if(res==false){
     res = right.contains(dato);
    }
   }
  }
  return res;
 }
 public T remove(T dato){
   T res=null;
   if(!empty()){
    if(dato.compareTo(raiz)==0){
     res = raiz;
     int opc = estadoRaiz();
     switch(opc){
        case 0:raiz=null;
               left=null;
               right=null;break;
        case 1:raiz=left.raiz;
               left=left.left;
               right=left.right;break;
        case 2:raiz = right.raiz;
               left = right.left;
               right = right.right;break;
        case 3:ArbolBB<T> arb = right.descIzq();
               raiz=arb.raiz;
               arb.remove(raiz);break;
     }
    }else{
     if(dato.compareTo(raiz)<0){
       res = left.remove(dato);
     }else{
       res = right.remove(dato);
     }   
    }
   }
   return res;
 }
 private int estadoRaiz(){
   int res = -1;
   if(left.raiz==null&&right.raiz==null){
    res = 0;
   }else if(left.raiz==null&&right.raiz!=null){
    res = 2; 
   }else if(left.raiz!=null&&right.raiz==null){
     res = 1;
   }else if(left.raiz!=null&&right.raiz!=null){
    res = 3;
   }
   return res;
 }
 private ArbolBB<T> descIzq(){
   ArbolBB<T> res = null;
   if(left.empty()){
    res = this;
   }else{
    res = left.descIzq(); 
   }
   return res;
 }
 //----------------------------------------
  public ListaSE<T> datosDeNivelN(int n){
  ListaSE<T> res = new ListaSE<>();
  if(!empty()){
   if(n==0){
    res.add(raiz);
   }else{
    res.addAll(left.datosDeNivelN(n-1));
    res.addAll(right.datosDeNivelN(n-1));
   }
  }
  return res;
 }
 //-------------------------------------------
 public ListaSE<T> ramaMasLargaa(){
  ListaSE<T> res = ramaMasLarga();  
  res.reverse();
  return res;
 }
 private ListaSE<T> ramaMasLarga(){
  ListaSE<T> res = new ListaSE<>();
  if(!empty()){
   ListaSE<T> lista1 = left.ramaMasLarga();
    lista1.add(raiz);
   ListaSE<T> lista2 = right.ramaMasLarga();
    lista2.add(raiz);
   if(lista1.size()>lista2.size()){
    res = lista1;
   }else{
    res = lista2; 
   }
  }
  //res.print();
  return res;
 }
 //----------------------------------------------
 public int nivelDeArbol(){
  int res = -1;
  if(!empty()){
   res = ramaMasLargaa().size()-1;
  }
  return  res;
 }
 //----------------------------------
 public T get(T d){
  T res = null;
  if(!empty()){
    if(raiz.equals(d)){//****???
     res = raiz;
    }else{
     res = left.get(d);
     if(res==null){
      res = right.get(d);
     }
    }
  }
  return res;
 }
}
