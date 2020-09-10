import ED.EDL.*;
import ED.EDNL.*;
public class Ejer9ednl{
   private ArbolBB<Pedido> pedidos;
   public Ejer9ednl(){
    pedidos = new ArbolBB<Pedido>(); 
   }
   public void setPedidos(Pedido p){
    pedidos.add(p);
   }
   public ListaSE<Pedido> getPedidos(){
    return pedidos.inOrden(); 
   }
}
