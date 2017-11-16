/*
 * Implement queue with two stack, idea: geeksforgeeks
 */
package implementqueueusingstack;

/**
 *
 * @author rumana aktar
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
    int pop(){
        if(!isEmpty())
            return nums[head--];
        return -1;
    }
    
    boolean isEmpty(){
        if(head==-1){
            //System.out.println("Stackunder flow.......");
            return true;
        }
        return false;
    }
    
    boolean isFull(){
        if(head==length-1){
            //System.out.println("Stack overflow.........");
            return true;
        }
        return false;
    }
    
    void push(int val){
        if(!isFull())
            nums[++head]=val;
        
    }
    void printStack(){
        for(int i=0; i<=head; i++)
            System.out.print(nums[i]+" ");
        System.out.println();
    }
}
public class ImplementQueueUsingStack {

    /**
     * @param args the command line arguments
     */
    
    Stack s1, s2;
    int size;
    ImplementQueueUsingStack(int num) {
        s1=new Stack(num);
        s2=new Stack(num);
        size=num;
    }
    
    void enqueue(int num){
        s1.push(num);
    }
    
    boolean isEmpty(){
        if(s1.isEmpty() && s2.isEmpty()){
            System.out.println("The queue is empty");
            return true;
        }
        return false;
    }
    
    boolean isFull(){
        if(s1.head+s2.head >= size){
            System.out.println("Queue is full");
            return true;
        }
        return false;
    }
    
    int dequeue(){
        if(isEmpty())
            return -1;
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }            
            s2.printStack();
        }
        int num=s2.pop();
        System.out.println("Dequeued element is: "+num);
        return num;        
    }
    void printQueue(){
        System.out.print("\nElemens in Stack1: ");
        s1.printStack();
        System.out.print("Elemens in Stack2: ");
        s2.printStack();
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        ImplementQueueUsingStack q = new ImplementQueueUsingStack(100);
        q.enqueue(10); q.enqueue(23); q.enqueue(4); q.enqueue(56);
        q.dequeue();q.dequeue();q.enqueue(3);q.dequeue();q.dequeue(); q.dequeue();
                
        
       
    }
    
}
