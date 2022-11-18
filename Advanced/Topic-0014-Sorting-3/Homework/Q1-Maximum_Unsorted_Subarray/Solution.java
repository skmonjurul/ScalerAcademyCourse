public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int left = 0, right = A.size() - 1, i = 0, j = A.size() - 1;

        while(i < A.size() - 1 && A.get(i) <= A.get(i + 1)){
            i++;
        }

        while(j > 0 && A.get(j) >= A.get(j - 1)) {
            j--;
        }

        ArrayList<Integer> result = new ArrayList<>(2);

        if(i == A.size() - 1) {
            result.add(-1);
            return result;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++) {
            min = Math.min(min, A.get(k));
            max = Math.max(max, A.get(k));
        }


        while(A.get(left) <= min && left <= i){
            left++;
        }

        while(A.get(right) >= max && right >= j) {
            right--;
        }

        result.add(left);
        result.add(right);

        return result;
    }
}
