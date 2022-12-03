###Problem Description
```
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.
```


###Problem Constraints
```
-10^8 <= B <= 10^8
1 <= N <= 10^4
-10^8 <= A[i] <= 10^8
```

###Input Format
```
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.
```


###Output Format
```
Return a single integer denoting the sum of three integers which is closest to B.
```


###Example Input
####Input 1:

```
A = [-1, 2, 1, -4]
B = 1
```
####Input 2:


```
A = [1, 2, 3]
B = 6
```

###Example Output
####Output 1:

```
2
```
####Output 2:

```
6
```


###Example Explanation
####Explanation 1:

```
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
```
####Explanation 2:

```
Take all elements to get exactly 6.
```