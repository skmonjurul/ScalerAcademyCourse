public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int left = 0, right = A.size() - 1;
        long count = 0;

        while(left < right) {
            int sum = A.get(left) + A.get(right);
            if(sum == B) {
                right--;
                long rightDuplicate = 1;
                while(right >=0 && Objects.equals(A.get(right), A.get(right + 1))){
                    right--;
                    rightDuplicate++;
                }

                if(right < left) {
                    count += (rightDuplicate * (rightDuplicate - 1)) / 2;
                    break;
                }

                if(rightDuplicate > 1 && A.get(right + 1) * 2 == B) {
                    count += (rightDuplicate * (rightDuplicate - 1)) / 2;
                }

                left++;
                long leftDuplicate = 1;
                while(Objects.equals(A.get(left), A.get(left - 1))){
                    left++;
                    leftDuplicate++;
                }

                if(leftDuplicate > 1 && A.get(left - 1) * 2 == B) {
                    count += (leftDuplicate * (leftDuplicate - 1)) / 2;
                }

                count += leftDuplicate * rightDuplicate;
            } else if(sum < B) {
                left++;
            } else {
                right--;
            }
        }

        return (int) (count % (1000 * 1000 * 1000 + 7));
    }
}
