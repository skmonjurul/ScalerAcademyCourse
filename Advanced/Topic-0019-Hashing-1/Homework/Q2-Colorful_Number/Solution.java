public class Solution {
    public int colorful(int A) {
        ArrayList<Integer> digits = new ArrayList();

        while(A > 0) {
            digits.add(0, A % 10);
            A /= 10;
        }

        Set<Integer> unique = new HashSet<>();
        for(int i = 0; i < digits.size(); i++) {
            int product = 1;
            for(int j = i; j < digits.size(); j++) {
                product *= digits.get(j);
                if(unique.contains(product)) return 0;
                unique.add(product);
            }
        }

        return 1;
    }
}
