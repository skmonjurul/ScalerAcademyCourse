public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> heap = new ArrayList<>();

        for(int i = 0; i < A.size(); i++) {
            if(i + 1 < 3) {
                B.add(-1);
                heap.add(A.get(i));
                maxRise(heap);
            }
            else {
                heap.add(A.get(i));
                maxRise(heap);

                B.add(getProduct(heap));
            }
        }

        return B;
    }

    public int getProduct(ArrayList<Integer> heap) {
        int product = 1;

        int firstMax = getMax(heap);
        int secondMax = getMax(heap);
        int thirdMax = getMax(heap);
        heap.add(firstMax);
        maxRise(heap);
        heap.add(secondMax);
        maxRise(heap);
        heap.add(thirdMax);
        maxRise(heap);

        product *= firstMax * secondMax * thirdMax;

        return product;
    }

    public int getMax(List<Integer> A) {
        int max = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.set(A.size() - 1, max);
        A.remove(A.size() - 1);
        maxSink(A);

        return max;
    }

    public void maxRise(ArrayList<Integer> A) {
        int index = A.size() - 1;
        while(index > 0) {
            int parentIndex = (index - 1) / 2;
            if (A.get(parentIndex) < A.get(index)) {
                int temp = A.get(parentIndex);
                A.set(parentIndex, A.get(index));
                A.set(index, temp);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    public static void maxSink(List<Integer> B) {
        int rootIndex = 0;
        while(true) {
            int leftIndex = rootIndex * 2 + 1;
            int rightIndex = rootIndex * 2 + 2;

            int maxIndex = leftIndex;

            //if the left index is not present then right index will also not be present
            if(leftIndex >= B.size()) break;
            if(rightIndex < B.size() && B.get(rightIndex) > B.get(leftIndex)) {
                maxIndex = rightIndex;
            }

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
