public class Solution {
    public int solve(ArrayList<Integer> arr, int B) {

        Set<Integer> unique = new HashSet<>();

        int count = 0;
        for(int i=0; i<arr.size(); i++) {
            int xor = arr.get(i) ^ B;
            if(unique.contains(xor)) count++;
            unique.add(arr.get(i));
        }

        return count;
    }
}
