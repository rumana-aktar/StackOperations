/*
 * Implement two stacks with one array, idea: geeksforgeeks
 */
package twostackwithonearray;

/**
 *
 * @author rumana aktar
 */
public class TwoStackWithOneArray {
    int top1, top2;
    int nums[];

    TwoStackWithOneArray(int length) {
        nums=new int[length];
        top1=-1;
        top2=nums.length;
    }
    
    boolean isEmpty1(){
        if(top1==-1){
            System.out.println("Stack1 is empty");
            return true;
        }
        return false;
            
    }
    
    boolean isEmpty2(){
        if(top2==nums.length){
            System.out.println("Stack2 is empty");
            return true;
        }
        return false;
            
    }
    
    boolean isFull(){
        if(top2-top1==1){
            System.out.println("Stacks are full");
            return true;
        }
        return false;
    }
    
    void push1(int val){
        if(isFull())
            return;
        nums[++top1]=val;
    }
    void push2(int val){
        if(isFull())
            return;
        nums[--top2]=val;
    }
    int pop1(){
        if(isEmpty1())
            return -1;
        return nums[top1--];
    }        
    int pop2(){
        if(isEmpty2())
            return -1;
        return nums[top2++];
    }
    
    void print1(){
        System.out.print("\nElemens in Stack1: ");
        for(int i=0; i<=top1; i++)
            System.out.print(nums[i]+" ");
    }
    void print2(){
        System.out.print("\nElemens in Stack2: ");
        for(int i=nums.length-1; i>=top2; i--)
            System.out.print(nums[i]+" ");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TwoStackWithOneArray ts=new TwoStackWithOneArray(10);
        ts.push1(10); ts.push1(12); ts.push1(34); ts.push1(45);
        //ts.print1();ts.print2();
       // ts.pop1();ts.pop2();ts.print1();ts.print2();
        
        ts.push2(23);ts.push2(45);ts.push2(3);ts.push2(8);ts.push2(9);ts.push2(8);ts.push2(4);ts.push2(5);
        ts.print1();ts.print2();
    }
    
}
