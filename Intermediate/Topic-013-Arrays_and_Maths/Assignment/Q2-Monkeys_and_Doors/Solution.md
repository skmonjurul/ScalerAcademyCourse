```
Consider door number 56. Monkeys will visit it for every divisor it has. So 56 has 1 & 56, 2 & 28, 4 & 14, 7 & 8.
So on pass 1 1st monkey will open the door, pass 2 2nd one will close it, pass 4 open, pass 7 close, pass 8 open, pass 14 close, pass 28 open, pass 56 close.
For every pair of divisors, the door will end up back in its initial state. But there are cases in which the pair of divisors has the same number, for example, door number 16. 16 has the divisors 1 & 16, 2 & 8, 4&4.
But 4 is repeated because 16 is a perfect square, so you will only visit door number 16, on passes 1, 2, 4, 8, and 16, leaving it open at the end. So only perfect square doors will be open at the end.
```