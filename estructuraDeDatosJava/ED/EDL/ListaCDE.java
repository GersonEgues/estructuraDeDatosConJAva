package ED.EDL;
public class ListaCDE<T> implements Lista<T>{
   private NodoDE<T> inicio;
   private NodoDE<T> fin;
   public ListaCDE(){
    inicio=null;
    fin=null;
   }
   public void add(T dato){
    if(empty()){
     NodoDE<T> nuevo = new NodoDE<T>(dato);
     inicio=fin=nuevo; 
     inicio.setS(inicio);
     inicio.setA(fin);
    }else{
     NodoDE<T> nuevo = new NodoDE<T>(dato);
     fin.setS(nuevo);
     nuevo.setA(fin);
     fin=nuevo;
     fin.setS(inicio);
     inicio.setA(fin);
    }
   }
   public void add(int index,T dato){
    if(!empty()){
     int tam = size();
     if(index>=0&&index<tam){
      if(index==0){
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        nuevo.setS(inicio);
        inicio.setA(nuevo);
        nuevo.setA(fin);
        fin.setS(nuevo);
        inicio=nuevo;
      }else if(index==tam-1){
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        fin.setS(nuevo);
        nuevo.setS(inicio);
        nuevo.setA(fin);
        fin = nuevo;
        inicio.setA(fin);
      }else{
        NodoDE<T> aux1 = getNodo(index-1);
        NodoDE<T> aux2 = getNodo(index);
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        nuevo.setS(aux2);
        nuevo.setA(aux1);
        aux1.setS(nuevo);
        aux2.setA(nuevo);
      }
     }
    }
   }
   public void addAll(ListaCDE<T> lista){
     if(!lista.empty()){
       int i=0;
       while(i<lista.size()){
        add(lista.get(i));
        i+=1;
       }
     }
   }
   public void addAll(int index,ListaCDE<T> lista){
    if(index>=0&&index<size()&&!lista.empty()){
     if(index==0){
      ListaCDE<T> aux = lista.clone();
      aux.getFin().setS(inicio);
      inicio.setA(aux.getFin());
      inicio=aux.getInicio();
      fin.setS(inicio);
      inicio.setA(fin);
     }else{ 
      ListaCDE<T> aux = lista.clone();
      NodoDE<T> n1 = getNodo(index-1);
      NodoDE<T> n2 = getNodo(index);
      n1.setS(aux.getInicio());
      aux.getInicio().setA(n1);
      n2.setA(aux.getFin());
      aux.getFin().setS(n2);      
     }
    }
   }
   public boolean empty(){
    return inicio==null; 
   }
   public void clear(){
    inicio=null;
    fin=null;
   }
   public ListaCDE<T> clone(){
    ListaCDE<T> res = null;
    if(!empty()){
     res = new ListaCDE<T>();
     int i=0;
     while(i<size()){
      res.add(get(i));
      i+=1;
     }
    }
    return res;
   }
   public ListaCDE<T> clone(ListaCDE<T> lista){
    ListaCDE<T> res = null;
    if(!lista.empty()){
     res = new ListaCDE<T>();
     int i=0;
     while(i<lista.size()){
      res.add(lista.get(i));
      i+=1;
     }
    }
    return res;
   }
   public boolean contains(T d){
    boolean res=false;
    if(!empty()){
     int tam = size();
     int i=0;
     NodoDE<T> aux = inicio;
     while(i<size()&&res==false){
      if(d.equals(aux.getD())){
         res = true;
      }
      aux = aux.getS();
      i+=1;
     }
    }
    return res;
   }
   public int indexOf(T dato){
    int res = -1;
    if(!empty()){
     int i=0;
     boolean b=false;
     NodoDE<T> aux = inicio;
     while(i<size()&&b==false){
      if(dato.equals(aux.getD())){
        b=true;
        res=i;
      }else{
       i+=1;
       aux=aux.getS();
      }
     }
    }
    return res;
   }
   public T get(int index){
    T res = null;
    if(!empty()){
     int tam = size();
     if(index>=0&&index<tam){
      int i=0;
      NodoDE<T> aux = inicio;
      res = aux.getD();
      while(i!=index){
        aux = aux.getS();
        res = aux.getD();
       
        i+=1;
      }
     }
    } 
    return res;
   }
   private NodoDE<T> getInicio(){
    return inicio; 
   }
   private NodoDE<T> getFin(){
    return fin; 
   }
   private NodoDE<T> getNodo(int index){
    NodoDE<T> res = null;
    if(!empty()&&index<size()){
     NodoDE<T> aux = inicio;
     int i=0;
     res = inicio;
     while(i!=index){
      res = res.getS(); 
      i+=1;
     }
    }
    return res;
   }
   public void remove(int index){
    if(!empty()){
     int tam = size();
     if(index>=0&&index<tam){
       if(index==0){
        if(tam==1){
         clear();
        }else{
         inicio = inicio.getS();
         fin.setS(inicio);
         inicio.setA(fin);
        }
       }else if(index==tam-1){
        if(tam==1){
         clear();
        }else{
         fin = fin.getA();
         fin.setS(inicio);
         inicio.setA(fin);
        }
       }else{
        NodoDE<T> n1 = getNodo(index-1);
        NodoDE<T> n2 = getNodo(index+1);
        
        n1.setS(n2);
        n2.setA(n1);
       }
     }
    }
   }
   public void remove(T dato){
    if(!empty()){
     int i=0;
     int tam = size();
     NodoDE<T> aux = inicio;
     boolean b = false;
     while(i<tam&&b==false){
      if(aux.getD().equals(dato)){
       remove(i);       
       b=true;
      }else{
       i+=1;  
       aux = aux.getS();
      }
     }
    }
   }
   public void removeRange(int i,int f){
    if(!empty()){
     int tam=size();
     if(i>=0&&i<tam&&f>=i&&f<=tam){
      if(i==f){
        remove(i);
      }else{
        if(i==0){
         if(f==tam){
            clear();
         }else{
            inicio = getNodo(f);
            fin.setS(inicio);
            inicio.setA(fin);
         }        
        }else{
         if(f==tam){
          fin = getNodo(i-1);
          fin.setS(inicio);
          inicio.setA(fin);
         }else{
          NodoDE<T> n1 = getNodo(i-1);
          NodoDE<T> n2 = getNodo(f);
          n1.setS(n2);
          n2.setA(n1);
        }
        }
      }
     }
    }
   }
   public void reverse(){
    if(!empty()){
     int tam = size();
     if(tam>1){
      int ini = tam-1;
      int i = ini-1;  
      while(i>=0){
       add(get(i));
       i-=1;
      }
       inicio = getNodo(ini);
       fin.setS(inicio);
       inicio.setA(fin);
     }
    }
   }
   public int size(){
    int i=0;
    if(!empty()){
     NodoDE<T> aux = inicio;
     while(!aux.equals(fin)){
        i+=1;
        aux=aux.getS();
     }
     i+=1;
    }
    return i;
   }
   public ListaCDE<T> sublist(int i,int f){
    ListaCDE<T> res = null;
    if(!empty()){
     int tam = size();
     if(i>=0&&i<tam&&f>=i&&f<=tam){
      res = new ListaCDE<>();
      if(i==f){
       res.add(get(i));
      }else{
       NodoDE<T> aux = getNodo(i);
       while(i<f){
        res.add(aux.getD());
        if(i!=tam)
         aux = aux.getS();
        
        i+=1;
       }
      }
     }
    }
    return res;
   }
}
