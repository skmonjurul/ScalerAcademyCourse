###Problem Description
```
You are given an integer array A of length N comprising of 0's & 1's, and an integer B.

You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.

A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
```


###Problem Constraints
```
1 <= N <= 10^3

A[i] equals to 0 or 1.

0 <= B <= (N - 1) / 2
```


###Input Format
```
First argument is an integer array A.

Second argument is an integer B.
```


###Output Format
```
Return an integer array containing indices(0-based) in sorted order. If no such index exists, return an empty integer array.
```



###Example Input
####Input 1:

```
A = [1, 0, 1, 0, 1]
B = 1
```
####Input 2:

```
A = [0, 0, 0, 1, 1, 0, 1]
B = 0
```

###Example Output
####Output 1:

```
[1, 2, 3]
```
####Output 2:

```
[0, 1, 2, 3, 4, 5, 6]
```


###Example Explanation
####Explanation 1:

```
Index 1 acts as a centre of alternating sequence: [A0, A1, A2]
Index 2 acts as a centre of alternating sequence: [A1, A2, A3]
Index 3 acts as a centre of alternating sequence: [A2, A3, A4]
```
####Explanation 2:

```
Each index in the array acts as the center of alternating sequences of lengths 1.
```