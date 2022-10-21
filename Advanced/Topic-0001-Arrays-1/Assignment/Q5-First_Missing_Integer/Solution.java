public class Solution {
    public int firstMissingPositive(ArrayList<Integer> arr) {
        int n = arr.size();

        for(int i = 0; i < n; i++) {
            int index = i;
            int num = arr.get(index);
            while(num != index + 1 && num != 0 && num > 0 && num <= n && arr.get(num - 1) != num) {

                int temp = arr.get(num - 1);
                arr.set(index, temp);
                arr.set(num - 1, num);
                num = arr.get(index);

            }
        }

        for(int i = 0; i < n; i++) {
            if(arr.get(i) != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
