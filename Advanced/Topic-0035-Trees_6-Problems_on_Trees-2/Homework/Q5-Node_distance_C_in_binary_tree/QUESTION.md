###Problem Description
```
Given a binary tree of integers. All nodes in the binary tree have distinct values. You are given an integer B.

You have to find all the nodes that are at a distance of exactly C from the node containing value B.

Return an array of integers consisting all the nodes that are C distance from node containing value B.

Note:

You may return the nodes in any order.

Your solution will run on multiple test cases, if you are using global variables make sure to clear every time .
```
###Constraints

```
1 <= Number of nodes in binary tree <= 100000
0 <= Node values <= 10^9
0 <= B <= 10^9
0 <= C <= 100
```
###For Example

####Input 1:
```
            1
          /   \
         2     3
        / \   / \
       4   5 6  7
      /
     8

B = 3
C = 3
     
```
####Output 1:
```
[4, 5]
```

####Input 2:
```
            1
           /  \
          2    3
           \
            4
             \
              5
B = 4
C = 1
```
####Output 2:
```
[2, 5]
```