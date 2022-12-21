public class Solution {
    public int findRank(String A) {
        int n = A.length();
        int[] fact = new int[n + 1];
        fact[0] = 1;

        int mod = 1000003;

        for(int i = 1; i < fact.length; i++) {
            fact[i] = (i * fact[i - 1]) % mod;
        }

        int[] character = new int[58];

        for(int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            character[ch - 'A']++;
        }



        long rank = 0;

        for(int i = 0; i < n; i++) {
            char currentCh = A.charAt(i);
            int currentChIndex = currentCh - 'A';
            long smallerString = 0;
            // how many character are smaller than current character
            for(int j = 0; j < currentChIndex; j++) {
                if(character[j] == 0) continue;
                // as we are considering we need to minus frequency by 1
                // later we also need to increase
                character[j]--;
                // permutation of remaining character
                long remainingPermutation = fact[n - i - 1];
                for(int k = 0; k < character.length; k++) {
                    if(character[k] <= 1) continue;
                    remainingPermutation = (remainingPermutation * binexp(fact[character[k]], mod - 2, mod)) % mod;
                }
                smallerString = (smallerString + remainingPermutation) % mod;
                character[j]++;
            }
            rank = (rank + smallerString) % mod;
            character[currentChIndex]--;
        }


        return (int)((rank + 1) % mod);
    }


    public long binexp(long a, int b, int m) {
        if(b == 0 || a == 1) return 1;

        long res = 1;

        while(b > 0) {
            if((b & 1) == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            b = b >> 1;
        }

        return res;
    }
}
