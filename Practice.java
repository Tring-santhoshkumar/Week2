class Account{
    private String name;
    private int accountNumber;
    private int accountBalance;
    public Account(String currentName,int currentAccountNumber){
        this.name = currentName;
        this.accountNumber = currentAccountNumber;
        this.accountBalance = 0;
    }
    public void withdraw(int amount){
        if(amount <= accountBalance){
            accountBalance = accountBalance - amount;
            System.out.println(accountBalance);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    public void deposit(int amount){
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
public class Practice {
    public static void main(String[] args) {
        Account person = new Account("Santhosh",123);
        person.deposit(20000);
        person.withdraw(6000);
        person.getInfo();
    }
}
