def sq_root(n):
    i = 0
    while i*i <= n:
        if i*i == n:
            print(i)
            print(i, "is the sq root of", n)
            break
    i = i+1


sq_root(n=int(input("Enter the no:- ")))
