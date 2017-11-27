/*
 * sort a stack using only stack operations and a temporary stack, idea geeksforgeeks
 */
package sortstack;
import java.util.Stack;
/**
 *
 * @author rumana aktar
 */
public class SortStack {

    
    /**
     * @param args the command line arguments
     */
    
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> tmp=new Stack<>();
        while(!stack.isEmpty()){
            int num=stack.pop();
                
            while(!tmp.isEmpty() && tmp.peek()>num){
                stack.push(tmp.pop());
            }
            tmp.push(num);  
            
        }
        return tmp;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<Integer> stack=new Stack<>();
        stack.push(12);
        stack.push(34);
        stack.push(2);
        stack.push(4);
        stack.push(46);
        System.out.println(stack);
        stack=sortStack(stack);
        System.out.println(stack);
        
    }
    
}
