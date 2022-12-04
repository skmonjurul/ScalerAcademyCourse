public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        for(Integer num : A) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            uniqueNumbers.add(num);
        }


        int maxLength = 0, length = 0;
        for(int i = min; i <= max; i++) {
            if(uniqueNumbers.contains(i)) {
                length++;
            } else {
                length = 0;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;

    }
}
