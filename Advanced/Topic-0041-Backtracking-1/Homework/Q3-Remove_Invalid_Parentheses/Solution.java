public class Solution {
    public ArrayList<String> solve(String A) {
        Integer offLeft = 0, offRight = 0;

        // setOffounts(A, offLeft, offRight);

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '(') offLeft++;
            if(A.charAt(i) == ')') {
                if(offLeft > 0) offLeft--;
                else offRight++;
            }
        }

        Set<String> result = new HashSet<>();

        removeInvalidParenthesis(A, 0, "", offLeft, offRight, 0, result);

        return new ArrayList<String>(result);
    }


    public void removeInvalidParenthesis(String A, int index, String current, Integer offLeft, Integer offRight, int balance, Set<String> result) {
        if(index == A.length()) {
            if(offLeft == 0 && offRight == 0) {
                result.add(current);

            }
            return;
        }


        if(balance >= 0) {
            if(A.charAt(index) == '(' && offLeft > 0) {
                removeInvalidParenthesis(A, index + 1, current, offLeft - 1, offRight, balance, result);
            }

            if(A.charAt(index) == ')' && offRight > 0) {
                removeInvalidParenthesis(A, index + 1, current, offLeft, offRight - 1, balance, result);
            }

            int diff = 0;
            if(A.charAt(index) == '(') diff = 1;
            if(A.charAt(index) == ')') diff = -1;

            removeInvalidParenthesis(A, index + 1, current + String.valueOf(A.charAt(index)), offLeft, offRight, balance + diff, result);
        }
    }

    public void setOffounts(String A, Integer offLeft, Integer offRight) {
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '(') offLeft++;
            if(A.charAt(i) == ')') {
                if(offLeft > 0) offLeft--;
                else offRight++;
            }
        }
    }

}
