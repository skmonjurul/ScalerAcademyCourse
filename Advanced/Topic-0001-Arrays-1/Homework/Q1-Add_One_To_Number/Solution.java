public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
        int size = arr.size();
        int carry = 0;

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = size - 1; i >= 0; i--) {
            int digit = arr.get(i) + carry;
            if(i == size - 1){
                digit += 1;
            }
            if(digit >= 10) {
                carry = 1;
                result.add(0, 0);
            } else {
                result.add(0, digit);
                carry = 0;
            }

        }

        if(carry != 0)
            result.add(0, carry);

        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()) {
            if(!iterator.next().equals(0)){
                break;
            }
            iterator.remove();
        }
        return result;
    }
}
