public class Solution {
    public int solve(ArrayList<Integer> A) {

        // int max = Integer.MIN_VALUE;
        // for(Integer num : A) {
        //     max = Math.max(max, num);
        // }

        // int[] hash = new int[max + 1];
        Map<Integer, Integer> hash = new HashMap<>();

        for(Integer num : A) {
            int value = hash.getOrDefault(num, 0);
            hash.put(num, value + 1);
        }

        ArrayList<Integer> buffer = new ArrayList<>();

        return permutes(hash, buffer, A.size());
    }

    public int permutes(Map<Integer, Integer> hash, ArrayList<Integer> buffer, int n) {
        if(buffer.size() >= 2) {
            int size = buffer.size();
            if(!isPerfectSqaure(buffer.get(size - 2), buffer.get(size - 1))) return 0;
        }
        if(buffer.size() == n) {
            // if(sqaurefulArray(buffer)) return 1;
            if(buffer.size() >= 2) return 1;
            return 0;
        }

        int count = 0;

        for(Integer key : hash.keySet()) {
            if(hash.get(key) > 0) {
                int value = hash.get(key);
                hash.put(key, value - 1);
                buffer.add(key);
                count += permutes(hash, buffer, n);
                hash.put(key, value);
                buffer.remove(buffer.size() - 1);
            }
        }

        return count;
    }

    public boolean sqaurefulArray(ArrayList<Integer> buffer) {

        if(buffer.size() == 1) return isPerfectSqaure(buffer.get(0), 0);


        for(int i = 0; i < buffer.size() - 1; i++) {
            if(!isPerfectSqaure(buffer.get(i), buffer.get(i + 1))) return false;
        }

        return true;
    }

    public boolean isPerfectSqaure(int a, int b) {
        int x = (int) Math.sqrt((long)a + b);
        return x * x == a + b;
    }


}
