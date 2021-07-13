package ds.program.google;

import java.util.*;

/*
843. Guess the Word
This problem is an interactive problem new to the LeetCode platform.

We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.

You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.

Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.

Example 1:
Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]

Explanation:

master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.

We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
 */

/*
My failed test case because I created global hashmap for all new list then I shifted map creation inside while(not empty ) check and it got passed:
"hbaczn"
["gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"]
10
 */


 interface Master {
     public int guess(String word);
 }
public class GuessTheWords {
    public void findSecretWord(String[] wordList, Master master) {
        List<String> list = Arrays.asList(wordList);

        while (!list.isEmpty()) {
            //hashmap having word with the number of words it had no characters matching
            Map<String, Integer> zeroMatch = new HashMap<>();

            //compare words and check if they don't match any character add it to the hashmap
            for (String cand : list) {
                for (String word : list) {
                    if (match(cand, word) == 0)
                        zeroMatch.put(cand, zeroMatch.getOrDefault(cand, 0) + 1);
                }
            }

            //we want to find the word in zeromatch that looks more like the others in order to delete a max part of words, we select a candidate who has a big "family" (fewest 0 match).
            //if there isn't a word with a zeromatch, we guess the first word in list
            String guess = list.get(0);
            int min = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : zeroMatch.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
                //if there is a word with zeromatch
                if (min > entry.getValue()) {
                    min = entry.getValue();
                    guess = entry.getKey();
                }
            }
            System.out.println("guess: " + guess);
            //int m = matching characters of guess word
            //if the word we guess match, end it
            int m = master.guess(guess);
            if (m == 6) return;

            //create a new list that has the words with the number of characters
            //that match what m currently has
            List<String> tmp = new ArrayList<>();
            for (String s : list) {
                if (m == match(s, guess)) {
                    tmp.add(s);
                }
            }

            //list = to new list
            list = tmp;
        }
    }

    private int match(String a, String b) {
        int m = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) m++;
        }

        return m;
    }
}

/*
best solution:

Random random;
    public void findSecretWord(String[] wordlist, Master master) {
        random = new Random();
        int guessCount=0;
        for(int i=0;i<10 & guessCount<6;i++){
            String word = wordlist[random.nextInt(wordlist.length)];
            guessCount = master.guess(word);
            List<String> list = new ArrayList<>();
            for(String s:wordlist){
                if(s.equals(word)){continue;}
                if(matchCount(s,word)==guessCount){
                    list.add(s);
                }
            }
            wordlist = list.toArray(new String[list.size()]);
        }
    }

    public int matchCount(String s1,String s2){
        int count=0;
        for(int i=0;i<6;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                count++;
            }
        }
        return count;
    }
 */