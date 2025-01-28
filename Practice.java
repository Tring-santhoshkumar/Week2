interface payment{
    void pay(double amount);
    void bal(double amount,double balance);                            //interface
    void refund(double amount,double price);
}
abstract class Calc{
    abstract double calcinterest();                                    //Abstract Class
}
class Account{
    private String name;
    private int accountNumber;
    private double accountBalance;
    public Account(String currentName,int currentAccountNumber){
        this.name = currentName;                                       //Paramaterised Constructor
        this.accountNumber = currentAccountNumber;
        this.accountBalance = 0;
    }
    public void withdraw(double amount){
        if(amount <= accountBalance){
            accountBalance = accountBalance - amount;
            System.out.println(accountBalance);                        //Method Functions
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    public void deposit(double amount){
        accountBalance = accountBalance + amount;
        System.out.println(accountBalance);
    }
    public void getInfo(){
        System.out.println("Account Holder : "+ name);
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Account Balance: "+accountBalance);
    }

    public String getName() {
        return name;                                                    //getter
    }

    public void setName(String name) {                                  //setter
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
class Mode implements payment{                                         //Class using implements for interface
    @Override                                                          //Overriding functions
    public void pay(double amount){
        System.out.println(amount+" is paid!");
    }
    @Override
    public void bal(double amount,double balance){
        System.out.println(balance - amount+" is balance!");
    }
    @Override
    public void refund(double amount,double price){
        System.out.println(amount - price+" is refunded!");
    }
}
class Interest extends Calc{                                           //Class using extends for creating a subClass
    public double amount;
    public double intPercent;
    public Interest(double currAmount,double currInterestPercent){
        this.amount = currAmount;
        this.intPercent = currInterestPercent;
    }
    @Override                                                           //Abstract Class method Override
    double calcinterest(){
        return amount*(intPercent/100);
    }
}
public class Practice {                                                 //Main class
    public static void main(String[] args) {
        Account person = new Account("Santhosh Kumar",123);
        Mode p1 = new Mode();
        p1.pay(1000);
        p1.bal(1000,2500.26);
        p1.refund(1000,900);
        Calc p2 = new Interest(20000,10);
        System.out.println("Interest amount is  "+p2.calcinterest());
        person.deposit(20000);
        person.withdraw(6000.56);
        person.getInfo();
    }
}