public class Solution {
    public int solve(String A) {
        if(A.length() == 1) return 1;
        Map<Character, Integer> frequency = new HashMap<>();

        for(Character ch : A.toCharArray()) {
            int value = frequency.getOrDefault(ch, 0);
            frequency.put(ch, value + 1);
        }

        if(A.length() == frequency.size()) return 0;

        if(A.length() > 1 && frequency.size() == 1) return 1;

        int oddCount = 0;
        for(Character ch : frequency.keySet()) {
            int value = frequency.get(ch);
            if(value % 2 != 0) oddCount++;
        }

        if(oddCount > 1) return 0;

        return 1;
    }
}
