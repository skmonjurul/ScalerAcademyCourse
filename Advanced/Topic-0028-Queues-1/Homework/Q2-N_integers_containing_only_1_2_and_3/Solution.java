public class Solution {
    public ArrayList<Integer> solve(int A) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        int size = A;
        ArrayList<Integer> result = new ArrayList<>();

        while(A > 0) {
            int num = queue.remove();
            result.add(num);
            if(queue.size() < size) {
                queue.add(num * 10 + 1);
                queue.add(num * 10 + 2);
                queue.add(num * 10 + 3);
            }

            A--;
        }

        return result;


    }
}
