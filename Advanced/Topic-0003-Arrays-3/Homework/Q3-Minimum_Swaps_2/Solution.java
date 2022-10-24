public class Solution {
    public int solve(ArrayList<Integer> arr) {
        int swap = 0;
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) == i) continue;
            while(arr.get(i) != i) {
                int num = arr.get(i);
                int temp = arr.get(num);
                arr.set(i, temp);
                arr.set(num, num);
                swap++;
            }
        }

        return swap;
    }
}
