public class Solution {
    public int solve(String str, int B) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int value = characterIntegerMap.getOrDefault(ch, 0);
            characterIntegerMap.put(ch, value + 1);
        }

        ArrayList<Integer> frequency = new ArrayList<>();

        for(Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            frequency.add(entry.getValue());
        }

        Collections.sort(frequency);

        for(int i=0; i<frequency.size(); i++) {
            int value = frequency.get(i);
            B -= value;

            if(B < 0) {
                return frequency.size() - i;
            }
        }

        return 1;
    }
}
