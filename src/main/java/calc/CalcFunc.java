package calc;

public class CalcFunc {
   public CalcFunc() {
   }

   protected void showMenu() {
      System.out.println("Please chose your operation: "
          + "\n1: Multiply \n2: Divide \n3: The difference (-) \n4: SUM \n5: Num to power (^) \n6: Sin \n7: Cos \n8: tg \nq: EXIT —>");
   }

   protected void sayBye() {
      System.out.println("Bye! Thx for using me.");
   }

   protected String drawExpression(char operation, Double arg1, Double arg2 ) {
      String expression = null ;
      switch (operation){
         case '*': expression = arg1 + " x " + arg2 + " = "; break;
         case '/': expression = arg1 + " / " + arg2 + " = "; break;
         case '-': expression = arg1 + " - " + arg2 + " = "; break;
         case '+': expression = arg1 + " + " + arg2 + " = "; break;
      }
      return expression;
   }
}