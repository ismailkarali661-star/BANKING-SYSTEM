package banking.model;
/**
 * Represents a single banking transaction.
 */
import java.time.LocalDateTime;


public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
    // Returns transaction type (DEPOSIT / WITHDRAW)
    public String getType() {
        return type;
    }
    // Returns transaction amount
    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
