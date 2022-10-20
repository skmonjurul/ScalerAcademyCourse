###Problem Description
```
There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B
```

###Problem Constraints
```
1 <= A <= 2 * 10^5
1 <= L <= R <= A
1 <= P <= 10^3
0 <= len(B) <= 10^5
```

###Input Format
```
The first argument is a single integer A.
The second argument is a 2D integer array B.
```

###Output Format
```
Return an array(0 based indexing) that stores the total number of coins in each beggars pot.
```


###Example Input
####Input 1:
```
A = 5
B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
```
###Example Output
####Output 1:
```
10 55 45 25 25
```


###Example Explanation
####Explanation 1:-
```
First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
```