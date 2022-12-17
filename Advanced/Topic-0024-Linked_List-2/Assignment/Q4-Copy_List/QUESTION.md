###Problem Description
```
A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.
```


###Problem Constraints
```
0 <= |A| <= 10^6
```



###Input Format
```
The first argument of input contains a pointer to the head of linked list A.
```



###Output Format
```
Return a pointer to the head of the required linked list.
```



###Example Input
```
Given list
1 -> 2 -> 3
with random pointers going from
1 -> 3
2 -> 1
3 -> 1
```


###Example Output
```
1 -> 2 -> 3
with random pointers going from
1 -> 3
2 -> 1
3 -> 1
```


###Example Explanation
```
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
```