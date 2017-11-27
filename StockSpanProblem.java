/*
 * Stock span problem, idea: geeksforgeeks
 */
package stockspanproblem;
import java.util.Arrays;
import java.util.Stack;
/**
 *
 * @author rumana aktar
 */
public class StockSpanProblem {

    /**
     * @param args the command line arguments
     */
    
    public static int [] getSpan(int stock[]){
        int span[]=new int[stock.length];
        Stack<Integer> stack=new Stack<>();
        
        span[0]=1;
        stack.push(0);
        for(int i=1; i<stock.length; i++){
            while(!stack.isEmpty() && stock[stack.peek()]<=stock[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                span[i]=i+1;
            else
                span[i]=i-stack.peek();
            
            stack.push(i);
        }
        System.out.print(Arrays.toString(span));
        return span;
    
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int price[] = {10, 4, 5, 90, 120, 80, 100};
        getSpan(price);
    }
    
}
