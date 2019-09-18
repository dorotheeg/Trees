
import java.io.*;
import java.util.*;
import java.util.LinkedList;
public class ExpressionTree {
    
    
    MyStack<ExpressionNode> nodeStack = new MyStack<ExpressionNode>();
    boolean error = false;
        /* Your constructor should take in a string containing the postfix expression that you
         * are using to build your expression tree. */
        public ExpressionTree(String expression) {
            root = null;
             String token;
            ExpressionNode operands = null;
             //credit: found how to do this on website below
             //https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html
     String[] result = expression.split("\\s");
     for (int x=0; x<result.length; x++){
         token = result[x];
                if(!token.equals( "/") && !token.equals( "+") && 
                   !token.equals( "-") && !token.equals( "*") ){
                    operands = new ExpressionNode(token);
                  nodeStack.push(operands); 

                }
                else{
                    ExpressionNode right = nodeStack.pop();
                    ExpressionNode left = nodeStack.pop();
                    ExpressionNode operator = new ExpressionNode(token, left, right);
                    nodeStack.push(operator);
                   root = operator;
                }
                
            }
            if(!nodeStack.isEmpty()){
                nodeStack.pop();
            }
            else{
                System.out.println("Error in your expression, please remove an operand");
                error = true;
            }
            if(!nodeStack.isEmpty()){
                System.out.println("Error in your expression, please add an operator");
                error = true;
               
            } 
            
        }
    
 
       //   This is the PUBLIC interface to the class. 
         public int eval(){
            if(root == null || error == true)
           return 0;
       else
           return eval(root);   
         }
         private int eval(ExpressionNode t){
             int total = 0; 
            if(t == null){
              
                return total;
            }
             else if(t.element.equals("+")){
                 return ((eval(t.left)) + eval(t.right));
             }
             else if(t.element.equals("-")){
                 return ((eval(t.left)) - eval(t.right));
             }
             else if(t.element.equals("*")){
                 return ((eval(t.left)) * eval(t.right));
             }
             else if(t.element.equals("/")){
                 if(t.right.element.equals("0")){
                     System.out.println("Can't divide by a 0, " +
                                       "the evaluation cannot be completed," +
                                       "will output 0");
                     return 0;
                 }
                 else{   
                  return ((eval(t.left)) / eval(t.right));   
                 }
             }  
       else 
            total = Integer.parseInt(t.element);
           return total;
       
    }
          
    
         public String postfix() {
            if(root == null || error == true)
           return "Please fix";
       else
             return postfix(root);   
        }
    
        private String postfix(ExpressionNode t){
            //only operators have children
            //when gets to an int print it out
            String left = "";
            String right = "";
            String s = " ";
            if(!t.element.equals( "/") && !t.element.equals( "+") && 
                   !t.element.equals( "-") && !t.element.equals( "*") ){
                return s + t.element;
            }
            else{
               left = postfix(t.left);
               right = postfix(t.right);
                return left +s+ right+ s + t.element;
            }
        }
    
    
        public String prefix() {
            if(root == null || error == true)
           return "Please fix";
       else
            return prefix(root);  
        }
    
        private String prefix(ExpressionNode t){
            String left = "";
            String right = "";
            String s = " ";
           if(!t.element.equals( "/") && !t.element.equals( "+") && 
                   !t.element.equals( "-") && !t.element.equals( "*") ){
                return s + t.element;
            } 
            else{
               left = postfix(t.left);
               right = postfix(t.right);
                return t.element +s+ left+ s + right;
            }
        }

       public String infix() {
           if(root == null || error == true)
           return "Please fix";
       else
            return infix(root);    
        } 
     private String infix(ExpressionNode t){
            String left = "";
            String right = "";
            String s = " ";
           if(!t.element.equals( "/") && !t.element.equals( "+") && 
                   !t.element.equals( "-") && !t.element.equals( "*") ){
                return s + "(" + t.element + ")";
            } 
            else{
               left = infix(t.left);
               right = infix(t.right);
                return "(" + left +s+
                     t.element  +s+ right + ")" ;
            }
        }
        

    
      public static class ExpressionNode{
            // Constructors
     
          ExpressionNode( String theElement )
        {
            this( theElement, null, null );
        }

        ExpressionNode( String theElement, ExpressionNode lt, ExpressionNode rt )
            
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        String element;            // The data in the node
        ExpressionNode left;   // Left child
        ExpressionNode right;  // Right child
    } 
    private ExpressionNode root;
}

