public class Solution {
    public ArrayList<String> letterCombinations(String A) {
        Map<Character, List<String>> digitOfLetters  = new HashMap<Character, List<String>>() {{
            put('0', Arrays.asList("0"));
            put('1', Arrays.asList("1"));
            put('2', Arrays.asList("a", "b", "c"));
            put('3', Arrays.asList("d", "e", "f"));
            put('4', Arrays.asList("g", "h", "i"));
            put('5', Arrays.asList("j", "k", "l"));
            put('6', Arrays.asList("m", "n", "o"));
            put('7', Arrays.asList("p", "q", "r", "s"));
            put('8', Arrays.asList("t", "u", "v"));
            put('9', Arrays.asList("w", "x", "y", "z"));
        }};

        ArrayList<String> result = new ArrayList<>();
        letterCombinations(A, 0, "", result, digitOfLetters);

        return result;
    }

    public void letterCombinations(String A, int index, String buffer, ArrayList<String> result,
                                   Map<Character, List<String>> digitOfLetters) {

        if(buffer.length() == A.length()) {
            result.add(buffer);
            return;
        }

        List<String> letters = digitOfLetters.get(A.charAt(index));
        for(String letter : letters) {
            letterCombinations(A, index + 1, buffer + letter, result, digitOfLetters);
        }
    }
}
