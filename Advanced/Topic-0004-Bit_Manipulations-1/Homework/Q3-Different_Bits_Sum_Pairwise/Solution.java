public class Solution {
    public int cntBits(ArrayList<Integer> A) {

        int n = A.size();
        if(n == 1) return 0;
        double modValue = Math.pow(10, 9) + 7;
        long sum = 0;
        for(int i = 0; i < 32; i++) {
            long noOfZero = 0, noOfOne = 0;
            for(Integer num : A) {
                if(isSetBit(num, i)) noOfOne++;
            }
            noOfZero = n - noOfOne;
            sum += (noOfZero * noOfOne) * 2;
        }

        return (int) (sum % modValue);
    }


    public boolean isSetBit(int num, int k) {
        return (num & (1 << k)) != 0;
    }
}
