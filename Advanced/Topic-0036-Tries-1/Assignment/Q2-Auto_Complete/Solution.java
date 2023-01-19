import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String[] dictionary = new String[n];
            int[] weight = new int[n];
            String[] prefixes = new String[m];

            for(int i = 0; i < n; i++) {
                dictionary[i] = sc.next();
            }

            for(int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }

            for(int i = 0; i < m; i++) {
                prefixes[i] = sc.next();
            }

            solve(dictionary, weight, prefixes);


            testCases--;
        }

        sc.close();

    }

    public static void solve(String[] words, int[] weight, String[] prefixes) {
        TrieNode root = new TrieNode();

        for(int i = 0; i < words.length; i++) {
            insert(words[i], root, weight[i]);
        }

        for(int i = 0; i < prefixes.length; i++) {
            search(root, prefixes[i]);
        }
    }

    public static void search(TrieNode root, String prefix) {
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            //if any time the character is not present as key then we can print -1 and return from there only
            if(!temp.allCharacter.containsKey(ch)) {
                System.out.println(-1 + " ");
                return;
            }
            //else go to next node
            else {
                temp = temp.allCharacter.get(ch);
            }
        }

        List<Pair> result = new ArrayList<>();
        // if(temp.end = 1) {
        //     result.add(prefix);
        // }

        // StringBuilder word = new StringBuilder(prefix);
        searchWord(temp, prefix, result);


        print(result);


    }

    public static void searchWord(TrieNode node, String word, List<Pair> result) {
        //if node's map size is 0 and end >= 1 then add word in result array
        if(node.allCharacter.size() == 0 && node.end >= 1) {
            for(int i = 0; i < node.end; i++)
                result.add(new Pair(word, node.weight.get(i)));
            return;
        }

        // it could be node map size is > 0 but end is >= 1
        // then we need to consider those words also
        if(node.end >= 1) {
            for(int i = 0; i < node.end; i++)
                result.add(new Pair(word, node.weight.get(i)));
        }

        //search for character 
        for(Character ch : node.allCharacter.keySet()) {
            searchWord(node.allCharacter.get(ch), word + String.valueOf(ch), result);
        }
    }

    public static void print(List<Pair> searchedWords) {

        // sort the list first
        searchedWords.sort((Pair p1, Pair p2) -> p2.weight.compareTo(p1.weight));

        int i = 1;
        //print the first 5 words
        for(Pair pair : searchedWords) {
            if(i > 5) break;
            System.out.print(pair.word + " ");
            i++;
        }
        System.out.println();
    }


    public static void insert(String word, TrieNode root, int weight) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            //check if the ch present as key, if not then create a new node, add into array
            // and then move the temp pointer to newly created node object
            if(!temp.allCharacter.containsKey(ch)) {
                TrieNode node = new TrieNode();
                temp.allCharacter.put(ch, node);
                temp = node;
            }
            //if present then move to the node object
            else {
                temp = temp.allCharacter.get(ch);
            }
        }

        //at the end temp will point to the last node for last Character of the string
        //so just increse the end value by 1
        temp.end++;
        //add associate weight to the weight list
        temp.weight.add(weight);
    }
}


// to create the TrieNode object
class TrieNode {

    //to mark it is a end of a string
    //same string can apper multiple times lests say n times, in that cases end will be n
    int end;

    // to store the weight of all same string
    List<Integer> weight;

    //instead of array choose HashMap to reduce space
    Map<Character, TrieNode> allCharacter;

    public TrieNode() {
        allCharacter = new HashMap<>();
        weight = new ArrayList<>();
    }
}


// Pair class to sort the String as per weight
class Pair {
    String word;
    Integer weight;

    public Pair(String word, int weight) {
        this.word = word;
        this.weight = weight;
    }
}