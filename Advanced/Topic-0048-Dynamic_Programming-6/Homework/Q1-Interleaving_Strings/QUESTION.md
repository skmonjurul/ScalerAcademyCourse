###Problem Description
```
Given A, B, C find whether C is formed by the interleaving of A and B.
```


###Problem Constraints
```
1 <= length(A), length(B) <= 100

1 <= length(C) <= 200
```


###Input Format
```
The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.
```


###Output Format
```
Return 1 if string C is formed by interleaving of A and B else 0.
```


###Example Input
####Input 1:

```
A = "aabcc"
B = "dbbca"
C = "aadbbcbcac"
```
####Input 2:

```
A = "aabcc"
B = "dbbca"
C = "aadbbbaccc"
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
"aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
```
####Explanation 2:

```
It is not possible to get C by interleaving A and B.
```