public class Solution {
    public int solve(ArrayList<Integer> A) {
        // return cutRodRecursion(A, 0, A.size());
        return cutRodDP(A, A.size());
    }

    public int cutRodRecursion(List<Integer> A, int index, int totalLength) {

        if(totalLength == 0) return 0;
        if(index == A.size()) return Integer.MIN_VALUE;

        int skip = cutRodRecursion(A, index + 1, totalLength);

        int maxPrice = skip;
        if(index + 1 <= totalLength){
            int take = A.get(index) + cutRodRecursion(A, index, totalLength - (index + 1));
            maxPrice = Math.max(maxPrice, take);
        }


        return maxPrice;
    }

    public int cutRodDP(List<Integer> A, int totalLength) {
        int[][] cache = new int[A.size()][totalLength + 1];
        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return cutRodDPHelper(A, 0, totalLength, cache);

    }

    public int cutRodDPHelper(List<Integer> A, int index, int totalLength, int[][] cache) {
        if(totalLength == 0) return 0;
        if(index == A.size()) return Integer.MIN_VALUE;

        if(cache[index][totalLength] == -1) {

            int skip = cutRodDPHelper(A, index + 1, totalLength, cache);

            int maxPrice = skip;
            if(index + 1 <= totalLength){
                int take = A.get(index) + cutRodDPHelper(A, index, totalLength - (index + 1), cache);
                maxPrice = Math.max(maxPrice, take);
            }


            cache[index][totalLength] = maxPrice;
        }

        return cache[index][totalLength];
    }
}
