package email;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class EmailStats {
    Boolean spam;
    int spam_Amount;
    double getAverage; 
  

    //FIND DUPLICATE EMAILS
    String SpamWords[] = {"click" , "free" , "top" , "sell" , "hyperlink", "porn", "access", "sign", "subscribe", "subscription", "insurance", "offer", "lucky", "member", "register", "deal"};

    public EmailStats(Boolean spam, int spam_Amount, double getAverage){
        this.spam = false;
        this.spam_Amount = spam_Amount;
        this.getAverage = getAverage; 
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

    public int spam_Amount(EmailStore email){
        int totalSpamCount = 0;
        String convert = email.toString().toLowerCase();
        
        for (int i = 0; i < SpamWords.length; i++){
            String[] words = convert.split(SpamWords[i]);
            totalSpamCount = totalSpamCount + (words.length - 1);
        }
        this.spam_Amount = totalSpamCount;
        return totalSpamCount;

    }

    public double getAverage(LinkedList<Integer>count){
        int sum = 0;
        for (int value : count){
            sum += value;
        }
      
        this.getAverage = sum;
        this.getAverage = (double) sum / count.size();
        return this.getAverage;
    }
 
/* 
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
        */
/* 
    @Override
    public String toString() {
         return "\nEmail number " + which_email + "\namount of times the word 'me' was used: " + phrase_amount + "\nword amount: " + word_amount + "\nAmount of Characters in Email: " + letter_amount + "\nIs spam: "  + spam + "\n";
    }
    */

   
}