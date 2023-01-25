public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>((Integer o1, Integer o2) -> o2.compareTo(o1));
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();

        ArrayList<Integer> result = new ArrayList<>();

        for(Integer num : A) {
            maxPriorityQueue.offer(num);
            if(maxPriorityQueue.size() == minPriorityQueue.size() + 1) {
                if(minPriorityQueue.size() > 0 && maxPriorityQueue.peek() > minPriorityQueue.peek()) {
                    minPriorityQueue.offer(maxPriorityQueue.poll());
                    maxPriorityQueue.offer(minPriorityQueue.poll());
                }
                result.add(maxPriorityQueue.peek());
            } else {
                minPriorityQueue.offer(maxPriorityQueue.poll());
                result.add(maxPriorityQueue.peek());
            }
        }

        return result;
    }
}
