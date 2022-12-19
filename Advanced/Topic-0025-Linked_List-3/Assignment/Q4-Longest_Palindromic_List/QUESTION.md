###Problem Description
```
Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.

A palindrome list is a list that reads the same backward and forward.

Expected memory complexity : O(1)
```


###Problem Constraints
```
1 <= length of the linked list <= 2000

1 <= Node value <= 100
```


###Input Format
```
The only argument given is head pointer of the linked list.
```



###Output Format
```
Return the length of the longest palindrome list.
```



###Example Input
####Input 1:

```
2 -> 3 -> 3 -> 3
```
####Input 2:

```
2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
```


###Example Output
####Output 1:

```
3
```
####Output 2:

```
5
```


###Example Explanation
####Explanation 1:

```
3 -> 3 -> 3 is largest palindromic sublist
```
####Explanation 2:

```
2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
```