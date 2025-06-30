import java.io.*;
import java.util.*;

class Account implements Serializable {
    private String accountNumber;
    private String holderName;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with ₹" + initialDeposit + " on " + new Date());
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited ₹" + amount + " on " + new Date());
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn ₹" + amount + " on " + new Date());
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + holderName + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

public class BankAccountSimulation {
    private static final String FILE_NAME = "bank_data.ser";
    private static HashMap<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);
        Account currentAccount = null;

        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Create New Account");
            System.out.println("2. Select Existing Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Show Balance");
            System.out.println("6. Show Transaction History");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Account Number: ");
                    String accNum = scanner.nextLine();
                    if (accounts.containsKey(accNum)) {
                        System.out.println("Account already exists.");
                        break;
                    }
                    System.out.print("Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Initial Deposit: ₹");
                    double deposit = scanner.nextDouble();
                    scanner.nextLine();
                    currentAccount = new Account(accNum, name, deposit);
                    accounts.put(accNum, currentAccount);
                    saveData();
                    System.out.println("✅ Account created.");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String acc = scanner.nextLine();
                    if (accounts.containsKey(acc)) {
                        currentAccount = accounts.get(acc);
                        System.out.println("✅ Account selected.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    if (currentAccount != null) {
                        System.out.print("Enter deposit amount: ₹");
                        double dep = scanner.nextDouble();
                        currentAccount.deposit(dep);
                        saveData();
                    } else {
                        System.out.println("⚠ Select an account first.");
                    }
                    break;

                case 4:
                    if (currentAccount != null) {
                        System.out.print("Enter withdrawal amount: ₹");
                        double wd = scanner.nextDouble();
                        currentAccount.withdraw(wd);
                        saveData();
                    } else {
                        System.out.println("⚠ Select an account first.");
                    }
                    break;

                case 5:
                    if (currentAccount != null) {
                        currentAccount.showBalance();
                    } else {
                        System.out.println("⚠ Select an account first.");
                    }
                    break;

                case 6:
                    if (currentAccount != null) {
                        currentAccount.printTransactionHistory();
                    } else {
                        System.out.println("⚠ Select an account first.");
                    }
                    break;

                case 7:
                    System.out.println("👋 Thank you for using Java Bank. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }

    // Save accounts map to file
    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    // Load accounts map from file
    @SuppressWarnings("unchecked")
    private static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (HashMap<String, Account>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            accounts = new HashMap<>();
        }
    }
}