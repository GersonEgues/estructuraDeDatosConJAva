package ED.EDL;
public class ListaCSE<T> implements Lista<T>{
   private NodoSE<T> inicio;
   private NodoSE<T> fin;
   public ListaCSE(){
    inicio=null; 
   }
   public void add(T dato){
    if(empty()){
     NodoSE<T> nuevo = new NodoSE<T>(dato);
     inicio = nuevo;
     fin = nuevo;
     nuevo.setS(nuevo);
    }else{
     NodoSE<T> nuevo = new NodoSE<T>(dato);
     fin.setS(nuevo);
     nuevo.setS(inicio);
     fin = nuevo;
    }
   }
   public void add(int index,T dato){
    if(!empty()){
     if(index>=0&&index<size()){
      if(index==0){
        NodoSE<T> nuevo = new NodoSE<T>(dato);
        nuevo.setS(inicio);
        fin.setS(nuevo);
        inicio=nuevo;
      }else if(index==size()-1){
        NodoSE<T> nuevo = new NodoSE<T>(dato);
        NodoSE<T> aux = getNodo(index-1);
        aux.setS(nuevo);
        nuevo.setS(fin);
      }else{
       NodoSE<T> nuevo = new NodoSE<T>(dato);
       NodoSE<T> aux1 = getNodo(index-1);
       NodoSE<T> aux2 = getNodo(index+1);
       aux1.setS(nuevo);
       nuevo.setS(aux2);
      }
     }
    }
   }
   public void addAll(ListaCSE<T> lista){
     if(!lista.empty()){
      int i=0;
      while(i<lista.size()){
       add(lista.get(i));
       i+=1;
      }
    }
   }
   public void addAll(int index,ListaCSE<T> lista){
    if(!empty()){
     if(!lista.empty()){
      if(index==0){
        ListaCSE<T> aux = lista.clone();
        aux.getFin().setS(inicio);
        fin.setS(aux.getInicio());
        inicio = aux.getInicio();
      }else if(index==size()-1){
         ListaCSE<T> aux = lista.clone();
         NodoSE<T> aux1=getNodo(index-1);  
         NodoSE<T> aux2=getNodo(index);
         aux1.setS(aux.getFin());
         aux.getFin().setS(aux2);
      }else{
       NodoSE<T> aux1=getNodo(index-1);  
       NodoSE<T> aux2=getNodo(index);
       ListaCSE<T> aux = lista.clone();
       aux1.setS(aux.getInicio());
       aux.getFin().setS(aux2);
      }
     }
    }
   }
   public ListaCSE<T> clone(){
    ListaCSE<T> nuevo = new ListaCSE<T>();
    if(!empty()){
     int i=0;
     while(i<size()){
      nuevo.add(get(i));
      i+=1;
     }
    } 
    return nuevo;
   }
   public boolean contains(T d){
    boolean res = false;
    if(!empty()){
     int i=0;
     int f = size();
     while(i<f&&res==false){
       if(d.equals(get(i))){
        res =true;
       }
       i+=1;
     }
    }
    return res;
   }
   public ListaCSE<T> clone(ListaCSE<T> lista){
      ListaCSE<T> nuevo = new ListaCSE<T>();
      if(!lista.empty()){
        int i=0;
        while(i<lista.size()){
         nuevo.add(lista.get(i));
         i+=1;
        }
      }
      return nuevo;
   } 
    public void clear(){
    inicio = null;
    fin = null;
   }
   public boolean empty(){
    return inicio==null;
   }
   public T get(int index){
    T res = null;
    if(!empty()&&index>=0&&index<size()){
     NodoSE<T> aux = inicio;
     int i=0;
     while(i<=index){
      if(i==index){
        res = aux.getD();  
      }else{
        aux = aux.getS();
      }
      i+=1;
     }
    }
    return res;
   }
   private NodoSE<T> getInicio(){
    return inicio; 
   }
   private NodoSE<T> getFin(){
    return fin; 
   }
      private NodoSE<T> getNodo(int index){
    NodoSE<T> res = null;
    if(!empty()){
     if(index>=0&&index<size()){
      int i=0;
      res = inicio;
      while(i!=index){
        res = res.getS();
        i+=1;
      }
     }
    }
    return res;
   }
     public int indexOf(T dato){
    int res = -1;
    if(!empty()){
     int i=0;
     boolean b=true;
     while(i<size()&&b==true){
      if(get(i).equals(dato)){
        res=i;
        b=false;
      }
      i+=1;
     }
    }
    return res;
   }
   public void remove(int index){
    if(!empty()){
     if(index>=0&&index<size()){
       if(index==0){
        if(size()==1){
         clear();
        }else{
         inicio = inicio.getS();
         fin.setS(inicio);
        }
       }else if(index==size()-1){
        if(size()==1){
         clear();
        }else{
         fin = getNodo(index-1);
         fin.setS(inicio);
        }
       }else{
        NodoSE<T> aux1 = getNodo(index-1);
        NodoSE<T> aux2 = getNodo(index+1);
        aux1.setS(aux2);
       }
     }
    } 
   }
   public void remove(T d){
    if(!empty()){
     int i=0;
     boolean b=true;
     while(i<size()&&b==true){
      if(d.equals(get(i))){
        remove(i);
        b=false;
      }
      i+=1;
     }
    }
   }
   public void removeRange(int i,int f){
    if(!empty()){
     if(i>=0&&f<=size()&&i<size()){
      if(i==f||size()==1){
       remove(i);
      }else if(i==0){
        if(f==size()){
         clear();
        }else{
         NodoSE<T> aux = getNodo(f);
         inicio = aux;
         fin.setS(inicio);
        }
      }else{
        if(f==size()){
         NodoSE<T> aux = getNodo(i-1);
         fin=aux;
         fin.setS(inicio);
        }else{
         NodoSE<T> aux1 = getNodo(i-1);
         NodoSE<T> aux2 = getNodo(f);
         aux1.setS(aux2);
        }
      }
     }
    }
   }
   public void reverse(){
    if(!empty()){
     int tam = size();
     if(tam>1){
      int i=tam-2;
      while(i>=0){
        add(get(i));
        i-=1;
      }
      inicio = getNodo(tam-1);
      fin.setS(inicio);
     }
    } 
   }
   public int size(){
    int res = 0;
    if(!empty()){
     NodoSE<T> aux = inicio;
     while(!aux.getS().equals(inicio)){
      res+=1;   
      aux=aux.getS();
     }
     res+=1;
    }
    return res;
   }
   public ListaCSE<T> subList(int i,int f){
    ListaCSE<T> res = null;
    if(!empty()){
     int tam = size();
     if(i>=0&&i<tam&&f<=tam&&f>=i){
       res = new ListaCSE<>();
       if(i==f){
        res.add(get(i));
       }else{
        NodoSE<T> aux = getNodo(i);
        while(i<f){
         res.add(aux.getD());
         aux = aux.getS();
         i+=1;
        }
       }
     }
    }
    return res;
   }
}
