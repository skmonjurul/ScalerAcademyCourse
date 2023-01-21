public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        // first convert the array to prefix XOR array
        for(int i = 1; i < A.size(); i++) {
            A.set(i, (A.get(i) ^ A.get(i - 1)));
        }

        TrieNode root = new TrieNode();
        //perform add operation
        for(Integer num : A) {
            addNumber(num, root);
        }

        int max = 0;

        for(int i = 0; i < A.size(); i++) {
            int val = findMaxPairValue(A.get(i), root);
            max = Math.max(max, val);
        }

        //create a Map to store index of xor value
        Map<Integer, Integer> valueWithIndex = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);

        for(int i = 0; i < A.size(); i++) {
            if(valueWithIndex.containsKey(A.get(i) ^ max)) {
                if(result.get(0) == -1) {
                    result.set(0, valueWithIndex.get(A.get(i) ^ max) + 1);
                    result.set(1, i);
                } else {
                    int newLength = Math.abs(i - (valueWithIndex.get(A.get(i) ^ max) + 1));
                    int previousLength = Math.abs(result.get(1) - result.get(0));

                    if(newLength < previousLength) {
                        result.set(0, valueWithIndex.get(A.get(i) ^ max) + 1);
                        result.set(1, i);
                    }
                }

            } else {
                valueWithIndex.put(A.get(i), i);
            }
        }

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) > max) {
                max = A.get(i);
                result.set(0, 0);
                result.set(1, i);
            } else if(A.get(i) == max) {
                int previousLength = Math.abs(result.get(0) - result.get(1));
                int newLength = Math.abs(i - 0);
                if(newLength < previousLength) {
                    result.set(0, 0);
                    result.set(1, i);
                }
            }
        }

        result.set(0, result.get(0) + 1);
        result.set(1, result.get(1) + 1);


        return result;
    }

    public int findMaxPairValue(int num, TrieNode temp) {
        int val = 0;
        for(int j = 31; j >= 0; j--) {
            int bit = (num >> j) & 1;
            if(bit == 0) {
                if(temp.children[1] != null) {
                    temp = temp.children[1];
                    val |= (1 << j);
                    // number |= (1 << j);
                } else {
                    temp = temp.children[0];
                }
            } else {
                if(temp.children[0] != null) {
                    temp = temp.children[0];
                    val |= (1 << j);
                } else {
                    temp = temp.children[1];
                    // number |= (1 << j);
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
