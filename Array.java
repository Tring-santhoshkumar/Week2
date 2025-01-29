import java.util.Scanner;
public class Array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        System.out.println("Enter array inputs : ");
        for(int i=0;i<N;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Element to be found is ");
        int X = sc.nextInt();
        sc.close();
        for(int i=0;i<a.length;i++){
            if(a[i] == X){
                System.out.println(X + " is found at index " + i);
                return;
            }
        }
        System.out.println(X + " is not found in the given array.");
    }
}