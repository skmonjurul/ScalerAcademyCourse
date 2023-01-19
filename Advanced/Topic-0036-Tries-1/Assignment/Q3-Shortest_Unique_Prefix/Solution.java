public class Solution {
    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode root = new TrieNode();
        for(String word : A) {
            add(word, root);
        }

        ArrayList<String> prefixes = new ArrayList<>();

        for(String word : A) {
            prefixes.add(query(word, root));
        }

        return prefixes;

    }

    public String query(String prefix, TrieNode root) {
        TrieNode temp = root;
        int i;
        for(i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            //if any time the character is not present as key then we can print -1 and return from there only
            if(temp.allCharacter.get(ch).count == 1) break;
                //else go to next node
            else {
                temp = temp.allCharacter.get(ch);
            }
        }

        return prefix.substring(0, i + 1);
    }

    public void add(String word, TrieNode root) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            //check if the ch present as key, if not then create a new node, add into array
            // and then move the temp pointer to newly created node object
            if(!temp.allCharacter.containsKey(ch)) {
                TrieNode node = new TrieNode();
                temp.allCharacter.put(ch, node);
                temp = node;
                temp.count++;
            }
            //if present then move to the node object
            else {
                temp = temp.allCharacter.get(ch);
                temp.count++;
            }
        }

        //at the end temp will point to the last node for last Character of the string
        //so just increse the end value by 1
        temp.end++;
    }
}

class TrieNode {

    //to mark it is a end of a string
    //same string can apper multiple times lests say n times, in that cases end will be n
    int end;
    int count;

    //instead of array choose HashMap to reduce space
    Map<Character, TrieNode> allCharacter;

    public TrieNode() {
        allCharacter = new HashMap<>();
    }
}

