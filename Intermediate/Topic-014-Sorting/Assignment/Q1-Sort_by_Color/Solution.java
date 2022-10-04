public class Solution {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int zero = 0;
        int two = A.size() - 1;

        for(int i = 0; i <= two;) {
            if(A.get(i) == 0) {
                int temp = A.get(zero);
                A.set(zero, 0);
                A.set(i, temp);
                zero++;
                i++;
            } else if(A.get(i) == 2) {
                int temp = A.get(two);
                A.set(two, 2);
                A.set(i, temp);
                two--;
            } else {
                i++;
            }
        }

        return A;
    }
}
