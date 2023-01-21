###Problem Description
```
Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.

NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.
```


###Problem Constraints
```
1 <= N <= 100000
0 <= A[i] <= 10^9
```


###Input Format
```
First and only argument is an integer array A.
```


###Output Format
```
Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.
```

###Example Input
####Input 1:

```
A = [1, 4, 3]
```
####Input 2:

```
A = [8]
```


###Example Output
####Output 1:

```
[2, 3]
```
####Output 2:

```
[1, 1]
```


###Example Explanation
####Explanation 1:

```
There are 6 possible subarrays of A:
subarray            XOR value
[1]                     1
[4]                     4
[3]                     3
[1, 4]                  5 (1^4)
[4, 3]                  7 (4^3)
[1, 4, 3]               6 (1^4^3)

[4, 3] subarray has maximum XOR value. So, return [2, 3].
```
####Explanation 2:

```
There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1]. 
```