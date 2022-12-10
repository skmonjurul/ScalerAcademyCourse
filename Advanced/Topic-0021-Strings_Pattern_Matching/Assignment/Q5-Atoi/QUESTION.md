###Problem Description
```
There are certain questions where the interviewer would intentionally frame the question vague.
The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.

Implement atoi to convert a string to an integer.
```
###Example :

```
Input : "9 2704"
Output : 9
```
<i>Note: There might be multiple corner cases here. Clarify all your doubts using "See Expected Output".</i>

<strong>Questions:</strong>

```
Q1. Does string contain whitespace characters before the number? A. Yes

Q2. Can the string have garbage characters after the number? A. Yes. Ignore it.

Q3. If no numeric character is found before encountering garbage characters, what should I do? A. Return 0.

Q4. What if the integer overflows? A. Return INTMAX if the number is positive, INTMIN otherwise.
```
<i><strong>Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.</strong> If you do, we will disqualify your submission retroactively and give you penalty points.</i>