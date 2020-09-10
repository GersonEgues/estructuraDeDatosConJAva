import ED.EDL.*;
import ED.EDNL.*;
public class Ejer35ednl{
   private BinaryTree<String> arbol1 = new BinaryTree<>();
   private BinaryTree<String> arbol2 = new BinaryTree<>();
   public void llenarArboles(){
    ListaSE<String> lista = new ListaSE<>();
    arbol1.add("1");
    arbol1.add("2");
    arbol1.add("3");
    arbol1.add("4");
    arbol1.add("5");
    arbol1.add("6");
    arbol1.add("7");
    arbol1.add("8");
    arbol1.add("9");
    arbol1.add("10");
    
    lista.add("1");
    lista.add("2");
    lista.add("5");
    lista.add("10");
    arbol1.add("33",lista);
    
    lista.clear();
    lista.add("1");
    lista.add("3");
    lista.add("7");
    arbol1.add("45",lista);
    //----------------------------------------------
    lista = new ListaSE<>();
    
    arbol2.add("1");
    arbol2.add("2");
    arbol2.add("3");
    arbol2.add("4");
    arbol2.add("5");
    arbol2.add("6");
    arbol2.add("7");
    arbol2.add("8");
    arbol2.add("9");
    arbol2.add("10");
    
    lista.add("1");
    lista.add("2");
    lista.add("5");
    lista.add("10");
    arbol2.add("33",lista);
    
   
    lista.clear();
    lista.add("1");
    lista.add("3");
    lista.add("7");
    arbol2.add("45",lista);
   }
   public boolean semejantes(){
    boolean res = false;
    int nivel1 = arbol1.nivelDeArbol();
    int nivel2 = arbol2.nivelDeArbol();
    if(nivel1==nivel2){
     int i=0;
     boolean b = true;
     while(i<=nivel1&&b){
       ListaSE<String> aux1 = arbol1.datosDeNivelN(i);
       ListaSE<String> aux2 = arbol2.datosDeNivelN(i);
       if(!aux1.equalsC(aux2)){
        b=false;
       }
       i+=1;
     }
     res = b;
    }
    return res;
   }
}
