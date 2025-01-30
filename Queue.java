import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int X){
        this.data = X;
        this.next = null;
    }
}
class QueueList{
    Node front;
    Node back;
    public QueueList(){
        this.front = null;
        this.back = null;
    }
    public void enqueue(int x){
        Node newNode = new Node(x);
        if(back == null){
            back = newNode;
            front = newNode;
        }
        else{
            back.next = newNode;
            back = newNode;
        }
    }
    public void dequeue(){
        if(front == null){
            System.out.println("Queue is Empty!");
        }
        else{
            front = front.next;
            if(front == null){
                back = null;
            }
        }
    }
    public void print(){
        Node temp = front;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Queue{
    public static void main(String[] args){
        QueueList queue = new QueueList();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            int var = sc.nextInt();
            queue.enqueue(var);
        }
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}