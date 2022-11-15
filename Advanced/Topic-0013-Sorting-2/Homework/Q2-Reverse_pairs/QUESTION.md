###Problem Description
```
Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.
```


###Problem Constraints
```
1 <= length of the array <= 10^5

-2 * 10^9 <= A[i] <= 2 * 10^9
```


###Input Format
```
The only argument given is the integer array A.
```



###Output Format
```
Return the number of important reverse pairs in the given array A.
```



###Example Input
####Input 1:

```
A = [1, 3, 2, 3, 1]
```
####Input 2:

```
A = [4, 1, 2]
```


###Example Output
####Output 1:

```
2
```
####Output 2:

```
1
```


###Example Explanation
####Explanation 1:

```
There are two pairs which are important reverse i.e (3, 1) and (3, 1).
```
####Explanation 2:

```
There is only one pair i.e (4, 1).
```