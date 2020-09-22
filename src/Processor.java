/* Project 1 Ham or Spam
 *  Ryan Giovanni Tjakrakartadinata
 *  CS 514 - 01
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* The Processor class will open a file and tokenize it. */

public class Processor {
    public static final String[] stopwords = {"i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "you're",
            "you've", "you'll", "you'd", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she",
            "she's", "her", "hers", "herself", "it", "it's", "its", "itself", "they", "them", "their", "theirs",
            "themselves", "what", "which", "who", "whom", "this", "that", "that'll", "these", "those", "am", "is", "are",
            "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing",
            "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while", "of", "at", "by", "for",
            "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to",
            "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here",
            "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some",
            "such", "no", "nor", "not", "only", "own", "same", "so", "than", "too", "very", "can", "will", "just", "don't",
            "should", "should've", "now", "aren't", "couldn't", "didn't", "doesn't", "hasn't", "haven't", "isn't", "shouldn't",
            "wasn't", "weren't", "won't", "wouldn't"};


    String filename;

    public Processor(String fname) {
        this.filename = fname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    /* you do this one */
    public boolean isStopword(String word) {
        for (String s : stopwords) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /* you do this one. */
    /* let's assume a word is junk if it contains anything except a letter. */

    public boolean isJunk(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* you do this one. */
    /* remove trailing punctuation. You can assume that there is at most one punctuation character at the end of the word*/

    public String stripPunctuation(String w) {
        if(w.isEmpty()) {
            return w;
        }
        int lastletter = w.length()-1;
        if (!Character.isLetterOrDigit(w.charAt(lastletter))) {
            w = w.substring(0, lastletter);
        }
        return w;
    }

    /* you do this one */
    /* parseFile should take a filename as input, open the file, read in each token, convert to lower case,
        check to see if it's in the stopword list, check to see if it's junk, and strip off trailing punctuation.
        Return an ArrayList of Strings representing all words that meet these criteria. processed accordingly. */

    public ArrayList<String> parseFile() {
        ArrayList<String> parsed = new ArrayList();
        try {
            int ct = 0;
            Scanner s = new Scanner(new File(filename));
            while (s.hasNext()) {
                ct++;
                //System.out.println(ct);
                String line = s.nextLine().toLowerCase().trim();
                String[] word = line.split("\\s+");

                for (String value : word) {
                    String normalizedword = stripPunctuation(value);
                    if (!isStopword(normalizedword) && !isJunk(normalizedword) && !normalizedword.isEmpty()) {
                        parsed.add(normalizedword);
                    }
                }
            }
            return parsed;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return parsed;
    }
}