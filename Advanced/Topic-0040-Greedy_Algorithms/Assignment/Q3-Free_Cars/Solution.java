public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> cars = new ArrayList<>();


        // first create the pair
        for(int i = 0; i < A.size(); i++) {
            cars.add(new Pair(A.get(i), B.get(i)));
        }

        // sort by time in ascending order
        cars.sort((c1, c2) -> c1.time.compareTo(c2.time));

        // create a min heap to find the min profit till at point of time
        PriorityQueue<Pair> priorityqueue = new PriorityQueue<>((Pair p1, Pair p2) -> p1.profit.compareTo(p2.profit));


        // go through the pair ArrayList
        // check the size of min heap is less than the pair time, if yes then add the pair to min heap
        // if it is equal then search for the min profit pair,
        // and check current pair profit is grater than the min profit, if yes then remove the min profit, and add the current pair
        for(int i = 0; i < cars.size(); i++) {
            if(priorityqueue.size() < cars.get(i).time) {
                priorityqueue.offer(cars.get(i));
            } else if(cars.get(i).profit > priorityqueue.peek().profit) {
                priorityqueue.poll();
                priorityqueue.offer(cars.get(i));
            }
        }

        long maxProfit = 0;
        long mod = 1000 * 1000 * 1000 + 7;

        // calculate the total profit
        // total profit can be very large so, do modulo with the 10^9 + 7
        while(!priorityqueue.isEmpty()) {
            maxProfit = (maxProfit % mod) + (priorityqueue.poll().profit % mod);
            maxProfit %= mod;
        }


        return (int)maxProfit;
    }
}

class Pair {
    Integer time;
    Integer profit;

    public Pair(int time, int profit) {
        this.time = time;
        this.profit = profit;
    }
}
