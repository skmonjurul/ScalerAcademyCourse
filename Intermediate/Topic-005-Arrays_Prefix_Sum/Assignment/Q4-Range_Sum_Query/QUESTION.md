
###Problem Description
```
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
```


###Problem Constraints
```
1 <= N, M <= 10^5
1 <= A[i] <= 10^9
1 <= L <= R <= N
```

###Input Format
```
The first argument is the integer array A.
The second argument is the 2D integer array B.
```

###Output Format
```
Return an integer array of length M where ith element is the answer for ith query in B.
```


###Example Input
####Input 1:
```
A = [1, 2, 3, 4, 5]
B = [[1, 4], [2, 3]]
```
####Input 2:

```
A = [2, 2, 2]
B = [[1, 1], [2, 3]]
```

###Example Output
####Output 1:
```
[10, 5]
```
####Output 2:

```
[2, 4]
```


###Example Explanation
####Explanation 1:
```
The sum of all elements of A[1 ... 4] = 1 + 2 + 3 + 4 = 10.
The sum of all elements of A[2 ... 3] = 2 + 3 = 5.
```
####Explanation 2:

```
The sum of all elements of A[1 ... 1] = 2 = 2.
The sum of all elements of A[2 ... 3] = 2 + 2 = 4.
```