public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);

        for(int i = 0; i < B; i++) {
            A.set(0, A.get(0) * -1);
            minSink(A);
        }

        int sum = 0;
        for(Integer num : A) {
            sum += num;
        }

        return sum;

    }

    public void minSink(List<Integer> B) {
        int rootIndex = 0;

        while (true) {
            int leftIndex = rootIndex * 2 + 1;
            int rightIndex = rootIndex * 2 + 2;

            int minIndex = leftIndex;

            //if the left index is not present then right index will also not be present
            if (leftIndex >= B.size()) break;
            if (rightIndex < B.size() && B.get(rightIndex) < B.get(leftIndex)) {
                minIndex = rightIndex;
            }

            if (B.get(minIndex) < B.get(rootIndex)) {
                //swap the elements
                int temp = B.get(rootIndex);
                B.set(rootIndex, B.get(minIndex));
                B.set(minIndex, temp);
                //update the root index
                rootIndex = minIndex;
            } else break;

        }
    }
}
