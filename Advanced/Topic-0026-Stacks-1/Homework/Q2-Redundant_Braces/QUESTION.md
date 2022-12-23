###Problem Description
```
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

Check whether A has redundant braces or not.

NOTE: A will be always a valid expression and will not contain any white spaces.
```


###Problem Constraints
1 <= |A| <= 10^5



###Input Format
```
The only argument given is string A.
```



###Output Format
```
Return 1 if A has redundant braces else, return 0.
```



###Example Input
####Input 1:

```
A = "((a+b))"
```
####Input 2:

```
A = "(a+(a+b))"
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
((a+b)) has redundant braces so answer will be 1.
```
####Explanation 2:

```
(a+(a+b)) doesn't have have any redundant braces so answer will be 0.
```