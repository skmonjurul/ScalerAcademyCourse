###Problem Description
```
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.
NOTE: A solution will always exist. Read Goldbach's conjecture.
```


###Problem Constraints
```
4 <= A <= 2*10^7
```



###Input Format
```
First and only argument of input is an even number A.
```



###Output Format
```
Return a integer array of size 2 containing primes whose sum will be equal to given number.
```



###Example Input
```
4
```


###Example Output
```
[2, 2]
```


###Example Explanation
```
There is only 1 solution for A = 4.
```