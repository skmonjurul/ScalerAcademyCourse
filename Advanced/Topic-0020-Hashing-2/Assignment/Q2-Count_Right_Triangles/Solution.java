public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        if(A.size() <= 2) return 0;
        Map<Integer, List<Integer>> xpoints = new HashMap<>();
        Map<Integer, List<Integer>> ypoints = new HashMap<>();

        int n = A.size();

        for(int i = 0; i < n; i++) {
            int x = A.get(i);
            if(xpoints.containsKey(x)) {
                xpoints.get(x).add(B.get(i));
            } else {
                List<Integer> ypoint = new ArrayList<>();
                ypoint.add(B.get(i));
                xpoints.put(x, ypoint);
            }
        }


        for(int i = 0; i < n; i++) {
            int y = B.get(i);
            if(ypoints.containsKey(y)) {
                ypoints.get(y).add(A.get(i));
            } else {
                List<Integer> xpoint = new ArrayList<>();
                xpoint.add(A.get(i));
                ypoints.put(y, xpoint);
            }
        }

        long sum = 0;

        for(int i = 0; i < n; i++) {
            int x = A.get(i);
            int y = B.get(i);

            sum += (long)(xpoints.get(x).size() - 1) * (ypoints.get(y).size() - 1);

        }

        sum = sum % (1000 * 1000 * 1000 + 7);
        return (int)sum;


    }
}
