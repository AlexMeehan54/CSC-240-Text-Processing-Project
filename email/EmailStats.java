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
}