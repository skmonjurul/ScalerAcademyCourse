###Problem Description
```
You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.
```


###Problem Constraints
```
1 <= N <= 10^6
```



###Input Format
```
First and only argument is a string A of length N.
```



###Output Format
```
Return an integer, denoting the period of the string.
```



###Example Input
####Input 1:

```
A = "abababab"
```
####Input 2:

```
A = "aaaa"
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
Period of the string will be 2:
Since, for all i, A[i] = A[i%2].
```
####Explanation 2:

```
Period of the string will be 1.
```