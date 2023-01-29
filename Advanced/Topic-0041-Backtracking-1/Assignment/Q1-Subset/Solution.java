public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allSubset = new ArrayList<>();

        Collections.sort(A);

        subsets(A, 0, subset, allSubset);

        // allSubset.sort((ArrayList<Integer> o1, ArrayList<Integer> o2) -> {
        //     if(o2.size() == 0) return 1;
        //     return o1.get(0).compareTo(o2.get(0));
        // });

        allSubset.sort((ArrayList<Integer> o1, ArrayList<Integer> o2) -> {
            if(o2.size() == 0) return 1;
            ArrayList<Integer> temp = o1.size() < o2.size() ? o1 : o2;
            int min = Math.min(o1.size(), o2.size());
            int i;
            for(i = 0; i < min - 1; i++) {
                if(o1.get(i).equals(o2.get(i))) continue;
                return o1.get(i).compareTo(o2.get(i));
            }
            return o1.get(i).compareTo(o2.get(i));
        });

        return allSubset;
    }

    public void subsets(ArrayList<Integer> A, int index, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> allSubset) {
        if(index == A.size()) {
            allSubset.add(new ArrayList<Integer>(subset));
            return;
        }


        subsets(A, index + 1, subset, allSubset);
        subset.add(A.get(index));

        subsets(A, index + 1, subset, allSubset);
        subset.remove(subset.size() - 1);
    }
}
