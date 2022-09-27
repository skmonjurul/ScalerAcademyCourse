```
What is the time complexity of the following code snippet?
```
1. C++
2. Java
3. Python

```
int i = 0;
while(i * i <= N) {
    for(int j = 0; j <= N; j++) {
        for(int k = 0; k <= N; k++, i++) {
            //some O(1) operation
        }
    }
    i++;
}
```

```
int i = 0;
while(i * i <= N) {
    for(int j = 0; j <= N; j++) {
        for(int k = 0; k <= N; k++, i++) {
            //some O(1) operation
        }
    }
    i++;
}
```

```
i = 0
while i * i <= N:
    for j in range(N + 1):
        for k in range(N + 1):
            i += 1
            //some O(1) operation
    i += 1
```



####Choose the correct answer from below:
1. ```O(NlogN)```
2. ```O(N^3)```
3. ```O(N^2 sqrt(N))```
4. ```O(N^2)```
5. ```None of these```