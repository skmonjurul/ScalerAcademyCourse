public class Solution {
    public ArrayList<Integer> primesum(int A) {
        int[] spf = new int[A + 1];

        //create the spf array

        for(int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }

        for(int i = 2; i * i <= A; i++) {
            if(spf[i] == i) {
                for(int m = i * i; m <= A; m += i) {
                    spf[m] = Math.min(i, spf[m]);
                }
            }
        }

        int first = -1, second = -1;

        for(int i = A - 1; i >=2; i--) {
            if(spf[i] == i) {
                if(A - i > 1 && spf[A - i] == A - i) {
                    first = A - i;
                    second = i;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(second);

        return result;
    }
}
