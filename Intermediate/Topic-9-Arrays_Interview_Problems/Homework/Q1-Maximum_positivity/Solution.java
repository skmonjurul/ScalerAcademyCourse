public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> arr) {

        int maxLength = Integer.MIN_VALUE;
        int index = -1;
        int startingIndex = 0;
        int i;
        for(i=0; i<arr.size(); i++) {
            if(arr.get(i) < 0) {
                int l = (i - 1) - startingIndex + 1;
                if(l > maxLength) {
                    maxLength = l;
                    index = startingIndex;
                } else if(l == maxLength) {
                    if(startingIndex < index) {
                        index = startingIndex;
                    }

                }
                startingIndex = i + 1;
                continue;
            }
        }


        int l = (i - 1) - startingIndex + 1;
        if(l > maxLength) {
            maxLength = l;
            index = startingIndex;
        } else if(l == maxLength) {
            if(startingIndex < index) {
                index = startingIndex;
            }
        }

        ArrayList<Integer> maxSubArray = new ArrayList<>();

        for(i=index; i< maxLength + index; i++){
            maxSubArray.add(arr.get(i));
        }

        return maxSubArray;

    }
}
