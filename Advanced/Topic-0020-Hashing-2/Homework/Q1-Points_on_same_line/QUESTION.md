###Problem Description
```
Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.

Find and return the maximum number of points that lie on the same line.
```


###Problem Constraints
```
1 <= (length of the array A = length of array B) <= 1000

-10^5 <= A[i], B[i] <= 10^5
```


###Input Format
```
The first argument is an integer array A.
The second argument is an integer array B.
```


###Output Format
```
Return the maximum number of points which lie on the same line.
```



###Example Input
####Input 1:

```
A = [-1, 0, 1, 2, 3, 3]
B = [1, 0, 1, 2, 3, 4]
```
####Input 2:

```
A = [3, 1, 4, 5, 7, -9, -8, 6]
B = [4, -8, -3, -2, -1, 5, 7, -4]
```

###Example Output
####Output 1:

```
4
```
####Output 2:

```
2
```


###Example Explanation
####Explanation 1:

```
The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
```
####Explanation 2:

```
Any 2 points lie on a same line.
```