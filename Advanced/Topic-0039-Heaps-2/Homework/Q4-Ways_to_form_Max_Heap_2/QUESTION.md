###Problem Description
```
Max heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.

Given an array A of size N consisting of N - 1 distinct elements. In other words, there is exactly one element that is repeated.
It is given that the element that would repeat would be either the maximum element or the minimum element.

Find the number of structurally different Max heaps possible using all the N elements of the array i.e., Max heap of size N.

As the final answer can be very large return your answer modulo 109 + 7.
```


###Problem Constraints
```
1 <= N <= 1000
```



###Input Format
```
The first and only argument is an integer array A.
```



###Output Format
```
Return an integer denoting the number of structurally different Max heaps possible modulo 109 + 7.
```


###Example Input
####Input 1:

```
A = [1, 5, 5]
```
####Input 2:

```
A = [2, 2, 7]
```


###Example Output
####Output 1:

```
2
```
####Output 2:

```
1
```


###Example Explanation
####Explanation 1:

```
The possible max heaps using the given elements are:- First: 5 on the root. 1 as the left child of root and 5 as the right child of the root.   
        5
      /   \
     1     5
Second: 5 on the root. 5 as the left child of root and 1 as the right child of the root.
        5
      /   \
     5     1            

```
####Explanation 2:

```
There is only one possible max heaps: 7 on the root. 2 as the left child of root and 2 as the right child of the root.   
        7
      /   \
     2     2
```