###Problem Description
```
What will be the output of following program ?
```

1. C++
2. Java
3. Python

```

int fun(int x, int n) {
    if(n == 0) 
        return 1;
    else if (n % 2 == 0)
        return fun(x * x, n / 2);
    else 
        return x * fun(x * x, (n - 1) / 2);       
}

int main() {
    int ans = fun(2, 10);
    printf("%d", ans);
    return 0;
}
```

```
public class solve {
    public int fun(int x, int n) {
        if(n == 0) 
            return 1;
        else if (n % 2 == 0)
            return fun(x * x, n / 2);
        else 
            return x * fun(x * x, (n - 1) / 2);       
    }
    
    public static void main(String[] args) {
        int ans = fun(2, 10);
        System.out.println(ans);
    }
}
```

```
def bar(x, y):
    if n == 0:
        return 1
    elif n % 2 == 0:
        return fun(x * x, n // 2)
    else:
        return x * fun(x * x, (n - 1) // 2)
    
ans = fun(2, 10)
print(ans)
```

###Choose the correct answer from below:

1. ```1023```

2. ```2048```

3. ```1024```

4. ```Noe of these```

    
