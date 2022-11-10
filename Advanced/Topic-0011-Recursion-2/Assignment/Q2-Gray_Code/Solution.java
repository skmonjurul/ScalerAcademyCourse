public class Solution {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        grayCode(a, result);
        return result;
    }

    public void grayCode(int n, ArrayList<Integer> result) {
        if(n == 1){
            result.add(0);
            result.add(1);
            return;
        }

        grayCode(n - 1, result);

        int addNumber = 1 << (n - 1);
        int startIndex = result.size() - 1;

        for(int index = startIndex; index >= 0; index--) {
            result.add(result.get(index) + addNumber);
        }
    }
}
