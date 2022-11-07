import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        reverse(str, str.length() - 1);
    }

    public static void reverse(String str, int index) {
        if(index < 0) return;
        System.out.print(str.charAt(index));
        reverse(str, index - 1);
    }
}