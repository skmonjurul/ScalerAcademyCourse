public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        return minFlipBottomUp(A);
    }

    public int minFlipBottomUp(List<Integer> A) {
        int totalSum = 0;
        for(Integer num : A) {
            totalSum += num;
        }

        Pair[][] minFlipRequired = new Pair[A.size() + 1][(totalSum / 2) + 1];

        for(int i = 0; i < A.size() + 1; i++) {
            for(int sum = 0; sum <= totalSum / 2; sum++) {
                if(i == 0) {
                    minFlipRequired[i][sum] = new Pair(0, 0);
                }

                else if(sum == 0) {
                    minFlipRequired[i][sum] = new Pair(0, 0);
                }

                else {
                    if(A.get(i - 1) > sum) {
                        minFlipRequired[i][sum] = minFlipRequired[i - 1][sum];
                    }

                    else {
                        Pair temp = minFlipRequired[i - 1][sum - A.get(i - 1)];
                        Pair include = new Pair(temp.sum + A.get(i - 1), temp.minFlip + 1);
                        Pair exclude = minFlipRequired[i - 1][sum];

                        if(include.sum > exclude.sum) {
                            minFlipRequired[i][sum] = include;
                        } else if(include.sum < exclude.sum) {
                            minFlipRequired[i][sum] = exclude;
                        } else {
                            minFlipRequired[i][sum] = include.minFlip < exclude.minFlip ? include : exclude;
                        }
                    }
                }
            }
        }

        return minFlipRequired[A.size()][totalSum / 2].minFlip;
    }
}


class Pair {
    int sum;
    int minFlip;

    public Pair(int sum, int minFlip) {
        this.sum = sum;
        this.minFlip = minFlip;
    }
}