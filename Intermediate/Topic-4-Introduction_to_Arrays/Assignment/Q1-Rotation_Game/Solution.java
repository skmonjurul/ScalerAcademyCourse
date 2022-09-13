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
        int[] arr = new int[A];
        for(int i=0; i<A; i++) {
            arr[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        printRotateArray(arr, B);

    }

    public static void printRotateArray(int[] arr, int k) {
        if(k == arr.length) {
            printArray(arr);
            return;
        }

        k = k % arr.length;
        int[] temp = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            temp[(i + k) % arr.length] = arr[i];
        }
        printArray(temp);
    }

    public static void printArray(int[] arr) {
        for(int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}