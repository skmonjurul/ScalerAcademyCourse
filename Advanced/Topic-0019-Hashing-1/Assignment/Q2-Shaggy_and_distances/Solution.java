public class Solution {
    public int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minDis = Integer.MAX_VALUE;

        for(int i = 0; i < A.size(); i++) {
            if(lastSeen.containsKey(A.get(i))) {
                int distance = i - lastSeen.get(A.get(i));
                minDis = Math.min(minDis, distance);
            }
            lastSeen.put(A.get(i), i);
        }

        if(minDis == Integer.MAX_VALUE) return -1;
        return minDis;
    }
}
