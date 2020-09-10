package ED.EDL;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaCDETest<T>{
    private ListaCDE<String> lista;
    public ListaCDETest(){
        lista = new ListaCDE<>();
    }
    @Test
    public void testAdd(){
     lista.add("1");
     lista.add("2");
     lista.add("3");
     lista.add("4");
     assertEquals(4,lista.size());
    }
    @Test
    public void testContains(){
     lista.add("1");
     lista.add("2");
     lista.add("3");
     lista.add("4");
     assertTrue(lista.contains("3"));
    }
    @Test
    public void testGetT(){
     lista.add("1");
     lista.add("2");
     lista.add("3");
     lista.add("4");
     assertEquals("3",lista.get(2));
    }
    @Test
    public void testRemove(){
     lista.add("1");
     lista.add("2");
     lista.add("3");
     lista.add("4");
     lista.remove(2);
     assertEquals(3,lista.size());
    }
    @Test
    public void testSubList(){
     lista.add("1");
     lista.add("2");
     lista.add("3");
     lista.add("4");
     lista.add("5");
     lista.add("6");
     ListaCDE<String> aux = lista.sublist(5,5);
     assertEquals(1,aux.size());
    }
    @Test
    public void testIndexOf(){
     lista.add("1");
     lista.add("2");
     lista.add("3");
     lista.add("4");
     lista.add("5");
     lista.add("6");
     assertEquals(-1,lista.indexOf("9"));
    }
    @Test
    public void testRemoveT(){
     lista.add("1");
     lista.add("2");
     lista.add("3");
     lista.add("4");
     lista.add("5");
     lista.add("6");
     lista.remove("1");
     lista.remove("6");
     assertEquals(4,lista.size());
    }
}
