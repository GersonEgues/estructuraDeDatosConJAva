package ED.EDL;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaCSETest<T>{
 private ListaCSE<String> lista;
 public ListaCSETest(){
  lista = new ListaCSE<>();
 }
 @Test
 public void testAdd(){
  lista.add("1");
  lista.add("2");
  assertTrue(!lista.empty());
 }
 @Test
 public void testContains(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  lista.add("4");
  lista.add("5");
  lista.add("6");
  assertFalse(lista.contains("9"));
 } 
 @Test
 public void TestSize(){
  lista.add("1");
  lista.add("2");
  assertEquals(2,lista.size());
 }
 @Test
 public void testRemoveIndex(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  lista.add("4");
  lista.remove(0);
  lista.remove(1);
  lista.remove(1);
  assertEquals(1,lista.size());
 }
 @Test
 public void testRemoveDate(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  lista.add("4");
  lista.remove("1");
  lista.remove("2");
  lista.remove("4");
  assertEquals(1,lista.size());
 }
 @Test
 public void testRemoveRange(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  lista.add("4");
  lista.removeRange(4,4);
  assertEquals(4,lista.size());
 }
 @Test
 public void testSubList(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  lista.add("4");
  lista.add("5");
  lista.add("6");
  ListaCSE<String> res = lista.subList(4,5);
  assertEquals(1,res.size());
 } 
}
