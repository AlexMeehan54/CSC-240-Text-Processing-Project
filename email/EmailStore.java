package email;
import java.util.Arrays;
import java.util.List;

public class EmailStore {
    private String individualEmail;
    /* 
    -emails: List<String>
    +storeEmail(email String) : void
*/
    public EmailStore (String individualEmail){
        this.individualEmail = individualEmail; 

    }

    //Splits the big string by _ and returns each output. 
    public List<String> getSeparatedEmails() {
        return Arrays.asList(individualEmail.split(","));
    }
    @Override
    public String toString() {
        return individualEmail;
    }
}
    