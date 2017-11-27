/*
 * find the next greater number, idea: geeksforgeeks
 */
package nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;
/**
 *
 * @author rumana aktar
 */
public class NextGreaterElement {

    /**
     * @param args the command line arguments
     */
    
    public static int[] nextGreaterElement(int num[]){
        Stack<Integer> stack=new Stack<>();
        int NGE[]=new int[num.length];
        
        NGE[num.length-1]=-1;
        stack.push(num[num.length-1]);
               
        for(int i=num.length-2; i>=0; i--){
            while(!stack.empty() && stack.peek()<num[i])
                    stack.pop();
            
            if(num[i+1]>num[i]){
                NGE[i]=num[i+1];
            }
            else{
                if(stack.isEmpty())
                    NGE[i]=-1;
                else
                    NGE[i]=stack.peek();
            }
            
            stack.push(num[i]);
        }
        System.out.println(Arrays.toString(NGE));
        return NGE;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int num[]={1,23,45,6,7,90,31,12,47};
        nextGreaterElement(num);
    }
    
}
