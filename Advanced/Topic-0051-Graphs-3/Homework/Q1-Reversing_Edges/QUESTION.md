###Problem Description
```
Given a directed graph with A nodes and M edges.
Find the minimum number of edges that needs to be reversed in order to reach node A from node 1.
```


###Problem Constraints

```
1 <= A, M <= 10^5
1 <= B[i][0], B[i][1] <= A
There can be multiple edges or self loops (B[i][0] = B[i][1])
```

###Input Format

```
The first argument is an integer A, denoting the number of nodes in the graph.
The second argument is a 2D integer array B, denoting the directed edges in the graph.
```

###Output Format

```
Return a single integer denoting the minimum number of edges to be reversed.
```

###Example Input

####Input 1:
```
A = 5
B = [[1, 2],
    [2, 3],
    [4, 3],
    [4, 5]]
```
####Input 2:

```
A = 5
B = [[1, 2],
    [2, 3],
    [3, 4],
    [4, 5]]
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

####Explanation 1:

```
Reversing the edge (4, 3) is only required.
```

###Explanation 2:

```
There already exists a path between 1 and A, so no edges need to be reversed.
```