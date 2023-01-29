public class Solution {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for(Integer num : A) {
            max = Math.max(max, num);
        }

        int[] hash = new int[max + 1];

        for(Integer num : A) {
            hash[num]++;
        }

        ArrayList<Integer> buffer = new ArrayList<>();

        permutes(hash, buffer, result, A.size());

        return result;
    }

    public void permutes(int[] hash, ArrayList<Integer> buffer, ArrayList<ArrayList<Integer>> result, int n) {
        if(buffer.size() == n) {
            result.add(new ArrayList<Integer> (buffer));
            return;
        }


        for(int i = 0; i < hash.length; i++) {
            if(hash[i] > 0) {
                hash[i]--;
                buffer.add(i);
                permutes(hash, buffer, result, n);
                hash[i]++;
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
