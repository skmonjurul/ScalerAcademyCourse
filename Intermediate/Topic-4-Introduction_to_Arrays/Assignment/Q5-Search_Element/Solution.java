import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i< T; i++) {
            int A = sc.nextInt();
            int[] arr = new int[A];
            for(int j=0; j<A; j++) {
                arr[j] = sc.nextInt();
            }
            int B = sc.nextInt();
            System.out.println(isPresent(arr, B));
        }

    }

    public static int isPresent(int[] arr, int element) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == element) return 1;
        }

        return 0;
    }
}