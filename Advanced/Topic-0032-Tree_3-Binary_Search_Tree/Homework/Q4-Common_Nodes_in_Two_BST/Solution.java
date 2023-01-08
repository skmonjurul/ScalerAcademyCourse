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
        //if both null return 0
        if(A == null && B == null) return 0;

        //if only A null, update and check for B node val
        //if we didn't find B in the map then return 0,
        //otherwise return B.val
        if(A == null) {
            int value = nodeWithFrequency.getOrDefault(B.val, 0);
            nodeWithFrequency.put(B.val, value + 1);
            return value == 0 ? value : B.val;
        }


        //if only B null, update and check for A node val
        //if we didn't find A in the map then return 0,
        //otherwise return A.val
        if(B == null) {
            int value = nodeWithFrequency.getOrDefault(A.val, 0);
            nodeWithFrequency.put(A.val, value + 1);
            return value == 0 ? value : A.val;
        }

        //find the left count
        long leftCount = commonNode(A.left, B.left, mod, nodeWithFrequency);
        leftCount = leftCount % mod;

        //find the right count
        long rightCount = commonNode(A.right, B.right, mod, nodeWithFrequency);
        rightCount = rightCount % mod;

        long sum = (leftCount + rightCount) % mod;


        // if both node value are same consider the value and put in Map
        if(A.val == B.val) {
            sum += A.val;
            sum %= mod;
            nodeWithFrequency.put(A.val, 1);
        }

        //if both node value is not same
        // then find for A.val and B.val in Map, update the Map
        // if we find the val is present in Map, then consider those value also
        else {
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
