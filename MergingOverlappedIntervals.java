/*
 * merge an orderes intevals if there is any overlap, idea: geeksforgeeks
 */
package mergingoverlappedintervals;

import java.util.Stack;

/**
 *
 * @author rumana aktar
 */

class Pair{
    int a, b;
    Pair(int x, int y){a=x;b=y;}
}
public class MergingOverlappedIntervals {

    /**
     * @param args the command line arguments
     */
    
    public static void print(Stack<Pair> stack){
        while(!stack.isEmpty()){
            Pair top=stack.pop();
            System.out.print(top.a+":"+top.b+"   ");
        }
    }
    
    public static void merger(Pair p[]){
        Stack<Pair> stack=new Stack<>();
        stack.push(p[0]);
        
        for(int i=1; i<p.length; i++){
            if(p[i].a <= stack.peek().b){
                Pair top=stack.pop();
                stack.push(new Pair(top.a, p[i].b));
            }else
                stack.push(p[i]);
        }        
        print(stack);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Pair p[]={new Pair(1,3), new Pair(2,4), new Pair(5,11),new Pair(5,30), new Pair(6,50), new Pair(8,55), new Pair(80, 100)};
        merger(p);
        
    }
    
}
