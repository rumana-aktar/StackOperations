/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getminimumfromstack;

/**
 *
 * @author md
 */
public class GetMinimumFromStack {

    /**
     * @param args the command line arguments
     */
    int top;
    int stck[];
    int currentMin;
    int size;

    public GetMinimumFromStack(int n) {
        top=0;
        size=n;
        stck=new int[size];
    }
    
    void push(int num){
        System.out.print("push()......");        
        if(top>=size){
            System.out.println("Stack overflow......");
            return;
        }
        if(top==0){
            stck[top++]=num;
            currentMin=num;
        }else if(num>=currentMin){
            stck[top++]=num;            
        }else if(num<currentMin){
            stck[top++]=2*num-currentMin;
            currentMin=num;
        }
        print();
    }
    
    int pop(){
        System.out.print("pop().......");
        int  num;
        if(top<=0){
            System.out.println("Stack underflow....");
            return -1;
        }
        if(stck[top-1]>currentMin){
            num=stck[--top];;
            System.out.print("The poped element: "+num+"...");print();
            return num;
        }
        else{
            --top;
            num=currentMin;
            currentMin=2*currentMin-stck[top];
            System.out.print("The poped element: "+num+"...");print();
            return num;
        }
        
            
    }
    
    void print(){
        for(int i=0; i<top; i++)
            System.out.print(stck[i]+" ");
        System.out.println(" : "+currentMin);
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        GetMinimumFromStack s=new GetMinimumFromStack(100);
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(1);
        s.push(1);
        s.push(-1);
        //s.push(0);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
    
}
