package ED.EDL;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class QueueTest<T>{
 private Queue<String> queue;
 public QueueTest(){
  queue = new Queue<>();
 }
 @Test
 public void testPop(){
  queue.push("1");   
  queue.push("2");
  queue.pop();
  queue.pop();
  assertTrue(queue.empty());
 }
}
