import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by alexandraqin on 4/14/15.
 */
public class UsingAPIs {

    public static void main(String args[]) {
        File twoCitiesFile = new File("/Users/ashiquechowdhury/Desktop/accesscode/unit-1-bootcamp/resources/tale-of-two-cities.txt");
        File mobyDickFile = new File("/Users/ashiquechowdhury/Desktop/accesscode/unit-1-bootcamp/resources/moby-dick.txt");

        Set<String> twoCitiesWordSet = new HashSet<>();
        Set<String> mobyDickWordSet = new HashSet<>();
        try {
            twoCitiesWordSet = uniqueWordSet(twoCitiesFile);
            mobyDickWordSet = uniqueWordSet(mobyDickFile);
            System.out.println("Approximation of unique words in Tale of Two Cities: " + twoCitiesWordSet.size());
            System.out.println("Approximation of unique words in Moby Dick: " + mobyDickWordSet.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> intersectionSet = intersectSets(twoCitiesWordSet, mobyDickWordSet);
        Set<String> combinedSet = combineSets(twoCitiesWordSet, mobyDickWordSet);

        System.out.println("\nApproximation of unique similar words in both books: " + intersectionSet.size());
        System.out.println("Approximation of unique combined words in both books: " + combinedSet.size());

        Iterator<String> combinedSetIterator = combinedSet.iterator();
    }

    private static Set<String> combineSets(Set<String> firstSet, Set<String> secondSet) {
        Set<String> combinedSet = new HashSet<>(firstSet);
        combinedSet.addAll(secondSet);
        return combinedSet;
    }

    private static Set<String> intersectSets(Set<String> firstSet, Set<String> secondSet) {
        Set<String> intersectionSet = new HashSet<>(firstSet);
        intersectionSet.retainAll(secondSet);
        return intersectionSet;
    }

    private static Set<String> uniqueWordSet(File textFile) throws IOException {
        FileReader fr = new FileReader(textFile);
        BufferedReader textReader = new BufferedReader(fr);

        String line = "";
        Set<String> uniqueWordSet = new HashSet<>();
        while((line = textReader.readLine()) != null){
            String[] wordsInLine = line.split(" ");
            for(int i=0; i<wordsInLine.length; i++){
                uniqueWordSet.add(wordsInLine[i].toLowerCase());
            }
        }
        return uniqueWordSet;
    }
}