public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> buffer = new ArrayList<>();

        Set<Integer> distinctElement = new HashSet<>(A);
        ArrayList<Integer> arr = new ArrayList<>();

        for(Integer num : distinctElement) {
            arr.add(num);
        }

        Collections.sort(arr);

        combinationSum(arr, 0, 0, B, buffer, result);

        Collections.sort(result, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });

        return result;
    }

    public void combinationSum(ArrayList<Integer> A, int index, int sum, int target, ArrayList<Integer> buffer, ArrayList<ArrayList<Integer>> result) {
        if(sum == target) {
            result.add(new ArrayList<Integer> (buffer));
            return;
        }

        if(sum > target || index == A.size()) return;

        int element = A.get(index);
        int maxNoOfTimes = target / element;

        for(int i = 0; i <= maxNoOfTimes; i++) {

            int k = 0;
            int total = 0;

            while(k < i) {
                buffer.add(element);
                total += element;
                k++;
            }

            combinationSum(A, index + 1, sum + total, target, buffer, result);

            k = 0;
            while(k < i) {
                buffer.remove(buffer.size() - 1);
                k++;
            }

        }
    }
}
