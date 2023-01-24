public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Comparator<PrimePairFraction> comparator = new Comparator<PrimePairFraction>() {
            @Override
            public int compare(PrimePairFraction o1, PrimePairFraction o2) {
                return o1.fraction.compareTo(o2.fraction);
            }
        };

        PriorityQueue<PrimePairFraction> priorityQueue = new PriorityQueue<>(comparator);

        int n = A.size();

        for(int i = 0; i < n; i++) {
            PrimePairFraction primePairFraction = new PrimePairFraction(i, n - 1,
                    A.get(i) / (double)A.get(n - 1));

            priorityQueue.offer(primePairFraction);
        }

        ArrayList<Integer> result = new ArrayList<>();



        while(!priorityQueue.isEmpty() && B > 0) {
            PrimePairFraction primePairFraction = priorityQueue.poll();
            B--;

            if(B == 0) {
                result.add(A.get(primePairFraction.firstIndex));
                result.add(A.get(primePairFraction.secondIndex));
                return result;
            }

            int firstIndex = primePairFraction.firstIndex;
            int secondIndex = primePairFraction.secondIndex;

            if(secondIndex - 1 > firstIndex) {
                PrimePairFraction temp = new PrimePairFraction(firstIndex, secondIndex - 1,
                        A.get(firstIndex) / (double)A.get(secondIndex - 1));
                priorityQueue.offer(temp);
            }

        }

        return result;
    }
}

class PrimePairFraction {
    int firstIndex;
    int secondIndex;
    Double fraction;

    public PrimePairFraction(int firstIndex, int secondIndex, double fraction) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.fraction = fraction;
    }
}
