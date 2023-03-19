import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test >= 1) {
            System.out.println(isPerfectNumber(sc.nextInt()));
            test--;
        }

    }

    public static String isPerfectNumber(int n) {
        int sum = 0;
        for(int i=1; i<n; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }

        if(sum == n) {
            return "YES";
        }

        return "NO";
    }
}