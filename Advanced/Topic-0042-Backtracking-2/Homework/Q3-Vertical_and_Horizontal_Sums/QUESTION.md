###Problem Description
```
Given a matrix B, of size N x M, you are allowed to do at most A special operations on this grid such that there is no vertical or horizontal contiguous subarray that has a sum greater than C.

A special operation involves multiplying any element by -1 i.e. changing its sign.

Return 1 if it is possible to achieve the answer, otherwise 0.
```


###Problem Constraints

```
1 <= N, M <= 10

0 <= A <= 5

-10^5 <= B[i][j], C <= 10^5
```


###Input Format

```
The first argument is an integer A, representing the number of special operations allowed.
The second argument has the N x M integer matrix, B.
The third argument is an integer C, as described in the problem statement.
```


###Output Format

```
Return 1 if it is possible to achieve the answer, otherwise 0.
```


###Example Input

####Input 1:

```
A = 3

B = [  
        [1, 1, 1]
        [1, 1, 1]
        [1, 1, 1]
    ]
    
C = 2
```
####Input 2:

```
A = 1

B = [
        [1, 1, 1]
        [1, 1, 1]
        [1, 1, 1]
    ]
    
C = 2

```
###Example Output

####Output 1:

```
1
```
####Output 2:

```
0
```


###Example Explanation

####Explanation 1:

```
The given matrix does not satisfy the conditions, but if we apply the special operation to B[0][0], B[1][1], B[2][2],
then the matrix would satisfy the given conditions i.e. no row or column has a sum greater than 2.
```
####Explanation 2:

```
It is not possible to apply the special operation to 1 element to satisfy the conditions.
```