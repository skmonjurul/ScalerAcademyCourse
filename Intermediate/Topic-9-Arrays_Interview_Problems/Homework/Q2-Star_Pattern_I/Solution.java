import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDiamond(n);

    }

    public static void printDiamond(int n) {
        int i = n *2;
        int j = n * 2;
        boolean flag = false;
        while(i >= 1) {
            int mid = j / 2;
            int space = (n * 2) - j;

            for(int k = 1; k<= mid; k++) {
                System.out.print("*");
            }

            for(int k = 1; k<= space; k++) {
                System.out.print(" ");
            }

            for(int k = 1; k<= mid; k++) {
                System.out.print("*");
            }
            System.out.println();

            if(!flag) {
                j = j - 2;
            } else {
                j = j + 2;
            }

            if(j == 0) {
                flag = !flag;
                j = j + 2;
            }

            i--;
        }
    }
}