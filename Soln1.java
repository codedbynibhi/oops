import java.util.*;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    static int totalAccounts = 0;
    static String bankName = "Utkarsh Bank";

    BankAccount(String accountHolder, double balance) {
      this.accountHolder=accountHolder;
      this.balance =balance;
      accountNumber=totalAccounts+1;
      totalAccounts++;
    }

    void deposit(double amount) {
       balance = balance + amount;
    }

    void withdraw(double amount) {
       if(balance<=amount){
        balance=balance-amount;
       }
       else{
        System.out.println("Insufficient Balance");
       }
        
    }

    static int getTotalAccounts() {
        return totalAccounts;
        
    }

    void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("accountNumber: " +accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("balance: "+balance);
    }

    int getAccountNumber() {
       return accountNumber;
    }
}

public class Soln1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        BankAccount[] accounts = new BankAccount[n];
        for(int i =0;i<n;i++){
            String name =sc.next();
            double Balance = sc.nextDouble();
            accounts[i] = new BankAccount(name, Balance);
        }
        int transactions = sc.nextInt();
        for(int i = 0; i < transactions; i++) {
            int accountNo = sc.nextInt();
            String operation = sc.next();
            double amount = sc.nextDouble();

        for(int j = 0; j < accounts.length; j++) {
            if(accounts[j].getAccountNumber() == accountNo) {
            if(operation.equals("deposit")) {
                accounts[j].deposit(amount);
            }
            else if(operation.equals("withdraw")) {
                accounts[j].withdraw(amount);
            }
        }
    }
}
}
}