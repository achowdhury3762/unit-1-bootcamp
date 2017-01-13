/**
 * Created by alexandraqin on 4/14/15.
 */
public class Conditionals {

    public static void main(String args[]) {
        System.out.println(evenlySpaced(17,108,199));
    }

    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    private static boolean isMultipleOfThree(int n) {
        return n % 3 == 0;
    }

    private static boolean isOddAndIsMultipleOfThree(int n) {
        return isOdd(n) && isMultipleOfThree(n);
    }

    private static boolean isOddAndIsMultipleOfThree2(int n) {
        return n % 2 == 0 && n % 3 == 0;
    }

    private static void fizzMultipleofThree(int n) {
        if (n % 3 == 0)
            System.out.println("Fizz");
        else
            System.out.println(n);
    }

    private static boolean personFromLondon(Person person) {
        return person.getCity().toLowerCase().equals("london");
    }

    private static void printLongName(Person person) {
        if (person.getName().length() > 5)
            System.out.println(person.getName());
        else
            System.out.println("Name is too short");
    }

    private static boolean cigarParty(int cigarNum, boolean weekEnd) {
        if (cigarNum >= 40 && cigarNum <= 60)
            return true;
        if (weekEnd == true) {
            if (cigarNum >= 40)
                return true;
        }
        return false;
    }

    private static int caughtSpeeding(int speed, boolean birthday) {
        int noTicket = 0;
        int smallTicket = 1;
        int bigTicket = 2;

        int noSpeed = 60;
        int UpperLimitMidSpeed = 80;
        if(birthday){
            noSpeed = 65;
            UpperLimitMidSpeed = 85;
        }

        if (speed <= noSpeed)
            return noTicket;
        if (speed <= UpperLimitMidSpeed)
            return smallTicket;
        else
            return bigTicket;

    }

    private static String alarmClock(int weekNum, boolean vacation){
        String weekdayTime = "7:00";
        String weekEndTime = "10:00";

        if(vacation){
            weekdayTime = "10:00";
            weekEndTime = "off";
        }

        switch(weekNum){
            case 0:
            case 7:
                return weekEndTime;
            default:
                return weekdayTime;
        }
    }

    private static int lotteryTicket(int a, int b, int c){
        if(a == b && b == c){
            return 20;
        }
        if(a==b || b ==c || a==c){
            return 10;
        }
        else
            return 0;
    }

    private static int blackJack(int firstNum, int secondNum){
        if(firstNum > 21 && secondNum > 21)
            return 0;
        if(firstNum > 21)
            return secondNum;
        if(secondNum > 21)
            return firstNum;
        return Math.max(firstNum, secondNum);
    }

    private static boolean evenlySpaced(int firstNum, int secondNum, int thirdNum){
        int[] array = new int[]{firstNum, secondNum, thirdNum};
        insertionSort(array);
        if((array[0] + array[2])== array[1]){
            return true;
        }
        return false;
    }

    private static void insertionSort(int[] array) {
        for(int i=1; i<array.length; i++){
            int key = array[i];
            for(int j = i-1; j>= 0; j--){
                if (key < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = key;
                }
            }
        }
    }
}
