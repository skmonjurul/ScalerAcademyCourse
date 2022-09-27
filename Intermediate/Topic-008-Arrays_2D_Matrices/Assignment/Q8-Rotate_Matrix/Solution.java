public class Solution {
    public void solve(ArrayList<ArrayList<Integer>> arr) {

        if(arr.size() == 1 && arr.get(0).size() == 1) return;

        int column = arr.size(); // for transpose row will be column
        int row = arr.get(0).size(); // for transpose column will be row

        transPose(arr); // transpose the array

        int left = 0;
        int right = column - 1;

        while(left < right) {
            for(int i = 0; i<row; i++) {
                int temp = arr.get(i).get(left);
                arr.get(i).set(left, arr.get(i).get(right));
                arr.get(i).set(right, temp);
            }
            left++;
            right--;
        }


        // for(ArrayList<Integer> element : arr) {
        //     for(Integer num: element) {
        //         System.out.print(num + " ");
        //     }
        //     System.out.println();
        // }



    }



    public void transPose(ArrayList<ArrayList<Integer>> arr) {
        int row = arr.size();
        int column = arr.get(0).size();

        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

        for(int j = 0; j<column; j++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0; i<row; i++) {
                tmp.add(arr.get(i).get(j));
            }

            temp.add(tmp);
        }

        int i;

        for(i = 0; i<arr.size(); i++) {
            arr.set(i, temp.get(i));
        }

        for(i = i; i<temp.size(); i++) {
            arr.add(temp.get(i));
        }

    }


}
