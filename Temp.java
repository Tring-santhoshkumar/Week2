class Person{
    public String name;
    public int age;
    public Person(String currentName,int currentAge){
        this.name = currentName;
        this.age = currentAge;
    }
    public void voting() {
        try {
            if (age < 18) {
                throw new Exception("Minimum Eligible Age to Vote is 18 or above!");
            } else {
                System.out.println(name + " is Eligible to Vote!!!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
public class Temp{
    public static void main(String[] args) {
        Person p1 = new Person("Santhosh",9);
        p1.voting();
    }
}