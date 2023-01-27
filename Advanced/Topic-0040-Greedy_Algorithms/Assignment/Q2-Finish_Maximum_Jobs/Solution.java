public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<Pair> jobsTiming = new ArrayList<>();


        for(int i = 0; i < A.size(); i++) {
            jobsTiming.add(new Pair(A.get(i), B.get(i)));
        }

        jobsTiming.sort((j1, j2) -> j1.end.compareTo(j2.end));

        int count = 1;
        int prev = 0;

        for(int i = 1; i < jobsTiming.size(); i++) {
            if(jobsTiming.get(i).start >= jobsTiming.get(prev).end) {
                count++;
                prev = i;
            }
        }

        return count;
    }
}


class Pair {
    Integer start;
    Integer end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}