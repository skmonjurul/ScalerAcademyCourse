public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<Integer> result = new ArrayList<>();
        //to store the frequency of each element
        Map<Integer, Integer> frequency = new HashMap<>();

        //to store stack as per frequency
        Map<Integer, Stack<Integer>> frequencyStack = new HashMap<>();

        int maxFrequency = 0;

        for(ArrayList<Integer> row : A) {
            if(row.get(0) == 1) {
                int currentFreq = push(row.get(1), frequency, frequencyStack);
                //if currentFreq is greater than maxFrequency, update the maxFrequency
                if(currentFreq > maxFrequency) {
                    maxFrequency = currentFreq;
                }
                result.add(-1);
            } else {
                //pop the element
                int element = pop(maxFrequency, frequency, frequencyStack);
                //update the highest frequency
                //get the frequency of current popped element
                int fre = frequency.get(element);
                //check the corresponding stack is empty or not
                //if empty then decrease the maxFrequency
                if(frequencyStack.get(fre + 1).isEmpty()) maxFrequency--;

                result.add(element);
            }
        }

        return result;
    }

    public int push(int element, Map<Integer, Integer> frequency, Map<Integer, Stack<Integer>> frequencyStack) {
        //get the frequency from the frequency map
        int value = frequency.getOrDefault(element, 0);
        //increase the frequency and add the element back to the map
        frequency.put(element, value + 1);

        int currentFreq = value + 1;

        //now add the element into corresponding frequency stack
        Stack<Integer> stack = frequencyStack.getOrDefault(currentFreq, null);
        //if there is no stack object present, then initialize and push to the stack
        if(stack == null) {
            stack = new Stack<>();
            stack.push(element);
        } else {
            stack.push(element);
        }
        frequencyStack.put(currentFreq, stack);

        return currentFreq;
    }

    public int pop(int maxFrequency, Map<Integer, Integer> frequency, Map<Integer, Stack<Integer>> frequencyStack) {
        //get the element to be popped from corresponding stack
        int element = frequencyStack.get(maxFrequency).pop();
        //update the value in frequency map for the element
        int value = frequency.get(element);
        frequency.put(element, value - 1);

        return element;
    }
}
