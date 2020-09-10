package ED.EDNL;
import ED.EDL.*;
public class MainBB{
 private ArbolBB<Integer> arb = new ArbolBB<>();
 public void mainn(){
  arb.add(9);
  arb.add(7);
  arb.add(8);
  arb.add(20);
  arb.add(1);
  arb.add(5);
  arb.add(10);
  arb.add(25);
  arb.add(0);
  arb.add(11);
  arb.add(6);
  arb.add(3);
  arb.add(12);
 }
 public ListaSE<Integer> inOrden(){
  return arb.inOrden();   
 }
 public ListaSE<Integer> postOrden(){ 
  return arb.postOrden();   
 }
 public ListaSE<Integer> preOrden(){
  return arb.preOrden();   
 }
 public ListaSE<Integer> inOrdenDesc(){
  return arb.inOrdenDesc();   
 }
 public boolean contains(Integer dato){
  return arb.contains(dato);   
 }
 public Integer remove(Integer t){
  return arb.remove(t);
 }
}
