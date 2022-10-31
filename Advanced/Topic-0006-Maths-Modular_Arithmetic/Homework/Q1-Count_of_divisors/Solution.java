public class Solution {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        return countDivisors_v2(A);
    }

    public ArrayList<Integer> countDivisors_v2(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        // array to store the smallest prime factor of number
        int[] smallestPrimeFactor = new int[1001001];
        // sieve formula to to calculate the smallest prime factor of a number
        // url: https://www.geeksforgeeks.org/sieve-of-eratosthenes/
        sieve(smallestPrimeFactor);

        for(Integer num : A) {
            result.add(countFactor_v2(num, smallestPrimeFactor));
        }

        return result;
    }

    public int countFactor_v2(int n, int[] smallestPrimeFactor) {
        int ans = 1;

        // get the smallest prime factor , check if it is not 1
        // lets say the number is 10, the prime factor are 2 and 5, now the total factor of 10 is 4, how: p1 and p2 are prime factor
        // then the no of total factor is the power of p1 and p2, lets say x and y. so (x + 1) (y + 1) will be the no of total factor
        // for 10, prime factors are 2 and 5, so 2 ^ 1 and 5 ^ 1, so (1 + 1) * (1 * 1) ==> 4
        // lets say the number 60 , then prime factor are 2, 3 and 5, so 2 ^ 2, 3 ^ 1, 5 ^ 1, so (2 + 1)*(1 + 1)*(1 + 1) ==> 12
        // 60: 1, 60, 2, 30, 3, 20, 4, 15, 5, 12, 6, 10
        while(smallestPrimeFactor[n] != 1) {
            // get the smallest prime factor
            int spf = smallestPrimeFactor[n];

            // now we need to count the power of smallest prime factor
            // initially count is 1 as we need to do power + 1
            int count = 1;

            while(n != 1 && n % spf == 0) {
                //count the power
                count++;
                n /= spf;
            }
            // count total no of factors
            ans *= count;
        }

        return ans;
    }

    public void sieve(int[] smallestPrimeFactor) {
        int n = smallestPrimeFactor.length;
        for(int i = 1; i < n; i++) {
            smallestPrimeFactor[i] = i;
        }

        for(int i = 2; i * i <= n; i++) {
            if(smallestPrimeFactor[i] != i) continue;
            for(int j = i * i; j < n; j += i) {
                if(smallestPrimeFactor[j] == j) smallestPrimeFactor[j] = i;
            }
        }
    }




    public ArrayList<Integer> countDivisors_v1(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        for(Integer num : A) {
            result.add(countFactor_v1(num));
        }

        return result;
    }

    /**
     to count the no of factor of a number
     **/
    public int countFactor_v1(int num) {
        int count = 0;
        // traverse from 1 to squrt(num)
        // for example, num = 36,  the factors are: 1, 2, 3, 4, 6, 9, 12, 18, 36
        // for 1 there is 36, for 2 there is 18, for 3 there is 12, for 4 there is 9,
        // now if you see 36 is perfect squrt, so we can not count 6 times
        for(int i = 1; i * i <= num; i++) {

            // if the num is divided by i and i ^ 2 is not equal to the num, then we can count by 2
            if(num % i == 0 && i * i != num) count += 2;
                //if the num is divided by i and i ^ 2 is equal to the num, then increase the count by 1
            else if(num % i == 0) count++;
        }

        return count;
    }
}
