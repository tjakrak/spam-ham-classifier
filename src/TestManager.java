/* Project 1 Ham or Spam
 *  Ryan Giovanni Tjakrakartadinata
 *  CS 514 - 01
 * */

import java.io.File;
import java.util.ArrayList;

/* Extend this to evaluate the fraction of spam and ham emails your classifier identifies correctly. */

public class TestManager {

    public static void main(String args[]) {
        FreqDist spam = new FreqDist();
        FreqDist ham = new FreqDist();

        ArrayList<String> words;
        Processor p;
        Predictor pr = new Predictor();

        double spamval, hamval;

        /* read in 100 spam and store in a FreqDist. */
        File spamFolder = new File("spamtrain");
        for (String filename : spamFolder.list()) {
            p = new Processor("spamtrain/" + filename);
            words = p.parseFile();
            for (String w : words) {
                spam.add(w);
            }
        }

        /* read in 100 ham and store in a FreqDist */

        File hamFolder = new File("hamtrain");
        for (String filename : hamFolder.list()) {
            p = new Processor("hamtrain/" + filename);
            words = p.parseFile();
            for (String w : words) {
                ham.add(w);
            }

        }

//        System.out.println(spam.getTotalCount());
//        double x = Math.log10(921);
//        System.out.println(x);
//
//        p = new Processor("spamtest/0101.2dfd7ee79ae439b8d9c38e783a137efa");
//        words = p.parseFile();
//        spamval = pr.computeLogLikelihood(spam, words);
//        double prob = 0;
//        for (int i = 0; i < words.size(); i++) {
//            System.out.println(words.get(i));
//            if (spam.getFrequencies().containsKey(words.get(i))) {
//                System.out.println(spam.getFrequencies().get(words.get(i)));
//                System.out.println(spam.getTotalCount());
//                prob += Math.log10((double)spam.getFrequencies().get(words.get(i)) / spam.getTotalCount());
//                System.out.println(prob);
//            } else {
//                System.out.println(1);
//                prob += Math.log10(1 / spam.getTotalCount());
//                System.out.println(prob);
//            }
//        }
//        hamval = pr.computeLogLikelihood(ham, words);
//        System.out.println(spamval + " " + hamval);
//        if (spamval > hamval) {
//            System.out.println("Correct");
//        } else {
//            System.out.println("Incorrect");
//        }

        /* take 50 ham test emails, compute loglikelihood */

        File spamTestFolder = new File("spamtest");
        int ctcorrect = 0;
        int ctincorrect = 0;
        for (String filename : spamTestFolder.list()) {
            p = new Processor("spamtest/" + filename);
            words = p.parseFile();
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval > hamval) {
                System.out.println("Correct");
                ctcorrect++;
            } else {
                System.out.println("Incorrect");
                ctincorrect++;
            }
        }
        System.out.println("correct: " + ctcorrect);
        System.out.println("incorrect: " + ctincorrect);

        /* take 50 spam test emails, compute loglikelihood */

        File hamTestFolder = new File("hamtest");
        ctcorrect = 0;
        ctincorrect = 0;
        for (String filename : hamTestFolder.list()) {
            p = new Processor("hamtest/" + filename);
            words = p.parseFile();
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval < hamval) {
                System.out.println("Correct");
                ctcorrect++;
            } else {
                System.out.println("Incorrect");
                ctincorrect++;
            }
        }
        System.out.println("correct: " + ctcorrect);
        System.out.println("incorrect: " + ctincorrect);
    }
}








