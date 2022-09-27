public class Solution {
    public String solve(ArrayList<Integer> A) {
        if(A.size() == 1 && A.get(0) % 2 == 0) {
            return "Yes";
        }
        int ans = 0;
        for(Integer num : A) {
            if(num % 2 != 0) {
                ans = ans ^ num;
                if(ans % 2 == 0) {
                    ans = 0;
                }
            }
        }

        return ans == 0 ? "Yes" : "No";
    }
}
