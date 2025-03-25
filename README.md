# CSC-240-Text-Processing-Project

classDiagram
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