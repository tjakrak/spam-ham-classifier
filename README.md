# Classifying spam emails with Naive Bayes

Implementing a simple machine learning classifier to determine whether an email is spam or ham.

Step 1: Processor.

Convert an email into a list of words. While doing so, we also want to remove those words that are not useful.
We will do this in the Processor class. Processor should work with a single file. It will read it in, convert everything to lower case,
strip off trailing punctuation, check to see if a word is either a junk word or a stop word, and then return an ArrayList of Strings
containing the remaining words.

- First, implement the stripPunctuation, isJunk and isStopword methods.
- Then, implement parseFile.
- Create a file called ProcessorTest that tests this out.

Step 2: Count the number of times a word occurs in a file, or list of files. We'll do this with the FreqDist class.
This is largely a wrapper for a HashMap, with two additions:
 - If a word is not present in a corpus, we'll give it a count of 1.
 - We also want to keep track of how many words we've counted.
 implement add and get.
 - Extend ProcessorTest to make sure this works.

Step 3: Determine how likely it is that a new email is spam or ham, given the contents of the
 training set. We'll do this by computing the log likelihood, as discussed in the class slides.

- implement computeLogLikelihood.
- Extend ProcessorTest once again to check Loglikelihood. You may want to try it on a couple of very simple cases if you're not sure of the results.

Step 4:
Get it all running! 
- Extend the TestManager to keep track of how many emails of each type were classified correctly.

