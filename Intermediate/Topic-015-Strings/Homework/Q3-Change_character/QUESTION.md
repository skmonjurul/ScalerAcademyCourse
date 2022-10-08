###Problem Description
```You are given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.
```


###Problem Constraints
```
1 <= N <= 100000

0 <= B < N
```


###Input Format
```
The first argument is a string A.

The second argument is an integer B.
```


###Output Format
```
Return an integer denoting the minimum number of distinct characters in the string.
```


###Example Input
```
A = "abcabbccd"
B = 3
```


###Example Output
```
2
```

###Example Explanation
```
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
```