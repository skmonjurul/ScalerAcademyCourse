###Problem Description
```
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
```


###Problem Constraints
```
0 <= |intervals| <= 10^5
```


###Input Format
```
First argument is the vector of intervals

second argument is the new interval to be merged
```


###Output Format
```
Return the vector of intervals after merging
```



###Example Input
####Input 1:

```
Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
```
####Input 2:

```
Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
```


###Example Output
####Output 1:

```
[ [1, 5], [6, 9] ]
```
####Output 2:

```
[ [1, 9] ]
```


###Example Explanation
####Explanation 1:

```
(2,5) does not completely merge the given intervals
```
####Explanation 2:

```
(2,6) completely merges the given intervals
```