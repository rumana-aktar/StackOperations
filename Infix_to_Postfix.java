/*
 * Convert an infix expression to postfix form; idea geeksforgeeks
 */
package infix_to_postfix;
import java.util.*;
import java.util.Stack;
/**
 *
 * @author rumana aktar
 */


public class Infix_to_Postfix {

    /**
     * @param args the command line arguments
     */
    HashMap<Character, Integer> setPriority(){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('+', 0);
        hm.put('-', 0);
        hm.put('*', 1);
        hm.put('/', 1);
        hm.put('^', 2);        
        return hm;
    }
    
    String InfixToPostfix(String inFix){
        String postFix="";
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> hm=setPriority();       
        
        
        for(int i=0; i<inFix.length(); i++){
            char ch=inFix.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                postFix+=ch+" ";
            }else if(ch == '(')
                stack.push(ch);
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!=')')
                    postFix+=stack.pop()+" ";
                
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression                
                else
                    stack.pop(); //pop the '('
            }else{
                while(!stack.isEmpty() && hm.get(ch)<=hm.get(stack.peek()))
                    postFix+=stack.pop()+" ";
                stack.push(ch);
            
            }
        }
        while(!stack.isEmpty())
            postFix+=stack.pop()+" ";
        
        return postFix;
        
    }    
    
   
    public static void main(String[] args) {
        // TODO code application logic here        
        Infix_to_Postfix itf=new Infix_to_Postfix();
        System.out.println(itf.InfixToPostfix("1-2+3*6/2"));
    }
    
}
