package email;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class readCSVScanner {
    public static void main (String[] args){
        readCSVScanner read = new readCSVScanner();
        System.out.println(read.getEmailListFromCSV("./csv/UserEmail.csv"));
    }
    public LinkedList<EmailStats> getEmailListFromCSV(String filePath) {
        LinkedList<EmailStats> emailList = new LinkedList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            
            String line = null;
            reader.readLine();
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

            if ((line = reader.readLine()) == null){

            }
            
           

        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        return emailList;
    }
    }


/* 
    readCSVScanner{
        +parseFile(): void  
        +getEmailFromCSV(filepath : string)
    }
        */

