/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int solve(TreeNode A, TreeNode B) {
        Map<Integer, Integer> nodeWithFrequency = new HashMap<>();
        long count = commonNode(A, B, 1000 * 1000 * 1000 + 7, nodeWithFrequency);
        return (int)count;
    }

    public long commonNode(TreeNode A, TreeNode B, long mod, Map<Integer, Integer> nodeWithFrequency) {
        if(A == null && B == null) return 0;

        if(A == null) {
            int value = nodeWithFrequency.getOrDefault(B.val, 0);
            nodeWithFrequency.put(B.val, value + 1);
            return value == 0 ? value : B.val;
        }

        if(B == null) {
            int value = nodeWithFrequency.getOrDefault(A.val, 0);
            nodeWithFrequency.put(A.val, value + 1);
            return value == 0 ? value : A.val;
        }

        long leftCount = commonNode(A.left, B.left, mod, nodeWithFrequency);
        leftCount = leftCount % mod;
        long rightCount = commonNode(A.right, B.right, mod, nodeWithFrequency);
        rightCount = rightCount % mod;

        long sum = (leftCount + rightCount) % mod;

        if(A.val == B.val) {
            sum += A.val;
            sum %= mod;
            nodeWithFrequency.put(A.val, 1);
        } else {
            int aFre = nodeWithFrequency.getOrDefault(A.val, 0);
            nodeWithFrequency.put(A.val, aFre + 1);
            int bFre = nodeWithFrequency.getOrDefault(B.val, 0);
            nodeWithFrequency.put(B.val, bFre + 1);
            if(aFre > 0) {
                sum += A.val;
                sum %= mod;
            }
            if(bFre > 0) {
                sum += B.val;
                sum %= mod;
            }
        }


        return sum;


    }
}
