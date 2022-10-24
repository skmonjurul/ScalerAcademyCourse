public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int max = Integer.MIN_VALUE;
        List<List<Integer>> pairs = new ArrayList<>();

        for(int i = 0; i< A.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(A.get(i));
            temp.add(i);
            pairs.add(temp);
        }
//       Comparator<List<Integer>> listComparator = new Comparator<List<Integer>>() {
//           @Override
//           public int compare(List<Integer> o1, List<Integer> o2) {
//               return o1.get(0).compareTo(o2.get(0));
//           }
//       };



        pairs.sort((List<Integer> l1, List<Integer> l2) -> l1.get(0).compareTo(l2.get(0)));
        int maxJ = pairs.get(pairs.size() - 1).get(1);
        for(int i = pairs.size() - 1; i >=0; i--) {
            max = Math.max(max, maxJ - pairs.get(i).get(1));
            maxJ = Math.max(maxJ, pairs.get(i).get(1));
        }
        return max;
    }
}
