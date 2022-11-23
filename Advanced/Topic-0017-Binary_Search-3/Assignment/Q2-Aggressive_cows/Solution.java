public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        long low = 1;
        int min = A.get(0);
        int max = A.get(A.size() - 1);
        long high = ((long)max - min) / (B - 1);

        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(isPossibleToPlace(A, B, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int)low;
    }

    public boolean isPossibleToPlace(ArrayList<Integer> A, int nowOfCows, long distance) {
        int i = 1, prev = A.get(0);
        nowOfCows--;
        while(nowOfCows > 0) {
            while(i < A.size() && A.get(i) - prev <= distance){
                i++;
            }

            if(i == A.size()) return false;
            prev = A.get(i);
            nowOfCows--;
        }

        return true;
    }
}
