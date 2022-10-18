public class Solution {
    public ArrayList<Integer> grayCode(int a) {
        return grayCode(a, new ArrayList<>());
    }


    public ArrayList<Integer> grayCode(int a, ArrayList<Integer> result) {
        if(a == 1) {
            result.add(0);
            result.add(1);
            return result;
        }

        result = grayCode(a - 1, result);
        int n = result.size();

        double number = Math.pow(2, a - 1);

        for(int i=n-1; i >= 0; i--) {
            result.add((int) (result.get(i) + number));
        }

        return result;
    }
}
