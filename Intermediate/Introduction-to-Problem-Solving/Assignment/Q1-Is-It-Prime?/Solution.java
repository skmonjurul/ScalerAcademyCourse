import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isPrime = isPrime_v2(n);
        if(isPrime) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static boolean isPrime_v2(int n) {
        int count = 0;
        for(int i=1; i * i <= n; i++) {
            if((i * (n/i)) == n) {
                count += 2;
            }
        }

        return count == 2 ? true : false;
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for(int i=2; i<n; i++) {
            if(n % i == 0) {
                count++;
            }
        }

        return count != 0 ? false : true;
    }
}