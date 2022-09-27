```
What is the Time Complexity of the below Code?
```
1. ```C++```
2. ```Java```
3. ```Python```

```
void solve() {
    int i = 1;
    while(i < n) {
        int x = i;
        while(x--) {
            //some operation of O(1)
        }
        i++;
    }
}
```

```
public void solve() {
    int i = 1;
    while(i < n) {
        int x = i;
        while(x-- > 0) {
            //some operation of O(1)
        }
        i++;
    }
}
```

```
def solve() {
    i = 1
    while i < n:
        x = i
        while x > 0:
            //some operation of O(1)
            x -= 1
        i += 1

```

####Choose the correct answer from below:
1. ```O(nlogn)```
2. ```O(n)```
3. ```O(n sqrt(n))```
4. ```O(n^2)```
5. ```None of the above```