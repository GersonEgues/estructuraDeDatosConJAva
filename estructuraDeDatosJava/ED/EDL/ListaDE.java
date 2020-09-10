package ED.EDL;
public class ListaDE<T> implements Lista<T>{
 private NodoDE<T> inicio;
 private NodoDE<T> fin;
 public ListaDE(){
  inicio=null;
  fin=null;
 }
 public void addAll(ListaDE<T> lista){//aprobado
  int tam = lista.size();
  int i=0;
  while(tam>0){
   add(lista.get(i));
   i+=1;
   tam-=1;
  }
 }
 public void addAll(int index,ListaDE<T> lista){//aprobado
   if(!empty()&&index>=0&&index<size()){
    if(index==0){
     ListaDE<T> aux = lista.clone();
     int i=0;
     while(i<size()){
      aux.add(get(i));
      i+=1;
     }
     inicio = aux.getNodoIni();
     fin = aux.getNodoFin();
    }else{
     ListaDE<T> lista1 = new ListaDE<>();
     ListaDE<T> lista2 = new ListaDE<>();
     
     int i=0;
     while(i<index){
        lista1.add(get(i));
        i+=1;
     }
     
     while(i<size()){
       lista2.add(get(i));
       i+=1;
     }
     
     lista1.addAll(lista);
     lista1.addAll(lista2);
     inicio = lista1.getNodoIni();
     fin = lista1.getNodoFin();
    }
   }
 }
 public void add(T d){//aprobado
   if(empty()){
    NodoDE<T> aux = new NodoDE<>(d);
    inicio=aux;
    fin=aux;
   }else{
    NodoDE<T> aux = new NodoDE<>(d);
    aux.setA(fin);
    fin.setS(aux);
    fin=aux;
   }
 }
 public void add(int index,T dato){//aprobado
  if(!empty()){
   if(index>=0&&index<size()){
    NodoDE<T> nuevo = new NodoDE<T>(dato);
    if(index==0){
     nuevo.setS(getNodoIni());
     inicio.setA(nuevo);
     inicio=nuevo;
    }else{
     NodoDE<T> aux1 = getN(index-1);
     NodoDE<T> aux2 = aux1.getS();
     aux1.setS(nuevo);
     nuevo.setA(aux1);
     aux2.setA(nuevo);
     nuevo.setS(aux2);
    }    
   }
  }
 }
 public void clear(){
     inicio=null;fin=null;
 }
 public ListaDE<T> clone(){
  ListaDE<T> res = new ListaDE<T>();
  int tam = size();
  int i=0;
  while(tam>0){
    res.add(get(i));
    i+=1;
    tam-=1;
  }
  return res;
 }
 public ListaDE<T> clone(ListaDE<T> lista){
  ListaDE<T> res = new ListaDE<T>();
  if(!lista.empty()){
   int i=0;
   while(i<lista.size()){
    res.add(lista.get(i));
    i+=1;
   }
  }
  return res;
 }
 public boolean contains(T dato){
  boolean res = false;
  NodoDE<T> aux = inicio;
  int i=0;
  while(i<size()){
   if(aux.getD().equals(dato)){
    res = true;
   }else{
    aux = aux.getS(); 
   }
   i+=1;
  }  
  return res;
 }
 public boolean empty(){//aprobado
  return inicio==null;   
 }
 public NodoDE<T> getN(int pos){//aprobado
  return getN(pos,inicio);   
 }
 private NodoDE<T> getN(int pos,NodoDE<T> ini){//aprobado
   NodoDE<T> res = null;             
   if(!empty()&&pos<size()&&pos>=0){
    if(pos==0){
     res = ini;
    }else{
     res = getN(pos-1,ini.getS());
    }
   }
   return res;
 }
 private NodoDE<T> getNodoIni(){//aprobado
  return inicio;   
 }
 private NodoDE<T> getNodoFin(){//aprobado
  return fin;   
 }
 public T get(int index){
  return get(index,inicio);
 }
 private T get(int i,NodoDE<T> ini){
  T res=null;
  if(!empty()){
   if(ini.getS()!=null){
     if(i==0){
      res = ini.getD();
     }else{
      res = get(i-1,ini.getS()); 
    }
   }else{
    if(i==0)
      res = ini.getD();
   }
  }  
  return res;    
 }
 public int indexOf(T dato){
  int res=-1;
  if(!empty()){
   boolean b=true;
   int i=0;
   NodoDE<T> ini = inicio;
   while(i<size()&&b==true){
    if(ini.getD().equals(dato)){
     res = i;
     b=false;
    }else{
     ini = ini.getS();
    }
    i+=1;
   }
  }
  return res;
 }
 public void remove(T dato){
  if(!empty()){
   int i=0;
   ListaDE<T> aux = this;
   while(i<size()){
    if(aux.get(i).equals(dato)){
     if(i==0){
      inicio=inicio.getS();
      inicio.setA(null);
     }else if(i==(size()-1)){
       fin = fin.getA();
       fin.setS(null);
     }else{
      NodoDE<T> a=getN(i-1);   
      NodoDE<T> b=getN(i+1);
      a.setS(b);
      b.setA(a);
     }
    }
    i+=1;
   }
  }   
 }
 public void remove(int index){//aprobado
  if(!empty()&&index>=0&&index<size()){
   if(index==0&&inicio.getS()==null){
    clear();
   }else if(index==0){
    inicio.getS().setA(null);
    inicio = inicio.getS();
   }else if(index==size()-1){
    fin=getN(index-1);
    fin.setS(null);
   }else{
    NodoDE<T> aux1 = getN(index-1); 
    NodoDE<T> aux2 = getN(index+1);
    
    aux1.setS(aux2);
    aux2.setA(aux1);
   }
  }
 }
 public void removeRange(int ini,int ult){
  if(!empty()&&ini>=0&&ult<=size()&&ini<size()){
   if(ini==ult){
    remove(ini);
   }else{
    int i=0;
    ListaDE<T> res = new ListaDE<>();
    while(i<ini){
     res.add(get(i));
     i+=1;
    }
   
    int f=ult;
    while(f<size()){
     res.add(get(f));
     f+=1;
    }
   
    if(res.size()==0){
      clear();
    }else{
      inicio=res.getNodoIni();
      fin=res.getNodoFin();
    }
   } 
  }   
 }
 public void reverse(){//aprobado
  if(!empty()){
    int newIni = size()-1;
    int cont = newIni-1;
    while(cont>=0){
     NodoDE<T> nuevo = new NodoDE<>(get(cont));
     fin.setS(nuevo);
     nuevo.setA(fin);
     fin=nuevo;
     cont-=1;
    }
    inicio=getN(newIni);
    inicio.setA(null);
  }  
 }
 public int size(){
  return size(inicio);
 }
 private int size(NodoDE<T> ini){
  int res = 0;
  if(!empty()){
   if(ini.getS()!=null){
    res = 1+size(ini.getS());
   }else{
     res=1;
   }
  }
   return res;
 }
 public ListaDE<T> subList(int ini,int fin){
  ListaDE<T> res = null;
  if(!empty()){
    if(ini>=0&&ini<size()&&fin<=size()&&fin>=ini){
     res = new ListaDE<>();
     NodoDE<T> aux = inicio;
     int i=0;
     while(i<=ini){
      if(i==ini){
        while(i<fin){
         res.add(get(i));
         i+=1;
        }
      }else{
        aux = aux.getS();
      }
      i+=1;
     }
    }
  }
  return res;
 }
}
