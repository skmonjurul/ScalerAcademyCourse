import java.util.stream.Collectors;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        List<String> numbers = A.stream()
                .map(String::valueOf)
                .sorted((str1, str2) -> {
                    String firstStr = str1 + str2;
                    String secondStr = str2 + str1;

                    return secondStr.compareTo(firstStr);
                })
                .collect(Collectors.toList());

        String maxNumber = "";
        for(String number : numbers) {
            maxNumber += number;
        }

        int pos = 0;
        while(maxNumber.charAt(pos) == '0' && pos < maxNumber.length() - 1) {
            pos++;
        }

        return maxNumber.substring(pos, maxNumber.length());
    }
}
