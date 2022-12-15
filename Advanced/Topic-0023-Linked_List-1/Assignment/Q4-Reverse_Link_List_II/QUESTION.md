###Problem Description
```
Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.
```

###Problem Constraints
```
1 <= |A| <= 10^6

1 <= B <= C <= |A|
```


###Input Format
```
The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.
```


###Output Format
```
Return a pointer to the head of the modified linked list.
```



###Example Input
####Input 1:

```
A = 1 -> 2 -> 3 -> 4 -> 5
B = 2
C = 4
```
####Input 2:

```
A = 1 -> 2 -> 3 -> 4 -> 5
B = 1
C = 5
```

###Example Output
####Output 1:

```
1 -> 4 -> 3 -> 2 -> 5
```
####Output 2:

```
5 -> 4 -> 3 -> 2 -> 1
```


###Example Explanation
####Explanation 1:

```
In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
```
####Explanation 2:

```
In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
```