package ED.EDL;

public class MainPila{
 private Stack<String> pila=new Stack<>();
 public void main(){
  pila.push("1");
  pila.push("2");
  pila.push("3");
  pila.push("4");
 }
 public Stack<String> invertir(){
  return pila.invertir();   
 }
}
