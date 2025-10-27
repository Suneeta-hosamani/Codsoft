import java.util.Scanner;

// Class representing the user's Bank Account
class BankAccount {
    private double balance;

    // Constructor to initialize account with a balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited: " + amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("✅ Successfully withdrawn: " + amount);
        }
    }

    // Check balance method
    public double checkBalance() {
        return balance;
    }
}

// Class representing the ATM machine
public class ATMInterface {
    public static void main(String[] args) {

        // Use try-with-resources for safe scanner handling
        try (Scanner sc = new Scanner(System.in)) {

            // Create a user account with an initial balance
            BankAccount userAccount = new BankAccount(10000.0); // ₹10,000 initial balance
            int choice;

            // ATM Menu Loop
            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                // ✅ Using rule-based switch (Java 17+)
                switch (choice) {
                    case 1 -> System.out.println("💰 Current Balance: " + userAccount.checkBalance());

                    case 2 -> {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        userAccount.deposit(depositAmount);
                    }

                    case 3 -> {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        userAccount.withdraw(withdrawAmount);
                    }

                    case 4 -> System.out.println("👋 Thank you for using our ATM. Goodbye!");

                    default -> System.out.println("❌ Invalid choice! Please try again.");
                }

            } while (choice != 4);
        }
    }
}
