public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(Integer num : A) {
            priorityQueue.offer(num);
        }

        int count = 0;

        while(!priorityQueue.isEmpty() && priorityQueue.peek() <= B) {
            int candy = priorityQueue.poll();
            count += candy / 2;

            if(priorityQueue.isEmpty()) break;

            int nextMinCandy = priorityQueue.poll();
            priorityQueue.offer(nextMinCandy + (candy - candy / 2));
        }

        return count;
    }
}
