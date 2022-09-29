public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int ans = 0;
        for(int i = 0; i < A.size(); i++) {
            ans = ans ^ A.get(i);
        }

        int setBitNumber = getSetBitNumber(ans);
        int set = 0, unset = 0;

        for(int i = 0; i < A.size(); i++) {
            if(isSetBit(A.get(i), setBitNumber)) {
                set = set ^ A.get(i);
            } else {
                unset = unset ^ A.get(i);
            }
        }

        ArrayList<Integer> result = new ArrayList();
        if(set < unset){
            result.add(set);
            result.add(unset);
        } else {
            result.add(unset);
            result.add(set);
        }



        return result;


    }

    public int getSetBitNumber(int num) {
        int k = 0;
        while(num != 0) {
            if((num & 1) == 1) {
                return k;
            }

            num = num >> 1;
            k++;
        }

        return -1;
    }

    public boolean isSetBit(int num, int k) {
        return (num & (1 << k)) != 0;
    }
}
