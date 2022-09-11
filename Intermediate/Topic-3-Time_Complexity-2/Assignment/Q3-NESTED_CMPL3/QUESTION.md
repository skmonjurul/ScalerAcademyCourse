```
What is time complexity of following code :
```
1. C++
2. Java
3. Python

```
int count = 0;
for(int i = N; i > 0; i /= 2) {
    for(int j = 0; j < i; j++) {
        count += 1;
    }
}
```

```
int count = 0;
for(int i = N; i > 0; i /= 2) {
    for(int j = 0; j < i; j++) {
        count += 1;
    }
}
```

```
count = 0
i = N
while i > 0:
    for j in range(i):
        count += 1
    i = i // 2
```



####Choose the correct answer from below:
1. ```O(N * N)```
2. ```O(N * log N)```
3. ```O(N * log(log(N)))```
4. ```O(N)```
5. ```O(N * Sqrt(N))```