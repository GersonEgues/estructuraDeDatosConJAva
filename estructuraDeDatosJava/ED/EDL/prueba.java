package ED.EDL;
import java.util.ArrayList;

/**
 * Write a description of class prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class prueba
{
    public ArrayList<Integer> sampleMethod()
    {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        
        
        b.add(6);
        b.add(9);
        
        a.addAll(1,b);
        return a;
    }
    public int vetCompareTo(){
     Integer a = 1;
     Integer b = 6;
     return a.compareTo(b);
    }
     public int vetCompareToo(){
     String a = "a";
     String b = "b";
     return b.compareTo(a);
    }
}
