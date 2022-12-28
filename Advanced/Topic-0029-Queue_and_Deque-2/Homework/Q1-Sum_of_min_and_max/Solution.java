public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dequeMax = new LinkedList<>();
        Deque<Integer> dequeMin = new LinkedList<>();

        int min = Math.min(A.size(), B);

        long sum = 0;
        long mod = 1000 * 1000 * 1000 + 7;

        for(int i = 0; i < min; i++) {

            //to find the max
            while(!dequeMax.isEmpty() && A.get(i) > dequeMax.peekLast()) {
                dequeMax.removeLast();
            }
            dequeMax.addLast(A.get(i));

            //to find the min
            while(!dequeMin.isEmpty() && A.get(i) < dequeMin.peekLast()) {
                dequeMin.removeLast();
            }
            dequeMin.addLast(A.get(i));
        }



        sum += (dequeMax.peek() + (long)dequeMin.peek()) % mod;
        sum %= mod;

        for(int i = min; i < A.size(); i++) {
            //to find the max
            if(A.get(i - min).equals(dequeMax.peek())) {
                dequeMax.remove();
            }
            while(!dequeMax.isEmpty() && A.get(i) > dequeMax.peekLast()) {
                dequeMax.removeLast();
            }
            dequeMax.addLast(A.get(i));

            //to find the min
            if(A.get(i - min).equals(dequeMin.peek())) {
                dequeMin.remove();
            }
            while(!dequeMin.isEmpty() && A.get(i) < dequeMin.peekLast()) {
                dequeMin.removeLast();
            }
            dequeMin.addLast(A.get(i));

            sum += (dequeMax.peek() + (long)dequeMin.peek()) % mod;
            sum %= mod;
        }

        sum = ((sum % mod) + mod) % mod;

        return (int)sum;
    }
}
