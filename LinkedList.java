import java.util.Scanner;
public class LinkedList{
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int x){
            this.data = x;
            this.next = null;
        }
    }
    public static LinkedList insert(LinkedList list,int x){
        Node newNode = new Node(x);
        if(list.head == null){
            list.head = newNode;
        }
        else{
            Node temp = list.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return list;
    }
    public static LinkedList reverse(LinkedList list){
        Node temp = list.head,prev = null,nextNode;
        while(temp != null){
            nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        list.head = prev;
        return list;
    }
    public static void print(LinkedList list){
        Node temp = list.head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            int var = sc.nextInt();
            list = insert(list,var);
        }
        sc.close();
        print(list);
        list = reverse(list);
        print(list);
    }
}