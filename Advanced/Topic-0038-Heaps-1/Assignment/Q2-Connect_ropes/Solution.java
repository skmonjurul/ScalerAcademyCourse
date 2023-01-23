public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int sum = 0;

        while(A.size() > 1) {
            int first = getMin(A);
            int second = getMin(A);

            sum += first + second;
            A.add(first + second);
            minRise(A);
        }

        return sum;
    }

    public void minRise(List<Integer> A) {
        int index = A.size() - 1;
        while(index > 0) {
            int parentIndex = (index - 1) / 2;
            if (A.get(parentIndex) > A.get(index)) {
                int temp = A.get(parentIndex);
                A.set(parentIndex, A.get(index));
                A.set(index, temp);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    public int getMin(List<Integer> A) {
        int min = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.set(A.size() - 1, min);
        A.remove(A.size() - 1);
        minSink(A);

        return min;
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
