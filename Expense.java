import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static int idCounter = 1;
    static double monthlyBudget = 0;

    public static void main(String[] args) {

        while (true) {

            System.out.println();
            System.out.println("===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Search by Category");
            System.out.println("5. Category-wise Summary");
            System.out.println("6. Monthly Expense");
            System.out.println("7. Set Monthly Budget");
            System.out.println("8. Budget Status");
            System.out.println("9. Delete Expense");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    calculateTotal();
                    break;

                case 4:
                    searchCategory();
                    break;

                case 5:
                    categorySummary();
                    break;

                case 6:
                    monthlyExpense();
                    break;

                case 7:
                    setBudget();
                    break;

                case 8:
                    budgetStatus();
                    break;

                case 9:
                    deleteExpense();
                    break;

                case 10:
                    System.out.println("Thank you for using Expense Tracker.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addExpense() {

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        double amount;

        while (true) {
            System.out.print("Enter amount: ");

            try {
                amount = sc.nextDouble();
                sc.nextLine();

                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0.");
                    continue;
                }

                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid amount.");
                sc.nextLine();
            }
        }

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = sc.nextLine();

        Expense expense = new Expense(
                idCounter,
                category,
                amount,
                description,
                date
        );

        expenses.add(expense);
        idCounter++;

        System.out.println("Expense added successfully.");
    }

    static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println();
        System.out.println("===== ALL EXPENSES =====");

        for (Expense expense : expenses) {
            expense.display();
        }
    }

    static void calculateTotal() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        System.out.println("Total Expenses: ₹" + total);
    }

    static void searchCategory() {

        System.out.print("Enter category to search: ");
        String category = sc.nextLine();

        boolean found = false;

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                expense.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    static void categorySummary() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }

        ArrayList<String> categories = new ArrayList<>();

        for (Expense expense : expenses) {

            String category = expense.getCategory();

            if (!categories.contains(category)) {
                categories.add(category);
            }
        }

        System.out.println();
        System.out.println("===== CATEGORY SUMMARY =====");

        for (String category : categories) {

            double total = 0;

            for (Expense expense : expenses) {

                if (expense.getCategory().equalsIgnoreCase(category)) {
                    total += expense.getAmount();
                }
            }

            System.out.println(category + ": ₹" + total);
        }
    }

    static void monthlyExpense() {

        System.out.print("Enter month (MM-YYYY): ");
        String month = sc.nextLine();

        double total = 0;

        for (Expense expense : expenses) {

            String date = expense.getDate();

            if (date.endsWith(month)) {
                total += expense.getAmount();
            }
        }

        System.out.println(
                "Total expenses for " + month + ": ₹" + total
        );
    }

    static void setBudget() {

        while (true) {

            System.out.print("Enter monthly budget: ");

            try {

                monthlyBudget = sc.nextDouble();
                sc.nextLine();

                if (monthlyBudget <= 0) {
                    System.out.println(
                            "Budget must be greater than 0."
                    );
                    continue;
                }

                break;

            } catch (Exception e) {

                System.out.println(
                        "Please enter a valid amount."
                );

                sc.nextLine();
            }
        }

        System.out.println(
                "Monthly budget set to ₹" + monthlyBudget
        );
    }

    static void budgetStatus() {

        if (monthlyBudget == 0) {

            System.out.println(
                    "Please set a monthly budget first."
            );

            return;
        }

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        double remaining = monthlyBudget - total;

        System.out.println();
        System.out.println("===== BUDGET STATUS =====");
        System.out.println("Monthly Budget : ₹" + monthlyBudget);
        System.out.println("Total Expenses : ₹" + total);
        System.out.println("Remaining      : ₹" + remaining);

        if (total > monthlyBudget) {

            System.out.println(
                    "You have exceeded your budget."
            );

        } else {

            System.out.println(
                    "You are within your budget."
            );
        }
    }

    static void deleteExpense() {

        if (expenses.isEmpty()) {

            System.out.println("No expenses to delete.");
            return;
        }

        System.out.print("Enter expense ID to delete: ");

        int id;

        try {

            id = sc.nextInt();
            sc.nextLine();

        } catch (Exception e) {

            System.out.println("Invalid ID.");
            sc.nextLine();
            return;
        }

        boolean found = false;

        for (int i = 0; i < expenses.size(); i++) {

            if (expenses.get(i).getId() == id) {

                expenses.remove(i);

                System.out.println(
                        "Expense deleted successfully."
                );

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Expense ID not found.");
        }
    }
}
