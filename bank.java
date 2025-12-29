import java.util.*;

class Account {
    String name;
    int accountNumber;
    double balance;

    Account(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Account\n2. Search Account\n3. Transfer Money\n4. Check Balance\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addAccount();
                case 2 -> searchAccount();
                case 3 -> transferMoney();
                case 4 -> checkBalance();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void addAccount() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        accounts.add(new Account(name, accNum, balance));
        System.out.println("Account added successfully!");
    }

    static void searchAccount() {
        System.out.print("Enter account number to search: ");
        int accNum = sc.nextInt();
        sc.nextLine();
        for (Account acc : accounts) {
            if (acc.accountNumber == accNum) {
                System.out.println("Name: " + acc.name + ", Balance: " + acc.balance);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    static void transferMoney() {
        System.out.print("Enter your account number: ");
        int fromAcc = sc.nextInt();
        System.out.print("Enter recipient account number: ");
        int toAcc = sc.nextInt();
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account sender = null, receiver = null;
        for (Account acc : accounts) {
            if (acc.accountNumber == fromAcc) sender = acc;
            if (acc.accountNumber == toAcc) receiver = acc;
        }

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number(s).");
        } else if (sender.balance < amount) {
            System.out.println("Insufficient balance.");
        } else {
            sender.balance -= amount;
            receiver.balance += amount;
            System.out.println("Transfer successful!");
        }
    }

    static void checkBalance() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        sc.nextLine();
        for (Account acc : accounts) {
            if (acc.accountNumber == accNum)
