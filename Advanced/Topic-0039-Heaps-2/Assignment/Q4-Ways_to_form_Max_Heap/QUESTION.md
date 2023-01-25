###Problem Description
```
Max Heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.

Find the number of distinct Max Heap that can be made from A distinct integers.

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
Every node is greater than all its children.
NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.
```


###Problem Constraints
```
1 <= A <= 100
```


###Input Format
```
The first and only argument is an integer A.
```


###Output Format
```
Return an integer denoting the number of distinct Max Heap.
```


###Example Input
####Input 1:

```
A = 4
```
####Input 2:

```
A = 10
```


###Example Output
####Output 1:

```
3
```
####Output 2:

```
3360
```


###Example Explanation
####Explanation 1:

```
Let us take 1, 2, 3, 4 as our 4 distinct integers
Following are the 3 possible max heaps from these 4 numbers :
        4           4                     4
       / \         / \                   / \
      3   2   ,   2   3      and        3   1
     /           /                     /    
    1           1                     2
```
####Explanation 2:

```
Number of distinct heaps possible with 10 distinct integers = 3360.
```