class InsufficientBalance extends Exception{
    public InsufficientBalance(String msg){
        super(msg);
    }
}
class Person{
    public String name;
    public int balance;
    public Person(String currName,int currBalance){
        this.name = currName;
        this.balance = currBalance;
    }
    public void calc(int amount) throws InsufficientBalance{
        if(amount > balance){
            throw new InsufficientBalance("Insufficient Balance in Account");
        }
        System.out.println("Balance after amount withdrawn is "+ (balance-amount));
    }
}
public class Temp2 {
    public static void main(String[] args) {
        Person newPerson = new Person("Santhosh",1000);
        try {
            newPerson.calc(10000);   
        } catch (InsufficientBalance e) {
            System.out.println(e.getMessage());
        }
    }
}
