public class Solution {
    public String solve(ArrayList<String> A, ArrayList<String> B) {

        TrieNode root = new TrieNode();

        //perform first add operation
        for(String word: A) {
            add(word, root);
        }

        String result = "";

        // perform the search operation
        for(String word : B) {
            result += checkNoOfModificationRequired(word, root);
        }

        return result;
    }

    public boolean query(TrieNode root, String word, int startIndex, int count) {

        // if startIndex crossed the word
        // then we need to check that count is 1 and the node I am getting is the terminal node or not
        if(startIndex >= word.length()) {
            if(count == 1 && root.end > 0) return true;
            return false;
        }

        // if I didn't find any mismatch till now
        // then I have to check for all the character present in the HashMap
        if(count == 0) {
            // check all the character present in HashMap
            for(Character c : root.allCharacter.keySet()) {

                // if the character is equal to character at the position at startIndex of word
                // then we can do recursive call by existing count value as the character got matched
                // if the character didn't matched then we need to do recursive call by increment count value by 1
                if(c == word.charAt(startIndex)) {
                    boolean ans = query(root.allCharacter.get(c), word, startIndex + 1, count);
                    if(ans) return ans;
                } else {
                    boolean ans = query(root.allCharacter.get(c), word, startIndex + 1, count + 1);
                    if(ans) return ans;
                }
            }
        }

        // if the count is already 1, means we already found 1 mismatch
        // then we can not check for each character , we need to check for the same character as we can not
        // increment the count by 1 anymore
        else {
            if(root.allCharacter.containsKey(word.charAt(startIndex))) {
                return query(root.allCharacter.get(word.charAt(startIndex)), word, startIndex + 1, count);
            }
        }

        return false;
    }

    public String checkNoOfModificationRequired(String word, TrieNode root) {

        return query(root, word, 0, 0) ? "1" : "0";


        // TrieNode temp = root;

        // int count = 0;

        // for(int i = 0; i < word.length(); i++) {
        //     char ch = word.charAt(i);
        //     //if the character not present, means a mismatch is found, increase the counter by 1
        //     //now we need to check for the next character present in any node's node
        //     //we need to handle, what if the mismatch character is the last character
        //     // we need to handle what if the node's HashMap is empty
        //     if(!temp.allCharacter.containsKey(ch)) {
        //         count++;
        //         //if the node HashMap is empty, lets say "dat" (already added) and "date" (searched word)
        //         // then we need to return 0, so increasing the counter by 1
        //         // your counter is already 2 , so need to traverse the loop
        //         if(temp.allCharacter.size() == 0) {
        //             //just to false , we are increasing the count
        //             count++;
        //             break;
        //         }
        //         // what if the mismatch character is the last character and node HashMap is not empty
        //         // then need to check is there any next node with end >= 1 is present, end >= 1 means a whole word
        //         // if we find any node, that means we can return 1 as there are only 1 mismatch
        //         // if we didn't find, then we need to return 0 as the word is present is greater than the word searching for
        //         // so we can just increase the counter just to return 0, we can break the loop
        //         else if(i == word.length() - 1) {
        //             boolean isLastCharacterFound = false;

        //             for(Character c : temp.allCharacter.keySet()) {
        //                 if(temp.allCharacter.get(c).end >= 1) {
        //                     temp = temp.allCharacter.get(c);
        //                     isLastCharacterFound = true;
        //                     break;
        //                 }
        //             }

        //             //just to false , we are increasing the count
        //             if(!isLastCharacterFound) {
        //                 count++;
        //                 break;
        //             }
        //         }

        //         // what if the mismatch happend in between or early stage
        //         // then we need to find the next character is present in HashMap in all the Object, present in Node's HashMap
        //         // if we found then from there we can continue
        //         // if we didn't found then there is 2 mismtach, so no need to continue, we can break the loop and return 0
        //         // so increasing counter just to represent 2 mismatch
        //         else {
        //             boolean isNextCharacterFound = false;
        //             for(Character c : temp.allCharacter.keySet()) {
        //                 if(temp.allCharacter.get(c).allCharacter.containsKey(word.charAt(i + 1))) {
        //                     temp = temp.allCharacter.get(c).allCharacter.get(word.charAt(i + 1));
        //                     i++;
        //                     isNextCharacterFound = true;
        //                     break;
        //                 }
        //             }

        //             if(!isNextCharacterFound) {
        //                 //just to false , we are increasing the count
        //                 count++;
        //                 break;
        //             }
        //         }


        //     }
        //     //if found then go to the next node
        //     else {
        //         temp = temp.allCharacter.get(ch);
        //     }
        // }

        // // it could happend that count is 1 but the last node is not representing the end of the word
        // // in that case, we need to return 0, so increasing the counter just to return 0
        // if(count == 1 && temp.end < 1) {
        //     count++;
        // }

        // return count == 1 ? "1" : "0";
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
