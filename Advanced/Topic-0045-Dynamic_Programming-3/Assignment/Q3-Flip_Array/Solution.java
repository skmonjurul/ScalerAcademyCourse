public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        // return flipArrayRecursion(A);
        // return flipArrayDP(A);

        return minFlipBottomUp(A);
    }

    public int flipArrayDP(List<Integer> A) {
        int totalSum = 0;
        for(Integer num : A) {
            totalSum += num;
        }


        Pair[][] cache = new Pair[A.size()][2 * totalSum + 1];

        return flipArrayDPHelper(A, 0, 0, cache, totalSum).minFlip;
    }

    public Pair flipArrayDPHelper(List<Integer> A, int index, int sum, Pair[][] cache, int totalSum) {
        if(index == A.size() && sum >= 0) {
            return new Pair(sum, 0);
        }

        if(index == A.size()) {
            return new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        int correctedSum = sum + totalSum;

        if(cache[index][correctedSum] == null) {
            // skip means dont flip
            Pair skip = flipArrayDPHelper(A, index + 1, sum + A.get(index), cache, totalSum);

            // take means filp
            Pair take = flipArrayDPHelper(A, index + 1, sum - A.get(index), cache, totalSum);

            // if(take.minFlip != Integer.MAX_VALUE)
            take.minFlip += 1;

            if(skip.sum < take.sum) cache[index][correctedSum] = skip; /*new Pair(skip.sum, skip.minFlip); */

            else if(skip.sum > take.sum) cache[index][correctedSum] = take; /* new Pair(take.sum, take.minFlip); */

            else cache[index][correctedSum] = skip.minFlip < take.minFlip ? skip : take;

            /*
            else {
                if(skip.minFlip < take.minFlip)
                    cache[index][correctedSum] = new Pair(skip.sum, skip.minFlip);
                else
                    cache[index][correctedSum] = new Pair(take.sum, take.minFlip);
            }
            */
        }

        return cache[index][correctedSum];
    }

    public int flipArrayRecursion(List<Integer> A) {
        return flipArrayRecursionHelper(A, 0, 0).minFlip;
    }

    public Pair flipArrayRecursionHelper(List<Integer> A, int index, int sum) {
        if(index == A.size() && sum >= 0) {
            return new Pair(sum, 0);
        }

        if(index == A.size()) {
            return new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        // skip means dont flip
        Pair skip = flipArrayRecursionHelper(A, index + 1, sum + A.get(index));

        // take means filp
        Pair take = flipArrayRecursionHelper(A, index + 1, sum - A.get(index));
        take.minFlip += 1;

        if(skip.sum < take.sum) return skip;

        else if(skip.sum > take.sum) return take;

        else return skip.minFlip < take.minFlip ? skip : take;
    }

    public int minFlipBottomUp(List<Integer> A) {
        int totalSum = 0;
        for(Integer num : A) {
            totalSum += num;
        }

        Pair[][] minFlipRequired = new Pair[A.size() + 1][(totalSum / 2) + 1];

        // for(Pair[] temp : minFlipRequired) {
        //     Arrays.fill(temp, new Pair(0, 0));
        // }

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
