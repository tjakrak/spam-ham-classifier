/* Project 1 Ham or Spam
 *  Ryan Giovanni Tjakrakartadinata
 *  CS 514 - 01
 * */

import java.util.ArrayList;

public class FreqTest {
    public static void main (String[] args) {
        ArrayList<String> spamWords;
        ArrayList<String> hamWords;
        FreqDist spamd = new FreqDist();
        FreqDist hamd = new FreqDist();

        Processor spamp = new Processor("spamtrain/0008.9562918b57e044abfbce260cc875acde");
        Processor hamp = new Processor("hamtrain/0007.c75188382f64b090022fa3b095b020b0");

        /* read in and store words from spam and ham files */
        spamWords = spamp.parseFile();
        hamWords = hamp.parseFile();

        /* storing list of spam words and ham words to FreqDist spamd and hamd */
        for (String w : spamWords) {
            spamd.add(w);
        }
        for (String w : hamWords) {
            hamd.add(w);
        }

        /* printing list of distinct key words from spamd and hamd */
        System.out.println("Spam!");
        for (String w : spamd.frequencies.keySet()) {
            System.out.println(w + " " + spamd.get(w));
        }

        System.out.println("Ham!");
        for (String w : hamd.frequencies.keySet()) {
            System.out.println(w + " " + hamd.get(w));
        }
    }
}
