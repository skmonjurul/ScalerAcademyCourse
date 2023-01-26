public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);

        PriorityQueue<SumPair> priorityQueue = new PriorityQueue<SumPair>((SumPair o1, SumPair o2) -> {
            return o2.sum.compareTo(o1.sum);
        });


        int i = A.size() - 1;
        int j = B.size() - 1;

        priorityQueue.offer(new SumPair(A.get(i) + B.get(j), i, j));

        Set<IndexPair> indexPair = new HashSet<>();
        indexPair.add(new IndexPair(i, j));

        ArrayList<Integer> result = new ArrayList<>();

        while(!priorityQueue.isEmpty()) {
            SumPair temp = priorityQueue.poll();
            result.add(temp.sum);

            if(result.size() == A.size()) break;

            i = temp.i;
            j = temp.j;

            IndexPair temp1 = new IndexPair(i - 1, j);
            IndexPair temp2 = new IndexPair(i, j - 1);

            if(!indexPair.contains(temp1)) {
                priorityQueue.offer(new SumPair(A.get(i - 1) + B.get(j), i - 1, j));
                indexPair.add(temp1);
            }

            if(!indexPair.contains(temp2)) {
                priorityQueue.offer(new SumPair(A.get(i) + B.get(j - 1), i, j - 1));
                indexPair.add(temp2);
            }

        }

        return result;
    }
}

class SumPair {
    Integer sum;
    int i;
    int j;

    public SumPair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}

class IndexPair {
    int i;
    int j;
    public IndexPair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexPair indexPair = (IndexPair) o;
        return i == indexPair.i && j == indexPair.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}