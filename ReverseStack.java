/*
 * reverse a stack with only stack operations: push, pop, peek; idea geeksforgeeks
 */
package reversestack;
import java.util.Stack;
/**
 *
 * @author rumana aktar
 */
public class ReverseStack {

    /**
     * @param args the command line arguments
     */
    
    static Stack<Integer> stack=new Stack<>();
    public static void insert_at_bottom(int num){
        if(stack.isEmpty())
            stack.push(num);
        else{
            int num2=stack.pop();
            insert_at_bottom(num);
            stack.push(num2);
        }
    }
    
    public static void reverse(){
        if(stack.size()>0){
            int num=stack.pop();
            reverse();
            insert_at_bottom(num);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        stack.push(12);
        stack.push(34);
        stack.push(2);
        stack.push(4);
        stack.push(46);
        System.out.println(stack);
        
        reverse();
        
        System.out.println(stack);
        
    }
    
}
