public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < B.size(); i++) {
            if(priorityQueue.size() < A) priorityQueue.offer(B.get(i));
            else {
                if(B.get(i) > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(B.get(i));
                }
            }


            if(priorityQueue.size() == A) result.add(priorityQueue.peek());
            else result.add(-1);

        }

        return result;
    }
}
