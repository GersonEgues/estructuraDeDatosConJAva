package ED.EDL;
public class ListaO<T extends Comparable>{
  private NodoDE<T> ini;
  private NodoDE<T> med;
  private NodoDE<T> fin;
  private int size;
  public ListaO(){
    ini=med=fin=null;
    size = 0;
  }
  public boolean empty(){
   return ini==null;  
  }
  public int getSize(){
   return size;  
  }
  public void add(T d){ 
    if(empty()){
     NodoDE<T> nuevo = new NodoDE<T>(d);
     size+=1;
     ini=med=fin=nuevo;  
    }else{
        
     NodoDE<T> nuevo = new NodoDE<T>(d);
     if(d.compareTo(ini.getD())<=0){
       if(size%2==0){
        ini.setA(nuevo);
        nuevo.setS(ini);
        ini=nuevo;
        size+=1;
       }else{
        nuevo.setS(ini);
        ini.setA(nuevo);
        ini = nuevo;
        med = med.getA();
        size+=1;
       }
      
     }else if(d.compareTo(fin.getD())>=0){
      if(size%2==0){
       fin.setS(nuevo);
       nuevo.setA(fin);
       fin=nuevo;
       med = med.getS();
       size+=1;
      }else{
        fin.setS(nuevo);
        nuevo.setA(fin);
        fin=nuevo;
        size+=1;
      }
      
     }else{//**
      if(size%2==0){
       if(size==2){
        ini.setS(nuevo);
        nuevo.setS(fin);
        nuevo.setA(ini);
        fin.setA(nuevo);
        med=nuevo;
        size+=1;
       }else{
        if(d.compareTo(med.getD())==0){
            nuevo.setA(med.getA());
            med.getA().setS(nuevo);
            nuevo.setS(med);
            med.setA(nuevo);
            size+=1;
        }else if(d.compareTo(med.getD())<0){
         NodoDE<T> aux = ini;
         while(d.compareTo(aux.getD())>=0){//+++
            aux = aux.getS();
         }
         NodoDE<T> aux0 = aux.getA();
         nuevo.setA(aux0);
         aux0.setS(nuevo);
         nuevo.setS(aux);
         aux.setA(nuevo);
         size+=1;
        }else if(d.compareTo(med.getD())>0){//+++
         NodoDE<T> aux = med;
         while(d.compareTo(aux.getD())>=0){
            aux = aux.getS();
         }
         NodoDE<T> aux0 = aux.getA();
         aux0.setS(nuevo);
         nuevo.setA(aux0);
         nuevo.setS(aux);
         aux.setA(nuevo);
         med = med.getS();//+++
         size+=1;
        }
       }  
      }else{
        if(d.compareTo(med.getD())==0){
           nuevo.setS(med.getS());
           nuevo.setA(med);
           med.setS(nuevo);
           nuevo.getS().setA(nuevo);
           size+=1;
        }else if(d.compareTo(med.getD())<0){//+++--
          NodoDE<T> aux = ini;
          while(d.compareTo(aux.getD())>=0){
            aux = aux.getS();
          }
          NodoDE<T> aux0 = aux.getA();
          nuevo.setA(aux0);
          aux0.setS(nuevo);
          nuevo.setS(aux);
          aux.setA(nuevo);
          med = med.getA();
          size+=1;
        }else if(d.compareTo(med.getD())>0){//++++
         NodoDE<T> aux = med;
         while(d.compareTo(aux.getD())>=0){
           aux = aux.getS();
         }
         NodoDE<T> aux0 = aux.getA();
         aux0.setS(nuevo);
         nuevo.setA(aux0);
         nuevo.setS(aux);
         aux.setA(nuevo);
         size+=1;
        }        
      }
     }
    }
  }
  public void print(){
   System.out.print("[");   
   NodoDE<T> aux = ini;
   for(int i=0;i<size;i++){
    if(i!=size-1)
     System.out.print(aux.getD()+", ");
    else
     System.out.print(aux.getD());
    aux=aux.getS();
   }
   System.out.println("]");
  }
  public void printM(){
   System.out.println("medio: " + med.getD());  
  }
}