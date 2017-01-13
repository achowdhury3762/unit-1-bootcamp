import com.stripe.exception.*;
import com.stripe.model.*;
import com.stripe.net.RequestOptions;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by alexandraqin on 4/14/15.
 */
public class DataStructures {

    public static void main(String args[]) {
//        List<Cat> catList = new ArrayList<>(5);
//        for (int i = 0; i < 5; i++) {
//            Cat randomCat = randomCat();
//            catList.add(randomCat);
//            printAllElements(randomCat);
//        }
//
//        Map<String, Integer> ageMap = new HashMap<>();
//        ageMap.put("Jonathon", 30);
//        ageMap.put("Ridita", 26);
//        ageMap.put("Rafat", 24);
//        ageMap.put("Helen", 29);
//
//        for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        RequestOptions requestOptions = new RequestOptions.RequestOptionsBuilder()
                .setApiKey("sk_test_jFEodylTKuZmzGtAZUhgg9tR")
                .build();

        try {
            Map<String, Object> customerParams = new HashMap<>();
            customerParams.put("limit", 40);
            CustomerCollection myCustomers = Customer.all(customerParams, requestOptions);
            List<Customer> myCustomerList = myCustomers.getData();
            for (int i = 0; i < myCustomerList.size(); i++) {
                System.out.println("Customer " + (i + 1) + " = " + myCustomerList.get(i).getEmail());
                Map<String, Object> updateparams = new HashMap<>();
                myCustomerList.get(i).update(updateparams, requestOptions);
            }
            System.out.println(myCustomers.getData().size() + " total customers");

//            Map<String, Object> chargeMap = new HashMap<String, Object>();
//            chargeMap.put("amount", 100);
//            chargeMap.put("currency", "usd");
//            Map<String, Object> cardMap = new HashMap<String, Object>();
//            cardMap.put("number", "4242424242424242");
//            cardMap.put("exp_month", 12);
//            cardMap.put("exp_year", 2020);
//            chargeMap.put("card", cardMap);
//            Charge charge = Charge.create(chargeMap, requestOptions);

//            Map<String, Object> chargeMap = new HashMap<>();
//            chargeMap.put("limit", 50);
//            ChargeCollection chargeCollection = Charge.all(chargeMap, requestOptions);
//            System.out.println(chargeCollection.getData().get(0));

            Charge specificCharge = Charge.retrieve("ch_19bIrYL2JsKz3W3jqKSH7br2",requestOptions);
//            System.out.println(specificCharge);
            Map<String, Object> refundParams = new HashMap<>();
            refundParams.put("charge", "ch_19bIrYL2JsKz3W3jqKSH7br2");


        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (CardException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }


    }

    private static void printAllElements(Cat randomCat) {
        String name = randomCat.getName();
        int age = randomCat.getAge();
        Person owner = randomCat.getOwner();
        String favoriteFood = randomCat.getFavoriteFood();

        System.out.println(name);
        System.out.println("Age: " + age);
        if (owner != null) {
            System.out.println("Owner: " + owner);
        } else
            System.out.println("Owner: " + "No Owner");
        System.out.println("Favorite Food: " + favoriteFood);
        System.out.println("\n");
    }

    private static Cat randomCat() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        Cat cat = new Cat();
        switch (randomNumber) {
            case 0:
                cat.setName("Bob");
                cat.setAge(random.nextInt(50) + 1);
                cat.setFavoriteFood("Milk");
                break;
            case 1:
                cat.setName("Michael");
                cat.setAge(random.nextInt(50) + 1);
                cat.setFavoriteFood("Cookies");
                break;
            case 2:
                cat.setName("Shirt");
                cat.setAge(random.nextInt(50) + 1);
                cat.setFavoriteFood("Shoes");
                break;
            case 3:
                cat.setName("Pants");
                cat.setAge(random.nextInt(50) + 1);
                break;
            case 4:
                cat.setName("Tie");
                cat.setAge(random.nextInt(50) + 1);
                break;
            default:
                cat.setName("Watch");
                cat.setAge(random.nextInt(50) + 1);
        }
        return cat;
    }

    private static int mostFrequentElement(ArrayList<Integer> integerList) {
        Collections.sort(integerList);
        int maxFrequency = 0;
        int frequentNumber = 0;
        for (int i = 0; i < integerList.size(); i++) {
            int currentElement = integerList.get(i);
            int currentFrequency = 1;
            while (i + 1 != integerList.size() && currentElement == integerList.get(i + 1)) {
                currentFrequency++;
                i++;
            }
            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                frequentNumber = integerList.get(i);
            }
        }
        return frequentNumber;
    }

    private static String mostFrequentWord(ArrayList<String> wordList) {
        Collections.sort(wordList);
        int maxFrequency = 0;
        String frequentWord = "";
        for (int i = 0; i < wordList.size(); i++) {
            String currentElement = wordList.get(i);
            int currentFrequency = 1;
            while (i + 1 != wordList.size() && currentElement == wordList.get(i + 1)) {
                currentFrequency++;
                i++;
            }
            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                frequentWord = wordList.get(i);
            }
        }
        return frequentWord;
    }

    private static boolean canRentACar(Map<String, Integer> podMap) {
        for (Integer age : podMap.values()) {
            if (age > 25)
                return true;
        }
        return false;
    }

    private static List<String> wordsWithoutList(List<String> wordList, int lengthToOmit) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).length() == lengthToOmit) {
                wordList.remove(i);
            }
        }
        return wordList;
    }

    private static int countClumps(List<?> myList) {
        int totalClumps = 0;
        for (int i = 0; i < myList.size() - 1; i++) {
            Object currentElement = myList.get(i);
            if (myList.get(i + 1) == myList.get(i)) {
                totalClumps++;
                while (i != myList.size() - 1 && myList.get(i + 1) == currentElement) {
                    i++;
                }
            }
        }
        return totalClumps;
    }

    private static void printAlphabeticalSentence(String sentence) {
        sentence = sentence.toLowerCase();
        String[] wordArray = sentence.split(" ");
        List<String> wordList = Arrays.asList(wordArray);
        Collections.sort(wordList);
        System.out.println(wordList);
    }
}