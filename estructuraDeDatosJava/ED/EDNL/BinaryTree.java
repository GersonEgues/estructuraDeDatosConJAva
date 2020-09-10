package ED.EDNL;
import ED.EDL.*;
public class BinaryTree<T>{
 private T raiz;
 private BinaryTree<T> left;
 private BinaryTree<T> right;
 public BinaryTree(){
  raiz = null;
  left=null;
  right=null;
 }
 public void add(T dato){
  Queue<BinaryTree<T>> c = new Queue<>();
  c.push(this);
  add(dato,c);
 }
 private void add(T dato,Queue<BinaryTree<T>> cola){
  BinaryTree<T> arb = cola.pop();
  if(arb.empty()){
   arb.raiz=dato;
   arb.left = new BinaryTree<T>();
   arb.right = new BinaryTree<T>();
  }else{
   cola.push(arb.left);
   cola.push(arb.right);
   add(dato,cola);
  }
 }
 public boolean add(T dato,ListaSE<T> ruta){
  boolean inserto = false;
  if(empty()){
   if(ruta.empty()){
    inserto = true;
    raiz = dato;
    left = new BinaryTree();
    right = new BinaryTree();
   }
  }else{
    if(!ruta.empty()){
     T r1 = ruta.get(0);
     if(raiz.equals(r1)){
      r1 = ruta.remove(0);
      inserto=left.add(dato,ruta);
      if(!inserto){
        inserto = right.add(dato,ruta);
      }
      ruta.add(0,r1);
     }     
    }
  }
  return inserto;
 }
 public boolean empty(){
  return raiz==null;
 }
 public int numHojas(){
  int res = 0;
  if(!empty()){
   if(arbolHoja()){
    res = 1;
   }else{
    int hi = left.numHojas();
    int hd = right.numHojas();
    res = hi+hd;
   }
  }
  return res;
 }
 public boolean arbolHoja(){
  return (left.empty() && right.empty());
 }
 public int arbolHoja1(){
  int res=-1;
  if(!empty()){
    res = (left.empty() && right.empty())?1:0;
  }
  return res;
 }
 public T removeL(T dato){//no elimina a menos que se una hoja
  T res = null;
  if(!empty()){
   if(raiz.equals(dato)){
    if(arbolHoja()){
     raiz = null;
     left=right = null;
    }
   }else{
    res = left.removeL(dato);
    if(res==null){
     res = right.removeL(dato);
    }
   }
  }
  return res;
 }
 public T removeW(T dato){//no importa que se una hoja o no lo elimina
  T res = null;
  if(!empty()){
   if(raiz.equals(dato)){
     raiz = null;
     left=right = null;
   }else{
    res = left.removeW(dato);
    if(res==null){
     res = right.removeW(dato);
    }
   }
  }
  return res;
 }
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
  return res;
 }
 public ListaSE<T> ramaMasCorta(){
  ListaSE<T> res = new ListaSE<>();
  if(!empty()){
   res.add(raiz);
   ListaSE<T> lista1 = left.ramaMasCorta();
   ListaSE<T> lista2 = right.ramaMasCorta();
   if(lista1.size()<lista2.size()){
    res.addAll(lista1);
   }else{
    res.addAll(lista2); 
   }
  }
  return res;
 }
 public ListaSE<T> recorridoPostOrden(){
  ListaSE<T> res = new ListaSE<T>();
  if(!empty()){
   ListaSE<T> aux1 = left.recorridoPostOrden();
   ListaSE<T> aux2 = right.recorridoPostOrden();
   aux1.addAll(aux2);
   res = aux1;
   res.add(raiz);
  }   
  return res;
 }
 public ListaSE<T> recorridoPreOrden(){
  ListaSE<T> res = new ListaSE<T>();
  if(!empty()){
    res.add(raiz);
    res.addAll(left.recorridoPreOrden());
    res.addAll(right.recorridoPreOrden());
  }
  return res;
 }
 public ListaSE<T> recorridoInOrden(){
  ListaSE<T> res = new ListaSE<T>();
  if(!empty()){
    res.addAll(left.recorridoInOrden());
    res.add(raiz);
    res.addAll(right.recorridoInOrden());
  }
  return res;
 }
 public ListaSE<T> recorridoAmplitud(){
  Queue<BinaryTree<T>> cola=new Queue<>();
  cola.push(this);
  return recorridoAmplitud(cola);
 }
 private ListaSE<T> recorridoAmplitud(Queue<BinaryTree<T>> cola){
  ListaSE<T> res = new ListaSE<>();
  BinaryTree<T> arb;
  
  while(!cola.empty()){
   arb = cola.front();
   if(!arb.empty()){
    res.add(arb.raiz);
    cola.pop();
    cola.push(arb.left);
    cola.push(arb.right);
    res.addAll(recorridoAmplitud(cola));
   }else
    cola.pop();
  }
  return res;
 }
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
 public boolean contains(T dato){
  boolean res = false;
  if(!empty()){
    if(raiz.equals(dato)){
     res = true;
    }else{
     res = left.contains(dato);
     if(!res){
      res = right.contains(dato);
     }
    }
  }
  return res;
 }
 private void setRaiz(T r){
  raiz = r;
 }
 public void mirror(){
  if(!empty()){
   BinaryTree<T> aux = left;
   left = right;
   right = aux;
   left.mirror();
   right.mirror();
  }
 }
 public int nivelDeArbol(){
  int res = -1;
  if(!empty()){
   res = ramaMasLargaa().size()-1;
  }
  return  res;
 }
 public int nivelNodo(T dato){
   int res = -1;
   if(!empty()){
    if(contains(dato)){
     if(raiz.equals(dato)){
        res = 0;
     }else{
      ListaSE<T> aux = getListaAsc(dato);
      res = aux.size()-1;
     }
    }
   }
   return res;
 }
 public ListaSE<T> getCaminoAsc(T dato){
    ListaSE<T> res = new ListaSE<>();
    if(!empty()){
     res = left.getCaminoAsc(dato);
     if(res.empty()){
      res = right.getCaminoAsc(dato);
      if(res.empty()){
       if(raiz.equals(dato))
        res.add(raiz);
      }else{
        res.add(raiz);
      }
     }else{
      res.add(raiz);   
     }
    }
    return res;
 }
 public ListaSE<T> getCaminoDesc(T dato){
    ListaSE<T> res = new ListaSE<>();
    if(!empty()){
     res = left.getCaminoDesc(dato);
     if(res.empty()){
      res = right.getCaminoDesc(dato);
      if(res.empty()){
       if(raiz.equals(dato)){
        res.add(raiz);
       }
      }else
        res.add(0,raiz);
     }else
      res.add(0,raiz);   
    }
    return res;
 }
 //--------------------------------
 public ListaSE<T> getListaAsc(T dato){
  ListaSE<T> res = new ListaSE<>();
  if(!empty()){
   if(raiz.equals(dato)){
    res.add(raiz);
   }else{
    ListaSE<T> aux1 = left.getListaAsc(dato);
    if(aux1.empty()){
     aux1 = right.getListaAsc(dato);
     if(!aux1.empty()){
      aux1.add(raiz);
      res = aux1;
     }
    }else{
     aux1.add(raiz);
     res = aux1;
    }
   }
  }
  return res;
 }
 public ListaSE<T> getListaDesc(T dato){
  ListaSE<T> res = new ListaSE<>();
  if(!empty()){
    res = left.getListaDesc(dato);
    if(res.empty()){
     res = right.getListaDesc(dato);
     if(res.empty()){
      if(raiz.equals(dato))
       res.add(raiz); 
     }else{
      res.add(0,raiz);   
     }
    }else{
     res.add(0,raiz);
    }
   }
  return res;
 }
 public ListaSE<T> getHojas(){
   ListaSE<T> res = new ListaSE<>();
   if(!empty()){
    if(arbolHoja()){
     res.add(raiz);
    }else{
     res = left.getHojas();
     res.addAll(right.getHojas());
    }
   }
   return res;
 }
 public ListaSE<T> getCamino(T d1,T d2){
  ListaSE<T> res = new ListaSE<>();
  if(!empty()){
   boolean aux = (contains(d1)&&contains(d2));
   if(aux){
    if(d1.equals(d2)){
     res.add(d1);
    }else if(raiz.equals(d1)||raiz.equals(d2)){
     if(raiz.equals(d1)){
        boolean a = left.contains(d2);
        if(a){
         res.addAll(left.getListaDesc(d2));
         res.add(0,raiz);
        }else{
         res.addAll(right.getListaDesc(d2));
         res.add(0,raiz);
        }
     }else{
        boolean a = left.contains(d1);
        if(a){
         res.addAll(left.getListaAsc(d1));
         res.add(raiz);
        }else{
         res.addAll(right.getListaAsc(d1));
         res.add(raiz);
        }
     }
    }else if(left.contains(d1)&&left.contains(d2)){
      res = left.getCamino(d1,d2);
    }else if(right.contains(d1)&&right.contains(d2)){
      res = right.getCamino(d1,d2);
    }else{
     if(left.contains(d1)){//-->right.contains(d2)
        res = left.getListaAsc(d1);
        res.add(raiz);
        res.addAll(right.getListaDesc(d2));
     }else{//left.contains(d2)&&right.contains(d1)
        res = right.getListaAsc(d1);
        res.add(raiz);
        res.addAll(left.getListaDesc(d2));
     }
    }
   }
  }
  return res;
 }
 public BinaryTree<T> getArbol(T raizD){
  BinaryTree<T> res = new BinaryTree<>();
  if(!empty()){
   if(contains(raizD)){
    if(raiz.equals(raizD)){
     res = this;
    }else{
     if(left.contains(raizD)){
      res = left.getArbol(raizD);
     }else{
      res = right.getArbol(raizD);
     }
    }
   }
  }
  return res;
 }
 public int gradoNodo(T dato){
  int res = -1;
  if(!empty()){
   if(contains(dato)){
    BinaryTree<T> aux = getArbol(dato);
    res=0;
    if(!aux.left.empty()){
     res+=1;
    }
    if(!aux.right.empty()){
     res+=1;
    }
   }
  }
  return res;
 }
 public int alturaArbol(){
  int res=-1;
  if(!empty()){
    ListaSE<T> aux = ramaMasLarga();
    res = aux.size();
  }
  return res;
 }
 public int alturaNodo(T dato){
  int res=-1;
  if(!empty()){
    ListaSE<T> aux = getListaAsc(dato);
    res = aux.size();
  }
  return res;
 }
 public ListaSE<ListaSE<T>> getRamas(){
    ListaSE<ListaSE<T>> res = new ListaSE<>();
    if(!empty()){
     ListaSE<T> hojas = getHojas();
     for(int i=0;i<hojas.size();i++){
      ListaSE<T> aux = getCamino(raiz,hojas.get(i));
      res.add(aux);
     }
    }
    return res;
 }
 public BinaryTree<T> getLeft(){
  return left;   
 }
 public BinaryTree<T> getRight(){
  return right;   
 }
 public T getRaiz(){
  return raiz;   
 }
 public boolean esHoja(){
  return (left.empty()&&right.empty());   
 }
}

