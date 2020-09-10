import ED.EDL.*;
import ED.EDNL.*;
public class Ejer22edl{
 private Stack<PatRed> pila = new Stack<>();
 public String patronReducido(String cadena){
  String res = ""; 
  for(int i=0;i<cadena.length();i++){
   if(pila.empty()){
    pila.push(new PatRed(cadena.charAt(i)));
   }else{
    char aux = cadena.charAt(i);
    if(aux==pila.top().getChar()){
     pila.top().sumar();
    }else{
     pila.push(new PatRed(cadena.charAt(i)));
    }
   }
  }
  
  while(!pila.empty()){
   res = ""+pila.top().getChar()+pila.top().getCont()+res;
   pila.pop();
  }
  return res;
 }
}