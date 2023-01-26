public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<PairWithIndex> priorityQueue = new PriorityQueue<PairWithIndex>((PairWithIndex o1, PairWithIndex o2) -> {
            if (o1.num.equals(o2.num)) {
                return A.get(o1.index).compareTo(A.get(o2.index));
            }

            return o1.num.compareTo(o2.num);
        });

        ArrayList<Integer> modified = new ArrayList<>(A);

        for(int i = 0; i < modified.size(); i++) {
            priorityQueue.offer(new PairWithIndex(modified.get(i) * 2, i));
        }

        while(B > 0) {
            PairWithIndex temp = priorityQueue.poll();
            modified.set(temp.index, temp.num);
            temp.num += A.get(temp.index);
            priorityQueue.offer(temp);
            B--;
        }


        int max = Integer.MIN_VALUE;
        for(Integer num : modified) {
            max = Math.max(max, num);
        }

        return max;
    }
}

class PairWithIndex {
    int index;
    Integer num;

    public PairWithIndex(int num, int index) {
        this.num = num;
        this.index = index;
    }
}
