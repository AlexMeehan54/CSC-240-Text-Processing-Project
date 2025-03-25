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

class readCSVScanner{



}

class email{

}
class phrase_amount{

}
class word_amount{

}
class letter_amount{

}
class a_count{

}
class the_count{
    
}
class is_count{
    
}
class day_count{
    
}



class Node {
          -left : Node
          -right : Node
          -op : Op
          +Node(op: Binop, left: Node, right: Node)
          +Node(op: Unop)
          +eval(values: double[]) double
}
      Op <|-- Binop
      Op <|-- Unop
      Unop <|-- Const
      Unop <|-- Variable
      Binop <|-- Plus
      Binop <|-- Minus
      Binop <|-- Divide
      Binop <|-- Mult
      class Const{
         -value : double
         +eval(values: double[]) double
         +toString() String
      }
      class Variable{
         -index : int
         +eval(values: double[]) double
         +toString() String
      }
      
      class Binop {
         +eval(left: double, right: double)* double
      }

      class Unop {
         +eval(values: double)* double
      }
      class Plus{
          +eval(left, right) double
          +toString() String
      }
      class Minus{
          +eval(left, right) double
          +toString() String
      }
      class Mult{
          +eval(left, right) double
          +toString() String
      }
      class Divide{
          +eval(left, right) double
          +toString() String
      }
      class TestAlgebra {
          +main(args: String[] )$
	  +randOperator(left: Node,right:Node)$ Node
	  +randConst()$ Node
	  +randVariable()$ Node
	  +randLeaf()$ Node
      }