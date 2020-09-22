/* Project 1 Ham or Spam
 *  Ryan Giovanni Tjakrakartadinata
 *  CS 514 - 01
 * */

import java.util.ArrayList;

public class Predictor {

    /* Counting the probability of the likelihood of an email is spam/ham based on the training set */
    public double computeLogLikelihood(FreqDist fd, ArrayList<String> wordsToScore) {
        double prob = 0;
        for (int i = 0; i < wordsToScore.size(); i++) {
            prob += Math.log10((double)fd.get(wordsToScore.get(i))/fd.getTotalCount());
        }
        return prob;
    }

}
