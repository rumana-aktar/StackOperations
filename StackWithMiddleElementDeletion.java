/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackwithmiddleelementdeletion;

/**
 *
 * @author md
 */
class Node{
    int val, count;
    Node next, prev;
    Node(int val){
        this.val=val;
        next=prev=null;
    }
}
public class StackWithMiddleElementDeletion {
    Node head, middle;
    int count=0;
    
    boolean isEmpty(){
        if(count==0){
            System.out.println("Stack is empty.........");
            return true;
        }
        return false;
    }
    
    void push(int num){
        if(head==null){
            head=new Node(num);
            middle=head;
            count++;
        }else{
            Node temp=new Node(num);
            temp.next=head;
            head.prev=temp;
            head=temp;
            if(count!=0 && count%2==0){
                middle=middle.prev;
            }
            count++;
        }
    }
    int pop(){
        if(isEmpty())
            return -1;
        if(count==1){
            head=null;
            middle=null;
            count=0;
            return -1;
        }
        int val=head.val;
        head=head.next;
        head.prev=null;
        if(count!=1 && count%2==1){
            middle=middle.next;
        }
        count--;
        return val;    
    }
    
    int getMiddle(){
        if(isEmpty())
            return -1;
        return middle.val;
    }
    
    int deleteMiddle(){
        //print();
        if(isEmpty())
            return -1;
        
        int val=middle.val;           
        
        if(count==1){
            head=null; middle=null;
        }else if(count==2){
            head.next=null;
            middle=head;
        }else{
            if(count%2==0){
                middle=middle.prev;
                middle.next=middle.next.next;
                middle.next.prev=middle;
            }else{
                middle.prev.next=middle.next;
                middle.next.prev=middle.prev;
                middle=middle.next;                 
            }            
        }
        count--;
        System.out.print("Middle element deleted: "+val+".....");
        return val;
    }
    void print(){
        if(isEmpty())
            return;
        
        Node cur=head;
        System.out.print("Stack: ");
        while(cur!=null){
            System.out.print(cur.val+"  ");
            cur=cur.next;
        }        
        System.out.println("middle="+(middle!=null?middle.val:null));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StackWithMiddleElementDeletion s=new StackWithMiddleElementDeletion();
        s.push(12);s.print();
        s.push(23);s.print();
        s.push(34);s.print();
        s.push(45);s.print();
        s.push(11);s.print();
        
        s.deleteMiddle();s.print();
        s.deleteMiddle();s.print();
        s.deleteMiddle();s.print();
        s.deleteMiddle();s.print();
        s.deleteMiddle();s.print();
        
        s.push(45);s.print();
        s.push(1);s.print();
        s.push(34);s.print();
        
    }
    
}
