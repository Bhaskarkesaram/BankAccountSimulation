# 🏦 Java Bank Account Simulation

This project is a command-line Java application that simulates real-world banking operations using Object-Oriented Programming (OOP). It supports multiple accounts, transaction tracking, and data persistence through file serialization.

---

## 🚀 Features

- ✅ Create new bank accounts with initial deposits
- ✅ Select and operate on existing accounts
- ✅ Deposit and withdraw funds securely
- ✅ View real-time balance for the selected account
- ✅ Access full transaction history with timestamps
- ✅ Save and load all accounts using Java Serialization (`bank_data.ser`)

---

## 🛠️ Technologies Used

- Java (OOP, Serialization)
- Terminal / Command Prompt
- VS Code / IntelliJ IDEA / Any Java IDE

---

## 📂 File Structure

```plaintext
BankAccountSimulation.java   // Main Java source file
bank_data.ser                // (Auto-generated) Serialized account data
README.md                    // This documentation file
```

## 🔧 How to Run

## Compile the program:
```
javac BankAccountSimulation.java
```

## Run the program:
```
java BankAccountSimulation
```
## 🖥️ Sample Output

=== Bank Menu ===
1. Create New Account
2. Select Existing Account
3. Deposit
4. Withdraw
5. Show Balance
6. Show Transaction History
7. Exit
   
Choose: 1

Account Number: 1001

Holder Name: Bhaskar

Initial Deposit: ₹5000

✅ Account created.

Choose: 3

Enter deposit amount: ₹2000

₹2000.0 deposited successfully.

Choose: 5

Current Balance: ₹7000.0

## 💾 Data Persistence

The application stores all accounts and their transaction histories in a file named "bank_data.ser". This means that your data is saved and available even after the program closes.

## 🎯 Learning Outcomes

-- Demonstrates real-world banking system simulation

-- Implements Object-Oriented Design principles: encapsulation, modularity, and reusability

-- Introduces Java file handling and serialization

-- Models multi-user interactions and session switching

## 👨‍💻 Author

Bhaskar Kesaram

Developed as part of OOP Simulation Tasks.

