public class Solution {
    public int seats(String A) {

        List<Integer> pos = new ArrayList<>();

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == 'x') pos.add(i);
        }

        int mid = (pos.size() - 1) / 2;

        long mod = 1000 * 1000 * 10 + 3;

        long minimumJumps = 0;

        int left = mid - 1;
        int right = mid + 1;
        int k = 1;

        while(left >= 0) {
            minimumJumps += (pos.get(mid) - pos.get(left) - k) % mod;
            minimumJumps %= mod;
            left--;
            k++;
        }


        k = 1;
        while(right < pos.size()) {
            minimumJumps += (pos.get(right) - pos.get(mid) - k) % mod;
            minimumJumps %= mod;
            right++;
            k++;
        }

        return (int) minimumJumps;
    }
}
