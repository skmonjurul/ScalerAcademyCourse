public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int min = Math.min(A.size(), B);

        for(int i = 0; i < min; i++) {
            while(!deque.isEmpty() && A.get(i) > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(A.get(i));
        }

        result.add(deque.peek());

        for(int i = min; i < A.size(); i++) {
            if(A.get(i - min).equals(deque.peek())) {
                deque.remove();
            }
            while(!deque.isEmpty() && A.get(i) > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(A.get(i));

            result.add(deque.peek());
        }

        return result;
    }
}
