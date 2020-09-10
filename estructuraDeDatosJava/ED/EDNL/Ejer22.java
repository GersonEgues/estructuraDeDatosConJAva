package ED.EDNL;
import ED.EDL.*;
public class Ejer22{
 private ArbolBB<Integer> arbol;
 public Ejer22(int[] cad){
  arbol = new ArbolBB<>();
  for(int i=0;i<cad.length;i++){
   arbol.add(cad[i]);
  }
 }
 public ListaSE<Integer> getMediana(){
  ListaSE<Integer> res = new ListaSE<>();
  int tam = arbol.nivelDeArbol();
  for(int i=0;i<=tam;i++){
    ListaSE<Integer> aux = arbol.datosDeNivelN(i);
    aux = getOrdenado(aux);
    //aux.print();
    int l = aux.size();
    if(l%2==0){
     int a = l/2;
     int b = a-1;
     int rr = (aux.get(b)+aux.get(a))/2;
     res.add(rr);
    }else{
     if(l==1){
      res.add(aux.get(0));
     }else{
      res.add(aux.get(l/2));
     }
    }    
  }
  //res.print();
  return res;
 }
 private ListaSE<Integer> getOrdenado(ListaSE<Integer> lista){
   int tam = lista.size();
   if(tam!=1){
    ArbolBB<Integer> aux = new ArbolBB<>();
    for(int i=0;i<tam;i++){
     aux.add(lista.get(i));
    }
    lista = aux.inOrden();
   }
   return lista;
 }
}
