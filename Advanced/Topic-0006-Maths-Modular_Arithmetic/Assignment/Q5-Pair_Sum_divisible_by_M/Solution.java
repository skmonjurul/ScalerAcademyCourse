public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        if(A.size() == 1) return 0;

        int[] modArray = new int[A.size()];

        //create the mod array, A.get(i) % B
        for(int i = 0; i < A.size(); i++) {
            modArray[i] = A.get(i) % B;
        }

        //create a bucket array to count how many 0, 1, 2 .... B - 1 is present
        //in the mod Array.
        //till B - 1 because x % B value counld be in range (0...B - 1)
        int[] bucket = new int[B];

        for(int i = 0; i < modArray.length; i++) {
            bucket[modArray[i]]++;
        }

        long ans = 0;
        long mod = 1000 * 1000 * 1000 + 7;

        // for 0 index we need to calculate separate
        //same as if B is even , B / 2 index , we need to calculate separate
        //if B is Odd, then we need to calulate like 1 with B - 1, 2 with B - 2, 3 with B - 3
        for(int i = 1; i < B / 2; i++) {
            ans += (1L * bucket[i] * bucket[B - i]) % mod;
            ans %= mod;
        }


        //for mid index incase of B is even and odd
        int mid = B / 2;
        if(B % 2 == 0) {
            ans += ((1L * bucket[mid] * (bucket[mid] - 1)) / 2) % mod;
            ans %= mod;
        } else {
            ans += (1L * bucket[mid] * bucket[mid + 1]) % mod;
            ans %= mod;
        }


        // for O index
        ans += ((1L * bucket[0] * (bucket[0] - 1)) / 2) % mod;
        ans %= mod;

        return (int)ans;
    }
}
