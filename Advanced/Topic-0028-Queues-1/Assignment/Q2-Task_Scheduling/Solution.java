public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        Queue<Integer> queue = new LinkedList<>();


        //first add all number from A to queue
        for(Integer num : A) {
            queue.add(num);
        }

        int noOfCycle = 0;

        for(Integer num : B) {
            //if the num is equal to first number in queue
            //then increase the noOfCycle and remove the num from queue
            if(queue.peek().equals(num)) {
                noOfCycle++;
                queue.remove();
            }

            else {
                //remove the number from front and add to end untill you got the same number
                // while doing the operation increase the noOfCycle
                while(!queue.peek().equals(num)) {
                    noOfCycle++;
                    queue.add(queue.remove());
                }

                //once you found the number
                //increase the noOfCycle and remove the number from f
                noOfCycle++;
                queue.remove();

            }
        }

        return noOfCycle;
    }
}
