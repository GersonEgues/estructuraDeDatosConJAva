import ED.EDL.*;
import ED.EDNL.*;
public class Ejer23ednl{
  private BinaryTree<Pueblo> arbol=new BinaryTree<>();
  public void llenarArbol(){
   Pueblo p1 = new Pueblo("Notar",0);  
   Pueblo p2 = new Pueblo("NejoCo",15);
   Pueblo p3 = new Pueblo("Noel",10);
   Pueblo p4 = new Pueblo("NoAs",30);
   Pueblo p5 = new Pueblo("Dillar",60);
   Pueblo p6 = new Pueblo("NoRe",20);
   Pueblo p7 = new Pueblo("Mapu",100);
   Pueblo p8 = new Pueblo("Onom",40);
   Pueblo p9 = new Pueblo("DoPar",35);
   Pueblo p10 = new Pueblo("TeraPan",40);
   Pueblo p11 = new Pueblo("ABo",50);
   Pueblo p12 = new Pueblo("GreTi",20);
   
   arbol.add(p1);
   arbol.add(p2);
   arbol.add(p3);
   arbol.add(p4);
   arbol.add(p5);
   arbol.add(p6);
   arbol.add(p7);
   
   ListaSE<Pueblo> lista=new ListaSE<>();
   lista.add(p1);
   lista.add(p2);
   lista.add(p5);
   arbol.add(p8,lista);
   lista.clear();
   
   lista.add(p1);
   lista.add(p2);
   lista.add(p5);
   lista.add(p8);
   arbol.add(p11,lista);
   lista.clear();
   //----------------------------
   lista.add(p1);
   lista.add(p3);
   lista.add(p7);
   arbol.add(p9,lista);
   lista.clear();
   
   lista.add(p1);
   lista.add(p3);
   lista.add(p7);
   arbol.add(p10,lista);
   lista.clear();
   
   lista.add(p1);
   lista.add(p3);
   lista.add(p7);
   lista.add(p10);
   arbol.add(p12,lista);
   lista.clear();
  }
  public ListaSE<Pueblo> masPueblos(int x){
    return masPueblos(x,arbol);
  }
  private ListaSE<Pueblo> masPueblos(int x,BinaryTree<Pueblo> a){
   ListaSE<Pueblo> res = new ListaSE<>();
   if(!a.empty()){
    int aux = x-a.getRaiz().getDistancia();
    if(aux>=0){
     res.add(a.getRaiz());
     ListaSE<Pueblo> aux1 = masPueblos(aux,a.getLeft());
     ListaSE<Pueblo> aux2 = masPueblos(aux,a.getRight());
     if(aux1.size()>aux2.size()){
      res.addAll(aux1);  
     }else{
      res.addAll(aux2);
     }
    }
   }
   return res;
  }
}
