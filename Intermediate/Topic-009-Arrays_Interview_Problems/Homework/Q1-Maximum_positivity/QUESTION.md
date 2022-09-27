###Problem Description
```
Given an array of integers A, of size N.

Return the maximum size subarray of A having only non-negative elements. If there are more than one such subarray, return the one having the smallest starting index in A.

NOTE: It is guaranteed that an answer always exists.
```


###Problem Constraints
```
1 <= N <= 10^5

-10^9 <= A[i] <= 10^9
```


###Input Format
```
The first and only argument given is the integer array A.
```



###Output Format
```
Return maximum size subarray of A having only non-negative elements. If there are more than one such subarrays, return the one having earliest starting index in A.
```



###Example Input
####Input 1:

```
A = [5, 6, -1, 7, 8]
```
####Input 2:

```
A = [1, 2, 3, 4, 5, 6]
```


###Example Output
####Output 1:

```
[5, 6]
```
####Output 2:

```
[1, 2, 3, 4, 5, 6]
```


###Example Explanation
####Explanation 1:

```
There are two subarrays of size 2 having only non-negative elements.
1. [5, 6]  starting point  = 0
2. [7, 8]  starting point  = 3
As starting point of 1 is smaller, return [5, 6]
```
####Explanation 2:

```
There is only one subarray of size 6 having only non-negative elements:
[1, 2, 3, 4, 5, 6]
```