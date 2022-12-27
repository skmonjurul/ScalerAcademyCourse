public class Solution {
    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> frequency = new HashMap<>();

        StringBuilder B = new StringBuilder();

        for(int i = 0; i < A.length(); i++) {
            queue.add(A.charAt(i));
            int value = frequency.getOrDefault(A.charAt(i), 0);
            frequency.put(A.charAt(i), value + 1);

            while (!queue.isEmpty() && frequency.get(queue.peek()) > 1) {
                queue.remove();
            }

            if(queue.isEmpty()) {
                B.append("#");
            } else {
                B.append(queue.peek());
            }
        }

        return B.toString();
    }
}
