public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> arr) {
        int product = 1;

        for(int i=0; i < arr.size(); i++) {
            product *= arr.get(i);
        }


        ArrayList<Integer> productArr = new ArrayList<>();
        for(int i=0; i<arr.size(); i++) {
            productArr.add(product / arr.get(i));
        }

        return productArr;
    }
}
