public class Solution {
    public int paint(int A, int B, ArrayList<Integer> C) {
        int low = 0, high = 0;

        for(Integer num : C) {
            high += num;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(!isPossibleToPaintWithinGivenTime(C, A, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long time = B;

        return (int)((low * time) % 10000003);

    }

    public boolean isPossibleToPaintWithinGivenTime(ArrayList<Integer> C, int A, int expectedTime) {
        int i = 0;
        while(A > 0) {
            int time = 0;
            while(i < C.size() && time + C.get(i) <= expectedTime) {
                time += C.get(i);
                i++;
            }
            if(i == C.size()) return true;
            A--;
        }

        return false;
    }
}
