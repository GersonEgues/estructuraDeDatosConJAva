package ED.EDL;
public class ListaSE<T> implements Lista<T>,Cloneable{
 T inicio;
 ListaSE<T> sigListaSE;
 public ListaSE(){//aprobado
  inicio=null;
  sigListaSE=null;
 }
 public void addAll(ListaSE<T> lista){//aprobado
  int tam=lista.size();
  int i=0;
  if(!lista.empty()){
    while(tam>0){
     add(lista.get(i));
     i+=1;
     tam-=1;
    }
  } 
 }
 public void addAll(int index,ListaSE<T> lista){//aprobado
  if(!empty()&&index<size()&&index>=0){
   ListaSE<T> listaC = lista.clone();
   ListaSE<T> aux2 = new ListaSE<>();
   ListaSE<T> ref = this;
   int i=index;
   while(index>=0){
    if(index==0){
     aux2 = clone(ref);
    }else
     ref = ref.getSigListaSE();
    index-=1;
   }
   
   ref=this;
   while(i>=0){
    if(i==0){
     ref.setInicio(null);
     ref.setSigListaSE(null);
    }
    ref = ref.getSigListaSE();
    i-=1;
   }
   
   this.addAll(listaC);
   this.addAll(aux2);
  }
 }
 public void add(T d){//aprobado
  if(empty()){
    inicio=d;
    sigListaSE=new ListaSE<T>();
  }else{
    sigListaSE.add(d);
  }
 }
 public void add(int pos,T d){//aprobado
  if(!empty()){
     if(pos==0){
       ListaSE<T> nueva = new ListaSE<T>();
       nueva.setInicio(inicio);
       nueva.setSigListaSE(sigListaSE);
       
       inicio=d;
       sigListaSE=nueva;
     }else{
        sigListaSE.add(pos-1,d);
     }
  }else{
   if(pos==0){
    add(d); 
   }  
  }
 }
 public void clear(){//aprobado
  inicio=null;
  sigListaSE=null;
 }
 public ListaSE<T> clone(ListaSE<T> listaa){//aprobado
    ListaSE<T> res = new ListaSE<T>();
    ListaSE<T> lista = listaa;
    int tam=lista.size();
    if(!lista.empty()){
     while(tam>0){
      res.add(lista.getInicio());
      lista = lista.getSigListaSE();
      tam-=1;
     }
    }
    return res;
 }
 public ListaSE<T> clone(){//aprobado
  ListaSE<T> res = new ListaSE<>();
  if(!empty()){
   int tam = size();
   ListaSE<T> aux = this;
   while(tam>0){
    res.add(aux.getInicio());
    aux = aux.getSigListaSE();
    tam-=1;
   }
  } 
  return res;
 }
 public boolean contains(T dato){//aprobado
  boolean res=false;
  if(!empty()){
    if(inicio.equals(dato)){
     res = true;
    }else{
     res = sigListaSE.contains(dato);
    }
  }
  return res;
 }
 public boolean empty(){//aprobado
  return inicio==null;
 }
 public T get(int index){//aprobado
  T res = null;
  if(!empty()){
   if(index==0){
    res=inicio;
   }else{
    res = sigListaSE.get(index-1); 
   }
  }
  return res;
 }
 private T getInicio(){//aprobado
  return inicio;   
 }
 private ListaSE<T> getSigListaSE(){//aprobado
  return sigListaSE;
 }
 public ListaSE<T> getLista(int index){//aprobado
  ListaSE<T> res = null;
  if(!empty()&&index<=size()){
    ListaSE<T> aux = this;
    res=new ListaSE<>();
    while(index>=0){
     if(index==0){
      res = clone(aux); 
     }else{
      aux = aux.getSigListaSE();
     }
     index-=1;
    }
  }
  return res;
 }
 public int indexOf(T dato){//aprobado
  int res=-1;
  int c=0;
  if(!empty()){
   if(inicio.equals(dato)){
    res = c;
   }else{
    res = 1 + sigListaSE.indexOf(dato);
    if(sigListaSE.indexOf(dato)==-1){
     res=-1;
    }
   } 
  }
  return res;
 }
 public T remove(T d){//aprobado
  T res=null;
  if(!empty()){
    if(d.equals(inicio)){
     res = inicio;
     inicio=sigListaSE.getInicio();;
     sigListaSE=sigListaSE.getSigListaSE();
    }else{
     res = sigListaSE.remove(d);
    }
  }
  return res;
 }
 public T remove(int pos){//aprobado
  T res = null;
  if(!empty()){
    if(pos==0){
     res=inicio;
     inicio=sigListaSE.getInicio();;
     sigListaSE=sigListaSE.getSigListaSE();
    }else{
      res = sigListaSE.remove(pos-=1);
    }
  }
  return res;
 }
 //aprobado
 public void removeRange(int ini,int fin){//inclusive exclusive
  if(!empty()){
   if(ini<size()&&fin<=size()){
    if(ini==0){
      ListaSE<T> aux = getLista(fin);
      inicio=aux.getInicio();
      sigListaSE=aux.getSigListaSE();
    }else{
     if(ini!=fin){   
        ListaSE<T> aux2 = getLista(fin);
        int i=0;
        ListaSE<T> res = new ListaSE<>();
        while(i<ini){
         res.add(get(i));
         i+=1;
        }
        res.addAll(aux2);
        inicio=res.getInicio();
        sigListaSE=res.getSigListaSE();
     }else{
      remove(ini);   
     }
    }
   }else{
    System.out.println("datos Incorrectos"); 
   }   
  }
 }
 public void reverse(){//aprobado
  if(!empty()){
   int tam = size();
   if(tam!=1){
    int newIni = tam-1;
    int i=newIni-1;
    while(i>=0){
     add(get(i));
     i-=1;
    }
    ListaSE<T> aux = this;
    i=0;
    while(i<=newIni){
     if(i==newIni){
       inicio=aux.getInicio();
       sigListaSE=aux.getSigListaSE();;
     }else{      
       aux = aux.getSigListaSE();  
     }
     i+=1;
    }
   }
  }
 }
  private void setInicio(T dato){
  inicio = dato;   
 }
 private void setSigListaSE(ListaSE<T> lista){
  sigListaSE = lista;    
 }
 public int size(){//aprobado
  int res = 0;
  if(!empty()){
   res = 1 + sigListaSE.size();  
  }   
  return res;
 }
 public ListaSE<T> subList(int ini,int fin){//inclusive,exclusive
  ListaSE<T> res=null;
  if(!empty()&&ini>=0&&fin<=size()){
   if(ini==0){
    int i=0;
    ListaSE<T> aux = clone(this);
    ListaSE<T> aux2=aux;
    while(i<=fin){
     if(i==fin){
      aux2.setInicio(null);
      aux2.setSigListaSE(null);
     }else{
       aux2 = aux2.getSigListaSE();
     }
     i+=1;
     }
    res=aux;
   }else{
    int i=0;
    ListaSE<T> aux = clone(this);
    res = new ListaSE<T>();
    while(i<=ini){
     if(i==ini){
       while(i<fin){
        res.add(aux.getInicio());
        aux = aux.getSigListaSE();
        i+=1;
       }
     }else{
        aux = aux.getSigListaSE();
     }
     i+=1;
    }
   }
  }
  return res;
 }
 public void print(){
  System.out.print("[");   
  ListaSE<T> aux1 = this;
  for(int i=0;i<size();i++){
   T aux =  aux1.getInicio();
   if(i!=size()-1)
    System.out.print(aux+", ");
   else
    System.out.print(aux);
   aux1=aux1.getSigListaSE();
  }
  System.out.println("]");
 }
 public boolean equalsC(ListaSE<T> lista){
    boolean res =false;
    if(!empty()){
     if(!lista.empty()){
      if(lista.size()==size()){
        ListaSE<T> aux1 = clone();
        ListaSE<T> aux2 = lista.clone();
        boolean b=true;
        while(!aux1.empty()&&b){
         T a = aux1.inicio;
         b = aux2.contains(a);
         if(b){
          aux1 = aux1.sigListaSE;
          aux2.remove(a);
         }else{
          b=false;  
         }
        }
        res = b;
      }
     }
    }
    return res;
 }
}
