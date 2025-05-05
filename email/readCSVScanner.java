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
     
        read.getTrainingEmailStatsFromArray(read.emailList);
        
        read.getTestingEmailStatsFromArray(read.emailList);
        System.out.println();
        
    }
    public ArrayList<EmailStore> emailList = new ArrayList<>(); //email in list
    public LinkedList<Integer> spamList = new LinkedList<>();
    public LinkedList<Integer> hamList = new LinkedList<>();

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
        LinkedList<EmailStats> testingEmails = new LinkedList<>();// <- Trainging SET: 2600 emails
        //int i = 0;
      
        for (int i = 0; i<2600; i++) { //testing class
            EmailStats EmSt = new EmailStats();

            Boolean isSpam = EmSt.spam(emailList.get(i));
            int spamCount = EmSt.spam_Amount(emailList.get(i));

          if (!isSpam) { 
            hamList.add(spamCount); 
          } else {
            spamList.add(spamCount);
          }
            //testingEmails.add(EmSt);
        }
        
        EmailStats EmailStats = new EmailStats();
        double spamAverage = EmailStats.getAverage(spamList);
        double hamAverage = EmailStats.getAverage(hamList);

        //System.out.println(spamList);
        //System.out.println(hamList);

        System.out.println("Average spam word count (spam emails): " + spamAverage);
        System.out.println("Average ham word count (ham emails): " + hamAverage);
        return testingEmails;
    }

    public LinkedList<EmailStats> getTestingEmailStatsFromArray(ArrayList<EmailStore> emailList){
        LinkedList<EmailStats> testStats = new LinkedList<>();
    
    int correctPredictions = 0;
    int total = 0;

        for (int i = 2600; i < 3000; i++) { // TESTING SET
            EmailStats EmSt = new EmailStats();
            EmailStore email = emailList.get(i);
    
            boolean predictedSpam = EmSt.spam(email);     // Your classifier
            boolean actualSpam = email.isSpamLabel();     // You must have this method in EmailStore
    
            if (predictedSpam == actualSpam) {
                correctPredictions++;
            }
    
            total++;
            testStats.add(EmSt);
        }
    
        double accuracy = (double) correctPredictions / total;
        System.out.println("Testing Set Accuracy: " + (accuracy * 100) + "%");
    
        return testStats;
    }
/* 
    readCSVScanner{
        +parseFile(): void  
        +getEmailFromCSV(filepath : string)
    }
        */
}
