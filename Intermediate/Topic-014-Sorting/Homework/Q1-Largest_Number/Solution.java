import java.lang.*;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {

        A.sort((x, y) -> {
            String first = String.valueOf(x) + y;
            String second = String.valueOf(y) + x;
            return second.compareTo(first);
        });

        StringBuilder result = new StringBuilder();
        boolean isNumber = false;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) > 0) isNumber = true;
            if(isNumber || i == A.size() - 1)
                result.append(A.get(i));
        }

        return result.toString();
    }
}
