package email;
import java.util.ArrayList;
import java.util.Arrays;

class EmailStats {
    int which_email;
    int phrase_amount;
    int word_amount;
    int letter_amount;
    Boolean spam;
  

    //FIND DUPLICATE EMAILS
    String SpamWords[] = {"click" , "free" , "top" , "sell" , "hyperlink", "porn", "access", "sign", "subscribe", "subscription", "insurance", "offer", "lucky", "member", "register", "deal"};

    public EmailStats(int which_email, int phrase_amount, int word_amount, int letter_amount, Boolean spam){
        this.which_email = which_email;
        this.phrase_amount = phrase_amount;
        this.word_amount = word_amount;
        this.letter_amount = letter_amount;
        this.spam = false;
    }

    public EmailStats(){
    }
    
    public Boolean spam (EmailStore email){
        int totalSpamCount = 0;
        String convert = email.toString().toLowerCase();
        
        for (int i = 0; i < SpamWords.length; i++){
            //int notFound = convert.indexOf(SpamWords[i]);
            String[] words = convert.split(SpamWords[i]);
            //System.out.println(notFound);
            /* 
            if (notFound != -1){ //not negative 1 
                this.spam = true;
                return true;
            }
            */
            totalSpamCount = totalSpamCount + (words.length - 1);
        }
        //System.out.println(totalSpamCount);
        if (totalSpamCount>5){
            this.spam = true;
            return true;
        } else {
            this.spam = false; //updates
            return false;
        }
    }
 

    public int which_email(int email){
        int emailCount = email + 1;
        this.which_email = emailCount;
        return emailCount;
    }
    
    public int phrase_amount(EmailStore email){
        String convert = email.toString();
        String[] words = convert.split(" me ");
        //System.out.println(words.length);
        this.phrase_amount = words.length - 1; //updates the count, -1 because it adds an extra one
        return words.length;
    }
    
    public int word_amount(EmailStore email){
        String convert = email.toString();
        String[] words = convert.split(" ");
        //System.out.println(words.length);
        this.word_amount = words.length; //updates the word length
        return words.length;
    }

    public int letter_amount(EmailStore email){
        int count = 0;

        String convert = email.toString();
        //System.out.println(convert);
        for (int i = 0; i < convert.length(); i++){
            if (convert.charAt(i) != ' '){
                count++;
            }
        }
       //System.out.println(count);
       this.letter_amount = count; //updates the letter amount
        return count;
    }

    @Override
    public String toString() {
        return "\nEmail number " + which_email + "\namount of times the word 'me' was used: " + phrase_amount + "\nword amount: " + word_amount + "\nAmount of Characters in Email: " + letter_amount + "\nIs spam: "  + spam + "\n";
    }
    
}