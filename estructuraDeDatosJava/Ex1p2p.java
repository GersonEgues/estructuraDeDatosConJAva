import ED.EDL.*;
import ED.EDNL.*;
public class Ex1p2p{
 private BinaryTree<String> arbol = new BinaryTree<String>();
 public void main(){
  arbol.add("inicio");   
  arbol.add("dia");
  arbol.add("noche");
  arbol.add("esperar");
  arbol.add("actuar");
  arbol.add("amanecer");
  ListaSE<String> lista = new ListaSE<>();
  lista.add("inicio");
  lista.add("dia");
  lista.add("esperar");
  arbol.add("muerte",lista);
  lista.clear();
  lista.add("inicio");
  lista.add("dia");
  lista.add("actuar");
  arbol.add("muerte",lista);
  lista.clear();
  lista.add("inicio");
  lista.add("amanecer");
  arbol.add("fortaleza",lista);
  lista.clear();
  lista.add("inicio");
  lista.add("noche");
  lista.add("amanecer");
  arbol.add("fortaleza",lista);
  lista.clear();
  lista.add("inicio");
  lista.add("noche");
  lista.add("amanecer");
  arbol.add("tinieblas",lista);
  lista.clear();
  
  lista.add("inicio");
  lista.add("noche");
  lista.add("amanecer");
  lista.add("tinieblas");
  arbol.add("aprender",lista);
  lista.clear();
  
  lista.add("inicio");
  lista.add("noche");
  lista.add("amanecer");
  lista.add("tinieblas");
  arbol.add("luz",lista);
  lista.clear();
  
  
  lista.add("inicio");
  lista.add("noche");
  lista.add("amanecer");
  lista.add("tinieblas");
  lista.add("aprender");
  arbol.add("vida",lista);
  lista.clear();
  
  lista.add("inicio");
  lista.add("noche");
  lista.add("amanecer");
  lista.add("tinieblas");
  lista.add("luz");
  arbol.add("muerte",lista);
 }
 public ListaSE<String> guia(){
  ListaSE<String> res = guia(arbol);
  if(!res.empty()){
    res.remove("vida");
  }
  return res;
 }
 private ListaSE<String> guia(BinaryTree<String> a){
  ListaSE<String> res = new ListaSE<>();
  if(!a.empty()){
   if(a.esHoja()){
    if(a.getRaiz().equals("vida")){
     res.add(a.getRaiz());
    }
   }else{
    ListaSE<String> aux1 = guia(a.getLeft());
    if(!aux1.empty()){
     res.add(0,"izq");
     res.addAll(aux1);
    }else{
     aux1 = guia(a.getRight());
     if(!aux1.empty()){
      res.add(0,"der");     
      res.addAll(aux1);
     }
    }
   }
  }
  return res;
 }
}
