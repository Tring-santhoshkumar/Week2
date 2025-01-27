interface payment{
    void pay(double amount);
    void bal(double amount,double balance);
    void refund(double amount,double price);
}
class Account{
    private String name;
    private int accountNumber;
    private double accountBalance;
    public Account(String currentName,int currentAccountNumber){
        this.name = currentName;
        this.accountNumber = currentAccountNumber;
        this.accountBalance = 0;
    }
    public void withdraw(double amount){
        if(amount <= accountBalance){
            accountBalance = accountBalance - amount;
            System.out.println(accountBalance);
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
class Mode implements payment{
    @Override
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
public class Practice {
    public static void main(String[] args) {
        Account person = new Account("Santhosh",123);
        Mode p1 = new Mode();
        p1.pay(1000);
        p1.bal(1000,2500.26);
        p1.refund(1000,900);
        person.deposit(20000);
        person.withdraw(6000.56);
        person.getInfo();
    }
}
