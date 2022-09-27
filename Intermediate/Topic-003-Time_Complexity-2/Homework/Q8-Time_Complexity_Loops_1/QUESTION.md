```
Find the Time Complexity of the following function solve :
```
1. C++
2. Java
3. Python

```
void fun(int n) {
    for(int i = 1; i * i <= n; i++) {
        for(int j = 1; j * j <= i; j += i) {
            //some O(1) opertation
        }
    }
}
```

```
public void fun(int n) {
    for(int i = 1; i * i <= n; i++) {
        for(int j = 1; j * j <= i; j += i) {
            //some O(1) opertation
        }
    }
}
```

```
def fund():
    i = 1
    while i * i <= n:
        j = 1
        while j * j <= i:
            //some O(1) operation
            j += i
        i += 1
```



####Choose the correct answer from below:
1. ```O(n)```
2. ```O(√n)```
3. ```O(n√n)```
4. ```O(√n*log(√n))```