import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by User on 25.11.2016.
 */
public class WordsList {
    private HashMap<String, Integer> wordsList;

    WordsList() {
        wordsList = new HashMap<>();
    }

    public void getFromFile(Scanner in) {
        while (in.hasNext()) {
            String[] words = in.nextLine().split("[.\\s,!?]+");
            for (int i = 0; i < words.length; ++i) {
                wordsList.put(words[i], 1);
            }
        }
    }

    public void findSimilar(Scanner in) {
        while (in.hasNext()) {
            String[] words = in.nextLine().split("[.\\s,!?]+");
            for (int i = 0; i < words.length; ++i) {
                if (wordsList.containsKey(words[i])) {
                    wordsList.put(words[i], wordsList.get(words[i]) + 1);
                }
            }
        }
    }

    public void printToConsole() {
        for (HashMap.Entry<String, Integer> entry : wordsList.entrySet())
        {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public void printToFile(FileWriter out) {
        try {
            out.write(wordsList.toString());
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
    public void printToByteFile(FileOutputStream bout){
        try {
            bout.write(wordsList.toString().getBytes());
        }
        catch (IOException e){
            System.out.println("IO Exception");
        }
    }

    @Override
    public String toString() {
        return wordsList.toString();
    }
}
