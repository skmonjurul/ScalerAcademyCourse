public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i <= B; i++) {
            priorityQueue.offer(A.get(i));
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(priorityQueue.poll());

        for(int i = B + 1; i < A.size(); i++) {
            priorityQueue.offer(A.get(i));
            result.add(priorityQueue.poll());
        }

        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }

        return result;
    }
}
