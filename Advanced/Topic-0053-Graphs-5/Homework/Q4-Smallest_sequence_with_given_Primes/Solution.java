public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        Set<Integer> unique = new HashSet<>();

        ArrayList<Integer> result = new ArrayList<>();

        int i = 1;

        if(!unique.contains(A * i)) {
            unique.add(A * i);
            min.add(A * i);
        }

        if(!unique.contains(B * i)) {
            unique.add(B * i);
            min.add(B * i);
        }

        if(!unique.contains(C * i)) {
            unique.add(C * i);
            min.add(C * i);
        }

        while(D != 0) {
            i = min.poll();
            result.add(i);
            D--;
            if(!unique.contains(A * i)) {
                unique.add(A * i);
                min.add(A * i);
            }

            if(!unique.contains(B * i)) {
                unique.add(B * i);
                min.add(B * i);
            }

            if(!unique.contains(C * i)) {
                unique.add(C * i);
                min.add(C * i);
            }
        }

        return result;

    }
}
