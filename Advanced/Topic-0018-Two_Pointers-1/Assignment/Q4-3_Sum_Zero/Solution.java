public class Solution {
    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

        // the problem is almost same as Q5. Pairs with given sum II
        // the only difference is we need an additional element
        // the same logic we can use as Q5, only we need an additional loop for the third element
        // so we can traverse the array, for each element we can apply the Q5 logic
        // here is one more thing we need to ignore duplicate elements


        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < A.size() ; i++) {
            // ignore the dupliacate elements
            if(i > 0 && Objects.equals(A.get(i), A.get(i - 1))) continue;
            // consider the diff as B of Q5
            int diff = 0 - A.get(i);
            int left = i + 1, right = A.size() - 1;
            while(left < right) {
                int sum = 0;
                if(left >= right) break;

                sum = A.get(left) + A.get(right);

                if(sum == diff){
                    ArrayList<Integer> temp = new ArrayList<>();
                    // we need to insert in non-descending order. (ie, a <= b <= c)
                    temp.add(A.get(i));
                    temp.add(A.get(left));
                    temp.add(A.get(right));

                    result.add(temp);
                    // we need to ignore duplicate
                    right--;
                    while(right >= 0 && Objects.equals(A.get(right), A.get(right + 1))) right--;

                    // we need to ignore duplicate
                    left++;
                    while(left < A.size() && Objects.equals(A.get(left), A.get(left - 1))) left++;

                } else if(sum < diff) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;

    }
}
