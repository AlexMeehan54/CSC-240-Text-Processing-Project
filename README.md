# CSC-240-Text-Processing-Project

1. How do you plan to read the .csv file and process the individual cells of data?
2. Which features do you plan to compute for each email?
phrase_amount //shows how amny times a specfic phrase shows up
word_amount //shows amount of words used in email
letter_amount //shows amount of letters used in email
a_count //CHANGE THESE!!
the_count //CHANGE THESE!!
is_count //CHANGE THESE!!
day_count //CHANGE THESE!!
3. How do you want to represent an email in code? Use a class? Just the features? Include the
whole raw text? Should the known class (spam/not spam) be part of the email? What if the class
(spam/not spam) isn’t known?
4. How do you plan to save the computed features and summaries? 
Save in a linkedlist
5. How do you plan to display the computed features and the summaries? 
Display as a GUI
6. What distance metric do you plan to use for distance between two emails? Euclidean distance?
Manhattan distance? Edit distance between features?
We will use Manhattan because it can represent counts
7. How will you compute distance from an email to the summary features?
?

UML:

```
UserEmailCSV

EmailStore{
    +storeEmail() : String
}

readCSVScanner{
    +parseFile(): void  
}

EmailProcessor{
    +processCsvStats() : String
}

EmailStats{
    phrase_amount : int 
    word_amount : int
    letter_amount : int
    a_count : int
    the_count : int
    is_count : int
    day_count : int

    +toString(): String
}
```
