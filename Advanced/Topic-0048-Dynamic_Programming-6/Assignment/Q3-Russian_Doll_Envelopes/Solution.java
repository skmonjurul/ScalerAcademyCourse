public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        A.sort((list1, list2) -> {
            if(list1.get(0).equals(list2.get(0))) {
                return list1.get(1).compareTo(list2.get(1));
            }

            return list1.get(0).compareTo(list2.get(0));
        });


        // return russianDollEnvelopes_v1(A, 0);
        // return russianDollEnvelopes_v2(A, 0, -1);
        return russianDollEnvelopesDp(A);
    }

    public int russianDollEnvelopes_v1(ArrayList<ArrayList<Integer>> A, int index) {

        if(index == A.size() - 1) {
            return 1;
        }
        ArrayList<Integer> first = A.get(index);
        ArrayList<Integer> second = A.get(index + 1);

        int insert = 0;

        if(second.get(0) > first.get(0) && second.get(1) > first.get(1)) {
            insert = 1 + russianDollEnvelopes_v1(A, index + 1);
        }

        int notInsert = russianDollEnvelopes_v1(A, index + 1);

        return Math.max(insert, notInsert);
    }

    public int russianDollEnvelopes_v2(ArrayList<ArrayList<Integer>> A, int index, int prevIndex) {
        if(index == A.size() - 1) {
            if(prevIndex == -1) return 1;
            ArrayList<Integer> current = A.get(index);
            ArrayList<Integer> prev = A.get(prevIndex);
            if(current.get(0) > prev.get(0) && current.get(1) > prev.get(1)) return 2;
            return 1;
        }

        // skip part
        int skip = russianDollEnvelopes_v2(A, index + 1, prevIndex);


        int take = 0;

        if(prevIndex == -1) {
            take = russianDollEnvelopes_v2(A, index + 1, index);
        }

        else {
            ArrayList<Integer> current = A.get(index);
            ArrayList<Integer> prev = A.get(prevIndex);

            if(current.get(0) > prev.get(0) && current.get(1) > prev.get(1)) {
                take = 1 + russianDollEnvelopes_v2(A, index + 1, index);
            }
        }

        return Math.max(skip, take);
    }

    public int russianDollEnvelopesDp(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[][] cache = new int[n][n];

        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return russianDollEnvelopesDpHelper(A, 0, -1, cache);


    }

    public int russianDollEnvelopesDpHelper(ArrayList<ArrayList<Integer>> A, int index, int prevIndex, int[][] cache) {
        if(index == A.size() - 1) {
            if(prevIndex == -1) {
                cache[index][prevIndex + 1] = 1;
                return 1;
            }



            ArrayList<Integer> current = A.get(index);
            ArrayList<Integer> prev = A.get(prevIndex);
            if(current.get(0) > prev.get(0) && current.get(1) > prev.get(1)) {
                cache[index][prevIndex + 1] = 2;
                return cache[index][prevIndex + 1];
            }

            cache[index][prevIndex + 1] = 1;
            return cache[index][prevIndex + 1];
        }

        if(cache[index][prevIndex + 1] == -1) {
            // skip part
            int skip = russianDollEnvelopesDpHelper(A, index + 1, prevIndex, cache);


            int take = 0;

            if(prevIndex == -1) {
                take = russianDollEnvelopesDpHelper(A, index + 1, index, cache);
            }

            else {
                ArrayList<Integer> current = A.get(index);
                ArrayList<Integer> prev = A.get(prevIndex);

                if(current.get(0) > prev.get(0) && current.get(1) > prev.get(1)) {
                    take = 1 + russianDollEnvelopesDpHelper(A, index + 1, index, cache);
                }
            }

            cache[index][prevIndex + 1] = Math.max(skip, take);

        }

        return cache[index][prevIndex + 1];
    }
}
