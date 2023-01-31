public class Solution {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<Integer> subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allSubset = new ArrayList<>();

        if(A.size() == 0) {
            allSubset.add(subset);
            return allSubset;
        }

        Collections.sort(A);

        int max = Integer.MIN_VALUE;

        for(Integer num : A) {
            max = Math.max(max, num);
        }

        int[] frequency = new int[max + 1];

        for(Integer num : A) {
            frequency[num]++;
        }

        subsets(A, A.get(0), subset, allSubset, frequency);

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

    public void subsets(ArrayList<Integer> A, int index, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> allSubset, int[] frequency) {
        if(index == frequency.length) {
            allSubset.add(new ArrayList<Integer>(subset));
            return;
        }

        for(int i = index; i < frequency.length; i++) {
            if(frequency[i] > 0) {
                for(int j = 0; j <= frequency[i]; j++) {
                    int k = 0;
                    while(k < j) {
                        subset.add(i);
                        k++;
                    }
                    subsets(A, i + 1, subset, allSubset, frequency);
                    k = 0;
                    while(k < j) {
                        subset.remove(subset.size() - 1);
                        k++;
                    }

                }
                break;
            }
        }
    }
}
