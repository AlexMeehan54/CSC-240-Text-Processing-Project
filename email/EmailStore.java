package email;
import java.util.Arrays;
import java.util.List;

public class EmailStore {
    private String individualEmail; // The actual email content
    private boolean isSpam; // true = spam, false = ham

    // Constructor takes a CSV line with email and label (e.g., "This is an email,1")
    public EmailStore(String individualEmail) {
        this.individualEmail = individualEmail.trim();
        String[] parts = individualEmail.split(",", 2); // Split email content and label

        if (parts.length == 2) {
            this.isSpam = parts[1].trim().equals("1"); // "1" means spam, "0" means ham
        } else {
            this.isSpam = false; // Default to false (ham) if the line doesn't match the expected format
        }
    }

    // Getter for email text
    public String getEmailText() {
        return individualEmail.split(",", 2)[0].trim();
    }

    // Getter for spam label (true for spam, false for ham)
    public boolean isSpamLabel() {
        return isSpam;
    }

    // Method to separate emails when reading multiple emails in bulk
    public List<String> getSeparatedEmails() {
        return Arrays.asList(individualEmail.split(","));
    }

    @Override
    public String toString() {
        return individualEmail; // You can return the full email content if needed
    }
}
