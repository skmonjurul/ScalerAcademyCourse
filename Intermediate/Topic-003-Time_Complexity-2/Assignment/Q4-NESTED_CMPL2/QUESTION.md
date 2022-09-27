```
What is time complexity of following code :
```
1. C++
2. Java
3. Python

```
int a = 0;
for(int i = 0; i < N; i++) {
    for(int j = N; j > i; j--) {
        a = a + i + j;
    }
}
```

```
int a = 0;
for(int i = 0; i < N; i++) {
    for(int j = N; j > i; j--) {
        a = a + i + j;
    }
}
```

```
a = 0
for i in range(N):
    j = N
    while j > i:
        a = a + i + j
        j--
```



####Choose the correct answer from below:
1. ```O(N)```
2. ```O(N*log(N))```
3. ```O(N * Sqrt(N))```
4. ```O(N*N)```