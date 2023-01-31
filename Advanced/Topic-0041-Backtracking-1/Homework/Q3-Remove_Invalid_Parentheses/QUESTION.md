###Problem Description
```
Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.

Return all possible results.

You can return the results in any order.
```


###Problem Constraints
```
1 <= length of the string <= 20
```



###Input Format
```
The only argument given is string A.
```



###Output Format
```
Return all possible strings after removing the minimum number of invalid parentheses.
```


###Example Input
####Input 1:

```
A = "()())()"
```
####Input 2:

```
A = "(a)())()"
```


###Example Output
####Output 1:

```
["()()()", "(())()"]
```
####Output 2:

```
["(a)()()", "(a())()"]
```


###Example Explanation
####Explanation 1:

```
By removing 1 parentheses we can make the string valid.
1. Remove the parentheses at index 4 then string becomes : "()()()"
2. Remove the parentheses at index 2 then string becomes : "(())()"
```
####Explanation 2:

```
By removing 1 parentheses we can make the string valid.
1. Remove the parentheses at index 5 then string becomes : "(a)()()"
2. Remove the parentheses at index 2 then string becomes : "(a())()"
```