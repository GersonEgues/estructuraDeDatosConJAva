package ED.EDL;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class DequeTest<T>{
 private Deque<String> deque; 
 public DequeTest(){
  deque = new Deque<>();
 }
 @Test
 public void testPopFront(){
  deque.push("1");   
 }
}
