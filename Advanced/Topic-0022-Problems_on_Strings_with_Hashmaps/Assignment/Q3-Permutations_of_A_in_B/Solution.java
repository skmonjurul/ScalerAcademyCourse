public class Solution {
    public int solve(String A, String B) {

        if(A.length() > B.length()) return 0;

        Map<Character, Integer> aMap = new HashMap<>();
        for(int i = 0; i < A.length(); i++) {
            int value = aMap.getOrDefault(A.charAt(i), 0);
            aMap.put(A.charAt(i), value + 1);
        }

        Map<Character, Integer> bMap = new HashMap<>();
        for(int i = 0; i < A.length(); i++) {
            if(aMap.containsKey(B.charAt(i))) {
                int value = bMap.getOrDefault(B.charAt(i), 0);
                bMap.put(B.charAt(i), value + 1);
            }
        }

        int count = 0;

        boolean isSame = true;
        for(Character ch : aMap.keySet()) {
            if(!Objects.equals(aMap.get(ch), bMap.get(ch))) {
                isSame = false;
                break;
            }
        }

        if(isSame) count++;

        for(int i = 1; i <= B.length() - A.length(); i++) {
            int value = bMap.getOrDefault(B.charAt(i - 1), 0);
            value--;
            if(value == 0) {
                bMap.remove(B.charAt(i - 1));
            } else if(aMap.containsKey(B.charAt(i - 1))) {
                bMap.put(B.charAt(i - 1), value);
            }


            char key = B.charAt(i + A.length() - 1);
            value = bMap.getOrDefault(key, 0);
            if(aMap.containsKey(key)) {
                bMap.put(key, value + 1);
            }

            isSame = true;
            for(Character ch : aMap.keySet()) {
                if(!Objects.equals(aMap.get(ch), bMap.get(ch))) {
                    isSame = false;
                    break;
                }
            }

            if(isSame) count++;
        }

        return count;

    }
}
