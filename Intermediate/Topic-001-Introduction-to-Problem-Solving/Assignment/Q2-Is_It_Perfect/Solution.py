def sq_root(n):
    c = 0
    for i in range(1,  n):
        if n % i == 0:
            c = c+i

    if c == n:
        print(n, "is  a perfect square")
    else:
        print(n, "is not a perfect square")


sq_root(n=int(input("Input no")))
