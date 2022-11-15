public class Solution {
    public int solve(ArrayList<Integer> A) {
        return mergeAndCount(A, 0, A.size() - 1, 0);
    }

    public int mergeAndCount(ArrayList<Integer> A, int start, int end, int count) {

        if(start >= end) return count;

        int mid = start + (end - start)/2;
        int leftCount = mergeAndCount(A, start, mid, count);
        int rightCount = mergeAndCount(A, mid + 1, end, count);
        return mergeCount(A, start, mid, end, leftCount + rightCount);
    }

    public int mergeCount(ArrayList<Integer> A, int start, int mid, int end, int count) {
        ArrayList<Integer> C = new ArrayList<>();
        int i = start, j = mid + 1;
        //count the condition
        while(i <= mid && j <= end) {
            if(A.get(i) > A.get(j) * 2L) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        //start the sorting and merging

        i = start;
        j = mid + 1;

        while(i <= mid && j <= end) {
            if(A.get(i) <= A.get(j)) {
                C.add(A.get(i));
                i++;
            } else {
                C.add(A.get(j));
                j++;
            }
        }

        while(i <= mid) {
            C.add(A.get(i));
            i++;
        }

        while(j <= end) {
            C.add(A.get(j));
            j++;
        }

        i = start;
        for(Integer num : C) {
            A.set(i, num);
            i++;
        }

        return count;

    }
}
