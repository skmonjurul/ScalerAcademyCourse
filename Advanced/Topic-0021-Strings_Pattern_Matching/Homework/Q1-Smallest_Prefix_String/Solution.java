public class Solution {
    public String smallestPrefix(String A, String B) {
        int i = 1, j = 0;
        StringBuilder result = new StringBuilder();
        result.append(A.charAt(0));
        while(i < A.length()) {
            if(A.charAt(i) >= B.charAt(j)) {
                result.append(B.charAt(j));
                break;
            } else {
                result.append(A.charAt(i));
                i++;
            }
        }

        if(i == A.length()) result.append(B.charAt(0));

        return result.toString();
    }
}
