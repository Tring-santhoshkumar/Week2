import java.util.Scanner;

public class Stack{
    static class Node{
        int data;
        Node next;
        Node(int X){
            this.data = X;
            this.next = null;
        }
    }
    Node top;
    public Stack(){
        top = null;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public void push(int d){
        Node newNode = new Node(d);
        newNode.next = top;
        top = newNode;
    }
    public void pop(){
        try {
            if(isEmpty()){
                throw new NullPointerException("Stack is Empty!"); 
            }
        } catch (NullPointerException e) {
            System.out.println("Error, " + e.getMessage());
            return;
        }
        top = top.next;
    }
    public void print(){
        try {
            if(isEmpty()){
                throw new NullPointerException("Stack is Empty!"); 
            }
        } catch (NullPointerException e) {
            System.out.println("Error, " + e.getMessage());
            return;
        }
        Node temp = top;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Stack stackList = new Stack();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            int var = sc.nextInt();
            stackList.push(var);
        }
        sc.close();
        stackList.print();
        stackList.pop();
        stackList.pop();
        stackList.print();
    }
}