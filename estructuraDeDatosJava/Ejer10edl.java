import ED.EDL.*;
import ED.EDNL.*;
public class Ejer10edl{
 private Stack<Character> pila;
 public Ejer10edl(){
  pila = new Stack<>();   
 }
 public String cadenaExtendida(String cadena){
  cadena = cadena.toLowerCase();
  String res = "";
  if(cadena.length()!=0){
   for(int i=0;i<cadena.length();i++){
    char aux = cadena.charAt(i);
    if(pila.empty()){
     if(vocalF(aux)){
      pila.push('i');
      pila.push(aux);
     }else{
      pila.push(aux); 
     }
    }else{
     boolean b = false;
     if(vocalF(pila.top())){
        pila.push('u');
        if(aux=='u')
         b=true;
     } 
     
     if(!b){
      if(vocalF(aux)){
       if(pila.top()=='i'){
        pila.push(aux);
       }else{
        pila.push('i');
        pila.push(aux);
       }
      }else{
        pila.push(aux);     
      }
     }
    }
    
    if(i==cadena.length()-1&&vocalF(aux)){
     pila.push('u');
    }
   }
   
   while(!pila.empty()){
     res = ""+pila.pop()+res;
   }
   System.out.println(res);
  }
  
  return res;
 }
 private boolean vocalF(char c){
  return (c=='a'||c=='e'||c=='o');
 }
}
