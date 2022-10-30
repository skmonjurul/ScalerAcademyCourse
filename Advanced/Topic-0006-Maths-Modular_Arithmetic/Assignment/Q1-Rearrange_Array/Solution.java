public class Solution {
    // public void arrange(ArrayList<Integer> a) {
    //     int[] arr = new int[a.size()];

    //     for(int i = 0; i < a.size(); i++) {
    //         arr[i] = a.get(a.get(i));
    //     }

    //     for(int i = 0; i < arr.length; i++) {
    //         a.set(i, arr[i]);
    //     }
    // }

    public void arrange(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
        for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
    }
}
