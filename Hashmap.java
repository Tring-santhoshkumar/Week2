
import java.util.HashMap;
import java.util.Scanner;

public class Hashmap{
    public static void main(String[] args){
        HashMap<String, Integer> person = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            String name = sc.next();
            int age = sc.nextInt();
            person.put(name,age);
        }
        System.out.println("Value of the key 'Santhosh' is "+ person.get("Santhosh"));
        System.out.println("Value of the key 'SS' is "+ person.get("SS"));
        System.out.println(person.containsKey("Santhosh"));
        person.remove("Kumar");
        for(String key:person.keySet()){
            System.out.println("Key : "+key+",Value : "+person.get(key));
        }
    }
}