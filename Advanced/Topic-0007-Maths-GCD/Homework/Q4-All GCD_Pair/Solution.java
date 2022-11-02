public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Map<Integer, Integer> allGCD = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();


        // sort the Array in reverse order
        A.sort(Collections.reverseOrder());


        for(Integer num : A) {

            // if the number is alredy present in the hashMap and the value of the number is greater than 0
            // that means this number is not the actual number, we found this number as gcd of existing any actual pair number
            // so we need to skip and deduct 1 from its value
            if(allGCD.containsKey(num) && allGCD.get(num) > 0) {
                int value = allGCD.get(num);
                allGCD.put(num, value - 1);
            }

            // if the number is not present in the hashMap or the value of the number is 0
            // that means this is the number from the original array
            // now we need to add the number in original array
            // but before adding the number, calculate the gcd of all the number present in the original array
            // with this number, and need to store the gcd in hashMap with 2 more frequecy as gcd(a, b) == gcd (b, a)
            // we need to consider every pair, so for pair (a, b) we need to consider also (b, a);
            else {
                for(Integer originalNum : result) {
                    int value = allGCD.getOrDefault(gcd(num, originalNum), 0);
                    allGCD.put(gcd(num, originalNum), value + 2);
                }
                result.add(num);
            }
        }

        return result;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
