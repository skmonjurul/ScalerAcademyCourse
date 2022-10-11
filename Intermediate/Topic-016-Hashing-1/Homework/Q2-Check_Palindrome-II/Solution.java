public class Solution {
    public int solve(String str) {
        Map<Character, Integer> store = new HashMap<>();

        for(int i=0; i<str.length(); i++) {
            int value = store.getOrDefault(str.charAt(i), 0);
            store.put(str.charAt(i), value + 1);
        }

        int isOddFound = 0;
        for(Map.Entry<Character, Integer> entry : store.entrySet()) {

            if((entry.getValue() & 1) == 1) {
                isOddFound++;
            }
            if((entry.getValue() & 1) == 1 && isOddFound != 1) return 0;
        }

        return 1;
    }
}
