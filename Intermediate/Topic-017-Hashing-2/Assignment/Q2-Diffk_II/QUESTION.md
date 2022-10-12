###Problem Description
```
Given an array A of integers and another non negative integer B .

Find if there exists 2 indices i and j such that A[i] - A[j] = B and i != j.
```


###Problem Constraints
```
1 <= |A| <= 10^6

0 <= A[i] <= 10^9

0 <= B <= 10^9
```


###Input Format
```
First argument A is an array of integer

Second argument B is an integer
```


###Output Format
```
Return 1 if two such indexes are found and 0 otherwise
```


###Example Input
####Input 1:
```
A = [1, 5, 3]
B = 2
```
####Input 2:
```
A = [2, 4, 3]
B = 3
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
####For Input 1:
```
The given value of A[1] = 1 and A[3] = 3.
The value of A[3] - A[1] = 2.
```
####For Input 2:
```
There are no pairs such that difference is B.
```