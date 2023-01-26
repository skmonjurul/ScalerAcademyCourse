public class Solution {
    public int solve(ArrayList<Integer> A) {

        if(A.size() == 1) return 0;

        ArrayList<Double> prefixM = prefixMedian(A);
        ArrayList<Double> postfixM = postfixMedian(A);

        for(int i = 0; i < A.size(); i++) {

            Double num = (double)A.get(i);

            if(i == 0 && num.equals(postfixM.get(i + 1))) return 1;

            if(i == A.size() - 1 && num.equals(prefixM.get(i - 1))) return 1;

            if((i > 0 && i < A.size() - 1) && (num.equals(prefixM.get(i - 1)) || num.equals(postfixM.get(i + 1)))) return 1;
        }
        return 0;
    }

    public ArrayList<Double> postfixMedian(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>((Integer o1, Integer o2) -> o2.compareTo(o1));
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();

        ArrayList<Double> result = new ArrayList<>();

        for(int i = 0; i < A.size(); i++) {
            result.add((double)-1);
        }

        for(int i = A.size() - 1; i >= 0; i--) {
            maxPriorityQueue.offer(A.get(i));
            if(maxPriorityQueue.size() == minPriorityQueue.size() + 1) {
                if(minPriorityQueue.size() > 0 && maxPriorityQueue.peek() > minPriorityQueue.peek()) {
                    minPriorityQueue.offer(maxPriorityQueue.poll());
                    maxPriorityQueue.offer(minPriorityQueue.poll());
                }
                result.set(i, (double)maxPriorityQueue.peek());
            } else {
                minPriorityQueue.offer(maxPriorityQueue.poll());
                result.set(i, (maxPriorityQueue.peek() + (double)minPriorityQueue.peek()) / 2);
            }
        }

        return result;
    }

    public ArrayList<Double> prefixMedian(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>((Integer o1, Integer o2) -> o2.compareTo(o1));
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();

        ArrayList<Double> result = new ArrayList<>();

        for(Integer num : A) {
            maxPriorityQueue.offer(num);
            if(maxPriorityQueue.size() == minPriorityQueue.size() + 1) {
                if(minPriorityQueue.size() > 0 && maxPriorityQueue.peek() > minPriorityQueue.peek()) {
                    minPriorityQueue.offer(maxPriorityQueue.poll());
                    maxPriorityQueue.offer(minPriorityQueue.poll());
                }
                result.add((double)maxPriorityQueue.peek());
            } else {
                minPriorityQueue.offer(maxPriorityQueue.poll());
                result.add((maxPriorityQueue.peek() + (double)minPriorityQueue.peek()) / 2);
            }
        }

        return result;
    }
}
