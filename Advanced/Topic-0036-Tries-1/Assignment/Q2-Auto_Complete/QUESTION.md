###Problem Description
```
There is a dictionary A of N words, and ith word has a unique weight Wi.

Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.

Output the words in decreasing order of their weight.

NOTE: If there is no word that starts with the given prefix output -1.
```


###Problem Constraints
```
1 <= T <= 5

1 <= N <= 20000
1 <= M <= 10000

1 <= Wi <= 10^6

1 <= length of any string either in A or B <= 30
```


###Input Format
```
First line is an integer T denoting the number of test cases.
For each test case,

First line denotes two space seperated integer N and M.
Second line denotes N space seperated strings denoting the words in dictionary.
Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
Fourth line denotes M space seperated integers denoting the prefixes.

```
###Output Format
```
For every prefix B[i], print the space seperated output on a new line.
NOTE: After every output there should be a space.
```


###Example Input
####Input 1:

```
1
6 3
abcd aecd abaa abef acdcc acbcc
2 1 3 4 6 5
ab abc a

```
####Input 2:

```
1
5 3
aaaa aacd abaa abaa aadcc
3 4 1 2 6
aa aba abc

```
###Example Output
####Output 1:

```
abef abaa abcd
abcd
acdcc acbcc abef abaa abcd
```
####Output 2:

```
aadcc aacd aaaa
abaa abaa
-1

```
###Example Explanation
####Explanation 1:

```
For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.
```
####Explanation 2:

```
For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.
```