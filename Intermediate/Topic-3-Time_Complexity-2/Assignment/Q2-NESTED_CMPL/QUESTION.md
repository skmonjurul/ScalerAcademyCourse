```
What is the time, space complexity of following code :
```
1. C++
2. Java
3. Python

```
int a = 0, b = 0;
for(i = 0; i < N; i++) {
    for(j = 0; j < N; j++) {
        a = a + j;
    }
}

for(k = 0; k < N; k++) {
    b = b + k;
}
```

```
int a = 0, b = 0;
for(i = 0; i < N; i++) {
    for(j = 0; j < N; j++) {
        a = a + j;
    }
}

for(k = 0; k < N; k++) {
    b = b + k;
}
```

```
a = 0
b = 0
for i in range(N):
    for j in range(N):
        a = a + j
for k in range(N):
    b = b + k
```



####Choose the correct answer from below:
1. ```O(N * N) time, O(1) space```
2. ```O(N) time, O(N) space```
3. ```O(N) time, O(N) space```
4. ```O(N * N) time, O(N) space```
5. ```O(N * N * N) time, O(1) space```