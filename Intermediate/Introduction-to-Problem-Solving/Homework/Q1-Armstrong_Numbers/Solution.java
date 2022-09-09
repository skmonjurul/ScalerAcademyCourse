import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printArmstrongNumbers(n);

    }

    public static void printArmstrongNumbers(int n) {
        for(int i = 1; i<=n; i++) {
            int temp = i;
            int sum = 0;
            while(temp != 0) {
                int digit = temp % 10;
                sum += (digit * digit * digit);
                temp = temp / 10;
            }

            if(sum == i) {
                System.out.println(i);
            }
        }
    }
}