###Problem Description
```
Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
```


###Problem Constraints
```
1 <= N <= 10^4

0 <= A[i], B <= 10^5
```


###Input Format
```
First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.
```


###Output Format
```
Return an integer denoting the count of all distinct pairs with difference equal to B.
```


###Example Input
####Input 1:

```
A = [1, 5, 3, 4, 2]
B = 3
```
####Input 2:

```
A = [8, 12, 16, 4, 0, 20]
B = 4
```
####Input 3:

```
A = [1, 1, 1, 2, 2]
B = 0
```

###Example Output
####Output 1:

```
2
```
####Output 2:

```
5
```
####Output 3:

```
2
```


###Example Explanation
####Explanation 1:

```
There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
```
####Explanation 2:

```
There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
```
####Explanation 3:

```
There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
```