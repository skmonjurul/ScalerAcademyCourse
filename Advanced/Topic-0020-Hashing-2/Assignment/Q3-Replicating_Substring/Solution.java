public class Solution {
    public int solve(int A, String B) {
        if(A == 1) return 1;
        Map<Character, Integer> uniqueCharacter = new HashMap<>();
        for(int i = 0; i < B.length(); i++) {
            int value = uniqueCharacter.getOrDefault(B.charAt(i), 0);
            uniqueCharacter.put(B.charAt(i), value + 1);
        }

        for(Character ch : uniqueCharacter.keySet()) {
            if(uniqueCharacter.get(ch) % A != 0) return -1;
        }
        return 1;
    }
}
