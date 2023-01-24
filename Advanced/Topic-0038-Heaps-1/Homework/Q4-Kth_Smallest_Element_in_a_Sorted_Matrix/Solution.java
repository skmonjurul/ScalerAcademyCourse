public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(List<Integer> arr : A) {
            for(Integer num : arr) {
                priorityQueue.offer(num);
            }
        }


        while(B > 1) {
            priorityQueue.poll();
            B--;
        }

        return priorityQueue.poll();

    }
}
