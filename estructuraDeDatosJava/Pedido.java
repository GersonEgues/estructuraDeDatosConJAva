import ED.EDL.*;
import ED.EDNL.*;
public class Pedido implements Comparable<Pedido>{
 private int cliente;
 private Integer zona;
 private ListaSE<Plato> platos;
 private Integer peso=0;
 public Pedido(int id,String zon,Plato[] plato){
    cliente = id;
    if(zon.equals("norte")){
     zona = 1;
    }else if(zon.equals("sur")){
     zona = 2;
    }else if(zon.equals("este")){
     zona = 3;
    }else if(zon.equals("oeste")){
     zona = 4;
    }
    platos=new ListaSE<>();
    for(int i=0;i<plato.length;i++){
     platos.add(plato[i]);
     peso+=plato[i].peso;
    }
 }
 //priorizaremos las que tienen menos peso
 public int compareTo(Pedido p){
   int res = 10;
   if(zona.compareTo(p.zona)!=0){
    res = zona.compareTo(p.zona);
   }else{
    res = peso-p.peso;
   }
   return res;
 }
}