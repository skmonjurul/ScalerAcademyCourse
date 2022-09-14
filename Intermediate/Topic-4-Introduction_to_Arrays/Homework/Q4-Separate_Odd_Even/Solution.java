import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // no of test case

        while (T >= 1) {
            int A = sc.nextInt(); // length of the array
            int[] arr = new int[A]; // actual array
            for(int i=0; i<A; i++) {
                arr[i] = sc.nextInt();
            }

            printOddAndEven(arr);
            System.out.println();
            T--;
        }
    }

    public static void printOddAndEven(int[] arr) {
        ArrayList<Integer> even = new ArrayList();
        ArrayList<Integer> odd = new ArrayList();


        for(int i = 0; i<arr.length; i++) {
            if(arr[i] % 2 == 0){
                even.add(arr[i]);
            } else {
                odd.add(arr[i]);
            }
        }


        for(Integer num : odd) {
            System.out.print(num + " ");
        }

        System.out.println();

        for(Integer num : even) {
            System.out.print(num + " ");
        }
    }
}