###Problem Description
```
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.
```


###Problem Constraints
```
1 <= number of nodes <= 10^5
```



###Input Format
```
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.
```


###Output Format
```
Return the root node of the binary tree.
```


###Example Input
####Input 1:

```
A = [2, 1, 3]
B = [2, 3, 1]
```
####Input 2:

```
A = [6, 1, 3, 2]
B = [6, 3, 2, 1]
```

###Example Output
####Output 1:

```
    1
  /   \
 2     3
```
####Output 2:

```
        1  
       / \
      6   2
         /
        3
```

###Example Explanation
####Explanation 1:

```
Create the binary tree and return the root node of the tree.
```