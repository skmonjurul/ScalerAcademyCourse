public class Solution {
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<Integer> B) {
        TrieNodeSum root = new TrieNodeSum();

        ArrayList<Integer> result = new ArrayList<>();
        Map<String, Integer> weightOfString = new HashMap<>();

        for(int i = 0; i < B.size(); i++) {
            if(B.get(i) == -1) {
                findSum(root, A.get(i), result, weightOfString);
            }

            // perform add operation
            else {
                weightOfString.put(A.get(i), B.get(i));
                add(root, A.get(i));
            }
        }


        return result;
    }

    public void findSum(TrieNodeSum root, String prefix, ArrayList<Integer> result,
                        Map<String, Integer> weightOfString) {

        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if(root.children[ch - 'a'] != null) {
                root = root.children[ch - 'a'];
            }

            else {
                result.add(0);
                return;
            }
        }

        int totalSum = totalSum(root, prefix, weightOfString);

        result.add(totalSum);
    }

    public int totalSum(TrieNodeSum root, String prefix, Map<String, Integer> weightOfString) {
        boolean isFound = false;
        for(int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null) {
                isFound = true;
                break;
            }
        }

        if(!isFound) {
            return root.end >= 1 ? weightOfString.get(prefix) : 0;
        }

        int sum = 0;
        if(root.end >= 1) {
            sum += weightOfString.get(prefix);
        }

        for(int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null) {
                char ch = (char) (i + 'a');
                sum += totalSum(root.children[i], prefix + String.valueOf(ch), weightOfString);
            }
        }

        return sum;
    }

    public void add(TrieNodeSum root, String str) {
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(root.children[ch - 'a'] == null) {
                TrieNodeSum temp = new TrieNodeSum();
                root.children[ch - 'a'] = temp;
                temp.count++;
                root = temp;
            }

            else {
                root = root.children[ch - 'a'];
                root.count++;
            }
        }
        root.end++;
    }
}
class TrieNodeSum {
    TrieNodeSum[] children;
    int count;
    int end;

    public TrieNodeSum() {
        children = new TrieNodeSum[26];
    }
}