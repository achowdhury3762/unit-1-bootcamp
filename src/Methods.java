import java.util.Random;

/**
 * Created by alexandraqin on 4/14/15.
 */
public class Methods {

  public static void main (String args[]) {
    for (int i = 0; i < 100; i++) {
      System.out.println(random(2, 6));
    }
  }

  private static int calculateSquare(int number){
    return number*number;
  }

  private static double calculateSquareRoot(double number){
    return Math.sqrt(number);
  }

  private static String toLowerCase(String input){
    return input.toLowerCase();
  }

  private static boolean isMultiple(int firstNum, int secondNum){
    return secondNum%firstNum==0;
  }

  private static void prettyInteger(int number){
    for (int i = 0; i < number; i++) {
      System.out.print("*");
    }
    System.out.print(" " + number + " ");
    for (int i = 0; i < number; i++) {
      System.out.print("*");
    }
  }

  private static int random(int min, int max){
    Random random = new Random();
    return random.nextInt(max-min-1) + min+1;

  }
}
