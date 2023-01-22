public class Solution {
    public int solve(ArrayList<String> A) {
        PhoneDirectory root = new PhoneDirectory();

        for(String phoneNumber : A) {
            if(!add(root, phoneNumber)) return 0;
        }


        return 1;
    }

    public boolean add(PhoneDirectory root, String phoneNumber) {
        for(int i = 0; i < phoneNumber.length(); i++) {
            int number = Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));

            // if already prefix number is stored, then you want to insert a big number which prefix is already stored
            if(root.end >= 1) return false;

            if(root.children[number] == null) {
                PhoneDirectory temp = new PhoneDirectory();
                root.children[number] = temp;
                root = temp;
            } else {
                root = root.children[number];
                // if same number is already present as prefix, like: 001 (already present), 001(trying to insert)
                if(root.end >= 1) return false;
            }
        }

        root.end++;
        // if there are still node present that means this string is prefix
        for(int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null) return false;
        }

        return true;
    }
}


// this is my trie node
class PhoneDirectory {
    PhoneDirectory[] children;
    int end;

    public PhoneDirectory() {
        children = new PhoneDirectory[10];
    }
}
