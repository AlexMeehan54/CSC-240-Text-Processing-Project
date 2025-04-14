package email;
import java.util.ArrayList;

class EmailStats {

    int phrase_amount;
    int word_amount;
    int letter_amount;

    public EmailStats(int phrase_amount, int word_amount, int letter_amount){
        this.phrase_amount = phrase_amount;
        this.word_amount = word_amount;
        this.letter_amount = letter_amount;
    }

    public EmailStats(){
    }

    public int phrase_amount(EmailStore email){
        int count = 0;
        return count; 
    }
    
    public int word_amount(EmailStore email){
        int count = 0;
        return count;
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
       this.letter_amount = count;
        return count;
    }

    @Override
    public String toString() {
        return "\nphrase amount: " + phrase_amount + "\nword amount: " + word_amount + "\nAmount of Characters in Email: " + letter_amount;
    }
}