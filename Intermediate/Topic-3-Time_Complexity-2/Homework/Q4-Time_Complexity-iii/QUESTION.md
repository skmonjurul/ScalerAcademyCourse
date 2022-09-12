```
What is the time complexity of the following code snippet?
```
1. C++
2. Java
3. Python

```
for(int i = 0; i < n; i++) {
    for(int j = i - 1; j >= 0; j++) {
        ans += i + j;
    }
}
```

```
for(int i = 0; i < n; i++) {
    for(int j = i - 1; j >= 0; j++) {
        ans += i + j;
    }
}
```

```
for i in range(n):
    j = i - 1
    while j >= 0:
        ans += i + j
        j += 1
```



####Choose the correct answer from below:
1. ```O(n)```
2. ```O(n^2)```
3. ```Code will run indefinitely```
4. ```O(1)```
5. ```None of these```