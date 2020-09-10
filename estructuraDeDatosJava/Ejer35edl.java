import ED.EDL.*;
import ED.EDNL.*;
public class Ejer35edl{
 private Stack<Character> pila = new Stack<>();
 public String decifrar(String cadena){
  String res = "";
  if(cadena.length()!=0){
   for(int i=0;i<cadena.length();i++){
    if(pila.empty()){
     pila.push(cadena.charAt(i));
    }else{
     char aux1 = cadena.charAt(i);
     char aux2 = pila.top();
     if(aux1==aux2){
      pila.pop();
     }else{
      pila.push(aux1);   
     }
    }
   }
    
   while(!pila.empty()){
    res = ""+pila.pop()+res;
   }
  }
  return res;
 }
}
