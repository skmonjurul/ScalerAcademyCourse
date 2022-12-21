###Problem Description
```
Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.
```


###Problem Constraints
```
1 <= A <= 10^6
1 <= B <= A
A <= C <= 10^9+7
```

###Input Format
```
The first argument given is the integer A ( = n).
The second argument given is the integer B ( = r).
The third argument given is the integer C ( = p).
```


###Output Format
```
Return the value of nCr % p.
```


###Example Input
####Input 1:

```
A = 5
B = 2
C = 13
```
####Input 2:

```
A = 6
B = 2
C = 13
```

###Example Output
####Output 1:

```
10
```
####Output 2:

```
2
```


###Example Explanation
####Explanation 1:

```
nCr( n=5 and r=2) = 10.
p=13. Therefore, nCr%p = 10.
```