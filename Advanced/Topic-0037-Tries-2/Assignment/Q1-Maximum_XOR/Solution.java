public class Solution {
    public int solve(ArrayList<Integer> A) {
        TrieNode root = new TrieNode();
        //perform add operation
        for(Integer num : A) {
            addNumber(num, root);
        }

        int max = 0;

        for(Integer num : A) {
            max = Math.max(max, findMaximumPair(num, root));
        }

        return max;
    }

    public int findMaximumPair(int num, TrieNode root) {
        int val = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(bit == 0) {
                if(root.children[1] != null) {
                    root = root.children[1];
                    val |= (1 << i);
                } else {
                    root = root.children[0];
                }
            } else {
                if(root.children[0] != null) {
                    root = root.children[0];
                    val |= (1 << i);
                } else {
                    root = root.children[1];
                }
            }
        }

        return val;
    }

    public void addNumber(int num, TrieNode root) {
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(root.children[bit] == null) {
                TrieNode temp = new TrieNode();
                root.children[bit] = temp;
                root = temp;
            } else {
                root = root.children[bit];
            }
        }
    }
}

class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
    }
}
