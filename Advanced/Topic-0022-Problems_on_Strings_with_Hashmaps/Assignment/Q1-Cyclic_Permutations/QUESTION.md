###Problem Description
```
Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.
```


###Problem Constraints
```
1 ≤ length(A) = length(B) ≤ 10^5
```



###Input Format
```
The first argument is a string A.
The second argument is a string B.
```


###Output Format
```
Return an integer denoting the required answer.
```



###Example Input
####Input 1:

```
A = "1001"
B = "0011"
```
####Input 2:

```
A = "111"
B = "111"
```

###Example Output
####Output 1:

```
1
```
####Output 2:

```
3
```


###Example Explanation
####Explanation 1:

```
4 cyclic shifts of B exists: "0011", "0110", "1100", "1001".  
There is only one cyclic shift of B i.e. "1001" which has 0 xor with A.
```
####Explanation 2:

```
All cyclic shifts of B are same as A and give 0 when taken xor with A. So, the ans is 3.
```