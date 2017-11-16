/*
 * K stack in a single array: push(val, stack_no), pop(stack_no): idea: geeksforgeeks
 */
package kstackswithonearray;

/**
 *
 * @author rumana aktar
 */
public class KStacksWithOneArray {

    /**
     * @param args the command line arguments
     */
    int nums[], prev[],  top[], k, free;

    KStacksWithOneArray(int n, int k) {
        free=0;
        this.k=k;
        nums=new int[n];
        prev=new int[n];
        top=new int[k];
        
        for(int i=0; i<k; i++)
            top[i]=-1;
        
        for(int i=0; i<n-1; i++)
            prev[i]=i+1;
        prev[n-1]=-1;
        
    }
    boolean isEmpty(int stack_no){
        if(!validStack(stack_no))
            return true;
        if(top[stack_no]==-1){
            System.out.print("Stack is empty");
            return true;
        }
        return false;
    }
    
    boolean isFull(int stack_no){
        if(!validStack(stack_no))
            return true;
        if(free==-1){
            System.out.print("Stack is full");
            return true;
        }
        return false;
            
    }
    
    boolean validStack(int stack_no){
        if(stack_no>=k){
            System.out.println("\nStack not found....");
            return false;
        }
        return true;        
    }
    
    void push(int val, int stack_no){        
        if(!validStack(stack_no) || isFull(stack_no))
            return;
        
        //get the available poition
        int i=free;
        free=prev[i];//update free
        
        //get the previous index of stack stack_no from top[stack_no] array
        prev[i]=top[stack_no];
        //update the top for current element for stack_no 
        top[stack_no]=i;
        //store the element in nums array
        nums[i]=val;
        
    }
    
    int pop(int stack_no){
        System.out.println();
        if(!validStack(stack_no) || isEmpty(stack_no))
            return -1;
        int stack_top=top[stack_no];
        int val=nums[stack_top];
        top[stack_no]=prev[stack_top];
        System.out.print("Poped element: "+val); print();
        return val;
    }
    
    void print1(){
        System.out.println();
        for(int i=0; i<k; i++)
            System.out.print(top[i]+" ");
        System.out.println();
        for(int i=0; i<nums.length; i++)
            System.out.print(prev[i]+" ");
        System.out.println();
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i]+" ");
    }
    
    void print(){
        System.out.print("\n**********************");
        for(int i=0; i<k; i++){
            System.out.print("\nStack"+i+": ");      
            if(isEmpty(i))
                continue;
            
            int curPos=top[i];
            while(true){
                System.out.print(nums[curPos]+" ");
                curPos=prev[curPos];
                if(curPos==-1)
                    break;
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        KStacksWithOneArray ks=new KStacksWithOneArray(10, 4);
        //ks.isEmpty();ks.isFull();ks.print();
        ks.push(12, 0); ks.print();
        ks.push(22, 1);
        ks.push(42, 1);
        ks.push(52, 1); ks.print();
        ks.pop(0);ks.pop(0);
        
        ks.push(1, 5);
        ks.pop(10);

    }
    
}
