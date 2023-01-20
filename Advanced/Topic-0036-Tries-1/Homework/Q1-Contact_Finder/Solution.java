public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {

        TrieNode root = new TrieNode();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) == 0) {
                add(B.get(i), root);
            }

            else {
                result.add(query(B.get(i), root));
            }
        }


        return result;
    }

    public int query(String prefix, TrieNode root) {
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            //if any time the character is not present as key then we can print -1 and return from there only
            if(!temp.allCharacter.containsKey(ch)) {
                return 0;
            }
            //else go to next node
            else {
                temp = temp.allCharacter.get(ch);
            }
        }

        return temp.count;
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
