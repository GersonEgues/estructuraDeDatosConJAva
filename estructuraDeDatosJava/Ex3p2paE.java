import ED.EDL.*; 
import ED.EDNL.*;
public class Ex3p2paE{
   private ArbolBB<Objeto> arbol=new ArbolBB<>();
   public ListaSE<Objeto> frecuencia(String cadena){
    ListaSE<Objeto> res = new ListaSE<>();
    if(cadena.length()!=0){
     for(int i=0;i<cadena.length();i++){
      String aa = ""+cadena.charAt(i);
      Objeto aux = new Objeto(aa);
      String aaa = aux.getNombre();
      if(arbol.contains(aux)){
       arbol.get(aux).sumar();
      }else{
        arbol.add(aux);
      }
     }
     res = arbol.inOrden();
    }
    return res;
   }
}
