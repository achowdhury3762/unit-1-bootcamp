import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandraqin on 4/14/15.
 */
public class Loops {

    public static void main(String args[]) {
//        System.out.println(sum("XY123XY", "XY"));
        allPositiveNumbersSum();
    }

    public static void print1to10() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public static void printOnetoTen() {
        int i = 0;
        while (++i < 11) {
            System.out.println(i);
        }
    }

    public static void printOneToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void printEventoN(int n) {
        for (int i = 2; i <= n; i += 2) {
            System.out.println(i);
        }
    }

    public static void printSumOf10() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void printSumOfConsecutive(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void repeatString(int n, String s) {
        String word = s;
        if (n < 0) {
            System.out.print("\"\"");
        }
        for (int i = 0; i < n; i++) {
            s += word;
        }
        System.out.println(s);
    }

    private static void sumFirstTenFibonacci(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fibonacci(i);
        }
        System.out.println(sum);
    }

    private static int fibonacci(int i) {
        if (i == 1 || i == 0 || i == 2)
            return 1;
        else
            return fibonacci(i - 1) + fibonacci(i - 2);
    }

    private static int sumNumbers(String randomString) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < randomString.length(); i++) {
            if (Character.isDigit(randomString.charAt(i))) {
                int numberStartIndex = i;
                int numberEndIndexPlusOne = randomString.length();
                for (int j = i + 1; j < randomString.length(); j++) {
                    if (!Character.isDigit(randomString.charAt(j))) {
                        numberEndIndexPlusOne = j;
                        i = j;
                        break;
                    }
                }
                int number = Integer.parseInt(
                        randomString.substring(numberStartIndex, numberEndIndexPlusOne)
                );
                numberList.add(number);
                if (numberEndIndexPlusOne == randomString.length()) {
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < numberList.size(); i++) {
            sum += numberList.get(i);
        }
        return sum;
    }

    private static String notReplace(String input) {
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == 'i' && sb.charAt(i + 1) == 's') {
                if (!precededByLetter(sb.toString(), i) && !followedByLetter(sb.toString(), i + 1)) {
                    sb.replace(i, i + 2, "is not");
                }
            }
        }
        return sb.toString();
    }


    private static boolean precededByLetter(String input, int index) {
        if (index == 0)
            return false;
        Character precedingChar = input.charAt(index - 1);
        if (Character.isLetter(precedingChar)) {
            return true;
        }
        return false;
    }

    private static boolean followedByLetter(String input, int index) {
        if (index == input.length() - 1)
            return false;
        Character followingChar = input.charAt(index + 1);
        if (Character.isLetter(followingChar))
            return true;
        return false;
    }

    private static boolean followedByCharacter(String input, int index) {
        if (index == input.length() - 1) {
            return false;
        }
        return true;
    }

    private static boolean precededByCharacter(String input, int index) {
        if (index == 0)
            return false;
        return true;
    }

    private static String wordEnds(String input, String letters) {
        String output = "";
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            int letterStart = sb.indexOf(letters);
            if (letterStart != -1) {
                if (precededByCharacter(sb.toString(), letterStart))
                    output += sb.charAt(letterStart - 1);
                if (followedByCharacter(sb.toString(), letterStart + letters.length() - 1))
                    output += sb.charAt(letterStart + letters.length());
                sb.delete(letterStart, letterStart + letters.length());
            }
        }
        return output;
    }

    private static void sum80Difference14() {
        for (int i = 0; i <= 40; i++) {
            for (int j = 41; j <= 80; j++) {
                if (j + i == 80 && j - i == 14) {
                    System.out.println(j + " " + i);
                }
            }
        }
    }

    private static void allPositiveNumbersSum() {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + "" + j + "," + " " + i + "+" + j + " = " + i + j);
            }
        }
    }
}
