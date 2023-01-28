public class Solution {
    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((Integer o1, Integer o2) -> o2.compareTo(o1));

        for(Integer num : C) {
            minQueue.offer(num);
            maxQueue.offer(num);
        }

        int maxMoney = 0;
        int temp = A;
        while(temp > 0) {
            int price = maxQueue.poll();
            maxMoney += price;
            temp--;
            price--;
            if(price > 0)
                maxQueue.offer(price);
        }

        int minMoney = 0;
        while(A > 0) {
            int price = minQueue.poll();
            minMoney += price;
            A--;
            price--;
            if(price > 0)
                minQueue.offer(price);
        }

        ArrayList<Integer> output = new ArrayList<>();
        output.add(maxMoney);
        output.add(minMoney);

        return output;

    }
}
