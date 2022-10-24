###Problem Description
```
Given an array, A of integers of size N. Find the maximum value of j - i such that A[i] <= A[j].
```



###Problem Constraints
```
1 <= N <= 10^5

-10^9 <= A[i] <= 10^9
```


###Input Format
```
First argument is an integer array A of size N.
```



###Output Format
```
Return an integer denoting the maximum value of j - i.
```



###Example Input
####Input 1:

```
A = [3, 5, 4, 2]
```


###Example Output
####Output 1:

```
2
```


###Example Explanation
####Explanation 1:

```
For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2.
```