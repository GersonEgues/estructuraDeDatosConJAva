package ED.EDNL;
import ED.EDL.*;
public class Main{
   private BinaryTree<String> arbol;
   public Main(){
    arbol = new BinaryTree<>(); 
   }
   public void main(){
    ListaSE<String> lista = new ListaSE<>();
    arbol.add("1");
    arbol.add("2");
    arbol.add("3");
    arbol.add("4");
    arbol.add("5");
    arbol.add("6");
    arbol.add("7");
    arbol.add("8");
    arbol.add("9");
    arbol.add("10");
    
    lista.add("1");
    lista.add("2");
    lista.add("5");
    lista.add("10");
    arbol.add("33",lista);
    
    
    
    lista.clear();
    lista.add("1");
    lista.add("3");
    lista.add("7");
    arbol.add("45",lista);
   }
   public int numHojas(){
    return arbol.numHojas(); 
   }
   public void remove(){
    arbol.removeW("2"); 
   }
   public ListaSE<String> ramaMasLarga(){
     return arbol.ramaMasLargaa();
   }
   public ListaSE<String> ramaMasCorta(){
     return arbol.ramaMasCorta();
   }
   public ListaSE<String> postOrden(){
    return arbol.recorridoPostOrden(); 
   }
   public ListaSE<String> preOrden(){
    return arbol.recorridoPreOrden(); 
   }
   public ListaSE<String> InOrden(){
    return arbol.recorridoInOrden(); 
   }
   public ListaSE<String> recorridoAmplitud(){
    return arbol.recorridoAmplitud(); 
   }
   public ListaSE<String> datosDeNivelN(int n){
    return arbol.datosDeNivelN(n);
   }
   public boolean contains(String dato){
    return arbol.contains(dato); 
   }
   public void mirror(){
    arbol.mirror();
   }
   public int nivelDeArbol(){
    return arbol.nivelDeArbol(); 
   }
   public ListaSE<String> getCaminoAsc(){
    return arbol.getCaminoAsc("10"); 
   }
   public ListaSE<String> getCaminoDesc(){
    return arbol.getCaminoDesc("10"); 
   }
   public ListaSE<String> getListaAsc(){
    return arbol.getListaAsc("3"); 
   }
   public ListaSE<String> getListaDesc(){
    return arbol.getListaDesc("4"); 
   }
   public ListaSE<String> getHojas(){
    return arbol.getHojas(); 
   }
   public ListaSE<String> getCaminoNN(String d1,String d2){
    return arbol.getCamino(d1,d2); 
   }
   public int nivelDeNodo(String d){
    return arbol.nivelNodo(d); 
   }
   public BinaryTree<String> getArbol(String raiz){
    return arbol.getArbol(raiz);
   }
   public int gradoNodo(String dato){
    return arbol.gradoNodo(dato); 
   }
   public int alturaArbol(){
    return arbol.alturaArbol(); 
   }
   public int alturaNodo(String d){
    return  arbol.alturaNodo(d);
   }
   public ListaSE<ListaSE<String>> getRamas(){
    return arbol.getRamas();
   }
}