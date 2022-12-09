public class Solution {
    public int solve(String A) {
        int[] z = new int[A.length()];
        compute_z(A, z);
        for(int i = 1; i < z.length; i++) {
            if(i + z[i] == A.length()) return i;
        }

        return A.length();
    }

    public void compute_z(String s, int z[])
    {
        int l = 0, r = 0;
        int n = s.length();
        for (int i = 1; i <= n - 1; i++) {
            if (i > r) {
                l = i;
                r = i;
                while (r < n && s.charAt(r - l) == s.charAt(r))
                    r++;
                z[i] = r - l;
                r--;
            }
            else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                }
                else {
                    l = i;
                    while (r < n && s.charAt(r - l) == s.charAt(r))
                        r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }
    }
}
