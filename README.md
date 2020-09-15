Project 1. Classifying spam emails with Naive Bayes. (100 points)
Due Thursday, Sept 23.

In this project you'll be implementing a simple machine learning classifier to determine whether an email is spam or ham.
This will give you a chance to practice some of the skills you've lesrned so far, and integrate them into a real-world
application. I've provided a fair amount of code for you to get you started.

This description is relatively short - you'll want to refer to the class slides and lecture for details on how to complete these tasks.

Recall from class that we are going to treat an email as a bag of words. Our problem then becomes one of predicting
which class (spam or ham) is more likely, given the words in the email.

(30 points) Step 1: Processor.

To begin, we need to convert an email into a list of words. While doing so, we also want to remove those words that are not useful.
We will do this in the Processor class. Processor should work with a single file. It will read it in, convert everything to lower case,
strip off trailing punctuation, check to see if a word is either a junk word or a stop word, and then return an ArrayList of Strings
containing the remaining words.

- First, implement the stripPunctuation, isJunk and isStopword methods.
- Then, implement parseFile.
- Create a file called ProcessorTest that tests this out.

(30 points) Step 2: Now we need to count the number of times a word occurs in a file, or list of files. We'll do this with the FreqDist class.
This is largely a wrapper for a HashMap, with two additions:
 - If a word is not present in a corpus, we'll give it a count of 1.
 - We also want to keep track of how many words we've counted.
 implement add and get.
 - Extend ProcessorTest to make sure this works.

(30 points) Step 3: Now we want to be able to determine how likely it is that a new email is spam or ham, given the contents of the
 training set. We'll do this by computing the log likelihood, as discussed in the class slides.

- implement computeLogLikelihood.
- Extend ProcessorTest once again to check Loglikelihood. You may want to try it on a couple of very simple cases if you're not sure of the results.

(10 points) Step 4:
Get it all running! 
- Extend the TestManager to keep track of how many emails of each type were classified correctly.

