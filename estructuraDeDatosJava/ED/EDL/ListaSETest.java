package ED.EDL;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaSETest<T>{
    private ListaSE<Integer> listaSE;
    public ListaSETest(){
      listaSE = new ListaSE<>();
    }
    @Test
    public void testAddAll1(){
     ListaSE<Integer> aux = new ListaSE<>();
     aux.add(1);
     aux.add(2);
     aux.add(3);
     listaSE.addAll(aux);
     assertEquals(3,listaSE.size());
    }
    
}
