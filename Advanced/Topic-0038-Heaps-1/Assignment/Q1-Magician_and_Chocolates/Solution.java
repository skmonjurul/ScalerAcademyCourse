public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        B.sort(Collections.reverseOrder());
        long sum = 0;
        long mod = 1000 * 1000 * 1000 + 7;
        for(int i = 0; i < A; i++) {
            sum += B.get(0);
            sum %= mod;
            B.set(0, B.get(0) / 2);
            sink(B);
        }

        return (int) sum;
    }

    public void sink(ArrayList<Integer> B) {
        int rootIndex = 0;
        while(true) {
            int leftIndex = rootIndex * 2 + 1;
            int rightIndex = rootIndex * 2 + 2;


            //by default lets consider left index is the max Index
            int maxIndex = leftIndex;

            //if the left index is not present then right index will also not be present
            if(leftIndex >= B.size()) break;
            //if right index prresent and right index value is greater than left index then update max Index as right index
            if(rightIndex < B.size() && B.get(rightIndex) > B.get(leftIndex)) {
                maxIndex = rightIndex;
            }

            //check if the max index value is greater than root index
            // if yes, then swap and update the root index
            if(B.get(maxIndex) > B.get(rootIndex)) {
                //swap the elements
                int temp = B.get(rootIndex);
                B.set(rootIndex, B.get(maxIndex));
                B.set(maxIndex, temp);
                //update the root index
                rootIndex = maxIndex;
            }
            else break;

        }
    }
}
