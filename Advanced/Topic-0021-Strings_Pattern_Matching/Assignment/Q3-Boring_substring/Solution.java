public class Solution {
    public int solve(String A) {
        List<Character> even = new ArrayList<>();
        List<Character> odd = new ArrayList<>();

        for(int i = 0; i < A.length(); i++) {
            if((A.charAt(i) - 'a') % 2 == 0) {
                even.add(A.charAt(i));
            } else {
                odd.add(A.charAt(i));
            }
        }

        Collections.sort(even);
        Collections.sort(odd);


        if(even.get(even.size() - 1) - odd.get(0) > 1) return 1;
        if(odd.get(odd.size() - 1) - even.get(0) > 1) return 1;

        return 0;
    }
}
