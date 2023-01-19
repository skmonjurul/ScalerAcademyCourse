public class Solution {
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        Set<String> words = new HashSet<>(A);
        ArrayList<Integer> result = new ArrayList<>();

        for(String word : B) {
            if(words.contains(word)) {
                result.add(1);
            } else {
                result.add(0);
            }
        }

        return result;
    }
}
