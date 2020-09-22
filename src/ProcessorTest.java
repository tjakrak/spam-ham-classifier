/* Project 1 Ham or Spam
 *  Ryan Giovanni Tjakrakartadinata
 *  CS 514 - 01
 * */

import java.util.ArrayList;

public class ProcessorTest {

    public static void main (String[] args) {
        ArrayList<String> parsedWords;
        Processor p = new Processor("spamtrain/0007.859c901719011d56f8b652ea071c1f8b");

        /* read in and store words from a file to arrayList parsedWords*/
        parsedWords = p.parseFile();

        /* printing words from arrayList parsedWords */
        for(String w:parsedWords) {
            System.out.println(w);
        }
    }
}
