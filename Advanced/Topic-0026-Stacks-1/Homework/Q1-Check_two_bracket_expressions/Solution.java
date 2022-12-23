public class Solution {
    public int solve(String A, String B) {
        Stack<Boolean> stack = new Stack<>();

        boolean[] adjacentSignA = new boolean[26];
        boolean[] adjacentSignB = new boolean[26];

        //true for +, false for -

        stack.push(true);


        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch == '+' || ch == '-') {
                continue;
            } else if(ch == '(') {
                if(adjacentSign(A, i - 1)) {
                    stack.push(stack.peek());
                } else {
                    stack.push(!stack.peek());
                }
            } else if(ch == ')') {
                if(!stack.isEmpty()) stack.pop();
            } else {
                if(stack.isEmpty() || stack.peek()) {
                    adjacentSignA[ch - 'a'] = adjacentSign(A, i - 1);
                } else {
                    adjacentSignA[ch - 'a'] = !adjacentSign(A, i - 1);
                }
            }

        }


        stack.clear();
        stack.push(true);


        for(int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if(ch == '+' || ch == '-') {
                continue;
            } else if(ch == '(') {
                if(adjacentSign(B, i - 1)) {
                    stack.push(stack.peek());
                } else {
                    stack.push(!stack.peek());
                }
            } else if(ch == ')') {
                if(!stack.isEmpty()) stack.pop();
            } else {
                if(stack.isEmpty() || stack.peek()) {
                    adjacentSignB[ch - 'a'] = adjacentSign(B, i - 1);
                } else {
                    adjacentSignB[ch - 'a'] = !adjacentSign(B, i - 1);
                }
            }

        }

        for(int i = 0; i < adjacentSignA.length; i++) {
            if(adjacentSignA[i] != adjacentSignB[i]) return 0;
        }


        return 1;
    }

    public boolean adjacentSign(String str, int i) {
        if(i < 0) return true;
        return str.charAt(i) != '-';
    }
}
