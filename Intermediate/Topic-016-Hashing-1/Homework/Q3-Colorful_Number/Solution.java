public class Solution {
    public int colorful(int n) {
        if(n >=1 && n < 10) return 1;
        char[] number = String.valueOf(n).toCharArray();
        Set<Integer> product = new HashSet<>();

        int[] productArr = new int[number.length];

        for(int i=0; i<number.length; i++) {
            int p = 1;
            for(int j = i; j<number.length; j++) {
                p *= Integer.parseInt(String.valueOf(number[j]));
                if(product.contains(p)) return 0;
                product.add(p);
            }
        }
        return 1;
    }
}
