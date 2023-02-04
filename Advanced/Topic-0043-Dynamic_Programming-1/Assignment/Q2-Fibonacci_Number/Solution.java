import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int[] cache = new int[A + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        System.out.print(fibDPWithBottomUp(A, cache));
    }

    public static int fib(int A) {
        if(A <= 1) return A;
        return fib(A - 2) + fib(A - 1);
    }

    public static int fibWithDP(int A, int[] cache) {
        if(A == 0) return cache[A];
        if(A == 1) return cache[A];

        if(cache[A] == -1) {
            cache[A] = fibWithDP(A - 1, cache) + fibWithDP(A - 2, cache);
        }

        return cache[A];
    }

    public static int fibDPWithBottomUp(int A, int[] cache) {
        for(int i = 2; i <= A; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[A];
    }
}