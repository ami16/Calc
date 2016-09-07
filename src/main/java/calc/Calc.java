package calc;

import java.util.Scanner;

public class Calc {

//   public Calc(){ }

   private static char operation ;
   private static double totalResult = 0 ;


   public void run(){

      CalcFunc func = new CalcFunc() ;
      System.out.println("Hello, I'm Simp-reCalc");
      Scanner scan = new Scanner(System.in) ;


      System.out.println("Please enter your value or hit 'x' for EXIT");

      while (true){
         String firstArg = scan.nextLine() ;
         if( firstArg.equalsIgnoreCase("x") ){
            func.sayBye(); break;
         }

         // 1st arg
         if( !isNum(firstArg) ){
            System.out.println("Invalid value! Enter smth like value...");
            continue ;
         }


         // get desired operation
         System.out.println("Please enter desired operation (+, -, *, / ). Or 'x' for EXIT");
         boolean validOperation = false ;
         String userOperation ;

         do{
            userOperation = scan.nextLine() ;

            if (!isOperation( userOperation ) ){
               System.out.println("Invalid operation! Enter operation & hit enter.");
               validOperation = false ;
            } else {
               validOperation = true ;
               operation = userOperation.toCharArray()[0] ;
            }

         } while (!validOperation) ;

         System.out.println(firstArg + operation);


         System.out.println("Please enter second argument OR OTHER operation");
         boolean validArg = false ;
         do {
            // 2nd arg
            String secondArg = scan.nextLine() ;

            if( isOperation(secondArg) ){
               operation = secondArg.toCharArray()[0] ;
               System.out.println("Please enter second argument OR OTHER operation");
            }
            else if( !isNum(secondArg) && !isOperation(secondArg) ){
               System.out.println("Invalid input. Try one more time...");
               validArg = false ;
            }
            else {
               validArg = true;
               System.out.println( "Calculating..." );
               System.out.print( func.drawExpression(operation, Double.parseDouble(firstArg), Double.parseDouble(secondArg)) );
               System.out.println( totalResult = getResult( Double.parseDouble(firstArg), Double.parseDouble(secondArg), operation) );
               System.out.println("\nPlease enter your value or hit 'x' for EXIT");
            }
         } while ( !validArg );

      }
   } //run



   private boolean isNum(String arg) {
      try{
         Double.parseDouble(arg) ;
      } catch( NumberFormatException e ){
         return false;
      }
      return true;
   }

   private boolean isOperation(String userReply ){
      boolean is = false ;
      switch (userReply){
         case "+" :
         case "-" :
         case "/" :
         case "*":
            is = true ;
            break ;
      }
      return is;
   }

   private double getResult(double arg1, double arg2, char operation){
      double result = 0 ;
      switch(operation){
         case '+' : result = arg1 + arg2; break;
         case '-' : result = arg1 - arg2; break;
         case '*' : result = arg1 * arg2; break;
         case '/' : result = arg1 / arg2; break;
      }
      return result;
   }
}