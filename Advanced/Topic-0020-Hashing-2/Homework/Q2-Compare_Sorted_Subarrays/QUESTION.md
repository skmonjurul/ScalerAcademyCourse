###Problem Description
```
Given an array A of length N. You have to answer Q queries.

Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.

NOTE The queries are 0-indexed.
```


###Problem Constraints
```
0 <= A[i] <= 100000
1 <= N <= 100000
1 <= Q <= 100000
```


###Input Format
```
The first argument is an array A.
The second is a 2D array B denoting queries with dimension Q * 4.
Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].
```


###Output Format
```
Return an array of length Q with answers to the queries in the same order as the input.
```



###Example Input
####Input 1:

```
A = [1, 7, 11, 8, 11, 7, 1]
B = [
        [0, 2, 4, 6]
    ]
```
####Input 2:

```
A = [1, 3, 2]
B = [
        [0, 1, 1, 2]
    ]
```

###Example Output
####Output 1:

```
[1]
```
####Output 2:

```
[0]
```


###Example Explanation
####Explanation 1:

```
(0, 2) -> [1, 7, 11]
(4, 6) -> [11, 7, 1]
Both are same when sorted hence 1.
```
####Explanation 2:

```
(0, 1) -> [1, 3]
(1, 2) -> [3, 2]
Both are different when sorted hence 0.
```