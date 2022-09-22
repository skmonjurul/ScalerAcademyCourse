public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> arr, int b) {
        int n = arr.size();
        int x = (b * 2) + 1;
        ArrayList<Integer> index = new ArrayList<>();

        for(int i = 0; i<= n - x; i++) {
            int end = i + (x - 1);

            int j = i;
            int k = j + 1;
            boolean flag = true;
            while(j < end && k <= end) {
                if(Objects.equals(arr.get(j), arr.get(k))) {
                    flag = false;
                    break;
                }
                j++;
                k++;
            }

            if(!flag) continue;
            int mid = (i + end) / 2;
            index.add(mid);
        }

        return index;
    }
}
