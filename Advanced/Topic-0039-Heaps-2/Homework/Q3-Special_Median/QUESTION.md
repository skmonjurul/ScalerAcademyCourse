###Problem Description
```
You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.

Return 1 if the array is special else return 0.

NOTE:

Do not neglect decimal point while calculating the median
For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]
```

###Problem Constraints
```
1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.
```


###Input Format
```
The first and only argument is an integer array A.
```



###Output Format
```
Return 1 if the given array is special else return 0.
```



###Example Input
####Input 1:

```
A = [4, 6, 8, 4]
```
####Input 2:

```
A = [2, 7, 3, 1]
```


###Example Output
####Output 1:

```
1
```
####Output 2:

```
0
```


###Example Explanation
####Explantion 1:

```
Here, 6 is equal to the median of [8, 4].
```
####Explanation 2:

```
No element satisfies any condition.
```