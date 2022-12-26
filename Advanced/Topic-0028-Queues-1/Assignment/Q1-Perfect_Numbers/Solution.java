public class Solution {
    public String solve(int A) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");

        int size = A;

        String result = "";

        while(!queue.isEmpty() && A > 0) {
            String num = queue.peek();

            if(queue.size() < size) {
                queue.add(num + "1");
                queue.add(num + "2");
            }
            result = queue.remove();
            A--;
        }

        return new StringBuilder(result).append(new StringBuilder(result).reverse()).toString();
    }
}
