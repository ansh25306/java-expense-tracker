public class Expense {

    private int id;
    private String category;
    private double amount;
    private String description;
    private String date;

    public Expense(int id, String category, double amount,
                   String description, String date) {

        this.id = id;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void display() {
        System.out.println("-------------------------");
        System.out.println("ID          : " + id);
        System.out.println("Category    : " + category);
        System.out.println("Amount      : ₹" + amount);
        System.out.println("Description : " + description);
        System.out.println("Date        : " + date);
        System.out.println("-------------------------");
    }
}
