# Defining the Function
def prime_no(n):
    c = 0
    i = 2
    while i*i <= n:
        if n % i == 0:
            print(n, "Is not a Prime no")
            c = c+1
            break

        i = i+1

    if c == 0:
        print(n, "Is a prime no")


# calling  the Function
prime_no(n=int(input("enter no:- ")))
