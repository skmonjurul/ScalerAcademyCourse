###Problem Description
```
Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
```


###Problem Constraints
```
1 <= size of tree <= 100000

1 <= B, C <= 10^9
```


###Input Format
```
First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.
```


###Output Format
```
Return the LCA.
```



###Example Input
####Input 1:

```
      1
     /  \
    2    3

B = 2
C = 3
```
####Input 2:
```
      1
     /  \
    2    3
   / \
  4   5

B = 4
C = 5
```

###Example Output
####Output 1:

```
1
```
####Output 2:

```
2
```


###Example Explanation
####Explanation 1:

```
LCA is 1.
```
####Explanation 2:

```
LCA is 2.
```