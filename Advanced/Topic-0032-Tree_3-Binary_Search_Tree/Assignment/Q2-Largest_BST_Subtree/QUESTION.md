###Problem Description
```
You are given a Binary Tree A with N nodes.

Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).

If the complete Binary Tree is BST, then return the size of the whole tree.

NOTE:

The largest subtree is the subtree with the most number of nodes.
```

###Problem Constraints
```
1 <= N <= 10^5
```


###Input Format
```
First and only argument is an pointer to root of the binary tree A.
```


###Output Format
```
Return an single integer denoting the size of the largest subtree which is also a BST.
```


###Example Input
####Input 1:
``` 
        10
        / \
       5  15
      / \   \
     1   8   7

```
####Input 2:
```
        5
       / \
      3   8
     / \ / \
    1  4 7  9

```
###Example Output
####Output 1:

```
3
```
####Output 2:

```
7
```


###Example Explanation
####Explanation 1:

```
Largest BST subtree is
        5
       / \
      1   8

```
####Explanation 2:

```
Given binary tree itself is BST.
```