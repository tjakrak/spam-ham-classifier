/* Project 1 Ham or Spam
 *  Ryan Giovanni Tjakrakartadinata
 *  CS 514 - 01
 * */

/* A freqDist is a wrapper for a Map that will tell us, for a given list of words, how often each word appeared
in a corpus. */

import java.util.HashMap;

public class FreqDist {
    HashMap<String, Integer> frequencies;
    int totalCount;

    public FreqDist() {
        frequencies = new HashMap<String, Integer>();
        totalCount = 0;
    }

    public HashMap<String, Integer> getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(HashMap<String, Integer> frequencies) {
        this.frequencies = frequencies;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /* Storing new words or existing words and keep track of the total words and each words*/
    public void add(String newWord) {
        totalCount++;
        if (frequencies.containsKey(newWord)) {
            frequencies.put(newWord, frequencies.get(newWord) + 1);
        } else {
            frequencies.put(newWord, 1);
        }

    }

    /* if a word is not present in our frequency dictionary, assume it has a count of 1. */
    public int get(String newWord) {
        if(frequencies.containsKey(newWord)) {
            return frequencies.get(newWord);
        } else {
            return 1;
        }
    }
}
