import java.math.BigInteger;
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> arr) {

        ArrayList<Integer> res = new ArrayList<>();

        Collections.sort(arr);
        int n = arr.size();
        int rep = -1;
        int miss = -1;
        long sum = arr.get(0);

        for (int i = 1; i < n; i++) {
            if (arr.get(i).intValue() == arr.get(i - 1).intValue()) {
                rep = arr.get(i);
            }
            sum += arr.get(i);
        }

        miss = (int) ((n * ((long) n + 1)) / 2 - sum + rep);

        res.add(rep);
        res.add(miss);

        return res;
    }
}
