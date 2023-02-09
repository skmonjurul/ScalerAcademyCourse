public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        return birthDayParty(A, B, C);
    }

    public int birthDayParty(List<Integer> A, List<Integer> B, List<Integer> C) {
        int totalMinCost = 0;

        for(Integer friendCapacity : A) {
            // totalMinCost += birthDayPartyWithRecursion(friendCapacity, B, C, 0);
            // totalMinCost += birthDayPartyWithDP(friendCapacity, B, C);
            totalMinCost += birthDayPartyBottomUp(friendCapacity, B, C);
        }

        return totalMinCost;
    }

    public int birthDayPartyWithRecursion(int friendCapacity, List<Integer> B, List<Integer> C, int index) {
        if(friendCapacity == 0) return 0;

        if(index == B.size()) return Integer.MAX_VALUE;

        int skip = birthDayPartyWithRecursion(friendCapacity, B, C, index + 1);

        int take = Integer.MAX_VALUE;
        if(B.get(index) <= friendCapacity)
            take = birthDayPartyWithRecursion(friendCapacity - B.get(index), B, C, index);

        if(take == Integer.MAX_VALUE) return skip;

        return Math.min(skip, take + C.get(index));
    }


    public int birthDayPartyWithDP(int friendCapacity, List<Integer> B, List<Integer> C) {
        int[][] cache = new int[B.size()][friendCapacity + 1];

        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return birthDayPartyWithDPHelper(friendCapacity, B, C, 0, cache);
    }

    public int birthDayPartyWithDPHelper(int friendCapacity, List<Integer> B, List<Integer> C, int index, int[][] cache) {
        if(friendCapacity == 0) return 0;

        if(index == B.size()) return Integer.MAX_VALUE;

        if(cache[index][friendCapacity] != -1) return cache[index][friendCapacity];

        int skip = birthDayPartyWithDPHelper(friendCapacity, B, C, index + 1, cache);

        int take = Integer.MAX_VALUE;
        if(B.get(index) <= friendCapacity)
            take = birthDayPartyWithDPHelper(friendCapacity - B.get(index), B, C, index, cache);

        if(take == Integer.MAX_VALUE) {
            cache[index][friendCapacity] = skip;
            return skip;
        }

        cache[index][friendCapacity] = Math.min(skip, take + C.get(index));

        return cache[index][friendCapacity];
    }

    public int birthDayPartyBottomUp(int friendCapacity, List<Integer> B, List<Integer> C) {
        int[][] minCost = new int[B.size() + 1][friendCapacity + 1];

        // fill the last row with Max value
        Arrays.fill(minCost[minCost.length - 1], Integer.MAX_VALUE);

        // put 0 in the last row first column
        minCost[minCost.length - 1][0] = 0;


        for(int index = B.size() - 1; index >= 0; index--) {
            for(int capacity = 0; capacity <= friendCapacity; capacity++) {
                // skip part
                minCost[index][capacity] = minCost[index + 1][capacity];

                // take part
                if(B.get(index) <= capacity) {
                    int take = minCost[index][capacity - B.get(index)];
                    if(take != Integer.MAX_VALUE)
                        minCost[index][capacity] = Math.min(minCost[index][capacity], take + C.get(index));
                }

            }
        }

        return minCost[0][friendCapacity];
    }


}
