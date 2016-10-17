A homophone is one of two or more words that are pronounced alike but are different in meaning or spelling; for example, the words �two�, �too�, and �to�. In this assignment you will write a program that ranks English words by the number of homophones.

The file cmudict.0.7a.txt is downloaded from http://www.speech.cs.cmu.edu/cgi-bin/cmudict The page also contains a detailed description of the pronunciation dictionary. After an initial segment of comment lines, the file consists of lines of the form ABUNDANT AH0 B AH1 N D AH0 N T 

The first string is an English word, which is followed by one or more phonemes (or phones) that describe the pronunciation of the word. There are 39 phonemes
occurring in North American English that are used in the dictionary. The collection of 39 symbols is known as the Arpabet, for the Advanced Research Projects Agency (ARPA), which developed it in in the 1970�s in connection with research on speech understanding.

Program takes one integer command line argument, call it k. 

The output of your program should consist of k lines, the ith of which gives a word that has the ith most homophones, followed by the number of homophones.