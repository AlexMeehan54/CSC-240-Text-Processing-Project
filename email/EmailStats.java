package email;
class EmailStats {

    int phrase_amount;
    int word_amount;
    int letter_amount;

    public EmailStats(int phrase_amount, int word_amount, int letter_amount){
        this.phrase_amount = phrase_amount;
        this.word_amount = word_amount;
        this.letter_amount = letter_amount;
    }
    
    public String toString() {
        return phrase_amount + word_amount + letter_amount;
    }

}