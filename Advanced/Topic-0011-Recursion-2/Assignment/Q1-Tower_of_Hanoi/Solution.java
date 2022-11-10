import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        towerOfHanoi(A, 1, 2, 3, matrix);
        return matrix;
    }

    public void towerOfHanoi(int A, int start, int end, ArrayList<ArrayList<Integer>> arr) {
        if(A == 0) return;
        if(start + end == 3) {
            towerOfHanoi(A - 1, start, end + start, arr);
            arr.add(new ArrayList<>(Arrays.asList(A, start, end)));
            towerOfHanoi(A - 1, end + start, end, arr);
        } else {
            towerOfHanoi(A - 1, start, Math.abs(end - start), arr);
            arr.add(new ArrayList<>(Arrays.asList(A, start, end)));
            towerOfHanoi(A - 1, Math.abs(end - start), end, arr);
        }
    }

    public void towerOfHanoi(int A, int source, int temp, int destination, ArrayList<ArrayList<Integer>> arr) {
        if(A == 0) return;
        towerOfHanoi(A - 1, source, destination, temp, arr);
        arr.add(new ArrayList<>(Arrays.asList(A, source, destination)));
        towerOfHanoi(A - 1, temp, source, destination, arr);
    }
}
