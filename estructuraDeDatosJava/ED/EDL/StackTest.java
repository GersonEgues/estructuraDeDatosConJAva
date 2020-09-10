package ED.EDL;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class StackTest<T>{
 private Stack<String> stack;
 public StackTest(){
  stack = new Stack<>();
 }
 @Test
 public void testPush(){
  stack.push("1");
  stack.push("2");
  stack.push("3");
  assertEquals("3",stack.top());
 }
}
