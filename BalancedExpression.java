/*
 * check whether en expression is balanced or not: idea geeksforgeeks
 */
package balancedexpression;
import java.util.*;
/**
 *
 * @author rumana aktar
 */
public class BalancedExpression {

    /**
     * @param args the command line arguments
     */
    
    public static boolean balancedExpression(String exp){
        Stack<Character> stack=new Stack<>();
        
        for(int i=0; i<exp.length(); i++){
            char ch=exp.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
                stack.push(ch);
            else if(ch==')' || ch=='}' || ch==']')
                if(stack.isEmpty())
                    return  false;
            else if(ch==')'){
                if(stack.pop()!='(')
                    return false;
            }else if(ch=='}'){
                if(stack.pop()!='{')
                    return false;
            }else if(ch==']'){
                if(stack.pop()!='[')
                    return false;
            }            
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print(balancedExpression("()(({})[])"));
        System.out.print("\n"+balancedExpression("()(({]})[])"));
    }
    
}
