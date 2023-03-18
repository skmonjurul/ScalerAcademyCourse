def summation_game(n):
    c = 0
    for i in range(1, n+1):
        if n % i == 0:
            print(i)
            c = c+i

    print("Sum of all factor of", n, "Is:-", c)


summation_game(n=int(input("Enter the no:- ")))


