###Problem Description
```
Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.

A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.
```


###Input Format

```
The first argument given is an Array A, having N integers.
```
###Output Format

```
Return an integer X, i.e number of Prime subsequences.
As X can be very large print X % (1000000007), here % is modulus operator.
```
###Constraints

```
1 <= N <= 1e3
1 <= A[i] <= 1e6
```
###For Example

####Input:
```
A = [1, 2, 3]
```
####Output:
```
3
```

####Explanation:
```
no. Subsequences      Prime subsequences
1.  [1]                     No
2.  [1, 2]                  No
3.  [1, 3]                  No
4.  [1, 2, 3]               No
5.  [2]                     Yes
6.  [2, 3]                  Yes
7.  [3]                     Yes
8.  []                      No

    here we have 3 subsequences(5, 6, 7) those have only prime number(s).
```