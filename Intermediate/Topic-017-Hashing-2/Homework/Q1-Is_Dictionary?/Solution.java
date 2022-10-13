public class Solution {
    public int solve(ArrayList<String> arr, String str) {

        if(arr.size() == 1) return 1;

        Map<Character, Integer> alphabet = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            alphabet.put(str.charAt(i), i);
        }

        for(int i=1; i<arr.size(); i++) {
            String prev = arr.get(i - 1);
            String next = arr.get(i);
            int prevLength = prev.length();
            int nextLength = next.length();

            if(prevLength > nextLength) return 0;

            if(prevLength == nextLength && prev == next) {
                continue;
            }

            int j = 0, k = 0;
            while(j < prevLength && k < nextLength) {
                if(prev.charAt(j) == next.charAt(k)) {
                    j++;
                    k++;
                    continue;
                }
                if(alphabet.get(prev.charAt(j)) > alphabet.get(next.charAt(k)))
                    return 0;
                else
                    break;
            }

            if(k >= nextLength && j < prevLength) return 0;

        }

        return 1;
    }
}
