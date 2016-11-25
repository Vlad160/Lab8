import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Scanner;

/**
 * Created by User on 25.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        WordsList wordsList = new WordsList();
        try {
            Scanner in = new Scanner(new FileReader("test.txt"));
            wordsList.getFromFile(in);
            System.out.println(wordsList.toString());
            in.close();
            in = new Scanner(new FileReader("test.txt"));
            wordsList.findSimilar(in);
            in.close();
            System.out.println(wordsList.toString());
            wordsList.printToConsole();
            try {
                FileWriter out = new FileWriter("out.txt");
                wordsList.printToFile(out);
                out.close();
            }
            catch (IOException e){
                System.out.println("IO Exception");
            }
            FileOutputStream bout = new FileOutputStream("byteOut.bin");
            wordsList.printToByteFile(bout);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
