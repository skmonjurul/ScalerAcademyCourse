
###Problem Description
```
Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.
```


###Problem Constraints
```
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000
```

###Input Format
```
The first argument given is the integer array A.
The second argument given is the integer array B.
```

###Output Format
```
Return the resultant matrix.
```

###Example Input
####Input 1:

```
    A = [1, 2, 3, 4, 5]
    B = [2, 3]
```
####Input 2:


```
    A = [5, 17, 100, 11]
    B = [1]
```



###Example Output
####Output 1:

```
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]
```


####Output 2:


```
    [ [17, 100, 11, 5] ]
```


###Example Explanation
```
for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

2: [4, 5, 1, 2, 4]
```