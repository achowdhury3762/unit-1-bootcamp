/**
 * Created by alexandraqin on 4/14/15.
 */
public class Variables {

  public static void main (String args[]) {
      System.out.println(greatestCommonFactor(1,1));
  }

  private static boolean isOdd(int number){
      return number%2!=0;
  }

  private static void printHelloWorld(){
      System.out.println("Hello World!");
  }

  private static int greatestCommonFactor(int firstNum, int secondNum){
      int smallerNumber = (firstNum < secondNum) ? firstNum:secondNum;
      int biggerNumber = (firstNum >= secondNum) ? firstNum:secondNum;
      for(int i=smallerNumber; i>0; i--){
          if (biggerNumber % i == 0)
              return i;
      }
      return 0;
  }
}
