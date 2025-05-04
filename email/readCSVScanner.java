package email;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class readCSVScanner {
    public static void main (String[] args){
        readCSVScanner read = new readCSVScanner();
        read.getEmailListFromCSV("./csv/spam_or_not_spam.csv");

        System.out.println(read.getTrainingEmailStatsFromArray(read.emailList));
        System.out.println(read.getTestingEmailStatsFromArray(read.emailList));
        
    }
    public ArrayList<EmailStore> emailList = new ArrayList<>(); //email in list

    public ArrayList<EmailStore> getEmailListFromCSV(String filePath){
        //String[] myArray = myStr.split(delimeter);
    
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder builder = new StringBuilder();

            //Turns the CSV into a big string. We use builder because buffering each line is faster then just adding it with +
            String line = null;
            reader.readLine();
            while ((line = reader.readLine()) != null){
                builder.append(line).append("\n");
            }

            //takes the big string we just made with builder and sends it to Email store. 
            EmailStore allEmails = new EmailStore(builder.toString());
            for (String email : allEmails.getSeparatedEmails()) {
                emailList.add(new EmailStore(email));
            }
        }
        
        catch (IOException e) {
            System.out.println("File not found");
        }
        Collections.shuffle(emailList); //shuffles csv
        return emailList;
    }

    public LinkedList<EmailStats> getTrainingEmailStatsFromArray(ArrayList<EmailStore> emailList){
        LinkedList<EmailStats> testingEmails = new LinkedList<>();
        //int i = 0;
    
        for (int i = 0; i<2600; i++) { //testing class
            EmailStats EmSt = new EmailStats();
        
            EmSt.which_email(i);
            EmSt.phrase_amount(emailList.get(i));
            EmSt.word_amount(emailList.get(i));
            EmSt.letter_amount(emailList.get(i));
            EmSt.spam(emailList.get(i));

            testingEmails.add(EmSt);
            //i++;
          
        }
        return testingEmails;
    }

    public LinkedList<EmailStats> getTestingEmailStatsFromArray(ArrayList<EmailStore> emailList){
        LinkedList<EmailStats> testStats = new LinkedList<>();
    
        for (int i = 2600; i < 3000; i++) { // <- TESTING SET: 400 emails
            EmailStats EmSt = new EmailStats();
    
            EmSt.which_email(i);
            EmSt.phrase_amount(emailList.get(i));
            EmSt.word_amount(emailList.get(i));
            EmSt.letter_amount(emailList.get(i));
            EmSt.spam(emailList.get(i));
    
            testStats.add(EmSt);
        }
    
        return testStats;
    }
/* 
    readCSVScanner{
        +parseFile(): void  
        +getEmailFromCSV(filepath : string)
    }
        */
}
