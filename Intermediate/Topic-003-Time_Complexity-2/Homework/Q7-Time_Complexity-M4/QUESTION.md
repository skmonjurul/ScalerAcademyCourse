```
Find the Time Complexity of the following function solve :
```
1. C++
2. Java
3. Python

```
void solve(int N) {
    for(int i = 0; i < pow(2, N); i++) {
        int j = i;
        while(j > 0) {
            j -= 1;
        }
    }
} 
```

```
public void solve(int N) {
    for(int i = 0; i < Math.pow(2, N); i++) {
        int j = i;
        while(j > 0) {
            j -= 1;
        }
    }
}
```

```
def solve(N):
    for i in range(2 ** N):
        j = i
        while j > 0:
            j -= 1
```



####Choose the correct answer from below:
1. ```O(N * N)```
2. ```O(2^N)```
3. ```O(N * (2^N))```
4. ```O(3^N)```
5. ```O(4^N)```