/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionevaluation;

/**
 *
 * @author md
 */

class Stack {
    int head;
    int nums[];
    int length;
    /**
     * @param args the command line arguments
     */
    Stack(int n){
        head=-1;
        nums=new int[n];
        this.length=n;
    }
    boolean isEmpty(){
        if(head==-1){
            System.out.println("Stackunder flow.......");
            return true;
        }
        return false;
    }
    int pop(){
        if(head==-1){
            System.out.println("Stackunder flow.......");
            return -1;
        }
        else
            return nums[head--];
    }
    
    void push(int val){
        if(head==length-1){
            System.out.println("Stack overflow.........");
            return;
        }else
            nums[++head]=val;
        
    } 
    void printStack(){
        for(int i=0; i<=head; i++)
            System.out.print(nums[i]+" ");
        System.out.println();
    }
}
public class ExpressionEvaluation {

    /**
     * @param args the command line arguments
     */
    
       
    int evaluateExpression(String postFix){
        int result=0;
        
        Stack s=new Stack(100);
        for(int i=0; i<postFix.length(); i++){
            char ch=postFix.charAt(i);
            if(ch==' ')
                continue;
            
            String num="";
            if(ch>='0' && ch <='9'){
                num+=ch;
                while(postFix.charAt(++i)!=' ')
                    num+=ch;
                s.push(Integer.parseInt(num));
            }else{
                int op2=s.pop();
                int op1=s.pop();
                if(ch=='+')
                    s.push((op1+op2));
                else if(ch=='-')
                    s.push((op1-op2));
                else if(ch=='^')
                    s.push((op1^op2));
                else if(ch=='*')
                    s.push((op1*op2));
                else if(ch=='/')
                    s.push((op1/op2));
            }
            //s.printStack();
        }
        result=s.pop();
        System.out.println("The result is: "+result);
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ExpressionEvaluation exp=new ExpressionEvaluation();
        exp.evaluateExpression("11 2 - 3 6 * 2 / + ");
    }
    
}
