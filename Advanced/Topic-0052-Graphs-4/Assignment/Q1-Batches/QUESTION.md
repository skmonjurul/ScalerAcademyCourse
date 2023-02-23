###Problem Description
```
A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.

Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.

All students who know each other are placed in one batch.

Strength of a batch is equal to sum of the strength of all the students in it.

Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.

Find the number of batches selected.

NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
```


###Problem Constraints

```
1 <= A <= 10^5

1 <= M <= 2*10^5

1 <= B[i] <= 10^4

1 <= C[i][0], C[i][1] <= A

1 <= D <= 10^9
```


###Input Format

```
The first argument given is an integer A.
The second argument given is an integer array B.
The third argument given is a matrix C.
The fourth argument given is an integer D.
```


###Output Format

```
Return the number of batches selected in IB.
```


###Example Input

####Input 1:

```
A = 7
B = [1, 6, 7, 2, 9, 4, 5]

C = [  [1, 2]
       [2, 3]
       [5, 6]
       [5, 7]  ]

D = 12

```
####Input 2:

```
A = 5
B = [1, 2, 3, 4, 5]

C = [  [1, 5]
       [2, 3]  ]

D = 6

```
###Example Output

####Output 1:

```
2
```
####Output 2:

```
1
```


###Example Explanation

####Explanation 1:

```
Initial Batches :
Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
Batch 2 = {4} Batch Strength = 2
Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
Selected Batches are Batch 1 and Batch 2.
```
####Explanation 2:

```
Initial Batches :
Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
Batch 2 = {2, 3} Batch Strength = 5
Batch 3 = {4} Batch Strength = 4  
Selected Batch is only Batch 1.
```