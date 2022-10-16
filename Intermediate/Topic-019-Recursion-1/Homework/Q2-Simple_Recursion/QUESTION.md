###Problem Description
```
What will be the output of following program ?
```

1. C++
2. Java
3. Python

```
using namespace std;

int bar(int x, int y) {
    if(y == 0) return 0;
    return (x + bar(x, y - 1));
}

int foo(int x, int y) {
    if(y == 0) return 1;
    return bar(x, foo(x, y - 1));
}

int main() {
    count << foo(3, 5);
}
```

```
public class solve {
    static int bar(int x, int y) {
        if(y == 0) return 0;
        return (x + bar(x, y - 1));
    }
    
    static int foo(int x, int y) {
        if(y == 0) return 1;
        return bar(x, foo(x, y - 1));
    }
    
    public static void main(String[] args) {
        System.out.println(foo(3, 5));
    }
 
}
```

```
def bar(x, y):
    if y == 0:
        return 0
    return (x + bar(x, y - 1))
    
    
def foo(x, y):
    if y == 0:
        return 1
    return bar(x, foo(x, y - 1))

    
print(foo(3, 5))
```

###Choose the correct answer from below:

1. ```243```

2. ```15```

3. ```18```

4. ```125```

    
