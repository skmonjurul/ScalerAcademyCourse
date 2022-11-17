public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        quickSort(A, 0, A.size() - 1);
        return A;
    }
    public void quickSort(List<Integer> A, int start, int end) {
        if(start >= end) return;
        int mid = partition(A, start, end);
        quickSort(A, start, mid);
        quickSort(A, mid + 1, end);
    }


    public int partition(List<Integer> A, int start, int end) {
        int pivot = A.get(start);
        int  i = start + 1, j = end;

        while(i <= j) {
            while(i <= end && A.get(i) < pivot) i++;
            while(j >= start && A.get(j) >= pivot) j--;
            if(i < j && i <= end && j >= start) {
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
            }
        }

        A.set(start, A.get(i - 1));
        A.set(i - 1, pivot);

        return i - 1;
    }
}
