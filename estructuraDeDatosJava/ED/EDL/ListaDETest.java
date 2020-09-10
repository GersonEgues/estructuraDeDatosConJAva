package ED.EDL;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaDETest<T>{
 private ListaDE<String> lista;
 public ListaDETest(){
  lista = new ListaDE<String>();     
 }
 @Test
 public void testContains(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  assertTrue(lista.contains("2"));
 }
 @Test
 public void TestIndexOf(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  assertEquals(1,lista.indexOf("2"));
 }
 @Test
 public void testSize(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  assertEquals(3,lista.size());
 }
 @Test
 public void testRemoveT(){
  lista.add("1");
  lista.add("2");
  lista.add("3");
  lista.add("4");
  lista.remove("2");
  assertEquals(3,lista.size());
 }
}
