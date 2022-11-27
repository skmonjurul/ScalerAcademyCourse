public class Solution {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int[] colours = new int[3];
        for(Integer num : A) {
            colours[num]++;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int j = 0; j < colours.length; j++) {
            for(int i = 1; i <= colours[j]; i++) {
                result.add(j);
            }
        }

        return result;
    }
}
