/*
 * Implement Stack with getMax() function in O(1) time
 */
package getmaximumelementfromstack;

/**
 *
 * @author rumana aktar
 */
public class GetMaximumElementFromStack {
    int head;
    int nums[];
    int length;
    int curMax;
    /**
     * @param args the command line arguments
     */
    GetMaximumElementFromStack(int n){
        head=-1;
        nums=new int[n];
        this.length=n;       
    }
    int pop(){
        if(isEmpty())
            return -1;
        int val=nums[head--];
        if(val>curMax){
            int temp=curMax;
            curMax=val-2*curMax;
            val=temp;
        }
        System.out.println("Poped item: "+val+"....curMax: "+curMax);
        return val;
    }
    
    boolean isEmpty(){
        if(head==-1){
            System.out.println("Stackunder flow.......");
            return true;
        }
        return false;
    }
    
    boolean isFull(){
        if(head==length-1){
            System.out.println("Stack overflow.........");
            return true;
        }
        return false;
    }
    
    void push(int val){
        if(isFull())
            return;
        if(head==-1)
            curMax=val;
        if(val>curMax){
            nums[++head]=2*val+curMax;
            curMax=val;
        }
        else
            nums[++head]=val;
        
    }
    void printStack(){
        for(int i=0; i<=head; i++)
            System.out.print(nums[i]+" ");
        System.out.println(".....current max: "+curMax);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        GetMaximumElementFromStack s=new GetMaximumElementFromStack(100);
        s.push(9);
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(10);
        s.push(12);
        s.push(7);
        s.printStack();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
    
}
