public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> arr, ArrayList<Integer> k) {

        ArrayList<ArrayList<Integer>> rotatedArray = new ArrayList<>();
        for(Integer rotateNumber : k) {
            rotatedArray.add(rotateArray(arr, rotateNumber));
        }

        return rotatedArray;
    }



    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        if(k == n) return arr;

        k = k % n;

        ArrayList<Integer> modifiedArr = getReverse(arr, 0, n-1);
        reverse(modifiedArr, 0, (n - k) - 1);
        reverse(modifiedArr, (n - k), n - 1);

        return modifiedArr;
    }

    private static ArrayList<Integer> getReverse(ArrayList<Integer> arr, int start, int end) {

        ArrayList<Integer> modifiedArr = new ArrayList<>();
        for(int i = end; i >= start; i--) {
            modifiedArr.add(arr.get(i));
        }

        return modifiedArr;
    }

    public static void reverse(ArrayList<Integer> arr, int start, int end) {
        int left = start, right = end;

        while(left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
    }
}
