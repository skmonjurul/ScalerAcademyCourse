public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;

        for(Integer num : A) {
            max = Math.max(max, num);
        }

        int[] spf = new int[max + 1];
        createSPF(spf);


        ArrayList<Integer> result = new ArrayList<>();

        for(Integer num : A) {
            if(num == 1) result.add(1);
            else if(spf[num] == num) result.add(2);
            else {
                int count = 2;
                int smallestPrimeFactor = spf[num];
                for(int i = smallestPrimeFactor; i * i <= num; i++) {
                    if(num % i == 0 && num / i == i) count += 1;
                    else if(num % i == 0) count += 2;
                }

                result.add(count);
            }
        }

        return result;
    }

    public void createSPF(int[] spf) {
        for(int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }

        for(int i = 2; i * i <= spf.length - 1; i++) {
            if(spf[i] == i){
                for(int m = i * i; m <= spf.length - 1; m += i) {
                    spf[m] = Math.min(i, spf[m]);
                }
            }
        }
    }
}
